package com.test.login.common;

import static com.test.login.common.HrmConstants.PAGE_DEFAULT_SIZE;


public class PageModel {
	//������
	private int recordCount;

	//��ǰҳ��
	private int pageIndex;
	
	//ҳ��ʾ����������
	private int pageSize = PAGE_DEFAULT_SIZE = 5;
	
	//��ҳ��
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
		//��ǰҳ���Ƿ񳬹���ҳ��
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
	//��ǰҳ��ǰ�������
	public int getFirstLimitParam(){
		return (this.getPageIndex()-1)*this.getPageSize();
	}
	
}
