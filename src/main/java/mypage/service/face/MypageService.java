package mypage.service.face;

import java.util.List;

public class MypageService {
	
	private UserCartDao userCartDao;
	private UserBoardDao userBoardDao;
	private UserInfoDao userInfoDao;
	
	
	
	//장바구니 리스트 int
	public List<CarList> checkCart();

	//장바구니 내역 삭제 int
	public int deleteCart();
	
	//장바구니 내역 전체 삭제 int
	public int deleteAllCart();
	
	//내가 쓴 글 확인 int
	public List<StoryBoard> showStory();

	//내가 쓴 글 삭제 int
	public List<StoryBoard> deleteStory();
	
	//문의사항 확인  int
	public List<AskBoard> showAsk();
	
	//회원 정보 확인 int
	public UserInfo showUserInfo();

	//회원 정보 수정 int, UserInfo
	public int showUserInfo();
	
	//회원 탈퇴 int
	public int deleteUser();
	
	
}
