package mypage.service.face;

import java.util.List;

import dto.AskBoard;
import dto.Cart;
import dto.StoryBoard;
import dto.UserInfo;
import mypage.dao.face.UserBoardDao;
import mypage.dao.face.UserCartDao;
import mypage.dao.face.UserInfoDao;
import mypage.dao.impl.UserBoardDaoImpl;
import mypage.dao.impl.UserCartDaoImple;
import mypage.dao.impl.UserInfoDaoImpl;

public interface MypageService {
	
	/**
	 * 장바구니 내역 조회
	 * 
	 * @return 조회된 장바구니의 리스트 
	 */
	
	public List<Cart> checkCart(); //장바구니 내역 조회 int

	
	public int deleteCart(); //장바구니 내역 삭제 int
	
	
	public int deleteAllCart(); //장바구니 내역 전체 삭제 int
	
	
	public List<StoryBoard> showStory(); //내가 쓴 글 확인 int

	
	public List<StoryBoard> deleteStory(); //내가 쓴 글 삭제 int
	
	
	public List<AskBoard> showAsk(); //문의사항 확인  int
	 
	
	public UserInfo showUserInfo(); //회원 정보 확인 int

	
	public int modifyUserInfo(); //회원 정보 수정 int, UserInfo
	
	
	public int deleteUser(); //회원 탈퇴 int
	
	
}
