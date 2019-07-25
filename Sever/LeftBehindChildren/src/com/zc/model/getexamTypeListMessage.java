package com.zc.model;

import java.util.List;

public class getexamTypeListMessage extends Message{
	private List<String> examTypeList;

	public getexamTypeListMessage() {
		super();
	}

	public getexamTypeListMessage(String msg, int code, List<String> examTypeList) {
		super(msg, code);
		this.examTypeList = examTypeList;
	}

	public List<String> getExamTypeList() {
		return examTypeList;
	}

	public void setExamTypeList(List<String> examTypeList) {
		this.examTypeList = examTypeList;
	}

	@Override
	public String toString() {
		return "getexamTypeListMessage [examTypeList=" + examTypeList + "]";
	}
}
