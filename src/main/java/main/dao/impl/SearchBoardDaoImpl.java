package main.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BoardInfo;
import main.dao.face.SearchBoardDao;

public class SearchBoardDaoImpl implements SearchBoardDao {

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<BoardInfo> selectAll(Connection conn) {
		
		//SQL
		String sql = "";
		sql += "SELECT";
		sql += "	boardno, boardtitle, usernick, userrank boardhit, date";
		sql += "	FROM boardinfo";
		sql += "	ORDER BY boardno DESC";
		
		List<BoardInfo> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
