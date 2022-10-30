package trade.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import common.JDBCTemplate;
import dto.Payment;
import trade.dao.face.OrderDao;

public class OrderDaoImpl implements OrderDao {


	private PreparedStatement ps;
	private ResultSet rs;


	@Override
	public Payment viewinfo(Connection conn, String loginId) {
		String sql = "";
		sql += "select userid, phone from tbl_user";
		sql += " where userid=?";
		
		Payment payment = new Payment();
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, loginId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				payment.setBuyerId(rs.getString("userid"));
				payment.setBuyerTel(rs.getInt("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return payment;
	}


	@Override
	public int saveOrder(Connection conn, Payment payment) {

		int res= 0;
		
		String sql = "";
		sql += "INSERT INTO tbl_payment (pay_no, buyer_id, buyer_tel)";
		sql += " VALUES(?,?,?)"; 

		try {
			ps = conn.prepareStatement(sql);
			payment.setPayNo((int)new Date().getTime());
			
			ps.setInt(1,payment.getPayNo());
			ps.setString(2, payment.getBuyerId());
			ps.setInt(3, payment.getBuyerTel());
			
			res= ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return res;
	}


	@Override
	public int insertPoint(Connection conn, Payment payment) {
		int res= 0;
		
		String sql = "";
		sql += "update tbl_payment set pay_price = ?";
		sql += " where pay_no=?"; 
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1,payment.getPayPrice());
			ps.setInt(2, payment.getPayNo());
			
			res= ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return res;
	}


	@Override
	public int pointAdd(Connection conn, Payment payment) {
		String sql = "";
		sql += "UPDATE tbl_user";
		sql += " SET userpoint = userpoint + ?";
		sql += " WHERE userid = ?";

		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, payment.getPayPrice());
			ps.setString(2, payment.getBuyerId());
			
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
