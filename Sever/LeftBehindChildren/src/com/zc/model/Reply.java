package com.zc.model;

public class Reply {
	private String rid;

    private String cid;

    private int uid;
    
    private int ruid;

    private String replycontent;

    private String timestamp;

	public Reply() {
		super();
	}

	public Reply(String rid, String cid, int uid, int ruid, String replycontent, String timestamp) {
		super();
		this.rid = rid;
		this.cid = cid;
		this.uid = uid;
		this.ruid = ruid;
		this.replycontent = replycontent;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", cid=" + cid + ", uid=" + uid + ", ruid=" + ruid + ", replycontent=" + replycontent + ", timestamp="
				+ timestamp + "]";
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid== null ? null : cid.trim();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int getRuid() {
		return ruid;
	}

	public void setRuid(int ruid) {
		this.ruid = ruid;
	}

	public String getReplycontent() {
		return replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent== null ? null : replycontent.trim();
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp== null ? null : timestamp.trim();
	}
}
