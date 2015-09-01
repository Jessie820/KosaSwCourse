package practice;

import java.sql.Connection;
import java.util.Scanner;

public class MemberDaoInsertTest2 {

	public static void main(String[] args) throws Exception{
	
		
		Members member = new Members();
		member.setId("ssd");
		member.setPassword("sdfsdf");
		member.setName("sdsdfsdf");
		member.setAddress("sdfsdf");
		member.setTel("123da");
		member.setEmail("sdsdfsdf");
		member.setPoint(1);
		member.setLevel("sdfsdf");
		member.setOrdercount(1);
		
		
		Connection conn = ConnectionManager.getConnection();
		MemberDao memberDao = new MemberDao(conn);
		String pk = memberDao.insert(member);
		if(pk!=null){
			System.out.println(pk + "의 게시물이 저장됨");
		}else{
			System.out.println("저장 실패");
		}
		conn.close();
	}

}
