package com.dreamchain.skeleton.model;

public class PageBean {
	private int page;//当前页
	private int pageSize;//每页的记录数
	private int start;//起始页
	
	public PageBean(int page,int pageSize){
		this.page = page;
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStart() {
		return (page-1)*pageSize;
	}

	public void setStart(int start) {
		this.start = start;
	}
	
	
	
	
	
//	//传递的参数或配置的值
//	private int currentPage;//当前页
//	private int pageSize;//每页的记录条数
//	
//	//查询数据库
//	private int recordCount;//总记录数
//	private List recordList;//要显示的数据
//	
//	//通过计算得出
//	private int pageCount;//总页数
//	private int beginPageIndex;//开始页码
//	private int endPageIndex;//结束页
//	
//	public PageBean(int currentPage,int pageSize,int recordCount,List recordList){
//		this.currentPage = currentPage;
//		this.pageSize = currentPage;
//		this.recordCount = recordCount;
//		this.recordList = recordList;
//		
//		//计算pageCount
//		this.pageCount = (recordCount + pageSize - 1)/pageSize;
//		//计算beginPageIndex和endPageIndex
//		//当总页数不大于5时，全部显示
//		if(pageCount<=5){
//			beginPageIndex = 1;
//			endPageIndex = pageCount;
//		}
//		//当总页数大于10，显示附近的10页
//		else{
//			beginPageIndex = currentPage - 4;
//			endPageIndex = currentPage + 5;
//			//当beginPageIndex<1,显示前5页
//			if(beginPageIndex<1){
//				beginPageIndex = 1;
//				endPageIndex = 5;
//			}else if(endPageIndex>pageCount){
//			//当endPageIndex>pageCount,显示后10页
//				beginPageIndex = endPageIndex - 4;
//				endPageIndex = pageCount;
//			}
//		}
//	}
//	
//	
//	
//	public int getCurrentPage() {
//		return currentPage;
//	}
//	public void setCurrentPage(int currentPage) {
//		this.currentPage = currentPage;
//	}
//	public int getPageSize() {
//		return pageSize;
//	}
//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}
//	public int getRecordCount() {
//		return recordCount;
//	}
//	public void setRecordCount(int recordCount) {
//		this.recordCount = recordCount;
//	}
//	public List getRecordList() {
//		return recordList;
//	}
//	public void setRecordList(List recordList) {
//		this.recordList = recordList;
//	}
//	public int getPageCount() {
//		return pageCount;
//	}
//	public void setPageCount(int pageCount) {
//		this.pageCount = pageCount;
//	}
//	public int getBeginPageIndex() {
//		return beginPageIndex;
//	}
//	public void setBeginPageIndex(int beginPageIndex) {
//		this.beginPageIndex = beginPageIndex;
//	}
//	public int getEndPageIndex() {
//		return endPageIndex;
//	}
//	public void setEndPageIndex(int endPageIndex) {
//		this.endPageIndex = endPageIndex;
//	}
//	
	
}
