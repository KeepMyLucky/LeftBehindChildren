package com.zc.model;

import java.util.List;

public class getAllUserMessage extends Message{
	private List<User> users;

	public getAllUserMessage() {
		super();
	}

	public getAllUserMessage(String msg, int code, List<User> users) {
		super(msg, code);
		this.users=users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "getAllUserMessage [users=" + users + "]";
	}
	
}
