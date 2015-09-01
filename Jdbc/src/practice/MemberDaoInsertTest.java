package practice;

import java.sql.Connection;
import java.util.Scanner;



public class MemberDaoInsertTest {

	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws Exception{
		
		System.out.print("���̵� �Է��Ͻÿ�: ");
		String id = scanner.nextLine();
		
		System.out.print("��й�ȣ�� �Է��Ͻÿ�: ");
		String pw = scanner.nextLine();
		
		System.out.print("�̸��� �Է��Ͻÿ�: ");
		String name = scanner.nextLine();
		
		System.out.print("�ּҸ� �Է��Ͻÿ�: ");
		String address = scanner.nextLine();
		
		System.out.print("��ȭ��ȣ�� �Է��Ͻÿ�: ");
		String tel = scanner.nextLine();
		
		System.out.print("�̸����� �Է��Ͻÿ�: ");
		String email = scanner.nextLine();
		
		System.out.print("����Ʈ�� �Է��Ͻÿ�: ");
		int point = Integer.parseInt(scanner.nextLine());
		
		System.out.print("������ �Է��Ͻÿ�: ");
		String level = scanner.nextLine();
		
		System.out.print("�ֹ�Ƚ���� �Է��Ͻÿ�: ");
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
			System.out.println(pk + "�� �Խù��� �����");
		}else{
			System.out.println("���� ����");
		}
		conn.close();
	}

}
