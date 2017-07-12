package com.yangkangjian.generateBean.util;

import java.io.File;

import org.apache.log4j.Logger;

public class FileUtils {
	private static Logger log = Logger.getLogger(FileUtils.class);

	public static void createFile(String path) throws Exception {
		File file = new File(path);
		log.info("文件路径" + file.getPath());
		if (!file.getParentFile().exists()) {
			log.info("没有父级目录，正在创建父级目录:" + file.getParent());
			if (file.getParentFile().mkdirs()) {
				log.info("父级目录:" + file.getParent() + "创建成功");
			}
		}
		if (file.exists()) {
			log.info("文件:" + file.getName() + "已经存在，删除:" + file.getName() + "...");
			if (file.delete()) {
				log.info("文件:" + file.getName() + "删除成功...");
			}
		}
		log.info("创建新的文件:" + file.getName() + "...");
		if (file.createNewFile()) {
			log.info("文件:" + file.getName() + "创建成功");
		}
	}

}
