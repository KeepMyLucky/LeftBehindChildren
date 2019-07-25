package com.zc.model;

public class Dynamic {
	
	private String did;
	
	private int uid;

    private String timestamp;

    private String details;
    
    private String pic;

	public Dynamic() {
		super();
	}

	public Dynamic(String did, int uid, String timestamp, String details, String pic) {
		super();
		this.did = did;
		this.uid = uid;
		this.timestamp = timestamp;
		this.details = details;
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "Dynamic [did=" + did + ", uid=" + uid +", timestamp=" + timestamp
				+ ", details=" + details + ", pic=" + pic + "]";
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did == null ? null : did.trim();
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details == null ? null : details.trim();
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic == null ? null : pic.trim();
	}
}
