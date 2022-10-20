package login.dao.impl;

import java.sql.Connection;
import java.sql.Date;
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
		sql += "SELECT count(*) FROM userinfo";
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
		sql += "SELECT u_id, u_pw, u_nick FROM userinfo";
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
		sql += "INSERT INTO userinfo ( u_no, u_id, u_pw, u_name, u_nick, u_birth, u_gender, u_email, u_phone, u_address, u_join_date )";
		sql += " VALUES ( userinfo_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userinfo.getU_no());
			ps.setString(2, userinfo.getU_id());
			ps.setString(3, userinfo.getU_pw());
			ps.setString(4, userinfo.getU_name());
			ps.setString(5, userinfo.getU_nick());
			ps.setDate(6, (Date) userinfo.getU_birth());
			ps.setString(7, userinfo.getU_gender());
			ps.setString(8, userinfo.getU_email());
			ps.setInt(9, userinfo.getU_phone());
			ps.setString(10, userinfo.getU_address());
			ps.setDate(11, (Date) userinfo.getU_join_date());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	
	
}


