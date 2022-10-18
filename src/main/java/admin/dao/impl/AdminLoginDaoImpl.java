package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import admin.dao.face.AdminLoginDao;
import common.JDBCTemplate;
import dto.AdminInfo;

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
			
			ps.setString(1, adminInfo.getAdminid());
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
		
		String sql = "SELECT count(*) cnt FROM tbl_admininfo";
		
		//총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장

			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return count;
		
	}

}
