package mypage.dao.face;

import java.sql.Connection;

import dto.UserInfo;

public interface UserInfoDao {


	/**
	 * 마이페이지 - 회원정보 삭제
	 * 
	 * @param conn - DB 연결 객체
	 * @param param - 회원 정보
	 * @return UserInfo - 회원 정보 삭제
	 */
	public int deleteUser(Connection conn, UserInfo param); // int 반환, 유저 정보 삭제

	
	public int deleteUser(Connection conn, int userno);

	/**
	 * 마이페이지 - 회원정보 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param param - 회원 정보
	 * @return - UserInfo 로그인한 회원 본인의 정보 조회
	 */
	public UserInfo showUserInfo(Connection conn, UserInfo param);

	/**
	 * 마이페이지 - 회원 정보 수정 및 업데이트
	 * 
	 * @param conn
	 * @param param
	 * @return
	 */
	public int updateUserInfo(Connection conn, UserInfo param);
	// int, userInfo 반환, 유저 정보 수정 및 업데이트

	/**
	 * 마이페이지 - 회원 정보 조회 후 닉네임 꺼내기
	 * 
	 * @param conn - DB 연결 객체
	 * @param param - 회원 정보
	 * @return - UserInfo 로그인한 회원 본인의 닉네임 조회
	 */
//	public  UserInfo askNick(Connection conn, UserInfo param);
	
}
