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
	 * @param connection - DB 연결 객체
	 * @param param -  ??
	 * @return - UserInfo 로그인한 회원 본인의 정보 조회
	 */
	public UserInfo showUserInfo(Connection connection, UserInfo param);
	
}
