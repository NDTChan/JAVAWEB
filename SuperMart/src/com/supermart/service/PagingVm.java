package com.supermart.service;

import java.util.List;

public class PagingVm<T> {
	protected long Total;
	protected int CurrentPage;
	protected List<T> Data;
	protected String KeySearch;
	
	public String getKeySearch() {
		return KeySearch;
	}
	public void setKeySearch(String keySearch) {
		KeySearch = keySearch;
	}
	public long getTotal() {
		return Total;
	}
	public void setTotal(long total) {
		Total = total;
	}
	public int getCurrentPage() {
		return CurrentPage;
	}
	public void setCurrentPage(int currentPage) {
		CurrentPage = currentPage;
	}
	public List<T> getData() {
		return Data;
	}
	
	public void setData(List<T> data) {
		Data = data;
	}
	public PagingVm() {
		super();
	}
}
