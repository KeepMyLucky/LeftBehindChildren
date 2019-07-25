package com.zc.model;

import java.util.List;

public class getAllDynamicMessage extends Message{
	private List<Dynamic> dynamics;

	public getAllDynamicMessage() {
		super();
	}

	public getAllDynamicMessage(String msg, int code, List<Dynamic> dynamics) {
		super(msg, code);
		this.dynamics = dynamics;
	}

	public List<Dynamic> getDynamics() {
		return dynamics;
	}

	public void setDynamics(List<Dynamic> dynamics) {
		this.dynamics = dynamics;
	}

	@Override
	public String toString() {
		return "getAllDynamicMessage [dynamics=" + dynamics + "]";
	}
}
