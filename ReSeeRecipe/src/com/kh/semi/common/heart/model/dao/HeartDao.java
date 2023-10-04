package com.kh.semi.common.heart.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.common.heart.model.vo.Heart;
import com.kh.semi.common.heart.model.vo.NoticeHeart;


public class HeartDao {
	
	
	private Properties prop = new Properties();
	
	public HeartDao() {
		String filePath = HeartDao.class.getResource("/sql/heart/heart-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/****************************************************************************/
	
	
	/*
	case "RECIPE" :
	case "BOOKMARK" :
	case "NOTICE" : result = new HeartDao().heartCountGeneralBoard(ht, conn); break;
	case "SUBSC" : result = new HeartDao().heartCountSubsc(ht, conn); break;
	case "REPLY" : result = new HeartDao().heartCountReply(ht, conn); break;
	*/
	public String heartCountGeneralBoard(Heart ht, Connection conn) {
		String result = "";
		String sql = prop.getProperty("heartCountGeneralBoard").replace("$BASEKEY", ht.getHtKind());
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, ht.getHtTargetNo());
			
			try(ResultSet rset = pstmt.executeQuery()) {
				if(rset.next()) {
					result = rset.getString("COUNT(*)");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		return result;
	}
	
	
	public String heartCountSubsc(Heart ht, Connection conn) {
		String result = "";
		String sql = prop.getProperty("heartCountSubsc");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, ht.getHtTargetNo());
			
			try(ResultSet rset = pstmt.executeQuery()) {
				if(rset.next()) {
					result = rset.getString("COUNT(*)");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public String heartCountReply(Heart ht, Connection conn) {
		String result = "";
		String sql = prop.getProperty("heartCountReply");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, ht.getHtTargetNo());
			
			try(ResultSet rset = pstmt.executeQuery()) {
				if(rset.next()) {
					result = rset.getString("COUNT(*)");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/****************************************************************************/
	
	
	public boolean heartCheckGeneralBoard(Heart ht, Connection conn) {
		boolean result = false;
		String sql = prop.getProperty("heartCheckGeneralBoard").replace("$BASEKEY", ht.getHtKind());
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, ht.getHtTargetNo());
			pstmt.setInt(2, ht.getMemNo());
			
			try(ResultSet rset = pstmt.executeQuery()) {
				if(rset.next() && (0 < rset.getInt("COUNT(*)"))) {
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public boolean heartCheckSubsc(Heart ht, Connection conn) {
		boolean result = false;
		String sql = prop.getProperty("heartCheckSubsc");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, ht.getHtTargetNo());
			pstmt.setInt(2, ht.getMemNo());
			
			try(ResultSet rset = pstmt.executeQuery()) {
				if(rset.next() && (0 < rset.getInt("COUNT(*)"))) {
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public boolean heartCheckReply(Heart ht, Connection conn) {
		boolean result = false;
		String sql = prop.getProperty("heartCheckReply");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, ht.getHtTargetNo());
			pstmt.setInt(2,ht.getMemNo());
			
			try(ResultSet rset = pstmt.executeQuery()) {
				if(rset.next() && (0 < rset.getInt("COUNT(*)"))) {
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/****************************************************************************/
	
	
	public boolean insertHeart(Heart ht, Connection conn) {
		// 현재 유저 STATUS = 'Y', 타겟의 STATUS = 'Y'
		
		boolean result = false;
		String sql = prop.getProperty("insertHeart");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public boolean deleteHeart(Heart ht, Connection conn) {
		boolean result = false;
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	/****************************************************************************/
	
	public ArrayList<NoticeHeart> countnoticeHeart(Connection conn, ArrayList<NoticeHeart> heartNoticeNo){
		NoticeHeart nh = null;
		ArrayList<NoticeHeart> noticeHeartList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("countnoticeHeart");
		//System.out.print("heartNo >> " + heartNoticeNo);
		
		 try {
			pstmt = conn.prepareStatement(sql);
			
			for(NoticeHeart n : heartNoticeNo) {
				pstmt.setInt(1, n.getNoticeNo());
				System.out.println("get >> " + n.getNoticeNo());
				noticeHeartList.add(n);
			}
			
			 rset = pstmt.executeQuery();
			 //ArrayList<int> count = new ArrayList();
			 while(rset.next()) {
				nh = new NoticeHeart();
				//nh.setMemNo(rset.getInt("MEM_NO"));
				//nh.setNoticeNo(rset.getInt("NOTICE_NO"));
				//nh.setNoticeHtDate(rset.getDate("HT_NOTICE_DATE"));
				nh.setNoticeHeartCount(rset.getInt("COUNT(NOTICE_NO)"));
				noticeHeartList.add(nh);
			 }
			 System.out.println("noticeHeartList >> " + noticeHeartList);
			 System.out.println("count >> " + nh.getNoticeHeartCount());
		 } catch(SQLException e) { 
			 e.printStackTrace(); 
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return noticeHeartList;
	}
	
	public ArrayList<NoticeHeart> selectnoticeHeartList(Connection conn){
		
		ArrayList<NoticeHeart> selectnoticeHeartList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectnoticeHeartList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				NoticeHeart nh = new NoticeHeart();
				nh.setMemNo(rset.getInt("MEM_NO"));
				nh.setNoticeNo(rset.getInt("NOTICE_NO"));
				nh.setNoticeHtDate(rset.getDate("HT_NOTICE_DATE"));
				
				selectnoticeHeartList.add(nh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return selectnoticeHeartList;
	}

}
