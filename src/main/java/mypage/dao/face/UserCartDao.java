package mypage.dao.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Cart;
import dto.Product;
import dto.UserInfo;

public interface UserCartDao {


	/**
	 * 로그인한 회원의 장바구니 조회
	 * 
	 * @param conn
	 * @param param
	 * @return
	 */
	public List<Cart> checkCart(Connection conn, UserInfo param); //장바구니 내역 조회
	
	public int deleteCart(); // int 반환, 장바구니 내역 삭제
	
	public int deleteAllCart(); // int 반환, 장바구니 내역 전체 삭제

	/**
	 * 장바구니 내역 조회 
	 * -- 이건 DB에 있는 모든 tbl_wish 리스트 전부 보여줌 / 잘못만듬,,ㅜㅜ
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<Cart> - 장바구니 전체 조회 목록
	 */
	public List<Cart> checkCart(Connection conn);

	
	public Product getParam(HttpServletRequest req);

	
	
	public List<Product> checkCarts(Connection conn, UserInfo param);



	
	
}
