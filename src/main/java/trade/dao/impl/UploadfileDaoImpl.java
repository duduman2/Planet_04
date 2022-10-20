package trade.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dto.BoardInfo;
import dto.Product;
import dto.Uploadfile;
import trade.dao.face.UploadfileDao;

public class UploadfileDaoImpl implements UploadfileDao {

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int insert(Connection conn, Uploadfile uploadfile) {
		String sql = "";
		sql += "INSERT INTO uploadfile (fileno,origin_name, stored_name, filepath)";
		sql += " VALUES (uploadfile_seq.nextval, ?, ?, ?)";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, uploadfile.getOriginName());
			ps.setString(2, uploadfile.getStoredName());
			ps.setString(3, uploadfile.getFilePath());
			
			res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	

	@Override
	public List<BoardInfo> selectBoardList(Connection connection) {

		return null;
	}

}
