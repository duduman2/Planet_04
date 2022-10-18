package trade.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dto.Paramdata;
import trade.dao.face.ParamdataDao;

public class ParamdataDaoImpl implements ParamdataDao {
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int insert(Connection conn, Paramdata paramdata) {
		
		String sql = "";
		sql += "INSERT INTO paramdata (datano, title, data1, data2 )";
		sql += " VALUES( paramdata_seq.nextval, ?, ? ,?)";
		
		int res= 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, paramdata.getTitle());
			ps.setString(2, paramdata.getData1());
			ps.setString(3, paramdata.getData2());
			
			res= ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
}
