package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	private Connection conn;
	
	public BoardDao(Connection conn){
	//������ ���� ���
		this.conn = conn;
	}
	
	//������ �۾� �޼ҵ�
	public Integer insert(Board board) throws SQLException{//insert�� �������� �� ���ϰ��� null�� �ֱ� ���� �⺻Ÿ���� ���� Integer�� ��
		//Insert�� ���� 
		Integer pk = null;
		String sql = "insert into boards(board_title, board_content, board_writer)values(?,?,?)";
		//sql���� �����Ϸ��� preparedstatement ��ü�� ������! 
		PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"board_no"});//board ��ü ����
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setString(3, board.getWriter());
		int row = pstmt.executeUpdate();
		if(row ==1){
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()){
					
					pk = rs.getInt(1);//getInt(1)->ù��° column�� ���� �����Ͷ�
					
				}
				rs.close();
			}
		pstmt.close();
		return pk;
	}
	
	public int update(Board board) throws SQLException{//update�� �ϳ��� ���� �ʿ�� ����.
		int rows = 0; //������Ʈ �� ���� �� ����
		String sql = "update boards set board_title=?, board_content=?, board_hitcount=? where board_no=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getHitcount());
		pstmt.setInt(4, board.getNo());
		rows = pstmt.executeUpdate();//���� ������ ���� ��
		pstmt.close();
		return rows;
	}
	
	public int delete(int boardNo)throws SQLException{//�����Ϸ��� ���� �ѹ� ���Խ������
		int rows = 0;//������ ���� �� ����
		String sql = "delete from boards where board_no=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);	
		rows = pstmt.executeUpdate();
		pstmt.close();
		return rows;
	}
	
	public Board selectByPk(int boardNo) throws SQLException{
		Board board = null;//�� ��ü�� ���� �׷��� �� ��ü�� ���� �� �ִ� Board��ü�� ����
		String sql = "select*from boards where board_no = ?";
		

		PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();//select�ϸ� ������ executeQuery!
			if(rs.next()){
			board = new Board();
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			
			board.setDate(rs.getDate("board_date"));
			board.setWriter(rs.getString("board_writer"));
			board.setHitcount(rs.getInt("board_hitcount"));
			
			
			}
			
		rs.close();
		pstmt.close();
		return board;
	}
	
	

	public List<Board> selectByPage(int pageNo, int rowsPerPage)throws SQLException{
		List<Board> list = new ArrayList<Board>();
		/*String sql = "";
		sql +="select rn, board_no,board_title, board_writer,board_date,board_hitcount ";
		sql +="from ";
		sql +="(select rownum rn, board_no,board_title,board_writer,board_date,board_hitcount ";
		sql +="from ";
		sql +="(select board_no,board_title,board_writer, board_date,board_hitcount ";
		sql +="from boards ";
		sql +="ORDER BY board_no DESC ";
		sql +=")where rownum<=? ";
		sql +=") where rn >=? ";*/

		
		//MySql
		String sql = "";
		sql +="(select board_no,board_title,board_writer, board_date,board_hitcount ";
		sql +="from boards ";
		sql +="ORDER BY board_no DESC ";
		sql +="limit ?,?";
		
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	//Oracle
	/*
	pstmt.setInt(1, (pageNo-1)*rowsPerPage);
	pstmt.setInt(2, rowsPerPage);
	*/
	
	
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){//while�� �� ��ŭ board ��ü�� ���������.
	Board board = new Board();
	board.setNo(rs.getInt("board_no"));
	board.setTitle(rs.getString("board_title"));
	
	board.setDate(rs.getDate("board_date"));
	board.setWriter(rs.getString("board_writer"));
	board.setHitcount(rs.getInt("board_hitcount"));
	list.add(board);
	
	}
	
	rs.close();
	pstmt.close();
	return list;
	}
	
}