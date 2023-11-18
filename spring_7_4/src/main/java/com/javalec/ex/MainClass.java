package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("이름 st1 : " + student1.getName());
		System.out.println("나이 st1 : " + student1.getAge());
		
		System.out.println("==============================");
		
		Student student2 = ctx.getBean("student", Student.class);
		student2.setName("홀길자");
		student2.setAge(100);
		
		System.out.println("이름 st2 : " + student2.getName());
		System.out.println("나이 st2 : " + student2.getAge());
		
		System.out.println("==============================");
		
		System.out.println("이름 st1 : " + student1.getName());
		System.out.println("나이 st1 : " + student1.getAge());

		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		} else {
			System.out.println("student1 != student2");
		}
		
		ctx.close();
		
	}
	
}
