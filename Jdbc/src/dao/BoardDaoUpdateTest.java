package dao;

import java.sql.Connection;

public class BoardDaoUpdateTest {

	public static void main(String[] args) throws Exception{
		Board board = new Board();
		board.setNo(62);
		board.setTitle("������ DAO�� �մϴ�.");
		board.setContent("DAO�� �� ���׿�.");
		board.setHitcount(2);
		
		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		int rows = boardDao.update(board);
		if(rows==1){
			System.out.println(board.getNo() + "�� �Խù��� ������");
		}else{
			System.out.println(board.getNo()+"�� �������� �ʽ��ϴ�.");
		}
		conn.close();
	}

}