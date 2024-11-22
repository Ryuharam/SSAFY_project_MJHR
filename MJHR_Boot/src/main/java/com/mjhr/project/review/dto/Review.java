package com.mjhr.project.review.dto;

public class Review {
	private String reviewId;
	private String userId;
	private String isbn;
	private String reviewTitle;
	private String reviewContent;

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", userId=" + userId + ", isbn=" + isbn + ", reviewTitle=" + reviewTitle
				+ ", reviewContent=" + reviewContent + "]";
	}

}
