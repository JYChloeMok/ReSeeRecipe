package com.kh.semi.product.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.common.model.vo.PageInfo;
import com.kh.semi.product.model.dao.ProductDao;
import com.kh.semi.product.model.vo.Product;
import com.kh.semi.product.model.vo.ProductPicture;

public class ProductService {
	
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new ProductDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Product> selectProductList(){
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new ProductDao().selectProductList(conn);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Product> selectProductList(PageInfo pi, String cate){
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new ProductDao().selectProductList(conn, pi, cate);
		
		close(conn);
		
		return list;
	}
	
	public Product selectProduct(int pno) {
		
		Connection conn = getConnection();
		
		Product p = new ProductDao().selectProduct(conn, pno);
		
		close(conn);
		
		return p;
		
	}
	
	public ArrayList<ProductPicture> selectPicture(int pno) {
		
		Connection conn = getConnection();
		
		ArrayList<ProductPicture> list = new ProductDao().selectPicture(conn, pno);
		
		close(conn);
		
		return list;
		
	}
	
	
	
	
	
	
	
	
	
	

}
