package com.zc.model;

import java.util.List;

public class getstuScoreMessage extends Message{
	private List<Score> stuScores;

	public getstuScoreMessage() {
		super();
	}

	public getstuScoreMessage(String msg, int code, List<Score> stuScores) {
		super(msg, code);
		this.stuScores=stuScores;
	}

	public List<Score> getStuScores() {
		return stuScores;
	}

	public void setStuScores(List<Score> stuScores) {
		this.stuScores = stuScores;
	}

	@Override
	public String toString() {
		return "getstuScoreMessage [stuScores=" + stuScores + "]";
	}
}
