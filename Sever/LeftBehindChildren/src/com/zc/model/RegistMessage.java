package com.zc.model;

public class RegistMessage extends Message{
	private User user;

	public RegistMessage() {
		super();
	}

	public RegistMessage(String msg, int code) {
		super(msg, code);
	}

	public RegistMessage(User user) {
		super();
		this.user = user;
	}

	@Override
	public String toString() {
		return "RegistMessage [user=" + user + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
