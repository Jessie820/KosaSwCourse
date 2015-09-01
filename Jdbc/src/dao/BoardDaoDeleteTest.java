package dao;

import java.sql.Connection;

public class BoardDaoDeleteTest {

	public static void main(String[] args) throws Exception{

		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		int rows = boardDao.delete(5);
		if(rows==1){
			System.out.println(5 + "번 게시물이 수정됨");
		}else{
			System.out.println(5 +"이 존재하지 않습니다.");
		}
		conn.close();
	}

}
