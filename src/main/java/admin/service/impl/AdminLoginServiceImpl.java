package admin.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import admin.dao.face.AdminLoginDao;
import admin.dao.impl.AdminLoginDaoImpl;
import admin.service.face.AdminLoginService;
import common.JDBCTemplate;
import common.Paging;
import dto.AdminInfo;

public class AdminLoginServiceImpl implements AdminLoginService {
	
	AdminLoginDao adminDao = new AdminLoginDaoImpl();

	@Override
	public AdminInfo getAdminInfo(HttpServletRequest req) {
		
		System.out.println("AdminServiceImpl.getAdminInfo Start");
		
		AdminInfo adminInfo = new AdminInfo();
		
		adminInfo.setAdminId( req.getParameter("userid") );
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
		
		System.out.println("AdminServiceImpl.getPaging Start");
		
		System.out.println("AdminServiceImpl.getPaging End");
		
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

}
