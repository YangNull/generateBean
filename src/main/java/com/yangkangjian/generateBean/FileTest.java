package com.yangkangjian.generateBean;

import java.io.File;
import java.io.FileWriter;

public class FileTest {
	public static void main(String[] args) throws Exception {
		String path = "D:" + File.separator + "temp" + File.separator + "Classmate.java";
		File file = new File("D:" + File.separator + "temp" + File.separator + "Classmate.java");
		FileWriter writer = new FileWriter(path, true);
		writer.write("public class Classmate{");
		writer.write("\n");
		writer.write("\n");
		writer.write("\t");
		writer.write("public String name");
		writer.write("\n");
		writer.write("\n");
		writer.write("}");
		writer.flush();
	}
}
