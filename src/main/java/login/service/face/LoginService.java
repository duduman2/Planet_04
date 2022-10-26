package login.service.face;

import javax.servlet.http.HttpServletRequest;

import dto.UserInfo;

public interface LoginService {

//	로그인 정보 추출하기
	public UserInfo getJoinUserInfo(HttpServletRequest req);

//	로그인 인증 처리
	public boolean login(UserInfo userInfo);
	public int login(String u_id, String u_pw);
	
//	유저 정보 가져오기	
	public UserInfo info(UserInfo userInfo);

//	회원가입 정보 추출하기
	public UserInfo getLoginUserInfo(HttpServletRequest req);
	
//	회원가입 처리
	public void join(UserInfo userinfo);

//	아이디 찾기
	public UserInfo findId(UserInfo userinfo);
	
//	아이디 찾기 - 이름, 이메일 활용
	public UserInfo getFindUserInfo(HttpServletRequest req);

//	비밀번호 찾기
	public UserInfo findPw(UserInfo userinfo);
	
//	비밀번호 찾기 - 이름, 아이디 활용
	public UserInfo getFindPwUserInfo(HttpServletRequest req);
	
//	로그인 정보 확인
	public UserInfo selectOneMember(String u_id, String u_pw);

}
