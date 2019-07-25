package com.zc.model;

public class Comment {
	
	private String cid;
	
	private String did;
	
	private int uid;
	
	private String details;

    private String timestamp;

	public Comment() {
		super();
	}

	public Comment(String cid, String did, int uid, String details, String timestamp) {
		super();
		this.cid = cid;
		this.did = did;
		this.uid = uid;
		this.details = details;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", did=" + did + ", uid=" + uid + ", details=" + details + ", timestamp="
				+ timestamp + "]";
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid== null ? null : cid.trim();
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did== null ? null : did.trim();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details== null ? null : details.trim();
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp== null ? null : timestamp.trim();
	}
	
}
