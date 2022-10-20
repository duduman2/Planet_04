package admin.service.impl;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		String from = req.getParameter("birth");
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		
		userInfo.setU_id(req.getParameter("userid"));
		userInfo.setU_pw(req.getParameter("userpw"));
		userInfo.setU_name(req.getParameter("name"));
		
		try {
			userInfo.setU_birth(fm.parse(from));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		userInfo.setU_gender(req.getParameter("gender"));
		userInfo.setU_phone(Integer.parseInt(req.getParameter("phone")));
		userInfo.setU_email(req.getParameter("email"));
		userInfo.setU_address(req.getParameter("add1"));
		userInfo.setU_nick(req.getParameter("usernick"));
		userInfo.setU_trade_user(req.getParameter("tradeuser"));
		userInfo.setB_business_number(Integer.parseInt(req.getParameter("userbsno")));
		
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

}
