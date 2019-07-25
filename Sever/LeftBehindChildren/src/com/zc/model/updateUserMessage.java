package com.zc.model;

public class updateUserMessage extends Message{
	private User user;

	public updateUserMessage() {
		super();
	}

	public updateUserMessage(String msg, int code, User user) {
		super(msg, code);
		this.user=user;
	}

	@Override
	public String toString() {
		return "updateUserMessage [user=" + user + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
