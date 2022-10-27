package board.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.dao.face.BoardDao;
import common.JDBCTemplate;
import common.Paging;
import dto.BoardFile;
import dto.BoardInfo;

public class BoardDaoImpl implements BoardDao {

	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	
	@Override
	public List<BoardInfo> selectAll(Connection conn) {
		System.out.println("BoardDao selectAll() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT";
		sql += "	boardno, title, userid, hit, board_date";
		sql += " FROM boardinfo";
		sql += " ORDER BY boardno DESC";
		
		//결과 저장할 List
		List<BoardInfo> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				BoardInfo b = new BoardInfo(); //조회 결과 행 저장 DTO객체
				
				b.setUserId(rs.getString("userid"));
				b.setBoardNo(rs.getInt("boardno"));
				b.setBoardTitle(rs.getString("title"));
				b.setBoardHit(rs.getInt("hit"));
//				b.setWriteDate(rs.getDate("write_date"));
				
				//리스트에 결과값 저장하기
				boardList.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("BoardDao selectAll() - 끝");
		return boardList; //최종 결과 반환
	}
	
//	@Override
//	public List<Board> selectAll(Connection conn, Paging paging) {
//		System.out.println("BoardDao selectAll() - 시작");
//		
//		//SQL작성
//		String sql = "";
//		sql += "SELECT * FROM (";
//		sql += "	SELECT rownum rnum, B.* FROM (";
//		sql += "		SELECT";
//		sql += "			boardno, title, userid, hit, write_date";
//		sql += "		FROM board";
//		sql += "		ORDER BY boardno DESC";
//		sql += "	) B";
//		sql += " ) BOARD";
//		sql += " WHERE rnum BETWEEN ? AND ?";
//		
//		
//		//결과 저장할 List
//		List<Board> boardList = new ArrayList<>();
//		
//		try {
//			ps = conn.prepareStatement(sql); //SQL수행 객체
//			
//			ps.setInt(1, paging.getStartNo());
//			ps.setInt(2, paging.getEndNo());
//			
//			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
//			
//			//조회 결과 처리
//			while(rs.next()) {
//				Board b = new Board(); //조회 결과 행 저장 DTO객체
//				
//				b.setBoardno(rs.getInt("boardno"));
//				b.setTitle(rs.getString("title"));
//				b.setUserid(rs.getString("userid"));
//				b.setHit(rs.getInt("hit"));
//				b.setWriteDate(rs.getDate("write_date"));
//				
//				//리스트에 결과값 저장하기
//				boardList.add(b);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		System.out.println("BoardDao selectAll() - 끝");
//		return boardList; //최종 결과 반환
//	}

	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM boardinfo";
		
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

	@Override
	public int updateHit(Connection conn, BoardInfo boardno) {
		
		String sql = "";
		sql += "UPDATE board";
		sql += "	SET hit = hit + 1";
		sql += " WHERE boardno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardNo());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public BoardInfo selectBoardByBoardno(Connection conn, BoardInfo boardno) {
		
		String sql = "";
		sql += "SELECT";
		sql += "	boardno, boardtitle, userid";
		sql += "	, boardcontent, boardHit, boarddate";
		sql += " FROM boardinfo";
		sql += " WHERE boardno = ?";
		
		BoardInfo board = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				board = new BoardInfo();
				
				board.setUserId( rs.getString("userid") );
				board.setBoardNo( rs.getInt("boardno") );
				board.setBoardTitle( rs.getString("boardtitle") );
				board.setBoardContent( rs.getString("boardcontent") );
				board.setBoardHit( rs.getInt("boardhit") );
//				board.setWriteDate( rs.getDate("write_date") );
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return board;
	}

	@Override
	public String selectNickByBoard(Connection conn, BoardInfo viewBoard) {
		
		String sql = "";
		sql += "SELECT usernick FROM member";
		sql += " WHERE userid = ?";
		
		//결과 저장할 변수
		String usernick = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, viewBoard.getUserId());

			rs = ps.executeQuery();
			
			while( rs.next() ) {
				usernick = rs.getString("usernick");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return usernick;
	}

	@Override
	public int insert(Connection conn, BoardInfo board) {

		String sql = "";
		sql += "INSERT INTO boardinfo ( boardno, boardtitle, userid, boardcontent, boardhit )";
		sql += " VALUES ( ?, ?, ?, ?, 0 )";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, board.getBoardNo());
			ps.setString(2, board.getBoardTitle());
			ps.setString(3, board.getUserId());
			ps.setString(4, board.getBoardContent());
			ps.setInt(5, board.getBoardHit());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public int selectNextBoardno(Connection conn) {
		
		String sql = "";
		sql += "SELECT board_seq.nextval FROM dual";
		
		int nextBoardno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				nextBoardno = rs.getInt("nextval");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextBoardno;
	}
	
//	@Override
//	public int insertFile(Connection conn, BoardFile boardFile) {
//		
//		String sql = "";
//		sql += "INSERT INTO boardfile( fileno, boardno, originname, storedname, filesize )";
//		sql += " VALUES( boardfile_seq.nextval, ?, ?, ?, ? )";
//		
//		int res = 0;
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, boardFile.getBoardno());
//			ps.setString(2, boardFile.getOriginname());
//			ps.setString(3, boardFile.getStoredname());
//			ps.setInt(4, boardFile.getFilesize());
//			
//			res = ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(ps);
//		}
//		
//		return res;
//	}

//	@Override
//	public BoardFile selectFile(Connection conn, Board viewBoard) {
//		
//		String sql = "";
//		sql += "SELECT";
//		sql += "	fileno, boardno, originname, storedname, filesize, write_date";
//		sql += " FROM boardfile";
//		sql += " WHERE boardno = ?";
//		
//		//조회 결과 객체
//		BoardFile boardFile = null;
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, viewBoard.getBoardno());
//			
//			rs = ps.executeQuery();
//			
//			while( rs.next() ) {
//				boardFile = new BoardFile();
//				
//				boardFile.setFileno( rs.getInt("fileno") );
//				boardFile.setBoardno( rs.getInt("boardno") );
//				boardFile.setOriginname( rs.getString("originname") );
//				boardFile.setStoredname( rs.getString("storedname") );
//				boardFile.setFilesize( rs.getInt("filesize") );
//				boardFile.setWrite_date( rs.getDate("write_date") );
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		return boardFile;
//	}

	@Override
	public int update(Connection conn, BoardInfo board) {

		String sql = "";
		sql += "UPDATE board ";
		sql += " SET";
		sql += "	title = ?";
		sql += "	, content = ?";
		sql += " WHERE boardno = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, board.getBoardTitle());
			ps.setString(2, board.getBoardContent());
			ps.setInt(3, board.getBoardNo());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;

	}

	@Override
	public int deleteFile(Connection conn, BoardInfo board) {
		
		String sql = "";
		sql += "DELETE boardfile ";
		sql += " WHERE boardno = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardNo());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
		
	}

	@Override
	public int delete(Connection conn, BoardInfo board) {
		
		String sql = "";
		sql += "DELETE board";
		sql += " WHERE boardno = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardNo());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
		
	}

	@Override
	public int insert(Connection conn, BoardFile boardFile) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardInfo> selectAll(Connection connection, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardFile selectFile(Connection connection, BoardInfo viewBoard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertFile(Connection conn, BoardFile boardFile) {
		// TODO Auto-generated method stub
		return 0;
	}




	
	

}
