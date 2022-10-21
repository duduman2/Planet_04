package mypage.dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Cart;

public interface UserCartDao {

	public List<Cart> checkCart(Connection conn); // int 반환, 장바구니 내역 조회
	
	public int deleteCart(); // int 반환, 장바구니 내역 삭제
	
	public int deleteAllCart(); // int 반환, 장바구니 내역 전체 삭제

	
	
}
