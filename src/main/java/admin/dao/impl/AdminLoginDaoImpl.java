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

import javax.servlet.http.HttpServletRequest;

import admin.dao.face.AdminLoginDao;
import common.JDBCTemplate;
import common.Paging;
import dto.AdminInfo;
import dto.AdminRecode;
import dto.BoardInfo;
import dto.Notice;
import dto.NoticeFile;
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
		
		System.out.println("AdminLoginDaoImpl.selectCntAll Start");
		
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
		
		System.out.println("AdminLoginDaoImpl.selectCntAll End");
		
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

	@Override
	public int selectCntAll1(Connection conn, Notice notice) {
		
		System.out.println("AdminLoginDaoImpl.selectCntAll1 Start");
		
		String sql = "";
		sql += "select count(*) cnt";
		sql += "	from tbl_notice n left outer join tbl_admininfo a";
		sql += "	on n.admin_no = a.admin_no where title like ? ";
		
		// 총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			ps.setString(1, "%" + notice.getTitle() + "%");

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
		
		System.out.println("AdminLoginDaoImpl.selectCntAll1 End");
		
		//최종 결과 반환
		return count;
		
	}

	@Override
	public int selectCntAll2(Connection conn, Notice notice) {
		
		System.out.println("AdminLoginDaoImpl.selectCntAll2 Start");
		
		String sql = "";
		sql += "select count(*) cnt";
		sql += "	from tbl_notice n left outer join tbl_admininfo a";
		sql += "	on n.admin_no = a.admin_no where admin_id like ? ";
		
		// 총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			ps.setString(1, "%" + notice.getAdmin_id() + "%");

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
	public List<Notice> selectAll1(Connection conn, Paging paging, Notice notice) {
		System.out.println("AdminLoginDaoImpl.selectAll4 Start");
		
		// SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		select n.notice_no, n.hit, n.title, n.notice_content, n.insert_dat, a.admin_id";
		sql += "		from tbl_notice n left outer join tbl_admininfo a";
		sql += "		on n.admin_no = a.admin_no where title like ? order by notice_no asc";
		sql += "	) B";
		sql += " ) tbl_notice";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 저장할 List
		List<Notice> noticeList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, "%" + notice.getTitle() + "%");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			// 조회 결과 처리
			while( rs.next() ) {
				
				Notice notice2 = new Notice(); //조회 결과 행 저장 DTO객체
				
				notice2.setNotice_no(rs.getInt("notice_no"));
				notice2.setHit(rs.getInt("hit"));
				notice2.setTitle(rs.getString("title"));
				notice2.setNotice_content(rs.getString("notice_content"));
				notice2.setInsert_dat(rs.getDate("insert_dat"));
				notice2.setAdmin_id(rs.getString("admin_id"));
				
				// 리스트에 결과값 저장하기
				noticeList.add(notice2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectAll4 End");
		
		return noticeList; //최종 결과 반환
	}

	@Override
	public List<Notice> selectAll2(Connection conn, Paging paging, Notice notice) {
		System.out.println("AdminLoginDaoImpl.selectAll5 Start");
		
		// SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		select n.notice_no, n.hit, n.title, n.notice_content, n.insert_dat, a.admin_id";
		sql += "		from tbl_notice n left outer join tbl_admininfo a";
		sql += "		on n.admin_no = a.admin_no where admin_id like ? order by notice_no asc";
		sql += "	) B";
		sql += " ) tbl_notice";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 저장할 List
		List<Notice> noticeList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, "%" + notice.getAdmin_id() + "%");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			// 조회 결과 처리
			while( rs.next() ) {
				
				Notice notice2 = new Notice(); //조회 결과 행 저장 DTO객체
				
				notice2.setNotice_no(rs.getInt("notice_no"));
				notice2.setHit(rs.getInt("hit"));
				notice2.setTitle(rs.getString("title"));
				notice2.setNotice_content(rs.getString("notice_content"));
				notice2.setInsert_dat(rs.getDate("insert_dat"));
				notice2.setAdmin_id(rs.getString("admin_id"));
				
				// 리스트에 결과값 저장하기
				noticeList.add(notice2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectAll5 End");
		
		return noticeList; //최종 결과 반환
	}

	@Override
	public int updateHit(Connection conn, Notice noticeno) {
		System.out.println("AdminLoginDaoImpl.updateHit Start");
		String sql = "";
		sql += "UPDATE tbl_notice";
		sql += "	SET hit = hit + 1";
		sql += " WHERE notice_no = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, noticeno.getNotice_no());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.updateHit End");
		
		return res;
	}

	@Override
	public Notice selectNoticeBynotice_no(Connection conn, Notice notice_no) {
		System.out.println("AdminLoginDaoImpl.selectNoticeBynotice_no Start");
		
		String sql = "";
		sql += "select n.notice_no, n.hit, n.title, n.notice_content, n.insert_dat, a.admin_id";
		sql += "	from tbl_notice n left outer join tbl_admininfo a";
		sql += "	on n.admin_no = a.admin_no where notice_no = ?";
		
		Notice notice = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, notice_no.getNotice_no());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				notice = new Notice();
				
				notice.setNotice_no(rs.getInt("notice_no"));
				notice.setHit(rs.getInt("hit"));
				notice.setTitle(rs.getString("title"));
				notice.setNotice_content(rs.getString("notice_content"));
				notice.setInsert_dat(rs.getDate("insert_dat"));
				notice.setAdmin_id(rs.getString("admin_id"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectNoticeBynotice_no End");
		
		return notice;
	}

	@Override
	public int selectNextNoticeno(Connection conn) {
		System.out.println("AdminLoginDaoImpl.selectNextNoticeno Start");
		
		String sql = "";
		sql += "SELECT tbl_notice_seq.nextval FROM dual";
		
		int nextNoticeno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				nextNoticeno = rs.getInt("nextval");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectNextNoticeno End");
		return nextNoticeno;
		
	}

	@Override
	public int insert(Connection conn, Notice notice, HttpServletRequest req) {
		System.out.println("AdminLoginDaoImpl.insert Start");
		
		String sql = "";
		sql += "INSERT INTO tbl_notice ( notice_no, hit, title, notice_content, insert_dat, admin_no )";
		sql += " VALUES ( ?, 0, ?, ?, sysdate, (select admin_no from tbl_admininfo where admin_id = ?) )";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, notice.getNotice_no());
			ps.setString(2, notice.getTitle());
			ps.setString(3, notice.getNotice_content());
			ps.setString(4, (String) req.getSession().getAttribute("userid"));
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.insert End");
		return res;
	}

	@Override
	public int insertFile(Connection conn, NoticeFile noticeFile) {
		System.out.println("AdminLoginDaoImpl.insertFile Start");
		
		String sql = "";
		sql += "INSERT INTO tbl_notice_file( file_no, notice_no, originname, storedname, filesize, write_date )";
		sql += " VALUES( tbl_notice_file_seq.nextval, ?, ?, ?, ?, sysdate )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, noticeFile.getnoticeno());
			ps.setString(2, noticeFile.getOriginname());
			ps.setString(3, noticeFile.getStoredname());
			ps.setInt(4, noticeFile.getFilesize());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.insertFile End");
		return res;
	}

	@Override
	public String selectOriginname(Connection conn, Notice notice) {
		System.out.println("AdminLoginDaoImpl.selectOriginname Start");
		
		String sql = "select originname from tbl_notice_file where notice_no = ?";
		
		String originName = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, notice.getNotice_no());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				originName = rs.getString("originname");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectOriginname End");
		return originName;
	}

	@Override
	public String selectStoredname(Connection conn, Notice notice) {
		System.out.println("AdminLoginDaoImpl.selectStoredname Start");
		
		String sql = "select storedname from tbl_notice_file where notice_no = ?";
		
		String storedname = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, notice.getNotice_no());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				storedname = rs.getString("storedname");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectStoredname End");
		return storedname;
	}

	@Override
	public void deleteNotice(Connection conn, Notice notice) {
		
		System.out.println("AdminLoginDaoImpl.deleteNotice Start");
		
		String sql = "delete from tbl_notice where notice_no = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, notice.getNotice_no());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.deleteNotice End");
		
	}

	@Override
	public void deleteNoticeFile(Connection conn, Notice notice) {
		System.out.println("AdminLoginDaoImpl.deleteNoticeFile Start");
		
		String sql = "delete from tbl_notice_file where notice_no = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, notice.getNotice_no());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.deleteNoticeFile End");
	}

	@Override
	public Notice selectNoticeByNoticeno(Connection conn, Notice noticeno) {
		System.out.println("AdminLoginDaoImpl.selectNoticeByNoticeno Start");
		
		String sql = "";
		sql += "select n.notice_no, n.hit, n.title, n.notice_content, n.insert_dat, n.admin_no, a.admin_id";
		sql += "	from tbl_notice n left outer join tbl_admininfo a";
		sql += "	on n.admin_no = a.admin_no";
		sql += "	WHERE notice_no = ?";
		
		Notice notice = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, noticeno.getNotice_no());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				notice = new Notice();
				
				notice.setNotice_no(rs.getInt("notice_no"));
				notice.setHit(rs.getInt("hit"));
				notice.setTitle(rs.getString("title"));
				notice.setNotice_content(rs.getString("notice_content"));
				notice.setInsert_dat(rs.getDate("insert_dat"));
				notice.setAdmin_no(rs.getInt("admin_no"));
				notice.setAdmin_id(rs.getString("admin_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectNoticeByNoticeno End");
		return notice;
	}

	@Override
	public NoticeFile selectFile(Connection conn, Notice updateNotice) {
		System.out.println("AdminLoginDaoImpl.selectFile Start");
		
		String sql = "";
		sql += "SELECT";
		sql += "	file_no, notice_no, storedname, originname, filesize, write_date";
		sql += "	FROM tbl_notice_file";
		sql += "	WHERE notice_no = ?";
		
		//조회 결과 객체
		NoticeFile noticeFile = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, updateNotice.getNotice_no());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				noticeFile = new NoticeFile();
				
				noticeFile.setFileno( rs.getInt("file_no") );
				noticeFile.setnoticeno( rs.getInt("notice_no"));
				noticeFile.setStoredname( rs.getString("storedname") );
				noticeFile.setOriginname( rs.getString("originname") );
				noticeFile.setFilesize( rs.getInt("filesize") );
				noticeFile.setWrite_date( rs.getDate("write_date") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectFile End");
		return noticeFile;
		
	}

	@Override
	public int update(Connection conn, Notice notice) {
		
		System.out.println("AdminLoginDaoImpl.update Start");
		
		String sql = "";
		sql += "UPDATE tbl_notice ";
		sql += " SET";
		sql += "	title = ?";
		sql += "	, notice_content = ?";
		sql += " WHERE notice_no = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, notice.getTitle());
			ps.setString(2, notice.getNotice_content());
			ps.setInt(3, notice.getNotice_no());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.update End");
		return res;

	}

	@Override
	public int selectCntAll(Connection conn, BoardInfo boardInfo) {
		System.out.println("AdminLoginDaoImpl.selectCntAll4 Start");
		
		String sql = "SELECT count(*) cnt FROM tbl_board where title like ? ";
		
		// 총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			ps.setString(1, "%" + boardInfo.getBoardTitle() + "%");

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
		
		System.out.println("AdminLoginDaoImpl.selectCntAll4 End");
		
		//최종 결과 반환
		return count;
	}

	@Override
	public List<BoardInfo> selectAll(Connection conn, Paging paging, BoardInfo boardInfo) {
		System.out.println("AdminLoginDaoImpl.selectAll6 Start");
		
		// SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		select b.boardno, b.title, b.board_content, b.insert_dat, b.update_dat, b.hit, b.cateno, u.userid";
		sql += "		from tbl_board b left outer join tbl_user u";
		sql += "		on b.userno = u.userno where title like ? ORDER BY boardno asc";
		sql += "	) B";
		sql += " ) tbl_board";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 저장할 List
		List<BoardInfo> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, "%" + boardInfo.getBoardTitle() + "%");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			// 조회 결과 처리
			while( rs.next() ) {
				
				BoardInfo boardInfo2 = new BoardInfo();
				
				boardInfo2.setBoardNo( rs.getInt("boardno") );
				boardInfo2.setBoardTitle( rs.getString("title") );
				boardInfo2.setBoardContent( rs.getString("board_content") );
				boardInfo2.setBoardDate( rs.getDate("insert_dat") );
				boardInfo2.setBoardDate( rs.getDate("update_dat") );
				boardInfo2.setBoardHit( rs.getInt("hit") );
				boardInfo2.setCateno( rs.getInt("cateno") );
				boardInfo2.setUserId(rs.getString("userid") );
				
				// 리스트에 결과값 저장하기
				boardList.add(boardInfo2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectAll6 End");
		
		return boardList; //최종 결과 반환
	}

	@Override
	public void deleteBoard(Connection conn, BoardInfo boardInfo) {
		System.out.println("AdminLoginDaoImpl.deleteBoard Start");
		
		String sql = "delete from tbl_board where boardno = ?";
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setInt(1, boardInfo.getBoardNo());

			ps.executeUpdate(); // SQL수행 및 결과 집합 저장
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.deleteBoard End");
		
	}

	@Override
	public void sendAdminLogin(Connection conn, String adminId) {
		System.out.println("AdminLoginDaoImpl.sendAdminLogin Start");
		
		String sql = "insert into tbl_admin_recode";
		sql += "	values (tbl_admin_recode_seq.nextval, ?, 'login', to_char(sysdate, 'yyyy-mm-dd/hh24.mi.ss'))";
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, adminId);

			ps.executeUpdate(); // SQL수행 및 결과 집합 저장
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.sendAdminLogin End");
	}

	@Override
	public void sendAdminLogout(Connection conn, String adminId) {
		System.out.println("AdminLoginDaoImpl.sendAdminLogout Start");
		
		String sql = "insert into tbl_admin_recode";
		sql += "	values (tbl_admin_recode_seq.nextval, ?, 'logout', to_char(sysdate, 'yyyy-mm-dd/hh24.mi.ss'))";
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, adminId);

			ps.executeUpdate(); // SQL수행 및 결과 집합 저장
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.sendAdminLogout End");
	}

	@Override
	public int selectCntAll(Connection conn, AdminRecode adminRecode) {
		System.out.println("AdminLoginDaoImpl.selectCntAll5 Start");
		
		String sql = "SELECT count(*) cnt FROM tbl_admin_recode where adminid like ? ";
		
		// 총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			ps.setString(1, "%" + adminRecode.getAdminid() + "%");

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
		
		System.out.println("AdminLoginDaoImpl.selectCntAll5 End");
		
		//최종 결과 반환
		return count;
	}

	@Override
	public List<AdminRecode> selectAll(Connection conn, Paging paging, AdminRecode adminRecode) {
		System.out.println("AdminLoginDaoImpl.selectAll5 Start");
		
		// SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		select manageno, adminid, behavior, time";
		sql += "		from tbl_admin_recode";
		sql += "		where adminid like ? order by manageno asc";
		sql += "	) B";
		sql += " ) tbl_admin_recode";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 저장할 List
		List<AdminRecode> noticeList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, "%" + adminRecode.getAdminid() + "%");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery(); // SQL수행 및 결과 집합 저장
			
			// 조회 결과 처리
			while( rs.next() ) {
				
				AdminRecode adminRecode2 = new AdminRecode();
				
				adminRecode2.setManageno( rs.getInt("manageno") );
				adminRecode2.setAdminid( rs.getString("adminid") );
				adminRecode2.setBehavior( rs.getString("behavior") );
				adminRecode2.setTime( rs.getString("time") );
				
				// 리스트에 결과값 저장하기
				noticeList.add(adminRecode2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.selectAll5 End");
		
		return noticeList; //최종 결과 반환
	}

	@Override
	public void sendAdminCreate(Connection conn, String adminId, AdminInfo adminInfo) {
		System.out.println("AdminLoginDaoImpl.sendAdminCreate Start");
		
		String sql = "insert into tbl_admin_recode";
		sql += "	values (tbl_admin_recode_seq.nextval, ?, ?, to_char(sysdate, 'yyyy-mm-dd/hh24.mi.ss'))";
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, adminId);
			ps.setString(2, "create adminId : " + adminInfo.getAdminId());

			ps.executeUpdate(); // SQL수행 및 결과 집합 저장
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.sendAdminCreate End");
	}

	@Override
	public void sendAdminDelete(Connection conn, String adminId, AdminInfo adminInfo) {
		System.out.println("AdminLoginDaoImpl.sendAdminDelete Start");
		
		String sql = "insert into tbl_admin_recode";
		sql += "	values (tbl_admin_recode_seq.nextval, ?, ?, to_char(sysdate, 'yyyy-mm-dd/hh24.mi.ss'))";
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, adminId);
			ps.setString(2, "delete adminId : " + adminInfo.getAdminId());

			ps.executeUpdate(); // SQL수행 및 결과 집합 저장
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.sendAdminDelete End");
	}

	@Override
	public void sendBoardDelete(Connection conn, String adminId, BoardInfo boardInfo) {
		System.out.println("AdminLoginDaoImpl.sendBoardDelete Start");
		
		String sql = "insert into tbl_admin_recode";
		sql += "	values (tbl_admin_recode_seq.nextval, ?, ?, to_char(sysdate, 'yyyy-mm-dd/hh24.mi.ss'))";
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, adminId);
			ps.setString(2, "delete boardNo / boardTitle / boardContent : " + boardInfo.getBoardNo()  + " / " + boardInfo.getBoardTitle() 
			+ " / " + boardInfo.getBoardContent());

			ps.executeUpdate(); // SQL수행 및 결과 집합 저장
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.sendBoardDelete End");
	}

	@Override
	public void sendUserCreate(Connection conn, String adminId, UserInfo userInfo) {
		System.out.println("AdminLoginDaoImpl.sendUserCreate Start");
		
		String sql = "insert into tbl_admin_recode";
		sql += "	values (tbl_admin_recode_seq.nextval, ?, ?, to_char(sysdate, 'yyyy-mm-dd/hh24.mi.ss'))";
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, adminId);
			ps.setString(2, "create userId : " + userInfo.getU_id());

			ps.executeUpdate(); // SQL수행 및 결과 집합 저장
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.sendUserCreate End");
	}

	@Override
	public void sendUserDelete(Connection conn, String adminId, UserInfo userInfo) {
		System.out.println("AdminLoginDaoImpl.sendUserDelete Start");
		
		String sql = "insert into tbl_admin_recode";
		sql += "	values (tbl_admin_recode_seq.nextval, ?, ?, to_char(sysdate, 'yyyy-mm-dd/hh24.mi.ss'))";
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, adminId);
			ps.setString(2, "delete userId : " + userInfo.getU_id());

			ps.executeUpdate(); // SQL수행 및 결과 집합 저장
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.sendUserDelete End");
	}

	@Override
	public void sendUserUpdate(Connection conn, String adminId, UserInfo userInfo) {
		System.out.println("AdminLoginDaoImpl.sendUserUpdate Start");
		
		String sql = "insert into tbl_admin_recode";
		sql += "	values (tbl_admin_recode_seq.nextval, ?, ?, to_char(sysdate, 'yyyy-mm-dd/hh24.mi.ss'))";
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, adminId);
			ps.setString(2, "Update userNo : " + userInfo.getU_no());

			ps.executeUpdate(); // SQL수행 및 결과 집합 저장
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.sendUserUpdate End");
	}

	@Override
	public void sendNoticeUpdate(Connection conn, String adminId, int test) {
		System.out.println("AdminLoginDaoImpl.sendNoticeUpdate Start");
		
		String sql = "insert into tbl_admin_recode";
		sql += "	values (tbl_admin_recode_seq.nextval, ?, ?, to_char(sysdate, 'yyyy-mm-dd/hh24.mi.ss'))";
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, adminId);
			ps.setString(2, "Update noticeNo : " + test);

			ps.executeUpdate(); // SQL수행 및 결과 집합 저장
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.sendNoticeUpdate End");
	}

	@Override
	public void sendNoticeDelete(Connection conn, String adminId, Notice notice) {
		System.out.println("AdminLoginDaoImpl.sendNoticeDelete Start");
		
		String sql = "insert into tbl_admin_recode";
		sql += "	values (tbl_admin_recode_seq.nextval, ?, ?, to_char(sysdate, 'yyyy-mm-dd/hh24.mi.ss'))";
		
		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			
			ps.setString(1, adminId);
			ps.setString(2, "Delete noticeNo / noticeTitle / noticeContent : " + notice.getNotice_no() + " / " + notice.getTitle() 
			+ " / " + notice.getNotice_content());

			ps.executeUpdate(); // SQL수행 및 결과 집합 저장
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("AdminLoginDaoImpl.sendNoticeDelete End");
	}
		
}
