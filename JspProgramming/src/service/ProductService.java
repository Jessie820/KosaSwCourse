package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BoardDao;
import dao.ConnectionManager;
import dao.ProductDao;

import dto.Product;

public class ProductService {
	
	public void add(Product product){
	      Connection conn = null;
	      try{
	         conn = ConnectionManager.getConnection();
	         ProductDao productDao = new ProductDao(conn);
	         productDao.insert(product);
	      } catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         try{conn.close();}catch(SQLException e){}
	      }

	   }
		
		public List<Product> getPage(int pageNo, int rowsPerPage) {
			List<Product> list = new ArrayList<Product>();
			Connection conn= null;
			try {
				conn = ConnectionManager.getConnection();
				ProductDao productDao = new ProductDao(conn);
				list = productDao.selectByPage(pageNo, rowsPerPage);
			} catch (Exception e) {
				
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {}
			}
				return list;
		}
			
		public Product getProduct(long productNo){
				Product product = null;
				Connection conn= null;
				try {
					conn = ConnectionManager.getConnection();
					ProductDao productDao = new ProductDao(conn);
					product = productDao.selectByPk(productNo);
				} catch (Exception e) {
					
				}finally{
					try {
						conn.close();
					} catch (SQLException e) {}
				}
					return product;
		}
		
		public void modify(Product product){
			
			Connection conn=null;
			try {
				conn = ConnectionManager.getConnection();
				ProductDao productDao = new ProductDao(conn);
				productDao.update(product);
			} catch (Exception e) {
				
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}	
		
		public void remove(long productNo){
			
			Connection conn=null;
			try {
				conn = ConnectionManager.getConnection();
				ProductDao productDao = new ProductDao(conn);
				productDao.delete(productNo);
			} catch (Exception e) {
				
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		
}
	

