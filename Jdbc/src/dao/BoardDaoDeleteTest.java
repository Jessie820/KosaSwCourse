package dao;

import java.sql.Connection;

public class BoardDaoDeleteTest {

	public static void main(String[] args) throws Exception{

		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		int rows = boardDao.delete(5);
		if(rows==1){
			System.out.println(5 + "�� �Խù��� ������");
		}else{
			System.out.println(5 +"�� �������� �ʽ��ϴ�.");
		}
		conn.close();
	}

}