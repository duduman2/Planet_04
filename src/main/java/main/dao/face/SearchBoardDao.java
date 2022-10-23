package main.dao.face;

import java.sql.Connection;
import java.util.List;

import dto.BoardInfo;

public interface SearchBoardDao {

	/**
	 * 게시글 테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return List<BoardInfo> - 테이블 전체 조회 목록
	 */
	public List<BoardInfo> selectAll(Connection conn);

	/**
	 * 
	 * @param conn
	 * @param keyword
	 * @return
	 */
	public List<BoardInfo> selectByWriter(Connection conn, String keyword);

}
