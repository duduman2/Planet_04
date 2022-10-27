package trade.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import trade.dao.face.BuyDao;

public class BuyDaoImpl implements BuyDao {


	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int pointView(Connection conn,String loginId) {
		String sql = "";
		sql += "select userpoint from tbl_user";
		sql += " WHERE userid = ?";

		int point = 0;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, loginId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				point = rs.getInt("userpoint");
				System.out.println("[BuyDAO]내 포인트 : " + point);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return point;
	}


	
}
