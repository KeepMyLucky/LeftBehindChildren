package com.zc.model;

public class getCommentMessage extends Message{
	private Comment comment;

	public getCommentMessage() {
		super();
	}

	public getCommentMessage(String msg, int code, Comment comment) {
		super(msg, code);
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "getAllCommentMessage [comment=" + comment + "]";
	}

	public Comment getCommnets() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
}
