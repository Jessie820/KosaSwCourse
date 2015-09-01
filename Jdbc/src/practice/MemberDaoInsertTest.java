package practice;

import java.sql.Connection;
import java.util.Scanner;



public class MemberDaoInsertTest {

	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws Exception{
		
		System.out.print("아이디를 입력하시오: ");
		String id = scanner.nextLine();
		
		System.out.print("비밀번호를 입력하시오: ");
		String pw = scanner.nextLine();
		
		System.out.print("이름을 입력하시오: ");
		String name = scanner.nextLine();
		
		System.out.print("주소를 입력하시오: ");
		String address = scanner.nextLine();
		
		System.out.print("전화번호를 입력하시오: ");
		String tel = scanner.nextLine();
		
		System.out.print("이메일을 입력하시오: ");
		String email = scanner.nextLine();
		
		System.out.print("포인트를 입력하시오: ");
		int point = Integer.parseInt(scanner.nextLine());
		
		System.out.print("레벨을 입력하시오: ");
		String level = scanner.nextLine();
		
		System.out.print("주문횟수를 입력하시오: ");
		int ordercount = Integer.parseInt(scanner.nextLine());
		
		Members member = new Members();
		member.setId(id);
		member.setPassword(pw);
		member.setName(name);
		member.setAddress(address);
		member.setTel(tel);
		member.setEmail(email);
		member.setPoint(point);
		member.setLevel(level);
		member.setOrdercount(ordercount);
		
		
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
