package login.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dto.UserInfo;
import login.dao.face.LoginDao;
import login.dao.impl.LoginDaoImpl;
import login.service.face.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao = new LoginDaoImpl();
	
	@Override
	public UserInfo getLoginUserInfo(HttpServletRequest req) {
		
		UserInfo userInfo = new UserInfo();
		
		userInfo.setU_id( req.getParameter("u_id") );
		userInfo.setU_pw( req.getParameter("u_pw") );
		
		return userInfo;
	}

	@Override
	public boolean login(UserInfo userinfo) {
		
		//로그인 인증 성공
		if( loginDao.selectCntUserInfoByU_idU_pw(JDBCTemplate.getConnection(), userinfo) > 0 ) {
			return true;
		}
		
		//로그인 인증 실패
		return false;
		
	}

	@Override
	public UserInfo info(UserInfo userinfo) {
		return loginDao.selectUserInfoByU_id(JDBCTemplate.getConnection(), userinfo);
	}

	
	
	
	@Override
	public UserInfo getJoinUserInfo(HttpServletRequest req) {
		
		UserInfo userinfo = new UserInfo();
		
		userinfo.setU_id( req.getParameter("u_id") );
		userinfo.setU_pw( req.getParameter("u_pw") );
		userinfo.setU_nick( req.getParameter("u_nick") );
		
		return userinfo;
	}

	@Override
	public void join(UserInfo userinfo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( loginDao.insert(conn, userinfo) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}


	
	}

	
	


	

	
	

