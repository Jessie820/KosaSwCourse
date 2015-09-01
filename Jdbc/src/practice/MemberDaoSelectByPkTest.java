package practice;

import java.sql.Connection;

public class MemberDaoSelectByPkTest {

	public static void main(String[] args) throws Exception {
		
		Connection conn = ConnectionManager.getConnection();
		MemberDao memberDao = new MemberDao(conn);
		Members member = memberDao.selectByPk("ssd");
		if(member != null){
			System.out.println("���̵�:"+ member.getId());
			System.out.println("�н�����:"+ member.getPassword());
			System.out.println("�̸�:"+ member.getName());
			System.out.println("�ּ�:"+ member.getAddress());
			System.out.println("��ȣ:"+ member.getTel());
			System.out.println("�̸���:"+ member.getEmail());
			System.out.println("����Ʈ:"+ member.getPoint());
			System.out.println("����:"+ member.getLevel());
			System.out.println("�ֹ�Ƚ��:"+ member.getOrdercount());
		}else{
			System.out.println(21 +"�� ȸ�������� �������� �ʽ��ϴ�.");
		}
		conn.close();
	}

}
