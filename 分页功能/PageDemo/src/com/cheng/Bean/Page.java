package com.cheng.Bean;

import java.util.List;

public class Page {
	// ҳ������
	private int pageIndex;
	// ÿҳ������
	private int pageSize;
	//  ��ҳ��
	private int pageCount;
	// ��ҳ������ݼ���
	private List<?> dataList;
	// ����������
	private int total;
	// ׼��һ��������ʾ��ҳ����
	private int[] bar;
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<?> getDataList() {
		return dataList;
	}
	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int[] getBar() {
		return bar;
	}
	public void setBar(int[] bar) {
		this.bar = bar;
	}
	
	
}
