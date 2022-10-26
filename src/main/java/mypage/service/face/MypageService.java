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
	 * 마이페이지 - 장바구니 내역 조회
	 * 
	 * @return List<Cart> - 조회된 장바구니의 리스트 
	 */
	
	public List<Cart> checkCart(); //장바구니 내역 조회 int

	
	public int deleteCart(); //장바구니 내역 삭제 int
	
	
	public int deleteAllCart(); //장바구니 내역 전체 삭제 int
	
	
	public List<StoryBoard> showStory(); //내가 쓴 글 확인 int

	
	public List<StoryBoard> deleteStory(); //내가 쓴 글 삭제 int
	
	
	public List<AskBoard> showAsk(); //문의사항 확인  int
	 
	/**
	 * 마이페이지 - 회원 조회
	 * 
	 * @param param - DB 연결 객체
	 * @return UserInfo - 회원 정보 조회
	 */
	public UserInfo showUserInfo(UserInfo param); //회원 정보 확인 int

	
	public int modifyUserInfo(); //회원 정보 수정 int, UserInfo
	
	
	/**
	 * 마이페이지 회원 정보 삭제
	 * 
	 * @param param - DB 연결 객체
	 * @return UserInfo - 회원 정보 삭제
	 */
	
	/**
	 * 마이페이지 - userno를 이용하여 회원 정보 삭제
	 * 
	 * @param param
	 * @return userno - 삭제할 회원의 PK
	 */
	public int deleteUser(UserInfo param); //회원 탈퇴 int


	public int deleteUser(int userno);


	/**
	 * 마이페이지 - 회원 정보 조회 후 닉네임 꺼내기
	 * 
	 * @param param - DB 연결 객체 
	 * @return UserInfo - 회원 정보 조회
	 */
//	public UserInfo askNick(UserInfo param);
	
	
}
