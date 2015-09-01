package practice;

import java.sql.Connection;

public class MemberDaoSelectByPkTest {

	public static void main(String[] args) throws Exception {
		
		Connection conn = ConnectionManager.getConnection();
		MemberDao memberDao = new MemberDao(conn);
		Members member = memberDao.selectByPk("ssd");
		if(member != null){
			System.out.println("아이디:"+ member.getId());
			System.out.println("패스워드:"+ member.getPassword());
			System.out.println("이름:"+ member.getName());
			System.out.println("주소:"+ member.getAddress());
			System.out.println("번호:"+ member.getTel());
			System.out.println("이메일:"+ member.getEmail());
			System.out.println("포인트:"+ member.getPoint());
			System.out.println("레벨:"+ member.getLevel());
			System.out.println("주문횟수:"+ member.getOrdercount());
		}else{
			System.out.println(21 +"의 회원정보가 존재하지 않습니다.");
		}
		conn.close();
	}

}
