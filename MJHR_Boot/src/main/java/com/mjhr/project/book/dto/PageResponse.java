package com.mjhr.project.book.dto;

import java.util.List;

public class PageResponse<T> {
	private List<T> data;
	private int currentPage;
	private int pageSize;
	private int totalPages;
	private int totalItems;

	public PageResponse(List<T> data, int currentPage, int pageSize, int totalPages, int totalItems) {
		this.data = data;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.totalItems = totalItems;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
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

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	@Override
	public String toString() {
		return "PageResponse [data=" + data + ", currentPage=" + currentPage + ", pageSize=" + pageSize
				+ ", totalPages=" + totalPages + ", totalItems=" + totalItems + "]";
	}

	// Getters and Setters
	
	
}
