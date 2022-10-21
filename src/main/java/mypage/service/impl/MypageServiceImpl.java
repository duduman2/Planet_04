package mypage.service.impl;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import dto.Cart;
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
	public int deleteUser() {

		return 0;
	}

	@Override
	public List<Cart> checkCart() {
		
		// DB 조회 결과 반환
		return userCartDao.checkCart(JDBCTemplate.getConnection());
		
//------------------------------------------------------------
//		Connection conn = JDBCTemplate.getConnection();
//		System.out.println("MypageService - List<Cart> checkCart() - DB 연결 객체 생성완료 ");
//		
//		//tbl_wish  전체 조회 - userCartDao 이용
//		List<Cart> list = userCartDao.checkCart(conn);
//		
//		System.out.println("MypageService - List<Cart> checkCart() - DAO 호출 후");
//
//		//조회 결과 리턴
//		return list;
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
	public dto.UserInfo showUserInfo() {

		return null;
	}

	@Override
	public int modifyUserInfo() {

		return 0;
	}

}
