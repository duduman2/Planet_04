package mypage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dto.Cart;
import mypage.dao.face.UserCartDao;

public class UserCartDaoImple implements UserCartDao {

	// DB 관련 객체
	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null;		 // 결과 집합 객체
	// (conn은 메소드의 변수에 선언)을 많이 하는 것 같음
	
	// 
	
	@Override
	public List<Cart> checkCart() {

		
		
		return null;
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
