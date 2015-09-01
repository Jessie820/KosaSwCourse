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
	//생성자 주입 방식
		this.conn = conn;
	}
	
	//데이터 작업 메소드
	public Integer insert(Board board) throws SQLException{//insert가 실패했을 때 리턴값을 null로 주기 위해 기본타입일 때는 Integer로 함
		//Insert는 보통 
		Integer pk = null;
		String sql = "insert into boards(board_title, board_content, board_writer)values(?,?,?)";
		//sql문을 실행하려면 preparedstatement 객체를 얻어야함! 
		PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"board_no"});//board 객체 주입
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setString(3, board.getWriter());
		int row = pstmt.executeUpdate();
		if(row ==1){
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()){
					
					pk = rs.getInt(1);//getInt(1)->첫번째 column의 값을 가져와라
					
				}
				rs.close();
			}
		pstmt.close();
		return pk;
	}
	
	public int update(Board board) throws SQLException{//update꼭 하나만 만들 필요는 없음.
		int rows = 0; //업데이트 된 행의 수 리턴
		String sql = "update boards set board_title=?, board_content=?, board_hitcount=? where board_no=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getHitcount());
		pstmt.setInt(4, board.getNo());
		rows = pstmt.executeUpdate();//실제 수정된 행의 수
		pstmt.close();
		return rows;
	}
	
	public int delete(int boardNo)throws SQLException{//실행하려면 보드 넘버 주입시켜줘야
		int rows = 0;//삭제된 행의 수 리턴
		String sql = "delete from boards where board_no=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);	
		rows = pstmt.executeUpdate();
		pstmt.close();
		return rows;
	}
	
	public Board selectByPk(int boardNo) throws SQLException{
		Board board = null;//행 전체를 리턴 그래서 행 전체를 담을 수 있는 Board객체를 리턴
		String sql = "select*from boards where board_no = ?";
		

		PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();//select하면 무조건 executeQuery!
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
	while(rs.next()){//while문 돈 만큼 board 객체가 만들어진다.
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
