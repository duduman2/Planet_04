package trade.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dto.Uploadfile;
import trade.dao.face.UploadfileDao;

public class UploadfileDaoImpl implements UploadfileDao {

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int insert(Connection conn, Uploadfile uploadfile) {
		String sql = "";
		sql += "INSERT INTO uploadfile (fileno,origin_name, stored_name)";
		sql += " VALUES (uploadfile_seq.nextval, ?, ?)";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, uploadfile.getOriginName());
			ps.setString(2, uploadfile.getStoredName());
			
			res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public List<Uploadfile> selectAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT fileno, origin_name, stored_name";
		sql += " FROM uploadfile";
		sql += " ORDER BY fileno DESC";
		
		List<Uploadfile> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next() ) {
				Uploadfile uploadfile = new Uploadfile();
				
				uploadfile.setFileno(rs.getInt("fileno"));
				uploadfile.setOriginName(rs.getString("origin_name"));
				uploadfile.setStoredName(rs.getString("stored_name"));
				
				list.add(uploadfile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
				
		
		return list;
	}

}
