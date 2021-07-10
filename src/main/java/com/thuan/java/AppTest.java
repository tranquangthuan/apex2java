package com.thuan.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class AppTest {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		List<String> list1 = createDummyData();
		// sortWithJava7(list1);
		list1.sort((o1, o2) -> o1.compareTo(o2));
		list1.forEach(item -> System.out.println(item));
	}

	@SuppressWarnings("unused")
	private static void sortWithJava7(List<String> list) {
		list.sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
	}

	private static List<String> createDummyData() {
		List<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("C++");
		list.add("C#");
		list.add("PHP");
		list.add("Javascript");
		return list;
	}
}
