package mypage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dto.Cart;
import dto.Product;
import dto.UserInfo;
import mypage.dao.face.UserCartDao;

public class UserCartDaoImple implements UserCartDao {

	// DB 관련 객체
	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null;		 // 결과 집합 객체
	
	@Override
	public List<Product> checkCarts(Connection conn, UserInfo param) {
		System.out.println("UserCartDao - List<Product> checkCarts(conn, param) 시작! ");

		
		String sql = "";
//		sql += "SELECT * FROM tbl_wish w, product p, tbl_user u";
//		sql += " WHERE w.productno = p.productno";
//		sql += " AND w.wish_no = u.wish_no";
//		sql += " AND w.userno = ?";
		
		
		sql += "SELECT * FROM tbl_wish w, product p, tbl_user u";
		sql += " WHERE w.productno = p.productno";
		sql += " AND w.wish_no = u.wish_no";
		
		
		List<Cart> cartlist = new ArrayList<>();
		List<Product> productlist = new ArrayList<>();
		Product product = new Product();
		
		try {
			ps = conn.prepareStatement(sql);	
			rs = ps.executeQuery();
			
			//조회결과처리
			while(rs.next()) {
				Cart cart = new Cart(); //조회 결과 행 저장 dto객체

//				PRODUCTQUAN
				
//				cart.setProduct_no( rs.getInt("productno"));
//				cart.setProduct_name( rs.getString("productname"));
//				cart.setPrice( rs.getInt("productprice"));
//				cart.set
				cart.setDeliveryfee( rs.getInt("deliveryfee"));
				cart.setWish_amount( rs.getInt("wish_amount"));
				cart.setTotalPrice( rs.getInt("wish_total_price"));
				
				product.setProductNo( rs.getInt("productno"));
				product.setProductName( rs.getString("productname"));
				product.setProductContent( rs.getString("productcontent"));
				product.setProductPrice( rs.getInt("productprice"));
				
				cartlist.add(cart); //리스트에 결과값 저장하기
				productlist.add(product);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("UserCartDao - List<Product> checkCarts(conn, param) 끝! ");
		return productlist; //최종결과값반환  
	}
	
	@Override
	public List<Cart> checkCart(Connection conn, UserInfo param) {
		System.out.println("UserCartDao - List<Cart> checkCart(conn, param) 시작! ");

		
		String sql = "";
		sql += "SELECT * FROM tbl_wish w, product p, tbl_user u";
		sql += " WHERE w.productno = p.productno";
		sql += " AND w.wish_no=u.wish_no";
		
		
		List<Cart> cartlist = new ArrayList<>();
		List<Product> productlist = new ArrayList<>();
		Product product = new Product();
		
		try {
			ps = conn.prepareStatement(sql);	
			rs = ps.executeQuery();
			
			//조회결과처리
			while(rs.next()) {
				Cart cart = new Cart(); //조회 결과 행 저장 dto객체

//				PRODUCTQUAN
				
//				cart.setProduct_no( rs.getInt("productno"));
//				cart.setProduct_name( rs.getString("productname"));
//				cart.setPrice( rs.getInt("productprice"));
//				cart.set
				cart.setDeliveryfee( rs.getInt("deliveryfee"));
				cart.setWish_amount( rs.getInt("wish_amount"));
				cart.setTotalPrice( rs.getInt("wish_total_price"));
				
				product.setProductNo( rs.getInt("productno"));
				product.setProductName( rs.getString("productname"));
				product.setProductContent( rs.getString("productcontent"));
				product.setProductPrice( rs.getInt("productprice"));
				
				cartlist.add(cart); //리스트에 결과값 저장하기
				productlist.add(product);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("UserCartDao - List<Cart> checkCart(conn, param) 끝! ");
		return cartlist; //최종결과값반환  
//		return productlist; //최종결과값반환  
	}
	@Override
	public List<Cart> checkCart(Connection conn) {
		System.out.println("UserCartDao - List<Cart> checkCart() 시작! ");

		
		String sql = "";
		sql += "SELECT * FROM tbl_wish";

		
		List<Cart> cartlist = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);	
			rs = ps.executeQuery();
			
			//조회결과처리
			while(rs.next()) {
				Cart cart = new Cart(); //조회 결과 행 저장 dto객체

				cart.setCarNo( rs.getInt("wish_no"));
				cart.setProduct_no( rs.getInt("product_no"));
				cart.setProduct_name( rs.getString("product_name"));
				cart.setPrice( rs.getInt("price"));
				cart.setDeliveryfee( rs.getInt("deliveryfee"));
				cart.setWish_amount( rs.getInt("wish_amount"));
				cart.setTotalPrice( rs.getInt("wish_total_price"));
				
				cartlist.add(cart); //리스트에 결과값 저장하기
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("UserCartDao - List<Cart> checkCart() 끝! ");
		return cartlist; //최종결과값반환
	}
//	@Override
//	public int deleteCart() {
//
//		return 0;
//	}
//	@Override
//	public int deleteAllCart() {
//
//		return 0;
//	}
//	@Override
//	public Product getParam(HttpServletRequest req) {
//
//		return null;
//	}
	
	
	
}
