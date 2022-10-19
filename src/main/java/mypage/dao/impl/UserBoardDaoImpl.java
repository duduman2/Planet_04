package mypage.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dto.AskBoard;
import dto.StoryBoard;
import mypage.dao.face.UserBoardDao;

public class UserBoardDaoImpl implements UserBoardDao {

	// DB 관련 객체
	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null;		 // 결과 집합 객체
	//(conn은 메소드의 변수에 선언)을 많이 하는 것 같음
	
	
	@Override
	public List<StoryBoard> selectStoryByUserNo() {

		return null;
	}
	@Override
	public int deleteStoryBoard() {

		return 0;
	}
	@Override
	public List<AskBoard> selectAskByUserNo() {

		return null;
	}
	
	
	
}
