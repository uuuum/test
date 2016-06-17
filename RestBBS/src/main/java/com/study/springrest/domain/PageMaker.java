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
		
		criteria = cri; // ���� ������
		totalArticles = total;
		process();
		
	}
	
	private void process() {
		
		// �� ������ �� 18
		int totalPages = (int)Math.ceil(totalArticles / (double)pagePerBlock); 
		
		// ��û�� ������ 12
		int currentPage = criteria.getPage();
		
		// ������ ��ȣ�� ������ ����
		endPage = ((int)Math.ceil(currentPage / (double)pagePerBlock)) * pagePerBlock ;
		
		// ������ ��ȣ�� ���۵Ǵ� ����
		startPage = (endPage - pagePerBlock) + 1;
		
		if(endPage > totalPages) {
			endPage = totalPages;
		}
		
		// ������������ ����
		if(startPage > 1) {
			prev = true;
		}
		// ������������ ����
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
