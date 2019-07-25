package com.zc.model;

public class getReplyMessage extends Message{
	
	private Reply reply;

	public getReplyMessage() {
		super();
	}

	public getReplyMessage(String msg, int code, Reply reply) {
		super(msg, code);
		this.reply=reply;
	}

	@Override
	public String toString() {
		return "getReplyMessage [reply=" + reply + "]";
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}
}
