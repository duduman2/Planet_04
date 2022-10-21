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

	private LoginDao loginDao = new LoginDaoImpl();
	private PreparedStatement ps;
	private ResultSet rs;
	
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
		 String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		 
		 Connection conn = JDBCTemplate.getConnection();
		 
	        try {
	            ps = conn.prepareStatement(SQL);
	            ps.setString(1, u_id);
	            rs = ps.executeQuery();
	            if(rs.next()){
	                if(rs.getString(1).equals(u_pw))
	                    return 1;    // 로그인 성공
	                else
	                    return 0; // 비밀번호 불일치
	            }
	            return -1; // ID가 없음
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return -2; // DB 오류
		
		
		
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
	public void join(UserInfo userinfo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( loginDao.insert(conn, userinfo) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}



//	@Override
//	public int idCheck(String u_id) {
//		
//		int result = loginDao.selectAllU_id(u_id);
//		
//		return result;
//	}


}


	
	


	

	
	

