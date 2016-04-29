/**
 * 建立用户信息类
 */


package com.qq.common;

public class User implements java.io.Serializable{

	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	private String passWord;
}
