package com.zc.model;

public class Message {
	/**
	 * 放结果的消息
	 */
	private String msg;
	/**
	 * 1：成功
	 * 0：失败
	 * 默认失败
	 */
	private int code=FAIL;
	public static final int SUCCESS=1;
	public static final int FAIL=0;
	public Message() {
		super();
	}
	public Message(String msg, int code) {
		super();
		this.msg = msg;
		this.code = code;
	}
	@Override
	public String toString() {
		return "Message [msg=" + msg + ", code=" + code + "]";
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public static int getSuccess() {
		return SUCCESS;
	}
	public static int getFail() {
		return FAIL;
	}
}
