package com.yangkangjian.generateBean.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.log4j.Logger;

import com.yangkangjian.generateBean.bean.BeanField;
import com.yangkangjian.generateBean.bean.BeanMethod;
import com.yangkangjian.generateBean.bean.Column;
import com.yangkangjian.generateBean.bean.Table;

public class DBUtils {
	private static Logger log = Logger.getLogger(FileUtils.class);

	public static Connection getConnection(String driver, String url, String user, String password) {
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void close(Connection conn, PreparedStatement prp, ResultSet re) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (prp != null) {
				prp.close();
			}
			if (re != null) {
				prp.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String[] getTables(String catalog, Connection connection) {
		try {
			ResultSet rs = null;
			String[] tables = null;
			String sql = "SELECT COUNT(1) FROM information_schema.TABLES WHERE table_schema=?";
			DatabaseMetaData metaData = connection.getMetaData();
			PreparedStatement prs = connection.prepareStatement(sql);
			prs.setString(1, catalog);
			System.out.println("执行SQL:" + sql + "\t" + "参数:" + catalog);
			rs = prs.executeQuery();
			int size = 0;
			if (rs.next()) {
				size = rs.getInt(1);
			}
			System.out.println("结果集:" + size);
			if (size == 0) {
				// 没有表
				return new String[0];
			}
			tables = new String[size];
			rs = metaData.getTables(catalog, null, null, new String[] { "TABLE" });
			for (int i = 0; rs.next(); i++) {
				tables[i] = rs.getString(Table.Select.TABLE_NAME.getIndex());
				System.out.println("数据库:" + rs.getString(Table.Select.TABLE_CAT.getIndex()) + "\t表:"
						+ rs.getString(Table.Select.TABLE_NAME.getIndex()) + "\t类型:"
						+ rs.getString(Table.Select.TABLE_TYPE.getIndex()));
			}
			return tables;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 取得单个表的表信息
	 * 
	 * @param databases
	 * @param tableName
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	public static Table getTableInfo(String databases, String tableName, Connection connection) throws Exception {
		DatabaseMetaData metaData = connection.getMetaData();
		ResultSet rs = metaData.getColumns(databases, null, tableName, null);
		Table table = new Table();
		table.setName(tableName);
		List<Column> columns = new ArrayList<Column>();
		// 取得所有的列信息
		while (rs.next()) {
			Column column = new Column(rs.getString(4), rs.getInt(5), rs.getString(6));
			column.setType(DBUtils.jdbcType2JavaType(rs.getInt(5)));
			columns.add(column);
			log.info(rs.getString(3) + "  " + rs.getString(4) + "	" + rs.getString(5) + "	" + rs.getString(6));
		}
		table.setColumns(columns);
		for (Column column : columns) {
			log.info(ToStringBuilder.reflectionToString(column, ToStringStyle.MULTI_LINE_STYLE));
		}
		return table;
	}

	public static Class jdbcType2JavaType(int jdbcType) {
		switch (jdbcType) {
		case java.sql.Types.INTEGER:

			return Integer.class;
		case java.sql.Types.REAL:

			return Float.class;
		case java.sql.Types.VARCHAR:

			return String.class;
		case java.sql.Types.TIME:

			return Date.class;
		case java.sql.Types.DOUBLE:

			return Double.class;
		case java.sql.Types.BIGINT:

			return Long.class;
		case java.sql.Types.BOOLEAN:

			return Boolean.class;
		case java.sql.Types.DATE:

			return Date.class;
		case java.sql.Types.CHAR:

			return Character.class;
		case java.sql.Types.BLOB:

			return String.class;
		default:
			return null;
		}
	}

	public static BeanMethod columnToBeanMethod() {
		return null;
	}

	public static BeanField columnToBeanField() {
		return null;
	}

}
