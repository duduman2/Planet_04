package trade.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import trade.dao.face.PaymentDao;

public class PaymentDaoImpl implements PaymentDao {

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int buyersub(Connection conn, String loginId, int point) {

		String sql = "";
		sql += "UPDATE tbl_user";
		sql += " SET userpoint = userpoint - ?";
		sql += " WHERE userid = ?";

		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, point);
			ps.setString(2, loginId);
			
			res = ps.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}

	@Override
	public int selleradd(Connection conn, String sellUserId, int point) {

		String sql = "";
		sql += "UPDATE tbl_user";
		sql += " SET userpoint = userpoint + ?";
		sql += " WHERE userid = ?";

		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, point);
			ps.setString(2, sellUserId);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}

}
