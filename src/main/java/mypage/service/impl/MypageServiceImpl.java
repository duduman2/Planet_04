package mypage.service.impl;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import dto.Cart;
import dto.Product;
import dto.UserInfo;
import mypage.dao.face.UserBoardDao;
import mypage.dao.face.UserCartDao;
import mypage.dao.face.UserInfoDao;
import mypage.dao.impl.UserBoardDaoImpl;
import mypage.dao.impl.UserCartDaoImple;
import mypage.dao.impl.UserInfoDaoImpl;
import mypage.service.face.MypageService;


public class MypageServiceImpl implements MypageService {

	// Dao 객체 
	private UserCartDao userCartDao = new UserCartDaoImple();
	private UserBoardDao userBoardDao = new UserBoardDaoImpl();
	private UserInfoDao userInfoDao = new UserInfoDaoImpl();
	
	@Override
	public int deleteCart() {

		return 0;
	}

	@Override
	public int deleteAllCart() {

		return 0;
	}

	@Override
	public int deleteUser(int userno) {
		System.out.println("MypageService - deleteUser(userno) - DB 연결 객체 생성완료 ");
		
		System.out.println("MypageService - deleteUser(userno) - DAO 호출 후");
		
		// DB 조회 결과 반환
		return 0;
	}

	@Override
	public List<Cart> checkCart(UserInfo param) {
		System.out.println("MypageService - List<Cart> checkCart() - DB 연결 객체 생성완료 ");
		
		System.out.println("MypageService - List<Cart> checkCart() - DAO 호출 후");

		// DB 조회 결과 반환
		return userCartDao.checkCart(JDBCTemplate.getConnection(), param);
	}

	@Override
	public List<dto.StoryBoard> showStory() {

		return null;
	}

	@Override
	public List<dto.StoryBoard> deleteStory() {

		return null;
	}

	@Override
	public List<dto.AskBoard> showAsk() {

		return null;
	}

	@Override
	public dto.UserInfo showUserInfo(UserInfo param) {
		System.out.println("MypageService - showUserInfo() - DB 연결 객체 생성완료 ");
		
		System.out.println("MypageService - showUserInfo() - DAO 호출 후");
		
		// DB 조회 결과 반환
		return userInfoDao.showUserInfo(JDBCTemplate.getConnection(), param);
	}


	@Override
	public int deleteUser(UserInfo param) {
		System.out.println("MypageService - deleteUser(param) - DB 연결 객체 생성완료 ");
		
		System.out.println("MypageService - deleteUser(param) - DAO 호출 후");
		
		// DB 조회 결과 반환
		return userInfoDao.deleteUser(JDBCTemplate.getConnection(), param);
	}

	@Override
	public int updateUserInfo(UserInfo param) {
		System.out.println("MypageService - updateUserInfo(param) - DB 연결 객체 생성완료 ");
		
		System.out.println("MypageService - updateUserInfo(param) - DAO 호출 후");
		
		// DB 조회 결과 반환
		return userInfoDao.updateUserInfo(JDBCTemplate.getConnection(), param);
	}

	@Override
	public int modifyUserInfo() {
		return 0;
	}

	@Override
	public List<Product> checkCarts(UserInfo param) {
		
		System.out.println("MypageService - List<Product> checkCarts - DB 연결 객체 생성완료 ");
		
		System.out.println("MypageService - List<Product> checkCarts - DAO 호출 후");
		
		// DB 조회 결과 반환
		return userCartDao.checkCarts(JDBCTemplate.getConnection(), param);
	}

//	@Override
//	public UserInfo askNick(UserInfo param) {
//		System.out.println("MypageService - askNick() - DB 연결 객체 생성완료 ");
//
//		System.out.println("MypageService - askNick() - DAO 호출 후 ");
//
//		// DB 연결 객체
//		Connection conn = JDBCTemplate.getConnection();
//		
//		// DB 조회 결과 반환
//		return UserInfoDao.askNick(conn, param);
//	}

}
