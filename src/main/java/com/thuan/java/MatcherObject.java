package com.thuan.java;

import java.util.List;

public class MatcherObject {
	private String wildCardPattern;
	private List<ReplaceCode> replaceCodes;

	public MatcherObject(String wildCardPattern, List<ReplaceCode> replaceCodes) {
		super();
		this.wildCardPattern = wildCardPattern;
		this.replaceCodes = replaceCodes;
	}

	public String getWildCardPattern() {
		return wildCardPattern;
	}

	public void setWildCardPattern(String wildCardPattern) {
		this.wildCardPattern = wildCardPattern;
	}

	public List<ReplaceCode> getReplaceCodes() {
		return replaceCodes;
	}

	public void setReplaceCodes(List<ReplaceCode> replaceCodes) {
		this.replaceCodes = replaceCodes;
	}

}
