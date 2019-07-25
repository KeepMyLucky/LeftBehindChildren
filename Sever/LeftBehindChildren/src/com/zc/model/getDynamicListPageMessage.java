package com.zc.model;

import java.util.List;

public class getDynamicListPageMessage extends Message{
	private int total;
	private List<Dynamic> rows;

	public getDynamicListPageMessage() {
		super();
	}

	public getDynamicListPageMessage(String msg, int code, int total, List<Dynamic> rows) {
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

	public List<Dynamic> getRows() {
		return rows;
	}

	public void setRows(List<Dynamic> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "getDynamicListPageMessage [total=" + total + ", rows=" + rows + "]";
	}
}
