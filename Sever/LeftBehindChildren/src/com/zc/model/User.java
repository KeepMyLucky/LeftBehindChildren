
package com.zc.model;

 

public class User{

    private int uid;

    private String username;

    private String password;
    
    private String level;
    
    private String avatar;

 

    public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level == null ? null : level.trim();
	}

	public int getUid() {

        return uid;

    }

    public void setUid(int uid) {

        this.uid = uid;

    }

    public String getUsername() {

		return username;

	}

	public void setUsername(String username) {

		this.username = username == null ? null : username.trim();

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password == null ? null : password.trim();

	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar ==null ? null : avatar.trim();
	}

	public User() {
		super();
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", level=" + level + ", avatar="
				+ avatar + "]";
	}

	public User(int uid, String username, String password, String level, String avatar) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.level = level;
		this.avatar = avatar;
	}

}