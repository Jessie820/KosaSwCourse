package practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Board;

public class MemberDao {

private Connection conn;
	
	public MemberDao(Connection conn){
	
		this.conn = conn;
	}
	
	
	public String insert(Members member) throws SQLException{
		String pk = null;
		String sql = "insert into members"
				+ "(member_id, member_password, member_name, member_address, member_tel, member_email, member_point, member_level, member_ordercount)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPassword());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getAddress());
		pstmt.setString(5, member.getTel());
		pstmt.setString(6, member.getEmail());
		pstmt.setInt(7, member.getPoint());
		pstmt.setString(8, member.getLevel());
		pstmt.setInt(9, member.getOrdercount());
		int row = pstmt.executeUpdate();
		if(row ==1){
				pk = member.getId();
			}
		pstmt.close();
		return pk;
	}
	
	public int update(Members member) throws SQLException{
		int rows = 0; 
		String sql = "update members set member_password=?, member_name=?, member_address=?, member_tel=?, member_email=?, member_point=?, member_level=?, member_ordercount where member_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, member.getPassword());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getAddress());
		pstmt.setString(4, member.getTel());
		pstmt.setString(5, member.getEmail());
		pstmt.setInt(6, member.getPoint());
		pstmt.setString(7, member.getLevel());
		pstmt.setInt(8, member.getOrdercount());
		rows = pstmt.executeUpdate();
		pstmt.close();
		return rows;
	}
	
	public int delete(String memberId)throws SQLException{
		int rows = 0;
		String sql = "delete from members where member_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberId);	
		rows = pstmt.executeUpdate();
		pstmt.close();
		return rows;
	}
	
	public Members selectByPk(String memberId) throws SQLException{
		Members member = null;
		String sql = "select*from members where member_id = ?";
		

		PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
			member = new Members();
			member.setId(rs.getString("member_id"));
			member.setPassword(rs.getString("member_password"));
			
			member.setName(rs.getString("member_name"));
			member.setAddress(rs.getString("member_address"));
			member.setTel(rs.getString("member_tel"));
			member.setEmail(rs.getString("member_email"));
			member.setPoint(rs.getInt("member_point"));
			member.setLevel(rs.getString("member_level"));
			member.setOrdercount(rs.getInt("member_ordercount"));
			
			
			}
			
		rs.close();
		pstmt.close();
		return member;
	}
	
}
