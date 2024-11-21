package com.mjhr.project.review.dto;

public class ReviewComment {
	private String commentId;
	private String userId;
	private String reviewId;
	private String commentContent;

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	@Override
	public String toString() {
		return "ReviewComment [commentId=" + commentId + ", userId=" + userId + ", reviewId=" + reviewId
				+ ", commentContent=" + commentContent + "]";
	}

}
