package mypage.dao.face;

import java.sql.Connection;

import dto.UserInfo;

public interface UserInfoDao {

	public UserInfo selectUserInfoByUserNo();  // int 반환, 특정 유저 정보 조회
	
	public int updateUserInfo(); // int, userInfo 반환, 유저 정보 수정 및 업데이트
	
	public int deleteUser(); // int 반환, 유저 정보 삭제

	/**
	 * 마이페이지 - 회원정보 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param param - 회원 정보
	 * @return - UserInfo 로그인한 회원 본인의 정보 조회
	 */
	public UserInfo showUserInfo(Connection conn, UserInfo param);

	/**
	 * 마이페이지 - 회원 정보 조회 후 닉네임 꺼내기
	 * 
	 * @param conn - DB 연결 객체
	 * @param param - 회원 정보
	 * @return - UserInfo 로그인한 회원 본인의 닉네임 조회
	 */
	public  UserInfo askNick(Connection conn, UserInfo param);
	
}
