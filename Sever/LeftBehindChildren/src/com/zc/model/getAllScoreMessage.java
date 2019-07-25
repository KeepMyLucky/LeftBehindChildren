package com.zc.model;

import java.util.List;

public class getAllScoreMessage extends Message{
	
	private List<Score> scores;

	public getAllScoreMessage() {
		super();
	}

	public getAllScoreMessage(String msg, int code, List<Score> scores) {
		super(msg, code);
		this.scores=scores;
	}

	@Override
	public String toString() {
		return "getAllScoreMessage [scores=" + scores + "]";
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
}
