package trade.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dto.Product;
import trade.dao.face.ProductDao;

public class ProductDaoImpl implements ProductDao {


	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int insert(Connection conn, Product product) {
		
		int res= 0;
		
		String sql = "";
		sql += "INSERT INTO product (productno, productname, productcontent, productprice,productclass, fileno)";
		sql += " VALUES( boardd_seq.nextval, ?, ? , ?, ?, uploadfile_seq.CURRVAL)"; 
						// boardd_seq 바꿔야댐
						//
						//
						//
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductContent());
			ps.setInt(3, product.getProductPrice());
			ps.setString(4, product.getProductClass());
			
			res= ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public List<Product> selectBoardList(Connection conn, Product product) {

		String sql = "";
		
//		sql += "SELECT productname, productprice, fileno";
//		sql += " FROM product";
		
		sql += "select p.productno, p.fileno, p.productname, p.productprice, u.stored_name, u.filepath";
		sql += " from product p";
		sql += " inner join uploadfile u";
		sql += " on p.fileno = u.fileno";
		sql += " order by p.productno desc";
//		sql += " where p.fileno = ?";
		
		List<Product> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next() ) {
				product = new Product();
				product.setProductNo(rs.getInt("productno"));
				product.setProductName(rs.getString("productname"));
				product.setProductPrice(rs.getInt("productprice"));
				product.setFileName(rs.getString("stored_name"));
				product.setFilePath(rs.getString("filepath"));
//				product.setFileno(rs.getInt("fileno"));
//				System.out.println("getfileno - " + product.getFileno());
				
				list.add(product);
			}
//			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
		
	}

	@Override
	public Product selectBoardByProductno(Connection conn, Product product) {
		String sql = "";
//		sql += "SELECT *";
//		sql += " FROM product";
//		sql += " WHERE productno= ?";
		
		sql += "select p.productno, p.fileno, p.productname,p.productcontent, p.productprice, p.productdate, u.stored_name, u.filepath";
		sql += " from product p";
		sql += " inner join uploadfile u";
		sql += " on p.fileno = u.fileno";
		sql += " WHERE p.productno= ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, product.getProductNo());
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				product.setProductNo(rs.getInt("productno"));
				product.setProductName(rs.getString("productname"));
				product.setProductContent(rs.getString("productcontent"));
				product.setProductPrice(rs.getInt("productprice"));
				product.setFileName(rs.getString("stored_name"));
				product.setFilePath(rs.getString("filepath"));
//				product.setHit(rs.getInt("hit"));
				product.setProductDate(rs.getDate("productdate"));
				
			}
			System.out.println("[Dao]조회완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return product;
	}


}
