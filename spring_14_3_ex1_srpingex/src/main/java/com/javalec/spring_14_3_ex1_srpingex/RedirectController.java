package com.javalec.spring_14_3_ex1_srpingex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

	@RequestMapping("/studentConfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest, Model model){
		
		String id = httpServletRequest.getParameter("id");
		if(id.equals("abc")) {
			return "redirect:studentOk";
		}
		
		return "redirect:studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk(Model model){
		
		return "student/studentOk";
	}
	
	
	@RequestMapping("/studentNg")
	public String studentNg(Model model){
		
		return "student/studentNg";
	}
	
	//리다이렉트 이용하여 루트경로 통해서 이동하거나, 주소 통쨰로 입력하여 이동가능
	@RequestMapping("/studentURL1")
	public String studentURL1(Model model) {
		
		return "redirect:http://localhost:8181/spring_14_3_ex1_srpingex/studentURL1.jsp";
	}
	
	
	@RequestMapping("/studentURL2")
	public String studentURL2(Model model) {
		
		return "redirect:student/studentURL2";
	}
	
	@RequestMapping("/student/studentURL2")
	public String studentURL22(Model model) {
		
		return "redirect:http://localhost:8181/spring_14_3_ex1_srpingex/studentURL2.jsp";
	}
	
	
}
