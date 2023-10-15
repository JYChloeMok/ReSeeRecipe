package com.kh.semi.blog.model.vo;

import java.sql.Date;

public class MemberDm {
	
	private int dmNo;
	private String receiveMem;
	private String sendMem;
	private String dmContent;
	private Date sendDate;
	private String dmStatus;
	private String dmReply;
	private String memId;			// 쪽지리스트에 띄워주기 위해 생성
	private String memNickname;	// 쪽지리스트에 띄워주기 위해 생성
	
	// 기본생성자
	public MemberDm() {
		super();
	}
	
	// 매개변수 생성자
	public MemberDm(int dmNo, String receiveMem, String sendMem, String dmContent, Date sendDate, String dmStatus,
			String dmReply, String memId, String memNickname) {
		super();
		this.dmNo = dmNo;
		this.receiveMem = receiveMem;
		this.sendMem = sendMem;
		this.dmContent = dmContent;
		this.sendDate = sendDate;
		this.dmStatus = dmStatus;
		this.dmReply = dmReply;
		this.memId = memId;
		this.memNickname = memNickname;
	}

	// getter, setter
	public int getDmNo() {
		return dmNo;
	}

	public void setDmNo(int dmNo) {
		this.dmNo = dmNo;
	}

	public String getReceiveMem() {
		return receiveMem;
	}

	public void setReceiveMem(String receiveMem) {
		this.receiveMem = receiveMem;
	}

	public String getSendMem() {
		return sendMem;
	}

	public void setSendMem(String sendMem) {
		this.sendMem = sendMem;
	}

	public String getDmContent() {
		return dmContent;
	}

	public void setDmContent(String dmContent) {
		this.dmContent = dmContent;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getDmStatus() {
		return dmStatus;
	}

	public void setDmStatus(String dmStatus) {
		this.dmStatus = dmStatus;
	}
	

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	
	public String getDmReply() {
		return dmReply;
	}

	public void setDmReply(String dmReply) {
		this.dmReply = dmReply;
	}

	@Override
	public String toString() {
		return "Dm [dmNo=" + dmNo + ", receiveMem=" + receiveMem + ", sendMem=" + sendMem + ", dmContent=" + dmContent
				+ ", sendDate=" + sendDate + ", dmStatus=" + dmStatus + ", dmReply=" + dmReply + ", memId=" + memId
				+ ", memNickname=" + memNickname + "]";
	}

}


