package com.JoseK.test;

import java.lang.reflect.Method;

public class TestReflect {
	
	public static void main(String[] args) {
		try {
			Class<?> classzz = Class.forName("com.JoseK.test.TestJavaBeans");
			Method[] ms = classzz.getDeclaredMethods();
			for(Method method : ms){
				System.out.println(method.getName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
