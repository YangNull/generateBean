package com.yangkangjian.generateBean;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Study {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		P p = new P();
		Class<?> c = p.getClass();
		Method method = c.getMethod("g", null);
		System.out.println(Modifier.toString(method.getReturnType().getModifiers()));

	}
}
