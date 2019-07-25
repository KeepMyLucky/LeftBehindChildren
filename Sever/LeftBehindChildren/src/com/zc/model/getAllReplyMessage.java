package com.zc.model;

import java.util.List;

public class getAllReplyMessage extends Message{
	
	private List<Reply> replys;

	public getAllReplyMessage() {
		super();
	}
	
	public getAllReplyMessage(String msg, int code, List<Reply> replys) {
		super(msg, code);
		this.replys=replys;
	}

	@Override
	public String toString() {
		return "getAllReplyMessage [replys=" + replys + "]";
	}

	public List<Reply> getReplys() {
		return replys;
	}

	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}
}
