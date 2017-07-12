package com.yangkangjian.generateBean;

import java.sql.Connection;

import com.yangkangjian.generateBean.base.Const;
import com.yangkangjian.generateBean.bean.JavaFile;
import com.yangkangjian.generateBean.bean.Table;
import com.yangkangjian.generateBean.util.DBUtils;

/**
 * 
 * @author Ubuntu
 *
 */
public class Run {
	public static void main(String[] args) throws Exception {
		Connection connection = DBUtils.getConnection(Const.JDBC_DRIVER, Const.JDBC_URL, Const.JDBC_USER,
				Const.JDBC_PASSWORD);
		Table table = DBUtils.getTableInfo("yangkangjian", "classmate", connection);
		generate(table);
	}

	public static void generate(Table table) throws Exception {
		JavaFile file = JavaFile.bulid(table);
		file.bulidJavaBeanFile();
	}
}
