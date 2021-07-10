package com.thuan.java;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ConvertUtils {

	public List<String> convert2Java(List<String> sourceCodeList) {
		List<String> sourceCodeConvert = new ArrayList<String>();
		for (String lineCode : sourceCodeList) {
			if (isSkipLine(lineCode)) {
				// line code comment or blank line
				// No replace
				sourceCodeConvert.add(lineCode);
			} else {
				List<MatcherObject> patternMatchs = PatternUtils.findPatternMatching(lineCode);
				if (patternMatchs != null && patternMatchs.size() > 0) {
					String codeAfterReplace = lineCode;
					for (MatcherObject matcherObject : patternMatchs) {
						codeAfterReplace = replaceByDefineList(codeAfterReplace, matcherObject.getReplaceCodes());
					}
					sourceCodeConvert.add(codeAfterReplace);
				} else {
					// line code not matcher any patter
					sourceCodeConvert.add(lineCode);
				}
			}
		}

		return sourceCodeConvert;
	}

	public String replaceByDefineList(String lineCode, List<ReplaceCode> replaceCodes) {
		for (ReplaceCode replaceCode : replaceCodes) {
			lineCode = StringUtils.replaceOnceIgnoreCase(lineCode, replaceCode.getOldChar(), replaceCode.getNewChar());
		}

		return lineCode;
	}

	public boolean isSkipLine(String lineCode) {
		lineCode = StringUtils.trimToEmpty(lineCode);
		if (StringUtils.isEmpty(lineCode) || StringUtils.isBlank(lineCode) || lineCode.startsWith("//")) {
			return true;
		}
		return false;
	}
}
