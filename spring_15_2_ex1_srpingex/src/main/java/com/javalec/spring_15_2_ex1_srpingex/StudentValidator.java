package com.javalec.spring_15_2_ex1_srpingex;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Student.class.isAssignableFrom(arg0);  // 검증할 객체의 클래스 타입 정보
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate()");
		Student student = (Student)obj;
		
		/*
		String studentName = student.getName();
		if(studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble");
		}
		*/
		
		//validation()메소드를 편리하게 사용가능. Static이라서 객체 없이 바로 메소드 사용가능
		//rejectIfEmptyOrWhitespace : 공백과 비어있는 값을 검증가능
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		
		int studentId = student.getId();
		if(studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "trouble");
		}
	}
	
}
