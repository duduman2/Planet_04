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
		sql += "INSERT INTO userinfo (";
		sql += "	u_no, u_id, u_pw, u_name, u_nick,";
		sql += "	u_birth, u_gender, u_email, u_phone, u_address,";
		sql += "	u_grade )";
		sql += " VALUES (";
		sql += "	userinfo_seq.nextval, ?, ?, ?, ?,";
		sql += "	sysdate, ?, ?, ?, ?,";
		sql += "	'새싹' )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userinfo.getU_id());
			ps.setString(2, userinfo.getU_pw());
			ps.setString(3, userinfo.getU_name());
			ps.setString(4, userinfo.getU_nick());
			ps.setString(5, userinfo.getU_gender());
			ps.setString(6, userinfo.getU_email());
			ps.setString(7, userinfo.getU_phone());
			ps.setString(8, userinfo.getU_address());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}



	@Override
	public int selectLoginInfo(String u_id, String u_pw) {
		 String SQL = "SELECT u_pw FROM userinfo WHERE u_id = ?";
		 
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
	public int idCheck(String u_id) {

		Connection conn = JDBCTemplate.getConnection();
		
		String SQL = "SELECT * FROM userinfo WHERE u_id = ?";
		int idCHeck = 0; 
		
		try {
	            ps = conn.prepareStatement(SQL);
	            ps.setString(1, u_id);
	            rs = ps.executeQuery();
	            if(rs.next() || u_id.equals("")){
	            	idCHeck = 0;
	            } else {
	            	idCHeck = 1;
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	JDBCTemplate.close(ps);
	        }
		
		return idCHeck;
	}



	@Override
	public int nickCheck(String u_nick) {
		Connection conn = JDBCTemplate.getConnection();
		
		String SQL = "SELECT * FROM userinfo WHERE u_nick = ?";
		int nickCHeck = 0; 
		
		try {
	            ps = conn.prepareStatement(SQL);
	            ps.setString(1, u_nick);
	            rs = ps.executeQuery();
	            if(rs.next() || u_nick.equals("")){
	            	nickCHeck = 0;
	            } else {
	            	nickCHeck = 1;
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	JDBCTemplate.close(ps);
	        }
		
		return nickCHeck;
	}



	@Override
	public int emailCheck(String u_email) {
		Connection conn = JDBCTemplate.getConnection();
		
		String SQL = "SELECT * FROM userinfo WHERE u_email = ?";
		int emailCHeck = 0; 
		
		try {
	            ps = conn.prepareStatement(SQL);
	            ps.setString(1, u_email);
	            rs = ps.executeQuery();
	            if(rs.next() || u_email.equals("")){
	            	emailCHeck = 0;
	            } else {
	            	emailCHeck = 1;
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	JDBCTemplate.close(ps);
	        }
		
		return emailCHeck;
	}



	@Override
	public int nameCheck(String u_name) {
		Connection conn = JDBCTemplate.getConnection();
		
		String SQL = "SELECT * FROM userinfo WHERE u_name = ?";
		int nameCHeck = 0; 
		
		try {
	            ps = conn.prepareStatement(SQL);
	            ps.setString(1, u_name);
	            rs = ps.executeQuery();
	            if(rs.next() || u_name.equals("")){
	            	nameCHeck = 0;
	            } else {
	            	nameCHeck = 1;
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	JDBCTemplate.close(ps);
	        }
		
		return nameCHeck;
	}



	@Override
	public UserInfo selectUserInfoByU_name(Connection conn, UserInfo userinfo) {
		String sql = "";
		sql += "SELECT u_id FROM userinfo";
		sql += " WHERE u_name = ?";
		
		UserInfo result = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userinfo.getU_name());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new UserInfo();
				
				result.setU_name(rs.getString("u_name"));
				result.setU_email( rs.getString("u_email") );
				result.setU_id( rs.getString("u_id") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return result;
		
	}



	//아이디 찾기
	@Override
	public UserInfo selectUserInfoByU_nameU_email(Connection conn, UserInfo userinfo) {
		String sql = "";
		sql += "SELECT u_id FROM userinfo";
		sql += " WHERE u_name = ?";
		sql += " AND u_email = ?";
		
		UserInfo result = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userinfo.getU_name());
			ps.setString(2, userinfo.getU_email());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new UserInfo();
				
				result.setU_id( rs.getString("u_id") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return result;
		
	}


	//비밀번호 찾기
	@Override
	public UserInfo selectUserInfoByU_nameU_id(Connection conn, UserInfo userinfo) {
		String sql = "";
		sql += "SELECT u_pw FROM userinfo";
		sql += " WHERE u_name = ?";
		sql += " AND u_id = ?";
		
		UserInfo result = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userinfo.getU_name());
			ps.setString(2, userinfo.getU_id());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new UserInfo();
				
				result.setU_pw( rs.getString("u_pw") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return result;
		
	}


	//로그인 
	@Override
	public UserInfo selectOneMember(Connection conn, String u_id, String u_pw) {
		UserInfo userinfo = null;
		
		String sql = "";
		sql += "SELECT * FROM userinfo WHERE u_id=? AND u_pw=?";
		
		  try {
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, u_id);
	            ps.setString(2, u_pw);
	            
	            rs = ps.executeQuery();
	            
	            if(rs.next()){
	               userinfo = new UserInfo();
	               
	               userinfo.setU_no(rs.getInt("u_no"));
	               userinfo.setU_id(rs.getString("u_id"));
	               userinfo.setU_pw(rs.getString("u_pw"));
	               userinfo.setU_name(rs.getString("u_name"));
	               userinfo.setU_nick(rs.getString("u_nick"));
	               userinfo.setU_email(rs.getString("u_email"));
	               userinfo.setU_gender(rs.getString("u_gender"));
	               userinfo.setU_phone(rs.getString("u_phone"));
	               userinfo.setU_address(rs.getString("u_address"));
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
	        }
		return userinfo;
		
	}




	
	
}


