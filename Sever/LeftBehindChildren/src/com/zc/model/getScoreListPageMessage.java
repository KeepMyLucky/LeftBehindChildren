package com.zc.model;

import java.util.List;

public class getScoreListPageMessage extends Message{
	private List<Score> rows;
	private int total;
	public getScoreListPageMessage() {
		super();
	}
	public getScoreListPageMessage(String msg, int code, int total, List<Score> rows) {
		super(msg, code);
		this.total=total;
		this.rows=rows;
	}
	public List<Score> getRows() {
		return rows;
	}
	public void setRows(List<Score> rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "getScoreListPageMessage [rows=" + rows + ", total=" + total + "]";
	}
}
