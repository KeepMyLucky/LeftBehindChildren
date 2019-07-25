package com.zc.model;

public class overviewMessage extends Message{
	private overviewNumber overviewNumber;
	public overviewMessage() {
		super();
	}
	public overviewMessage(String msg, int code, overviewNumber overviewNumber) {
		super(msg, code);
		this.overviewNumber=overviewNumber;
	}
	public overviewNumber getOverviewNumber() {
		return overviewNumber;
	}
	public void setOverviewNumber(overviewNumber overviewNumber) {
		this.overviewNumber = overviewNumber;
	}
	@Override
	public String toString() {
		return "overviewMessage [overviewNumber=" + overviewNumber + "]";
	}
}
