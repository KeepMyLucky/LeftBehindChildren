package com.zc.model;

import java.util.List;

public class getAllCommentMessage extends Message{
	
	private List<Comment> comments;

	public getAllCommentMessage() {
		super();
	}

	public getAllCommentMessage(String msg, int code, List<Comment> comments) {
		super(msg, code);
		this.comments=comments;
	}

	@Override
	public String toString() {
		return "getAllCommentMessage [comments=" + comments + "]";
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
