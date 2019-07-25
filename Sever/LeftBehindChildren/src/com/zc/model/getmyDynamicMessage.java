package com.zc.model;

import java.util.List;

public class getmyDynamicMessage extends Message{
	private List<Dynamic> myDynamics;

	public getmyDynamicMessage() {
		super();
	}

	public getmyDynamicMessage(String msg, int code, List<Dynamic> myDynamics) {
		super(msg, code);
		this.myDynamics=myDynamics;
	}

	public List<Dynamic> getMyDynamics() {
		return myDynamics;
	}

	public void setMyDynamics(List<Dynamic> myDynamics) {
		this.myDynamics = myDynamics;
	}

	@Override
	public String toString() {
		return "getmyDynamicMessage [myDynamics=" + myDynamics + "]";
	}
}
