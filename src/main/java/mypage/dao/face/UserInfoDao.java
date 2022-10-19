package mypage.dao.face;

import dto.UserInfo;

public interface UserInfoDao {

	public UserInfo selectUserInfoByUserNo();  // int 반환, 특정 유저 정보 조회
	
	public int updateUserInfo(); // int, userInfo 반환, 유저 정보 수정 밒 업데이트
	
	public int deleteUser(); // int 반환, 유저 정보 삭제
	
}
