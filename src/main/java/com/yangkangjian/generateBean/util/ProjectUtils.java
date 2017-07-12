package com.yangkangjian.generateBean.util;

/**
 * 一些项目的杂七杂八工具
 * 
 * @author Ubuntu
 *
 */
public class ProjectUtils {
	/**
	 * 类名的生成
	 * 
	 * @param name
	 * @param split
	 * @return
	 */
	public static String generateClassName(String name, String split) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(name.substring(0, 1).toUpperCase()).append(name.substring(1).toLowerCase());
		return buffer.toString();
	}

	/**
	 * 生成方法名，通常get和set的方法名是setXXX和getXXX,XXX首字母大写
	 * 
	 * @param name
	 * @param split
	 * @return
	 */
	public static String generateMehtodName(String name, String split) {
		String[] words = name.toLowerCase().split(split);
		int size = words.length;
		StringBuffer buffer = new StringBuffer();
		for (int index = 0; index < size; index++) {
			buffer.append(words[index].substring(0, 1).toUpperCase()).append(words[index].substring(1));
		}
		return buffer.toString();
	}

	public static String generateFieldName(String name, String split) {
		String[] words = name.toLowerCase().split(split);
		int size = words.length;
		StringBuffer buff = new StringBuffer();
		// 第一个字母首字母小写
		buff.append(words[0].substring(0, 1).toLowerCase()).append(words[0].substring(1));
		for (int i = 1; i < size; i++) {
			buff.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1));
		}
		return buff.toString();
	}

	public static void main(String[] args) {
	}
}
