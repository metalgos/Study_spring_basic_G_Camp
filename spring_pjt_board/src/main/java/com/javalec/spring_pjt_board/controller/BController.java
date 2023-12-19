package com.javalec.spring_pjt_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_pjt_board.command.BCommand;
import com.javalec.spring_pjt_board.command.BContentCommand;
import com.javalec.spring_pjt_board.command.BDeleteCommand;
import com.javalec.spring_pjt_board.command.BListCommand;
import com.javalec.spring_pjt_board.command.BModifyCommand;
import com.javalec.spring_pjt_board.command.BReplyCommand;
import com.javalec.spring_pjt_board.command.BReplyViewCommand;
import com.javalec.spring_pjt_board.command.BWriteCommand;
import com.javalec.spring_pjt_board.util.Constant;

@Controller
public class BController {
//모든 서비스를 하나의 컨트롤러에서 제어
	
	BCommand command;//모든 서비스의 인터페이스인 커맨드를 선언, 생성은 안함
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		
		command = new BListCommand(); //생성을 여기서 함
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")  //작성하는 화면
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {//작성한 글의 데이터를 받기위해 서블릿 리퀘스트 객체 파라미터로 방음
		System.out.println("write()");
		
		model.addAttribute("request", request);//서비스에서 작업을 하기때문에 리퀘스트를 통쨰로 모델에 담음
		command = new BWriteCommand();
		command.execute(model);//서비스에서 실제 작업
		
		
		return "redirect:list";
	}
	
	@RequestMapping("content_view")
	//컨텐츠를 보는 화면
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/modify")
	//수정화면
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	//답변을 보는것
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	//답변을 다는것
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	//삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
}
