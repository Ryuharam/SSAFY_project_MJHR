package com.mjhr.project.review.dto;

public class ReviewLike {
	private int reviewLikeId;
	private String userId;
	private String reviewId;
	private String reviewTitle;
	private String userNic;

	public int getReviewLikeId() {
		return reviewLikeId;
	}

	public void setReviewLikeId(int reviewLikeId) {
		this.reviewLikeId = reviewLikeId;
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

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getUserNic() {
		return userNic;
	}

	public void setUserNic(String userNic) {
		this.userNic = userNic;
	}

	@Override
	public String toString() {
		return "ReviewLike [reviewLikeId=" + reviewLikeId + ", userId=" + userId + ", reviewId=" + reviewId
				+ ", reviewTitle=" + reviewTitle + ", userNic=" + userNic + "]";
	}

}
