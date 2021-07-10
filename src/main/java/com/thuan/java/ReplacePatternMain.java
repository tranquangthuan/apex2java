package com.thuan.java;

import java.util.List;

public class ReplacePatternMain {

	public static void main(String[] args) {
		// testIsMatching();
		FileUtils readSourceCode = new FileUtils();
		List<String> soureCodeList = readSourceCode.read();
		ConvertUtils convertUtils = new ConvertUtils();
		List<String> soureCodeConverts = convertUtils.convert2Java(soureCodeList);
		FileUtils.write(soureCodeConverts);
	}

	public static void testIsMatching() {
		System.out.println(PatternUtils.isMatch("private Set<Id> setAbc = new Set<Id>();", "Set<Id>*Set<Id>()"));
		System.out.println(
				PatternUtils.isMatch("for (Integer i = 0; i < paidinvoicenumberlist.size(); i++)", "for*(integer"));
		System.out.println(PatternUtils.isMatch("for (integer i = 0; i < strMsgAry.size(); i++)", "for*size()"));
	}

}
