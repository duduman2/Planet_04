package mypage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import dto.AskBoard;
import dto.BoardInfo;
import dto.StoryBoard;
import dto.UserInfo;
import mypage.dao.face.UserBoardDao;

public class UserBoardDaoImpl implements UserBoardDao {

	// DB 관련 객체
	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null;		 // 결과 집합 객체
	
//	@Override
//	public int deleteStoryBoard() {
//
//		return 0;
//	}
//	@Override
//	public List<AskBoard> selectAskByUserNo() {
//
//		return null;
//	}
	@Override
	public int selectStoryByUserNo(Connection conn, UserInfo param) {
		System.out.println("UserBoardDaoImpl - selectStoryByUserNo() - 시작");

		// sql 작성
		String sql = "";
		sql += "SELECT count(*) cnt FROM boardinfo";
		sql += " WHERE userno = ?";
		
//		BoardInfo result = new BoardInfo();
		
		//userno의 총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return count;
	}
//	@Override
//	public List<BoardInfo> selectStoryByUserNo() {
//		return null;
//	}
	
	
	
}
