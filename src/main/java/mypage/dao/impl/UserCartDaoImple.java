package mypage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dto.Cart;
import mypage.dao.face.UserCartDao;

public class UserCartDaoImple implements UserCartDao {

	// DB 관련 객체
	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null;		 // 결과 집합 객체
	
	@Override
	public List<Cart> checkCart(Connection conn) {
		System.out.println("UserCartDaoImple - List<Cart> checkCart() 시작! ");

		// wish_no, wish_total_price, product_no, wish_amount
		
		String sql = "";
		sql += "SELECT";
		sql += " wish_no, wish_total_price, product_no, wish_amount";
		sql += " FROM tbl_wish";
		sql += " ORDER BY wish_no";
		
		List<Cart> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);	
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Cart cart = new Cart();
				
				cart.setCarNo( rs.getInt("wish_no"));
				cart.setTotalPrice( rs.getInt("wish_total_price"));
				cart.setProduct_no( rs.getInt("product_no"));
				cart.setWish_amount( rs.getInt("wish_amount"));
				
				list.add(cart);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("UserCartDaoImple - List<Cart> checkCart() 끝! ");
		return list;
	}
	@Override
	public int deleteCart() {

		return 0;
	}
	@Override
	public int deleteAllCart() {

		return 0;
	}
	
	
	
}
