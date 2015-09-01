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
			//Ʈ����� �۾� ����
			conn.setAutoCommit(false);
			
			
			
			MemberDao memberDao = new MemberDao(conn);
			
			
			
			//ȸ������
			Members fromMember = memberDao.selectByPk("");
			fromMember.setBalance(fromAccount.getBalance()-amount);
			
			//�Ա� �۾�
			Account toAccount = accountDao.selectByPk(to);
			toAccount.setBalance(toAccount.getBalance()+amount);
			
			accountDao.update(fromAccount);
			accountDao.update(toAccount);
		conn.commit();
		System.out.println("���� ��ü ����");
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {}
			System.out.println("���� ��ü ����");
			e.printStackTrace();
		} finally{
			try{conn.close();}catch(Exception e){}
		}
		
	}
	



	}


