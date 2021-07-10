package com.thuan.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

public class PatternUtils {

	public static List<MatcherObject> getClassPatterns() {
		List<MatcherObject> matcherObjects = new ArrayList<MatcherObject>();
		matcherObjects
				.add(new MatcherObject("Set<Id>*Set<Id>()", Arrays.asList(new ReplaceCode("Set<Id>", "Set<String>"),
						new ReplaceCode("Set<Id>", "LinkedHashSet<String>"))));

		matcherObjects.add(new MatcherObject("Decimal", Arrays.asList(new ReplaceCode("Decimal", "BigDecimal"))));
		matcherObjects.add(new MatcherObject("for*(integer", Arrays.asList(new ReplaceCode("integer", "int"),
				new ReplaceCode("Integer", "int"), new ReplaceCode("INTEGER", "int"))));
		matcherObjects.add(new MatcherObject("for*size()", Arrays.asList(new ReplaceCode("size()", "length"))));

		return matcherObjects;
	}

	public static List<MatcherObject> findPatternMatching(String lineCode) {
		List<MatcherObject> patternMatchs = new ArrayList<MatcherObject>();
		List<MatcherObject> matcherObjects = getClassPatterns();
		for (MatcherObject matcherObject : matcherObjects) {
			String wildCardPattern = matcherObject.getWildCardPattern();
			if (isMatch(lineCode, wildCardPattern)) {
				patternMatchs.add(matcherObject);
			}
		}

		return patternMatchs;
	}

	public static boolean isMatch(String lineCode, String wildCardPattern) {
		lineCode = lineCode.toLowerCase();
		wildCardPattern = wildCardPattern.toLowerCase();
		StringTokenizer wildcardToken = new StringTokenizer(wildCardPattern, "*");
		int countMatchingPatten = 0;
		int totalToken = 0;
		while (wildcardToken.hasMoreTokens()) {
			totalToken++;
			String wildcard = wildcardToken.nextToken();
			if (lineCode.contains(wildcard)) {
				lineCode = StringUtils.replaceOnceIgnoreCase(lineCode, wildcard, "");
				countMatchingPatten++;
			}
		}

		if (countMatchingPatten == totalToken) {
			return true;
		}

		return false;
	}

}
