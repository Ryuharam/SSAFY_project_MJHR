package com.mjhr.project.user.dto;

public class User {
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private String userNic;
	private String userImg;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
	    if (userEmail == null || userEmail.isEmpty()) {
	        throw new IllegalArgumentException("이메일은 필수 입력 항목");
	    }
	    this.userEmail = userEmail;
	}

	public String getUserNic() {
		return userNic;
	}
	public void setUserNic(String userNic) {
		this.userNic = userNic;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userNic=" + userNic + ", userImg=" + userImg + "]";
	}
	
	
}
