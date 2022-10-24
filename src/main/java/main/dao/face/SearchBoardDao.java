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
	 * keyword가 포함된 게시글 테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param keyword - 입력한 검색어
	 * @return List<BoardInfo> - 테이블 전체 조회 목록
	 */
	public List<BoardInfo> selectByAll(Connection conn, String keyword);

	/**
	 * keyword가 포함된 게시글 테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param keyword - 입력한 검색어
	 * @return List<BoardInfo> - 테이블 전체 조회 목록
	 */
	public List<BoardInfo> selectByTitle(Connection conn, String keyword);

	/**
	 * keyword가 포함된 게시글 테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param keyword - 입력한 검색어
	 * @return List<BoardInfo> - 테이블 전체 조회 목록
	 */
	public List<BoardInfo> selectByContent(Connection conn, String keyword);
	
	/**
	 * keyword가 포함된 게시글 테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param keyword - 입력한 검색어
	 * @return List<BoardInfo> - 테이블 전체 조회 목록
	 */
	public List<BoardInfo> selectByWriter(Connection conn, String keyword);
	
}
