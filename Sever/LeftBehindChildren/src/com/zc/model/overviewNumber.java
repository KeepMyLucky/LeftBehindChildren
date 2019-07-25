package com.zc.model;

public class overviewNumber {
	private int userNumber;
	private int dynamicNumber;
	private int commentNumber;
	private int bookNumber;
	public overviewNumber(int userNumber, int dynamicNumber, int commentNumber, int bookNumber) {
		super();
		this.userNumber = userNumber;
		this.dynamicNumber = dynamicNumber;
		this.commentNumber = commentNumber;
		this.bookNumber = bookNumber;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public int getDynamicNumber() {
		return dynamicNumber;
	}
	public void setDynamicNumber(int dynamicNumber) {
		this.dynamicNumber = dynamicNumber;
	}
	public int getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	@Override
	public String toString() {
		return "overviewNumber [userNumber=" + userNumber + ", dynamicNumber=" + dynamicNumber + ", commentNumber="
				+ commentNumber + ", bookNumber=" + bookNumber + "]";
	}
}
