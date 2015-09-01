package practice;

import java.sql.Connection;
import java.sql.SQLException;

import dao.Account;
import dao.AccountDao;
import dao.ConnectionManager;

public class Service {
	
	public void login(int from, int to, int amount){
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			//트랜잭션 작업 시작
			conn.setAutoCommit(false);
			
			
			
			MemberDao memberDao = new MemberDao(conn);
			
			
			
			//회원가입
			Members fromMember = memberDao.selectByPk("");
			fromMember.setBalance(fromAccount.getBalance()-amount);
			
			//입금 작업
			Account toAccount = accountDao.selectByPk(to);
			toAccount.setBalance(toAccount.getBalance()+amount);
			
			accountDao.update(fromAccount);
			accountDao.update(toAccount);
		conn.commit();
		System.out.println("계좌 이체 성공");
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {}
			System.out.println("계좌 이체 실패");
			e.printStackTrace();
		} finally{
			try{conn.close();}catch(Exception e){}
		}
		
	}
	



	}


