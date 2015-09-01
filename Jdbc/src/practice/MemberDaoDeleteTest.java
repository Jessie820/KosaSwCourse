package practice;

import java.sql.Connection;

public class MemberDaoDeleteTest {

	public static void main(String[] args) throws Exception{

		Connection conn = ConnectionManager.getConnection();
		MemberDao memberDao = new MemberDao(conn);
		int rows = memberDao.delete("ssd");
		if(rows==1){
			System.out.println( "삭제됨");
		}else{
			System.out.println("삭제 실패");
		}
		conn.close();
	}

}
