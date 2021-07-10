package com.thuan.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	public List<String> read() {
		List<String> soureCodeList = new ArrayList<String>();
		File file = new File("D:\\SalesForce\\SalesForce2\\force-app\\main\\default\\classes\\TestController.cls");

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {
				soureCodeList.add(st);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return soureCodeList;
	}

	public static void write(List<String> soureCodeList) {
		try {
			FileWriter writer = new FileWriter("TestController.java");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			for (String string : soureCodeList) {
				bufferedWriter.write(string);
				bufferedWriter.newLine();
			}

			bufferedWriter.close();
			System.out.println("write file success");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
