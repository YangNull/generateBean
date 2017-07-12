package com.yangkangjian.generateBean.bean;

import java.util.List;

public class Table {
	private String catalog;
	private String schem;
	/**
	 * 表名
	 */
	private String name;
	/**
	 * 所属类型
	 */
	private String type;
	private String remarks;
	private String catalogType;
	private String nameType;
	private String schemType;
	private String selfReferencingColName;
	private String refGeneration;
	/**
	 * 列信息
	 */
	private List<Column> columns;

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getSchem() {
		return schem;
	}

	public void setSchem(String schem) {
		this.schem = schem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCatalogType() {
		return catalogType;
	}

	public void setCatalogType(String catalogType) {
		this.catalogType = catalogType;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public String getSchemType() {
		return schemType;
	}

	public void setSchemType(String schemType) {
		this.schemType = schemType;
	}

	public String getSelfReferencingColName() {
		return selfReferencingColName;
	}

	public void setSelfReferencingColName(String selfReferencingColName) {
		this.selfReferencingColName = selfReferencingColName;
	}

	public String getRefGeneration() {
		return refGeneration;
	}

	public void setRefGeneration(String refGeneration) {
		this.refGeneration = refGeneration;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public enum Select {
		TABLE_CAT(1), TABLE_SCHEM(2), TABLE_NAME(3), TABLE_TYPE(4), REMARKS(5), TYPE_CAT(6), TYPE_SCHEM(7), TYPE_NAME(
				8), SELF_REFERENCING_COL_NAME(9), REF_GENERATION(10);
		private int index;

		private Select(int index) {
			this.index = index;
		}

		public int getIndex() {
			return index;
		}
	}

	public enum Type {
		TABLE(1, "TABLE"), VIEW(2, "VIEW"), SYSTEM_TABLE(3, "SYSTEM_TABLE"), GLOBAL_TEMPORARY(4,
				"GLOBAL_TEMPORARY"), LOCAL_TEMPORARY(5, "TEMPORARY"), ALIAS(6, "ALIAS"), SYNONYM(7, "SYNONYM");
		private int index;
		private String desc;

		private Type(int index, String desc) {
			this.index = index;
			this.desc = desc;
		}

		public String getDesc() {
			return desc;
		}

		public int getIndex() {
			return index;
		}

	}

}
