package main.dao.impl;

import java.lang.reflect.Array;
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
import main.dao.face.SearchBoardDao;

public class SearchBoardDaoImpl implements SearchBoardDao {

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<BoardInfo> selectAll(Connection conn) {
		
		System.out.println("시작");
		//SQL
		String sql = "";
		sql += "SELECT";
		sql += "	boardno, boardtitle, boardcontent, usernick, grade, boardhit, boarddate";
		sql += "	FROM tbl_board";
		sql += "	ORDER BY boardhit DESC";
		
		List<BoardInfo> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardInfo b = new BoardInfo();
				
				b.setBoardNo(rs.getInt("boardno"));
				b.setBoardTitle(rs.getString("boardtitle"));
				b.setBoardContent(rs.getString("boardcontent"));
				b.setUserNick(rs.getString("usernick"));
				b.setUserRank(rs.getString("grade"));
				b.setBoardHit(rs.getInt("boardhit"));
				b.setBoardDate(rs.getDate("boarddate"));
				
				boardList.add(b);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		System.out.println("끝");
		
		return boardList;
	}
	
	@Override
	public List<BoardInfo> selectByAll(Connection conn, String keyword) {
		
		//SQL
		String sql = "";
		sql += "SELECT";
		sql += "	boardno, boardtitle, boardcontent, usernick, grade, boardhit, boarddate";
		sql += "	FROM tbl_board";	
		sql += "	WHERE boardtitle LIKE ?";
		sql += "	or boardcontent LIKE ?";
		sql += "	or usernick LIKE ?";
		sql += "	ORDER BY boardno DESC";
		
		//조회결과 저장
		List<BoardInfo> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			ps.setString(3, "%" + keyword + "%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardInfo b = new BoardInfo();
				
				b.setBoardNo(rs.getInt("boardno"));
				b.setBoardTitle(rs.getString("boardtitle"));
				b.setBoardContent(rs.getString("boardcontent"));
				b.setUserNick(rs.getString("usernick"));
				b.setUserRank(rs.getString("grade"));
				b.setBoardHit(rs.getInt("boardhit"));
				b.setBoardDate(rs.getDate("boarddate"));
				
				boardList.add(b);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return boardList;
		
	}

	@Override
	public List<BoardInfo> selectByContent(Connection conn, String keyword) {

		//SQL
		String sql = "";
		sql += "SELECT";
		sql += "	boardno, boardtitle, boardcontent, usernick, grade, boardhit, boarddate";
		sql += "	FROM tbl_board";	
		sql += "	WHERE boardcontent LIKE ?";
		sql += "	ORDER BY boardno DESC";
		
		//조회결과 저장
		List<BoardInfo> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardInfo b = new BoardInfo();
				
				b.setBoardNo(rs.getInt("boardno"));
				b.setBoardTitle(rs.getString("boardtitle"));
				b.setBoardContent(rs.getString("boardcontent"));
				b.setUserNick(rs.getString("usernick"));
				b.setUserRank(rs.getString("grade"));
				b.setBoardHit(rs.getInt("boardhit"));
				b.setBoardDate(rs.getDate("boarddate"));
				
				boardList.add(b);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return boardList;
	}
	
	@Override
	public List<BoardInfo> selectByTitle(Connection conn, String keyword) {
		
		//SQL
		String sql = "";
		sql += "SELECT";
		sql += "	boardno, boardtitle, boardcontent, usernick, grade, boardhit, boarddate";
		sql += "	FROM tbl_board";	
		sql += "	WHERE boardtitle LIKE ?";
		sql += "	ORDER BY boardno DESC";
		
		//조회결과 저장
		List<BoardInfo> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardInfo b = new BoardInfo();
				
				b.setBoardNo(rs.getInt("boardno"));
				b.setBoardTitle(rs.getString("boardtitle"));
				b.setBoardContent(rs.getString("boardcontent"));
				b.setUserNick(rs.getString("usernick"));
				b.setUserRank(rs.getString("grade"));
				b.setBoardHit(rs.getInt("boardhit"));
				b.setBoardDate(rs.getDate("boarddate"));
				
				boardList.add(b);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return boardList;
	}
	
	@Override
	public List<BoardInfo> selectByWriter(Connection conn, String keyword) {

		//SQL
		String sql = "";
		sql += "SELECT";
		sql += "	boardno, boardtitle, boardcontent, usernick, grade, boardhit, boarddate";
		sql += "	FROM tbl_board";	
		sql += "	WHERE usernick LIKE ?";
		sql += "	ORDER BY boardno DESC";
		
		//조회결과 저장
		List<BoardInfo> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardInfo b = new BoardInfo();
				
				b.setBoardNo(rs.getInt("boardno"));
				b.setBoardTitle(rs.getString("boardtitle"));
				b.setBoardContent(rs.getString("boardcontent"));
				b.setUserNick(rs.getString("usernick"));
				b.setUserRank(rs.getString("grade"));
				b.setBoardHit(rs.getInt("boardhit"));
				b.setBoardDate(rs.getDate("boarddate"));
				
				boardList.add(b);
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return boardList;
	}
	
	@Override
	public List<Product> selectProductAll(Connection conn) {
		//SQL
		String sql = "";
		sql += "SELECT";
		sql += "	p.productno, p.fileno, p.productname, p.productprice, p.productclass, u.stored_name, u.filepath";
		sql += "	FROM product p";	
		sql += " 	inner join uploadfile u";
		sql += "	on p.fileno = u.fileno";
		sql += "	ORDER BY p.productno DESC";
		
		List<Product> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				Product p = new Product();
				
				p = new Product();
				p.setProductNo(rs.getInt("productno"));
				p.setProductName(rs.getString("productname"));
				p.setProductPrice(rs.getInt("productprice"));
				p.setFileName(rs.getString("stored_name"));
				p.setFilePath(rs.getString("filepath"));
				
				list.add(p);
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
