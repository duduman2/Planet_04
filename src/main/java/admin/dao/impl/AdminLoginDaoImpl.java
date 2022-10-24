package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import admin.dao.face.AdminLoginDao;
import common.JDBCTemplate;
import common.Paging;
import dto.AdminInfo;
import dto.UserInfo;

public class AdminLoginDaoImpl implements AdminLoginDao {
	
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public int select_tbl_admininfo(Connection conn, AdminInfo adminInfo) {
		
		System.out.println("AdminLoginDaoImpl.select_tbl_admininfo Start");
		
		String sql = "select count(*) cnt from tbl_admininfo where admin_id = ? and admin_pw = ?";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, adminInfo.getAdminId());
			ps.setString(2, adminInfo.getAdminPw());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.select_tbl_admininfo End");
		
		return cnt;
	}

	@Override
	public int selectCntAll(Connection conn) {
		
		System.out.println("AdminLoginDaoImpl.selectCntAll Start");
		
		String sql = "SELECT count(*) cnt FROM tbl_admininfo";
		
		// 총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장

			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectCntAll End");
		
		// 최종 결과 반환
		return count;
		
	}

	@Override
	public List<AdminInfo> selectAll(Connection conn, Paging paging) {
		
		System.out.println("AdminLoginDaoImpl.selectAll Start");
		
		// SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT admin_no, admin_id, admin_date FROM tbl_admininfo";
		sql += "		ORDER BY admin_no asc";
		sql += "	) B";
		sql += " ) tbl_admininfo";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 저장할 List
		List<AdminInfo> adminList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			// 조회 결과 처리
			while(rs.next()) {
				AdminInfo adminInfo = new AdminInfo(); // 조회 결과 행 저장 DTO객체
				
				adminInfo.setAdminNo( rs.getInt("admin_no") );
				adminInfo.setAdminId( rs.getString("admin_id") );
				adminInfo.setAdminDate( rs.getDate("admin_date") );
				
				// 리스트에 결과값 저장하기
				adminList.add(adminInfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectAll End");
		
		return adminList; // 최종 결과 반환
	}

	@Override
	public int create_tbl_admininfo(Connection conn, AdminInfo adminInfo) {
		
		System.out.println("AdminLoginDaoImpl.create_tbl_admininfo Start");
		
		String sql = "";
		sql += "insert into tbl_admininfo";
		sql += " values (tbl_admininfo_seq.nextval, ?, ?, sysdate)";
		
		int cnt = 0;
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, adminInfo.getAdminId());
			ps.setString(2, adminInfo.getAdminPw());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.create_tbl_admininfo End");
		
		return cnt;
		
	}

	@Override
	public int delete_tbl_admininfo(Connection conn, AdminInfo adminInfo) {
		
		System.out.println("AdminLoginDaoImpl.delete_tbl_admininfo Start");
		
		String sql = "delete from tbl_admininfo where admin_id = ?";
		
		int cnt = 0;
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, adminInfo.getAdminId());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.delete_tbl_admininfo End");
		
		return cnt;
		
	}

	@Override
	public int selectCntAll(Connection conn, AdminInfo adminInfo) {
		
		System.out.println("AdminLoginDaoImpl.selectCntAll2 Start");
		
		String sql = "SELECT count(*) cnt FROM tbl_admininfo where admin_id like ? ";
		
		// 총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			ps.setString(1, "%" + adminInfo.getAdminId() + "%");

			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			

			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectCntAll2 End");
		
		//최종 결과 반환
		return count;
		
	}

	@Override
	public List<AdminInfo> selectAll(Connection conn, Paging paging, AdminInfo adminInfo) {
		System.out.println("AdminLoginDaoImpl.selectAll2 Start");
		
		// SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT admin_no, admin_id, admin_date FROM tbl_admininfo";
		sql += "		where admin_id like ? ORDER BY admin_no asc";
		sql += "	) B";
		sql += " ) tbl_admininfo";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 저장할 List
		List<AdminInfo> adminList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, "%" + adminInfo.getAdminId() + "%");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			// 조회 결과 처리
			while(rs.next()) {
				
				AdminInfo adminInfo2 = new AdminInfo(); //조회 결과 행 저장 DTO객체
				
				adminInfo2.setAdminNo( rs.getInt("admin_no") );
				adminInfo2.setAdminId( rs.getString("admin_id") );
				adminInfo2.setAdminDate( rs.getDate("admin_date") );
				
				// 리스트에 결과값 저장하기
				adminList.add(adminInfo2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectAll2 End");
		
		return adminList; //최종 결과 반환
	}

	@Override
	public int create_tbl_user(Connection conn, UserInfo userInfo) {
		System.out.println("AdminLoginDaoImpl.create_tbl_user Start");
		
		String sql = "";
		sql += "insert into tbl_user";
		sql += " values (tbl_user_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, null, null)";
		
		int cnt = 0;
		
		try {
			
			// java.util.date로 저장된 dto객체를 string을 거쳐 java.sql.date로 변환하는 구문
	        Date date = userInfo.getU_birth();
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = simpleDateFormat.format(date);
	        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userInfo.getU_id());
			ps.setString(2, userInfo.getU_pw());
			ps.setString(3, userInfo.getU_name());
			ps.setDate(4, date1);
			ps.setString(5, userInfo.getU_gender());
			ps.setString(6, userInfo.getU_phone());
			ps.setString(7, userInfo.getU_email());
			ps.setString(8, userInfo.getU_address());
			ps.setString(9, userInfo.getU_nick());
			ps.setString(10, userInfo.getU_trade_user());
			ps.setString(11, userInfo.getB_business_number());
			ps.setString(12, userInfo.getGrade());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.create_tbl_user End");
		
		return cnt;
		
	}

	@Override
	public int delete_tbl_user(Connection conn, UserInfo userInfo) {
		System.out.println("AdminLoginDaoImpl.delete_tbl_user Start");
		
		String sql = "delete from tbl_user where userid = ?";
		
		int cnt = 0;
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userInfo.getU_id());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.delete_tbl_user End");
		
		return cnt;
		
	}

	@Override
	public UserInfo selectUser(Connection conn, UserInfo userInfo) {
		
		System.out.println("AdminLoginDaoImpl.selectUser End");
		
		String sql = "select * from tbl_user where userid = ?";
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userInfo.getU_id());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				/*
				// java.util.date로 저장된 dto객체를 string을 거쳐 java.sql.date로 변환하는 구문..인데 필요없네?
				Date date1 = rs.getDate("birth");
				Date date2 = rs.getDate("joindate");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String formattedDate1 = simpleDateFormat.format(date1);
				String formattedDate2 = simpleDateFormat.format(date2);
				userInfo.setU_birth(simpleDateFormat.parse(formattedDate1));
				userInfo.setU_birth(simpleDateFormat.parse(formattedDate2));
				*/
				
				userInfo.setU_no( rs.getInt("userno") );
				userInfo.setU_id( rs.getString("userid") );
				userInfo.setU_pw( rs.getString("userpw") );
				userInfo.setU_name( rs.getString("name") );
				userInfo.setU_birth( rs.getDate("birth") );
				userInfo.setU_gender( rs.getString("gender") );
				userInfo.setU_phone( rs.getString("phone") );
				userInfo.setU_email( rs.getString("email") );
				userInfo.setU_address( rs.getString("add1") );
				userInfo.setU_nick( rs.getString("usernick") );
				userInfo.setU_join_date( rs.getDate("joindate") );
				userInfo.setU_trade_user( rs.getString("tradeuser") );
				userInfo.setB_business_number( rs.getString("userbsno") );
				userInfo.setGrade( rs.getString("grade") );
				userInfo.setReportcode( rs.getString("reportcode") );

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("AdminLoginDaoImpl.selectUser End");
		
		return userInfo;
	}

	@Override
	public int selectCntAll(Connection conn, UserInfo userInfo) {
		System.out.println("AdminLoginDaoImpl.selectCntAll3 Start");
		
		String sql = "SELECT count(*) cnt FROM tbl_user where userid like ? ";
		
		// 총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			ps.setString(1, "%" + userInfo.getU_id() + "%");

			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			

			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectCntAll3 End");
		
		//최종 결과 반환
		return count;
		
	}

	@Override
	public List<UserInfo> selectAll(Connection conn, Paging paging, UserInfo userInfo) {
		System.out.println("AdminLoginDaoImpl.selectAll3 Start");
		
		// SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT userno, userid, name, birth, gender, phone, email, add1, usernick, joindate,";
		sql += "		tradeuser, userbsno, grade, reportcode FROM tbl_user";
		sql += "		where userid like ? ORDER BY userno asc";
		sql += "	) B";
		sql += " ) tbl_user";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 저장할 List
		List<UserInfo> userList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, "%" + userInfo.getU_id() + "%");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			// 조회 결과 처리
			while( rs.next() ) {
				
				UserInfo userInfo2 = new UserInfo(); //조회 결과 행 저장 DTO객체
				
				userInfo2.setU_no( rs.getInt("userno") );
				userInfo2.setU_id( rs.getString("userid") );
				userInfo2.setU_name( rs.getString("name") );
				userInfo2.setU_birth( rs.getDate("birth") );
				userInfo2.setU_gender( rs.getString("gender") );
				userInfo2.setU_phone( rs.getString("phone") );
				userInfo2.setU_email( rs.getString("email") );
				userInfo2.setU_address( rs.getString("add1") );
				userInfo2.setU_nick( rs.getString("usernick") );
				userInfo2.setU_join_date( rs.getDate("joindate") );
				userInfo2.setU_trade_user( rs.getString("tradeuser") );
				userInfo2.setB_business_number( rs.getString("userbsno") );
				userInfo2.setGrade( rs.getString("grade") );
				userInfo2.setReportcode( rs.getString("reportcode") );
				
				// 리스트에 결과값 저장하기
				userList.add(userInfo2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectAll3 End");
		
		return userList; //최종 결과 반환
		
	}

	@Override
	public int update_tbl_user(Connection conn, UserInfo userInfo) {
		
		System.out.println("AdminLoginDaoImpl.update_tbl_user Start");
		
		String sql = "";
		sql += "update tbl_user set userid = ?, userpw = ?, name = ?, ";
		sql += "phone = ?, email = ?, add1 = ?, usernick = ?, userbsno = ?, ";
		sql += "grade = ?, reportcode = ?, birth = ?, gender = ?, tradeuser = ? ";
		sql += "where userno = ?";
				
		int cnt = 0;
		
		try {
			
			// java.util.date로 저장된 dto객체를 string을 거쳐 java.sql.date로 변환하는 구문
	        Date date = userInfo.getU_birth();
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = simpleDateFormat.format(date);
	        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userInfo.getU_id());
			ps.setString(2, userInfo.getU_pw());
			ps.setString(3, userInfo.getU_name());
			ps.setString(4, userInfo.getU_phone());
			ps.setString(5, userInfo.getU_email());
			ps.setString(6, userInfo.getU_address());
			ps.setString(7, userInfo.getU_nick());
			ps.setString(8, userInfo.getB_business_number());
			ps.setString(9, userInfo.getGrade());
			ps.setString(10, userInfo.getReportcode());
			ps.setDate(11, date1);
			ps.setString(12, userInfo.getU_gender());
			ps.setString(13, userInfo.getU_trade_user());
			ps.setInt(14, userInfo.getU_no());
			
			System.out.println(
					userInfo.getU_id() + userInfo.getU_pw() + userInfo.getU_name()
					+ userInfo.getU_phone() + userInfo.getU_email() + userInfo.getU_address()
					+ userInfo.getU_nick() + userInfo.getB_business_number() + userInfo.getGrade() + userInfo.getReportcode()
					+ date1 + userInfo.getU_gender() + userInfo.getU_trade_user() + userInfo.getU_no()
					);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.update_tbl_user End");
		
		return cnt;
		
	}

	@Override
	public UserInfo selectUser2(Connection conn, UserInfo userInfo) {
		
		System.out.println("AdminLoginDaoImpl.selectUser2 End");
		
		String sql = "select * from tbl_user where userno = ?";
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userInfo.getU_no());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				userInfo.setU_id( rs.getString("userid") );
				userInfo.setU_pw( rs.getString("userpw") );
				userInfo.setU_name( rs.getString("name") );
				userInfo.setU_phone( rs.getString("phone") );
				userInfo.setU_email( rs.getString("email") );
				userInfo.setU_address( rs.getString("add1") );
				userInfo.setU_nick( rs.getString("usernick") );
				userInfo.setB_business_number( rs.getString("userbsno") );
				userInfo.setGrade( rs.getString("grade") );
				userInfo.setReportcode( rs.getString("reportcode") );
				userInfo.setU_birth( rs.getDate("birth") );
				userInfo.setU_gender( rs.getString("gender") );
				userInfo.setU_trade_user( rs.getString("tradeuser") );

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("AdminLoginDaoImpl.selectUser2 End");
		
		return userInfo;
		
	}

	@Override
	public int select_tbl_admininfo2(Connection conn, AdminInfo adminInfo) {
System.out.println("AdminLoginDaoImpl.select_tbl_admininfo2 Start");
		
		String sql = "select count(*) cnt from tbl_admininfo where admin_id = ?";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, adminInfo.getAdminId());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.select_tbl_admininfo2 End");
		
		return cnt;
	}

}
