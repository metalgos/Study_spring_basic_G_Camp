package com.javalec.spring_pjt_ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.javalec.spring_pjt_ex.dto.TicketDto;

public class TicketDao {

	JdbcTemplate template;

	//여러 구현체중 jdbc에 맞는 구현체를 선택
	PlatformTransactionManager transactionManager;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	//빈주입 위해 세터 설정, 서블릿 컨텍스트에서 빈주입 설정 
	public void setTransactionManager( PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public TicketDao() {
		System.out.println(template);
	}
	
	public void buyTicket(final TicketDto dto) {
		System.out.println("buyTicket()");
		System.out.println("dto.getConsumerId() : " + dto.getConsumerId());
		System.out.println("dto.getAmount() : " + dto.getAmount());
		
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(definition);
		
		try {
		
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					String query = "insert into card (consumerId, amount) values (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setString(2, dto.getAmount());
					
					return pstmt;
				}
			});
			
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					String query = "insert into ticket (consumerId, countnum) values (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setString(2, dto.getAmount());
					
					return pstmt;
				}
			});
		//성공시 커밋
			transactionManager.commit(status);
			
		} catch (Exception e) {
			e.printStackTrace();
			//실패시 롤백
			transactionManager.rollback(status);
		}
	}

	
}
