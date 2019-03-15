package com.test.login.common;

import static com.test.login.common.HrmConstants.PAGE_DEFAULT_SIZE;


public class PageModel {
	//总数据
	private int recordCount;

	//当前页码
	private int pageIndex;
	
	//页显示多少条数据
	private int pageSize = PAGE_DEFAULT_SIZE = 5;
	
	//总页码
	private int totalSize;

	public int getRecordCount() {
		this.recordCount = this.recordCount <=0 ? 0 :this.recordCount;
		return recordCount;
	}

	public void setRecordCount(int recordCount) {    
		this.recordCount = recordCount;
	}

	public int getPageIndex() {
		this.pageIndex = this.pageIndex <=0 ? 1 :this.pageIndex;
		//当前页码是否超过总页数
		this.pageIndex = this.pageIndex>=this.getTotalSize() ? this.getTotalSize():this.pageIndex;
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		this.pageSize = this.pageSize >= PAGE_DEFAULT_SIZE ? this.pageSize :PAGE_DEFAULT_SIZE;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalSize() {
		if(this.getRecordCount()<=0){
			this.totalSize =0;
		}else{
			this.totalSize =(this.getRecordCount()-1)/this.getPageSize()+1;
		}
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	//当前页面前面的数据
	public int getFirstLimitParam(){
		return (this.getPageIndex()-1)*this.getPageSize();
	}
	
}
