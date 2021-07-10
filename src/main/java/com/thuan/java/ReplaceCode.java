package com.thuan.java;

public class ReplaceCode {

	private String oldChar;
	private String newChar;

	public ReplaceCode(String oldChar, String newChar) {
		super();
		this.oldChar = oldChar;
		this.newChar = newChar;
	}

	public String getOldChar() {
		return oldChar;
	}

	public void setOldChar(String oldChar) {
		this.oldChar = oldChar;
	}

	public String getNewChar() {
		return newChar;
	}

	public void setNewChar(String newChar) {
		this.newChar = newChar;
	}

}
