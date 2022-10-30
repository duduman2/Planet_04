package mypage.dao.face;

import java.sql.Connection;
import java.util.List;

import dto.AskBoard;
import dto.BoardInfo;
import dto.StoryBoard;
import dto.UserInfo;

public interface UserBoardDao {

	/**
	 * 
	 * @param connection
	 * @param param
	 * @return int
	 */
	public int selectStoryByUserNo(Connection connection, UserInfo param);  
	// int 반환, 내가 쓴 글 조회
	
//	public int deleteStoryBoard(); // int 반환, 내가 쓴 글 삭제
	
//	public List<AskBoard> selectAskByUserNo(); // int 반환, 문의사항 조회

	
	
}
