package com.zc.model;

public class AdminloginMessage extends Message{
	private Admin admin;

	public AdminloginMessage() {
		super();
	}

	public AdminloginMessage(String msg, int code, Admin admin) {
		super(msg, code);
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "AdminloginMessage [admin=" + admin + "]";
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
