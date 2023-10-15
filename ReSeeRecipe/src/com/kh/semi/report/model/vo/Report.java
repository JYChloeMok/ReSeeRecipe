package com.kh.semi.report.model.vo;

import java.sql.Date;

public class Report {

//	REPORT_NO	NUMBER
//	RPT_CONTENT	VARCHAR2(500 BYTE)
//	RPT_DATE	DATE
//	RPT_TARGET	NUMBER
//	MEM_NO	NUMBER
//	RPT_CATEGORY_NO	NUMBER
//	RPT_STATUS	VARCHAR2(1 BYTE)
	
	private int reportNo;
	private String rptContent;
	private Date rptDate;
	private int rptTarget;
	private int memNo;
	private int rptCategoryNo;
	private String rptStatus;
	private String rptCategoryName;
	private String reciveReport;
	private String sendReport;
	
	public Report() {
		super();
	}

	public Report(int reportNo, String rptContent, Date rptDate, int rptTarget, int memNo, int rptCategoryNo,
			String rptStatus) {
		super();
		this.reportNo = reportNo;
		this.rptContent = rptContent;
		this.rptDate = rptDate;
		this.rptTarget = rptTarget;
		this.memNo = memNo;
		this.rptCategoryNo = rptCategoryNo;
		this.rptStatus = rptStatus;
	}



	public Report(int reportNo, String rptContent, Date rptDate, int rptTarget, int memNo, int rptCategoryNo,
			String rptStatus, String rptCategoryName, String reciveReport, String sendReport) {
		super();
		this.reportNo = reportNo;
		this.rptContent = rptContent;
		this.rptDate = rptDate;
		this.rptTarget = rptTarget;
		this.memNo = memNo;
		this.rptCategoryNo = rptCategoryNo;
		this.rptStatus = rptStatus;
		this.rptCategoryName = rptCategoryName;
		this.reciveReport = reciveReport;
		this.sendReport = sendReport;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public String getRptContent() {
		return rptContent;
	}

	public void setRptContent(String rptContent) {
		this.rptContent = rptContent;
	}

	public Date getRptDate() {
		return rptDate;
	}

	public void setRptDate(Date rptDate) {
		this.rptDate = rptDate;
	}

	public int getRptTarget() {
		return rptTarget;
	}

	public void setRptTarget(int rptTarget) {
		this.rptTarget = rptTarget;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getRptCategoryNo() {
		return rptCategoryNo;
	}

	public void setRptCategoryNo(int rptCategoryNo) {
		this.rptCategoryNo = rptCategoryNo;
	}

	public String getRptStatus() {
		return rptStatus;
	}

	public void setRptStatus(String rptStatus) {
		this.rptStatus = rptStatus;
	}
	
	public String getRptCategoryName() {
		return rptCategoryName;
	}

	public void setRptCategoryName(String rptCategoryName) {
		this.rptCategoryName = rptCategoryName;
	}

	
	public String getReciveReport() {
		return reciveReport;
	}

	public void setReciveReport(String reciveReport) {
		this.reciveReport = reciveReport;
	}

	public String getSendReport() {
		return sendReport;
	}

	public void setSendReport(String sendReport) {
		this.sendReport = sendReport;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", rptContent=" + rptContent + ", rptDate=" + rptDate + ", rptTarget="
				+ rptTarget + ", memNo=" + memNo + ", rptCategoryNo=" + rptCategoryNo + ", rptStatus=" + rptStatus
				+ ", rptCategoryName=" + rptCategoryName + ", reciveReport=" + reciveReport + ", sendReport="
				+ sendReport + "]";
	}
	
}	// end class
