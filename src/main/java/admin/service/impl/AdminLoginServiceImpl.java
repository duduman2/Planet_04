package admin.service.impl;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.dao.face.AdminLoginDao;
import admin.dao.impl.AdminLoginDaoImpl;
import admin.service.face.AdminLoginService;
import common.JDBCTemplate;
import common.Paging;
import dto.AdminInfo;
import dto.UserInfo;

public class AdminLoginServiceImpl implements AdminLoginService {
	
	AdminLoginDao adminDao = new AdminLoginDaoImpl();

	@Override
	public AdminInfo getAdminInfo(HttpServletRequest req) {
		
		System.out.println("AdminServiceImpl.getAdminInfo Start");
		
		AdminInfo adminInfo = new AdminInfo();
		
		if( req.getParameter("userid") != null) {
			adminInfo.setAdminId( req.getParameter("userid") );
		} else {
			adminInfo.setAdminId("");
		}
		
		adminInfo.setAdminPw( req.getParameter("userpw") );
		
		System.out.println("AdminServiceImpl.getAdminInfo End");
		
		return adminInfo;
	}

	@Override
	public Boolean AdminLogin(AdminInfo adminInfo) {
		
		System.out.println("AdminServiceImpl.AdminLogin Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.select_tbl_admininfo(conn, adminInfo) > 0 ) {
			// JDBCTemplate.close(conn); 왜 이거 있으면 에러떨어지지?
			return true;
		}
		
		// JDBCTemplate.close(conn); 그럼 conn은 종료 안해도 문제가 없나?
		
		System.out.println("AdminServiceImpl.AdminLogin End");
		
		return false;
		
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		System.out.println("AdminServiceImpl.getPaging Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		//총 관리자리스트 수 조회하기
		int totalCount = adminDao.selectCntAll(conn);
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage"); // url의 curPage파라미터값 조회
		
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		System.out.println("AdminServiceImpl.getPaging End");
				
		return paging;
				
	}

	@Override
	public List<AdminInfo> getList(Paging paging) {
		
		System.out.println("AdminServiceImpl.getList Start");
		
		System.out.println("AdminServiceImpl.getList End");
		
		return adminDao.selectAll(JDBCTemplate.getConnection(), paging);
		
	}

	@Override
	public Boolean AdminCreate(AdminInfo adminInfo) {
		System.out.println("AdminServiceImpl.AdminCreate Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.create_tbl_admininfo(conn, adminInfo) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
		}
		
		JDBCTemplate.rollback(conn);
		
		System.out.println("AdminServiceImpl.AdminCreate End");
		
		return false;
	}

	@Override
	public Boolean AdminDelete(AdminInfo adminInfo) {
		System.out.println("AdminServiceImpl.AdminDelete Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.delete_tbl_admininfo(conn, adminInfo) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
		}
		
		JDBCTemplate.rollback(conn);
		
		System.out.println("AdminServiceImpl.AdminDelete End");
		
		return false;
	}

	@Override
	public Paging getPaging(HttpServletRequest req, AdminInfo adminInfo) {
		
		System.out.println("AdminServiceImpl.getPaging2 Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		//총 관리자리스트 수 조회하기
		int totalCount = adminDao.selectCntAll(conn, adminInfo);
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage"); // url의 curPage파라미터값 조회
		
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		System.out.println(paging);
		
		System.out.println("AdminServiceImpl.getPaging2 End");
				
		return paging;

	}

	@Override
	public List<AdminInfo> getList(Paging paging, AdminInfo adminInfo) {
		
		System.out.println("AdminServiceImpl.getList2 Start");
		
		System.out.println("AdminServiceImpl.getList2 End");
		
		return adminDao.selectAll(JDBCTemplate.getConnection(), paging, adminInfo);
		
	}

	@Override
	public UserInfo getUserInfo(HttpServletRequest req) {
		
		System.out.println("AdminServiceImpl.getUserInfo Start");
		
		UserInfo userInfo = new UserInfo();
		
		if( req.getParameter("userid") != null) {
			userInfo.setU_id( req.getParameter("userid") );
		} else {
			userInfo.setU_id("");
		}
		
		userInfo.setU_pw(req.getParameter("userpw"));
		userInfo.setU_name(req.getParameter("name"));
		userInfo.setU_phone(req.getParameter("phone"));
		userInfo.setU_email(req.getParameter("email"));
		userInfo.setU_address(req.getParameter("add1"));
		userInfo.setU_nick(req.getParameter("usernick"));
		userInfo.setB_business_number(req.getParameter("userbsno"));
		userInfo.setGrade(req.getParameter("grade"));
		
		// string으로 가져온 birth를 date로 바꿔서 dto에 저장하는 구문
		String from = req.getParameter("birth");
		if( from != null) {
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			try {
				userInfo.setU_birth(fm.parse(from));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		userInfo.setU_gender(req.getParameter("gender"));
		userInfo.setU_trade_user(req.getParameter("tradeuser"));
		
		System.out.println("AdminServiceImpl.getUserInfo End");
		
		return userInfo;
		
	}

	@Override
	public Boolean UserCreate(UserInfo userInfo) {
		
		System.out.println("AdminServiceImpl.UserCreate Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.create_tbl_user(conn, userInfo) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
		}
		
		JDBCTemplate.rollback(conn);
		
		System.out.println("AdminServiceImpl.UserCreate End");
		
		return false;
		
	}

	@Override
	public Boolean UserDelete(UserInfo userInfo) {
		
		System.out.println("AdminServiceImpl.UserDelete Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.delete_tbl_user(conn, userInfo) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
		}
		
		JDBCTemplate.rollback(conn);
		
		System.out.println("AdminServiceImpl.UserDelete End");
		
		return false;
		
	}

	@Override
	public UserInfo UserSearch(UserInfo userInfo) {
		
		System.out.println("AdminServiceImpl.UserSearch Start");
		
		System.out.println("AdminServiceImpl.UserSearch End");
		
		return adminDao.selectUser(JDBCTemplate.getConnection(), userInfo);
		
	}

	@Override
	public Paging getPaging(HttpServletRequest req, UserInfo userInfo) {
		
		System.out.println("AdminServiceImpl.getPaging3 Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		//총 관리자리스트 수 조회하기
		int totalCount = adminDao.selectCntAll(conn, userInfo);
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage"); // url의 curPage파라미터값 조회
		
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		System.out.println("AdminServiceImpl.getPaging3 End");
				
		return paging;
		
	}

	@Override
	public List<UserInfo> getList(Paging paging, UserInfo userInfo) {
		
		System.out.println("AdminServiceImpl.getList3 Start");
		
		System.out.println("AdminServiceImpl.getList3 End");
		
		return adminDao.selectAll(JDBCTemplate.getConnection(), paging, userInfo);
		
	}

	@Override
	public Boolean UserUpdate(UserInfo userInfo) {
		
		System.out.println("AdminServiceImpl.UserUpdate Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.update_tbl_user(conn, userInfo) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
		}
		
		JDBCTemplate.rollback(conn);
		
		System.out.println("AdminServiceImpl.UserUpdate End");
		
		return false;
		
	}

	@Override
	public UserInfo UserSearch2(HttpServletRequest req) {
		
		System.out.println("AdminServiceImpl.UserSearch2 Start");
		
		UserInfo userInfo = new UserInfo();
		
		userInfo.setU_no(Integer.parseInt(req.getParameter("userno")));
		userInfo.setU_id(req.getParameter("userid"));
		userInfo.setU_pw(req.getParameter("userpw"));
		userInfo.setU_name(req.getParameter("name"));
		userInfo.setU_phone(req.getParameter("phone"));
		userInfo.setU_email(req.getParameter("email"));
		userInfo.setU_address(req.getParameter("add1"));
		userInfo.setU_nick(req.getParameter("usernick"));
		userInfo.setB_business_number(req.getParameter("userbsno"));
		userInfo.setGrade(req.getParameter("grade"));
		userInfo.setReportcode(req.getParameter("reportcode"));
		
		// string으로 가져온 birth를 date로 바꿔서 dto에 저장하는 구문
		String from = req.getParameter("birth");
		if( from != null) {
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			try {
				userInfo.setU_birth(fm.parse(from));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		userInfo.setU_gender(req.getParameter("gender"));
		userInfo.setU_trade_user(req.getParameter("tradeuser"));
		
		System.out.println("AdminServiceImpl.UserSearch2 End");
		
		return userInfo;
		
	}

	@Override
	public Boolean AdminCheck(AdminInfo adminInfo) {
		System.out.println("AdminServiceImpl.AdminCheck Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.select_tbl_admininfo2(conn, adminInfo) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
		}
		
		JDBCTemplate.rollback(conn);
		
		System.out.println("AdminServiceImpl.AdminCheck End");
		
		return false;
	}

}
