package com.javalec.spring_pjt_board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_pjt_board.dao.BDao;
import com.javalec.spring_pjt_board.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		//데이터에서 게시판 리스트를 읽어와 담아온다
		BDao dao = new BDao();
		ArrayList<BDto>dtos =  dao.list();
		
		model.addAttribute("list", dtos);
		
	}

}
