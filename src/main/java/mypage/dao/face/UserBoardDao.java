package mypage.dao.face;

import java.util.List;

import dto.AskBoard;
import dto.StoryBoard;

public interface UserBoardDao {

	public List<StoryBoard> selectStoryByUserNo();  // int 반환, 내가 쓴 글 조회
	
	public int deleteStoryBoard(); // int 반환, 내가 쓴 글 삭제
	
	public List<AskBoard> selectAskByUserNo(); // int 반환, 문의사항 조회
	
	
}
