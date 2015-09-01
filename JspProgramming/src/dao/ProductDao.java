package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Product;

public class ProductDao {
	private Connection conn;
	
	public ProductDao(Connection conn){
		this.conn = conn;
	}
	
	public Integer insert(Product product) throws SQLException{
	      Integer pk = null;
	      String sql = "insert into products(product_name, product_price, product_amount, product_kind, product_content) values(?,?,?,?,?)";
	      PreparedStatement pstmt = conn.prepareStatement(sql,new String[]{"product_no"});
	      pstmt.setString(1, product.getName());
	      pstmt.setLong(2, product.getPrice());
	      pstmt.setLong(3, product.getAmount());
	      pstmt.setString(4, product.getKind());
	      pstmt.setString(5, product.getContent());
	      int rows = pstmt.executeUpdate();
	      if(rows==1){
	         ResultSet rs = pstmt.getGeneratedKeys();
	         if(rs.next()){
	            pk = rs.getInt(1);
	         }
	         rs.close();
	      }
	      pstmt.close();
	      return pk;
	   }
	
	public List<Product> selectByPage(int pageNo, int rowsPerPage) throws SQLException{
		List<Product> list = new ArrayList<Product>();
		String sql = "";
		sql +="select product_no, product_name, product_price, product_amount, product_kind, product_content ";
		sql +="from products ";
		sql +="ORDER BY product_no DESC ";
		sql +="limit ?,?";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setInt(1, (pageNo-1)*rowsPerPage);
		pstmt.setInt(2, rowsPerPage);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Product product = new Product();
			product.setNo(rs.getLong("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			product.setAmount(rs.getInt("product_amount"));
			product.setKind(rs.getString("product_kind"));
			product.setContent(rs.getString("product_content"));
			list.add(product);
		}
		
		return list;
	}
	
	
	public Product selectByPk(long productNo) throws SQLException{
		Product product = null;
		String sql = "";
		sql +="select * from products where product_no=?";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setLong(1, productNo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			product=new Product();
			product.setNo(rs.getLong("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			product.setAmount(rs.getInt("product_amount"));
			product.setKind(rs.getString("product_kind"));
			product.setContent(rs.getString("product_content"));
		}
		
		rs.close();
		pstmt.close();
		
		return product;
	}
	
	
	public int update(Product product) throws SQLException {
		int rows = 0;
		String sql = 
		"update products set product_name=?, product_price=?, product_amount=?, product_content=? where product_no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		pstmt.setString(1, product.getName());
		pstmt.setInt(2, product.getPrice());
		pstmt.setInt(3, product.getAmount());
		pstmt.setString(4, product.getContent());
		pstmt.setLong(5, product.getNo());
		rows = pstmt.executeUpdate();
	
		pstmt.close();
		return rows;
	}
	
	
	public int delete(long productNo) throws SQLException {
		int rows = 0;
		String sql = 
		"delete from products where product_no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, productNo);
		rows = pstmt.executeUpdate();
		pstmt.close();
		return rows;
	}
}





