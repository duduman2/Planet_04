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
		sql += "INSERT INTO product (productno, productname, productcontent, productprice, fileno)";
		sql += " VALUES( boardd_seq.nextval, ?, ? , ?, uploadfile_seq.CURRVAL)";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, product.getProductname());
			ps.setString(2, product.getProductcontent());
			ps.setInt(3, product.getProductprice());
			
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
		
		sql += "select p.fileno, p.productname, p.productprice, u.stored_name, u.filepath";
		sql += " from product p";
		sql += " inner join uploadfile u";
		sql += " on p.fileno = u.fileno";
//		sql += " where p.fileno = ?";
		
		List<Product> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next() ) {
				product = new Product();
				product.setProductname(rs.getString("productname"));
				product.setProductprice(rs.getInt("productprice"));
				product.setFilename(rs.getString("stored_name"));
				product.setFilepath(rs.getString("filepath"));
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


}
