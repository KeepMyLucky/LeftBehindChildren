package com.zc.model;

import java.util.List;

public class getclassInListMessage extends Message{
	private List<String> classInList;

	public getclassInListMessage() {
		super();
	}

	public getclassInListMessage(String msg, int code, List<String> classInList) {
		super(msg, code);
		this.classInList=classInList;
	}

	public List<String> getClassInList() {
		return classInList;
	}

	public void setClassInList(List<String> classInList) {
		this.classInList = classInList;
	}

	@Override
	public String toString() {
		return "getclassInListMessage [classInList=" + classInList + "]";
	}
}
