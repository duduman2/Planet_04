package login.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dto.UserInfo;
import login.dao.face.LoginDao;
import login.dao.impl.LoginDaoImpl;
import login.service.face.LoginService;

public class LoginServiceImpl implements LoginService {

	
	private PreparedStatement ps;
	private ResultSet rs;
	
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
	public int login(String u_id, String u_pw) {

		return loginDao.selectLoginInfo(u_id, u_pw);
		
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
		userinfo.setU_name( req.getParameter("u_name") );
		userinfo.setU_nick( req.getParameter("u_nick") );
		userinfo.setU_gender( req.getParameter("u_gender") );
		userinfo.setU_email( req.getParameter("u_email") );
		userinfo.setU_phone( req.getParameter("u_phone") );
		userinfo.setU_address( req.getParameter("u_address") );
		
		
		return userinfo;
	} 

	@Override
	public UserInfo getFindUserInfo(HttpServletRequest req) {
		
		UserInfo userinfo = new UserInfo();
		
		userinfo.setU_name( req.getParameter("u_name") );
		userinfo.setU_email( req.getParameter("u_email") );
		
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
	

	@Override
	public UserInfo findId(UserInfo userinfo) {
		Connection conn = JDBCTemplate.getConnection();
		
		return loginDao.selectUserInfoByU_nameU_email(conn, userinfo);
	}

	@Override
	public UserInfo findPw(UserInfo userinfo) {
		Connection conn = JDBCTemplate.getConnection();
		
		return loginDao.selectUserInfoByU_nameU_id(conn, userinfo);
	}

	@Override
	public UserInfo getFindPwUserInfo(HttpServletRequest req) {
		
		UserInfo userinfo = new UserInfo();
		
		userinfo.setU_name( req.getParameter("u_name") );
		userinfo.setU_email( req.getParameter("u_id") );
		
		return userinfo;
	}

	@Override
	public UserInfo selectOneMember(String u_id, String u_pw) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		UserInfo userinfo = loginDao.selectOneMember(conn, u_id, u_pw);
		JDBCTemplate.close(conn);

		return userinfo;
	}

	
	
	
}


	
	


	

	
	

