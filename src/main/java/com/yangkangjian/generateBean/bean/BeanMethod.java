package com.yangkangjian.generateBean.bean;

/**
 * Bean方法
 * 
 * @author Ubuntu
 *
 */
public class BeanMethod {
	private String name;
	private Class<?> returnType;
	/**
	 * 修饰
	 */
	private String modifierName;
	/**
	 * 参数列表类型
	 */
	private Class<?>[] parameterType;
	/**
	 * 参数列表变量名
	 */
	private String[] parameterName;

	public BeanMethod() {

	}

	public BeanMethod(String modifierName, Class<?> returnType, String name) {
		this.modifierName = modifierName;
		this.returnType = returnType;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getReturnType() {
		return returnType;
	}

	public void setReturnType(Class<?> returnType) {
		this.returnType = returnType;
	}

	public String getModifierName() {
		return modifierName;
	}

	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}

	public Class<?>[] getParameterType() {
		return parameterType;
	}

	public void setParameterType(Class<?>[] parameterType) {
		this.parameterType = parameterType;
	}

	public String[] getParameterName() {
		return parameterName;
	}

	public void setParameterName(String[] parameterName) {
		this.parameterName = parameterName;
	}

}
