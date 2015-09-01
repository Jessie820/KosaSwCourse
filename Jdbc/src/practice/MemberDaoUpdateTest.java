package practice;

import java.sql.Connection;

public class MemberDaoUpdateTest {

	public static void main(String[] args) throws Exception{
		Members member = new Members();
		member.setId("ssdf");
		member.setPassword("sdfsdf");
		member.setName("sdf");
		member.setAddress("sdfsdf");
		member.setTel("11231");
		member.setEmail("asfasf");
		member.setPoint(3);
		member.setLevel("fd");
		member.setOrdercount(3);
		
		Connection conn = ConnectionManager.getConnection();
		MemberDao memberDao = new MemberDao(conn);
		int rows = memberDao.update(member);
		if(rows==1){
			System.out.println("수정됨");
		}else{
			System.out.println("존재하지 않습니다.");
		}
		conn.close();
	}

}
