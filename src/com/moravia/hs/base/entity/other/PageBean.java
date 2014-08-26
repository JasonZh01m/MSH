package com.moravia.hs.base.entity.other;

import java.util.List;

import javax.persistence.Entity;

public class PageBean {
	private List list;	// 要返回的某一页的九路列表
	
	private int allRow;		// 总记录数
	private int totalPage;	// 总页数
	private int currentPage;	// 当前页
	private int pageSize;	// 每页记录数
	private String strpage;	// 链接增加的字符参数
	
	private boolean isFirstPage;	// 是否为第一页
	private boolean isLastPage;		// 是否是最后一页
	private boolean hasPreviousPage; 	// 是否有前一页
	private boolean hasNextPage;	// 是否有下一页
	
	
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getStrpage() {
		return strpage;
	}
	public void setStrpage(String strpage) {
		this.strpage = strpage;
	}
	
	
	public void init(){
        this.isFirstPage = isFirstPage();
        this.isLastPage = isLastPage();
        this.hasPreviousPage = hasPreviousPage();
        this.hasNextPage = hasNextPage();
    }
	
	public boolean isFirstPage() {
		return currentPage == 1;	// 如果当前是第一页
	}

	public boolean isLastPage() {	
		return currentPage == totalPage;	// 如果当前页是最后一页
	}

	public boolean hasPreviousPage() {
		return currentPage != 1;	// 只要当前页不是第一页
	}

	public boolean hasNextPage() {
		return currentPage != totalPage;	// 只要当前页不是最后一页
	}
	
	// 计算总页数
	public static int countTotalPage(final int pageSize, final int allRow) {
		int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
		if(totalPage == 0) {
			totalPage = 1;
		}
		return totalPage;
	}
	
	public static int countOffset(final int pageSize, final int currentPage) {
		final int offset = pageSize * (currentPage - 1);
		return offset;
	}
	
	public static int countCurrentPage(int page) {
		final int curPage = (page == 0 ? 1 : page);
		return curPage;
	}
	
	
	
}
