package com.study.springrest.domain;

public class PageMaker {
	
	int totalArticles = 175;
	int startPage;
	int endPage;
	
	int pagePerBlock = 10;
	
	boolean next = false;
	boolean prev = false;
	
	Criteria criteria;
	
	public PageMaker(Criteria cri, int total) {
		
		criteria = cri; // 현재 페이지
		totalArticles = total;
		process();
		
	}
	
	private void process() {
		
		// 총 페이지 수 18
		int totalPages = (int)Math.ceil(totalArticles / (double)pagePerBlock); 
		
		// 요청한 페이지 12
		int currentPage = criteria.getPage();
		
		// 페이지 번호가 끝나는 숫자
		endPage = ((int)Math.ceil(currentPage / (double)pagePerBlock)) * pagePerBlock ;
		
		// 페이지 번호가 시작되는 숫자
		startPage = (endPage - pagePerBlock) + 1;
		
		if(endPage > totalPages) {
			endPage = totalPages;
		}
		
		// 이전페이지블럭 유무
		if(startPage > 1) {
			prev = true;
		}
		// 다음페이지블럭 유무
		if(endPage < totalPages) {
			next = true;
		}
	}

	public int getTotalArticles() {
		return totalArticles;
	}

	public void setTotalArticles(int totalArticles) {
		this.totalArticles = totalArticles;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
	


}
