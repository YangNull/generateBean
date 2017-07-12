package com.yangkangjian.generateBean.bean;

/**
 * Bean字段
 * 
 * @author Ubuntu
 *
 */
public class BeanField {
	private String name;
	private Class clazz;
	private String modifierName;

	public BeanField() {

	}

	public BeanField(String modifierName, Class clazz, String name) {
		this.name = name;
		this.clazz = clazz;
		this.modifierName = modifierName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public String getModifierName() {
		return modifierName;
	}

	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}

}
