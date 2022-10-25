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
				
//				rs.getInt(); 조회결과시 사용하는 코드
				
				re.setU_no( rs.getInt("userno"));
				re.setU_id(rs.getString("userid"));
				re.setU_pw(rs.getString("userpw"));
				re.setU_name(rs.getString("name")); //4
				re.setU_birth(rs.getDate("birth"));
				re.setU_gender(rs.getString("gender"));
				re.setU_phone(rs.getString("phone"));
				re.setU_email(rs.getString("email"));//8
				re.setU_address(rs.getString("add1"));
				re.setU_nick(rs.getString("usernick"));
				re.setU_join_date(rs.getDate("joindate"));
				re.setU_trade_user(rs.getString("tradeuser")); //12
				re.setB_business_number(rs.getString("userbsno"));
				re.setGrade(rs.getString("grade"));
				re.setReportcode(rs.getString("reportcode"));
				re.setWishno(rs.getString("wish_no"));  //16
				
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
