package com.yangkangjian.generateBean.bean;

/**
 * 字段信息
 * 
 * @author Ubuntu
 *
 */
public class Column {
	/**
	 * 字段名
	 */
	private String name;
	/**
	 * 字段类型
	 */
	private Class type;
	/**
	 * jdbcType
	 */
	private int dateType;
	/**
	 * jdbcType name
	 */
	private String typeName;

	public Column(String name, int dateType, String typeName) {
		this.name = name;
		this.dateType = dateType;
		this.typeName = typeName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class getType() {
		return type;
	}

	public void setType(Class type) {
		this.type = type;
	}

	public int getDateType() {
		return dateType;
	}

	public void setDateType(int dateType) {
		this.dateType = dateType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
