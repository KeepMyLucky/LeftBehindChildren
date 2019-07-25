package com.zc.model;

import java.util.List;

public class getUserListPageMessage extends Message{
	private int total;
	private List<User> rows;
	
	public getUserListPageMessage() {
		super();
	}
	public getUserListPageMessage(String msg, int code,int total, List<User> rows) {
		super(msg, code);
		this.total=total;
		this.rows=rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<User> getRows() {
		return rows;
	}
	public void setRows(List<User> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "getUserPageMessage [total=" + total + ", rows=" + rows + "]";
	}
}
