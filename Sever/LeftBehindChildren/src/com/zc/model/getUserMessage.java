package com.zc.model;

public class getUserMessage extends  Message{
	private User user;

	public getUserMessage() {
		super();
	}

	public getUserMessage(String msg, int code, User user) {
		super(msg, code);
		this.user = user;
	}

	@Override
	public String toString() {
		return "getUserMessage [user=" + user + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
