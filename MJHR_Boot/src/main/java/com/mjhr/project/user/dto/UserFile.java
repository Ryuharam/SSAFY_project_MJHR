package com.mjhr.project.user.dto;

public class UserFile {
	private String userId;
	private String userFilePath;
	private String userFileName;

	public String getUserFilePath() {
		return userFilePath;
	}

	public void setUserFilePath(String userFilePath) {
		this.userFilePath = userFilePath;
	}

	public String getUserFileName() {
		return userFileName;
	}

	public void setUserFileName(String userFileName) {
		this.userFileName = userFileName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserFile [userFilePath=" + userFilePath + ", userFileName=" + userFileName + "]";
	}

}
