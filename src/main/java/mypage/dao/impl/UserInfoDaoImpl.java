package mypage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dto.UserInfo;
import mypage.dao.face.UserInfoDao;

public class UserInfoDaoImpl implements UserInfoDao {

	// DB 관련 객체
	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null;		 // 결과 집합 객체
	
	
	@Override
	public UserInfo selectUserInfoByUserNo() {

		return null;
	}
	@Override
	public int updateUserInfo() {

		return 0;
	}
	@Override
	public int deleteUser() {

		return 0;
	}
	@Override
	public UserInfo showUserInfo(Connection conn, UserInfo param) {
		System.out.println("userInfoDao - showUserInfo() - 시작");
		
		// sql 작성
		String sql = "";
		sql += "SELECT * FROM tbl_user";
		sql += " WHERE userno = ?";
		
		UserInfo re = new UserInfo();
		
		try {
			// sql 수행 객체
			ps = conn.prepareStatement(sql);
			
			// sql 파라미터 전달
			ps.setInt(1, param.getU_no());
			
			// sql 수행 및 결과 집합 저장
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
//				rs.getInt(); 조회결과시
				
				rs.getInt(0);
				rs.getString(0);
				
//				re.setU_no("userno");
//				re.setU_id("userid");
//				re.setU_pw("userpw");
//				re.setU_name("name"); //4
//				re.setU_birth("birth");
//				re.setU_gender("gender");
//				re.setU_phone("phone");
//				re.setU_email("email");//8
//				re.setU_address("add1");
//				re.setU_nick("usernick");
//				re.setU_join_date("joindate");
//				re.setU_trade_user("tradeuser"); //12
//				re.setB_business_number("userbsno");
//				re.setGrade("grade");
//				re.setReportcode("reportcode");
//				re.setWishno("wish_no");  //16
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("userInfoDao - showUserInfo() - 끝");
		return re; //최종 결과 반환
	}
	
	
	
}
