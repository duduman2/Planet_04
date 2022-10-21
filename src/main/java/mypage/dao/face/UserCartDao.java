package mypage.dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Cart;

public interface UserCartDao {

	/**
	 * 장바구니 내역 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<Cart> - 장바구니 전체 조회 목록
	 */
	public List<Cart> checkCart(Connection conn); // int 반환, 장바구니 내역 조회
	
	public int deleteCart(); // int 반환, 장바구니 내역 삭제
	
	public int deleteAllCart(); // int 반환, 장바구니 내역 전체 삭제

	
	
}
