package com.zc.model;

import java.util.List;

public class searchMessage extends Message{
	private List<Dynamic> dynamics;

	public List<Dynamic> getDynamics() {
		return dynamics;
	}

	public void setDynamics(List<Dynamic> dynamics) {
		this.dynamics = dynamics;
	}

	public searchMessage() {
		super();
	}

	public searchMessage(String msg, int code, List<Dynamic> dynamics) {
		super(msg, code);
		this.dynamics=dynamics;
	}

	@Override
	public String toString() {
		return "searchMessage [dynamics=" + dynamics + "]";
	}
}
