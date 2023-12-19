package com.javalec.spring_pjt_board.command;

import org.springframework.ui.Model;

public interface BCommand {
//인터페이스, 이걸 구현하여 각 서비스에 맞게 만든다
	public void execute(Model model);
	
}
