package com.kh.semi.common.model.vo;

/**
 * @author MJY
 * 기본 SQL문 : SELECT COUNT(*)
 */
public class PageInfo {
	
	
	int listCount; // 현재 게시글 총 개수
	int currentPage; // 현재 페이지(사용자가 요청한 페이지)
	int pageLimit; // 한 페이지에 보여질 페이징 바의 최대 개수 (페이지 하단에 보여질 페이징바의 최대 개수)
	int boardLimit; // 한 페이지에 최대 몇개의 게시글을 보여줄건지 (한 페이지에 보여질 게시글의 최대 개수)
	
	int maxPage; // 가장 마지막 페이지가 몇 번 페이지인지(총 페이지의 개수)
	int startPage; // 페이지 하단에 보여질 페이징바의 시작 수
	int endPage; // 페이지 하단에 보여질 페이징바의 끝 수
	
	
	public PageInfo() {
		super();
	}
	
	/**
	 * 페이지들을 자동계산해 전 필드 초기화하는 생성자
	 * @param listCount   : 총 게시글 개수 합산
	 * @param currentPage : 현재 사용자가 요청한 페이지
	 * @param pageLimit	  : 한 페이지에 보일 페이징바 최대 개수
	 * @param boardLimit  : 한 페이지에 보일 게시글 수
	 * 
	 */
	public PageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		
		int mPage = (int)(Math.ceil((double)listCount / boardLimit));
		int sPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int ePage = sPage + pageLimit - 1;
		
		this.maxPage = mPage;
		this.startPage = sPage;
		this.endPage = (ePage > mPage) ? mPage : ePage;
	}
	
	public PageInfo(int listCount, int currentPage, int pageLimit, int boardLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getListCount() {
		return listCount;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public int getPageLimit() {
		return pageLimit;
	}
	
	public int getBoardLimit() {
		return boardLimit;
	}
	
	public int getMaxPage() {
		return maxPage;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	
	@Override
	public String toString() {
		return "PageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", boardLimit=" + boardLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
	
	
}//class.end