package com.zc.model;

public class LoginMessage extends Message{
	private User user;

	public LoginMessage() {
		super();
	}

	public LoginMessage(String msg, int code) {
		super(msg, code);
	}

	public LoginMessage(User user) {
		super();
		this.user = user;
	}

	@Override
	public String toString() {
		return "LoginMessage [user=" + user + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
