package login.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dto.UserInfo;
import login.dao.face.LoginDao;

public class LoginDaoImpl implements LoginDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int selectCntUserInfoByU_idU_pw(Connection conn, UserInfo userinfo) {

		String sql = "";
		sql += "SELECT count(*) FROM member";
		sql += " WHERE 1=1";
		sql += "	AND u_id = ?";
		sql += "	AND u_pw = ?";
		
		int cnt = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userinfo.getU_id());
			ps.setString(2, userinfo.getU_pw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return cnt;
	};
	
	
	
	@Override
	public UserInfo selectUserInfoByU_id(Connection conn, UserInfo userinfo) {

		String sql = "";
		sql += "SELECT u_id, u_pw, u_nick FROM member";
		sql += " WHERE u_id = ?";
		
		UserInfo result = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userinfo.getU_id());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new UserInfo();
				
				result.setU_id(rs.getString("u_id"));
				result.setU_pw( rs.getString("u_pw") );
				result.setU_nick( rs.getString("u_nick") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return result;
		
	}
	
	@Override
	public int insert(Connection conn, UserInfo userinfo) {
		
		String sql = "";
		sql += "INSERT INTO member ( u_id, u_pw, u_nick )";
		sql += " VALUES ( ?, ?, ? )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userinfo.getU_id());
			ps.setString(2, userinfo.getU_pw());
			ps.setString(3, userinfo.getU_nick());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	
	
}


