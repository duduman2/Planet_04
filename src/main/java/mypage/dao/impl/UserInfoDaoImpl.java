package mypage.dao.impl;

import java.sql.Connection;
import java.sql.Date;
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
	public int updateUserInfo(Connection conn, UserInfo param) {
		System.out.println("userInfoDao - updateUserInfo() - 시작");

		// sql 작성
		String sql = "";
		sql += "UPDATE tbl_user";
		sql += " SET userno = ?";
		sql += " SET userid = ?"; 
		sql += " SET userpw = ?";
		sql += " SET name = ?"; 
		sql += " SET birth = ?"; //5
		
		sql += " SET gender = ?"; 
		sql += " SET phone = ?"; 
		sql += " SET email = ?"; 
		sql += " SET add1 = ?"; 
		sql += " SET usernick = ?"; //10
		
		sql += " SET joindate = ?";
		sql += " SET tradeuser = ?";
		sql += " SET userbsno = ?";
		sql += " SET grade = ?";
		
		sql += " SET reportcode = ?";
		sql += " SET wish_no = ?"; //16
		sql += " WHERE userno = ?"; 
		
		int result = 0; //결과를 저장할 객체

		try {
			// sql 수행 객체
			ps = conn.prepareStatement(sql);
			
			// sql 파라미터 전달
			ps.setInt(1, param.getU_no());
			ps.setString(2, param.getU_id());
			ps.setString(3, param.getU_pw());
			ps.setString(4, param.getU_name());
			
			ps.setDate(5, (Date) param.getU_birth());
			ps.setString(6, param.getU_gender());
			ps.setString(7, param.getU_phone());
			ps.setString(8, param.getU_email());
			
			ps.setString(9, param.getU_address());
			ps.setString(10, param.getU_nick());
			ps.setDate(11, (Date) param.getU_join_date());
			ps.setString(12, param.getU_trade_user());
			
			ps.setString(13, param.getB_business_number());
			ps.setString(14, param.getGrade());
			ps.setString(15, param.getReportcode());
			ps.setString(16, param.getWishno());
			
			// sql 수행 및 결과 집합 저장
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("userInfoDao - updateUserInfo() - 끝");
		return result; //최종 결과 반환
	}

	@Override
	public UserInfo showUserInfo(Connection conn, UserInfo param) {
		
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
	
	@Override
	public int deleteUser(Connection conn, int userno) {
		System.out.println("userInfoDao - deleteUser() - 시작");

		// sql 작성
		String sql = "";
		sql += "DELETE tbl_user";
		sql += " WHERE userno = ?";
		
		//삭제된 행의 수를 저장하는 변수
		int res = 0;
		
		//sql 수행 객체 생성
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userno);
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("userInfoDao - deleteUser() - 끝");
		return res;
	}
	@Override
	public int deleteUser(Connection conn, UserInfo param) {

		
		
		return 0;
	}

	
//	@Override
//	public UserInfo askNick(Connection conn, UserInfo param) {
//		System.out.println("userInfoDao - askNick() - 시작");
//		
//		// sql 작성
//		String sql = "";
//		sql += "SELECT usernick";
//		sql += " FROM tbl_user";
//		
//		UserInfo re = new UserInfo();
//
//		try {
//			ps = conn.prepareStatement(sql);	// sql 수행 객체
//			ps.setString(1, param.getU_nick()); // sql 파라미터 전달
//			rs = ps.executeQuery();				// sql 수행 및 결과 집합 저장
//			
//			re.setU_nick(rs.getString("usernick"));
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		System.out.println("userInfoDao - askNick() - 끝");
//		return re;
//	}
	
	
	
}
