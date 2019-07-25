package com.zc.model;

public class MessageBoard {
	
    private int uid;
	
	private String timestamp;
	
	private String messagecontent;

	public MessageBoard() {
		super();
	}

	public MessageBoard(int uid, String timestamp, String messagecontent) {
		super();
		this.uid = uid;
		this.timestamp = timestamp;
		this.messagecontent = messagecontent;
	}

	@Override
	public String toString() {
		return "MessageBoard [uid=" + uid + ", timestamp=" + timestamp + ", messagecontent=" + messagecontent + "]";
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp == null ? null : timestamp.trim();
	}

	public String getMessagecontent() {
		return messagecontent;
	}

	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent == null ? null : timestamp.trim();
	}
	
}
