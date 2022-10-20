package mypage.service.impl;

import java.util.List;

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
	public List<dto.CarList> checkCart() {

		return null;
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
