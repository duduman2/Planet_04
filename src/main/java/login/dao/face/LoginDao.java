package login.dao.face;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import dto.UserInfo;

public interface LoginDao {

	//userid와 userpw를 동시에 만족하는 회원의 수를 조회한다 - 로그인 인증값으로 사용한다
	public int selectCntUserInfoByU_idU_pw(Connection conn, UserInfo userinfo);
	
	// userid를 이용해 회원정보 조회하기
	public UserInfo selectUserInfoByU_id(Connection conn, UserInfo userinfo);

	// 회원 정보 삽입
	public int insert(Connection conn, UserInfo userinfo);

	public int selectLoginInfo(String u_id, String u_pw);
	
	//중복확인
	public int idCheck(String u_id);
	
	public int nickCheck(String u_nick);

	public int emailCheck(String u_email);

	public int nameCheck(String u_name);
	
	// username을 이용해 회원정보 조회하기
	public UserInfo selectUserInfoByU_name(Connection conn, UserInfo userinfo);
	
	//아이디 찾기
	public UserInfo findId(String u_name, String u_email);

}
