package kr.human.java0428;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;

public class ClassReflect {
	public static void main(String[] args) {
		// getClass() : 클래스의 정보를 얻어낸다.
		Class<? extends Date> dateClass = new Date().getClass();
		
		System.out.println(dateClass.getPackageName());
		System.out.println(dateClass.getName());
		
		Method[] methods = dateClass.getDeclaredMethods();
		for(Method m : methods) {
			System.out.println(m.getName());
			for(Parameter p : m.getParameters()) {
				System.out.println(p.getName() + " : " + p.getType());
			}
			System.out.println();
		}
	}
}
