package board.dao.face;

import java.sql.Connection;
import java.util.List;

import common.Paging;
import dto.BoardFile;
import dto.BoardInfo;

public interface BoardDao {

	/**
	 * 게시글 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<BoardInfo> - 테이블 전체 조회 목록
	 */
	public List<BoardInfo> selectAll(Connection conn);
	
//	/**
//	 * 게시글 테이블 페이징 목록 조회
//	 * 
//	 * @param conn - DB 연결 객체
//	 * @param paging - 페이징 정보 객체
//	 * @return List<Board> - 테이블 페이징 목록 조회 결과
//	 */
//	public List<BoardInfo> selectAll(Connection conn, Paging paging);
	
	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 * 조회된 게시글의 조회수 증가시키기
	 * 
	 * @param conn - DB 연결 객체
	 * @param boardno - 조회할 게시글의 boardno를 가진 DTO객체
	 * @return int - UPDATE쿼리 수행 결과
	 */
	public int updateHit(Connection conn, BoardInfo boardno);

	/**
	 * 지정된 boardno의 게시글 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param boardno - 조회할 게시글의 boardno를 가진 DTO객체
	 * @return Board - 조회된 게시글의 상세정보 DTO객체
	 */
	public BoardInfo selectBoardByBoardno(Connection conn, BoardInfo boardno);
	
	/**
	 * 게시글 작성자 ID를 이용하여 usernick 을 조회한다
	 * 
	 * @param conn - DB연결 객체
	 * @param viewBoard - 조회할 id를 가진 객체
	 * @return String - 작성자 닉네임
	 */
	public String selectNickByBoard(Connection conn, BoardInfo viewBoard);

	/**
	 * 게시글 입력
	 * 
	 * @param conn - DB 연결 객체
	 * @param boardFile - 삽입될 게시글 내용
	 * @return int - INSERT 쿼리 수행 결과
	 */
	public int insert(Connection conn, BoardFile boardFile);

	/**
	 * 시퀀스를 이용하여 다음 게시글 번호 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @return int - 다음 게시글 번호
	 */
	public int selectNextBoardno(Connection conn);

	/**
	 * 첨부파일 삽입
	 * 
	 * @param conn - DB연결 객체
	 * @param boardFile - 첨부파일 정보
	 * @return int - INSERT 수행 결과
	 */
//	public int insertFile(Connection conn, BoardFile boardFile);
//
//	/**
//	 * 첨부파일 정보 조회
//	 * 
//	 * @param conn - DB연결 객체
//	 * @param viewBoard - 조회할 게시글 번호
//	 * @return BoardFile - 첨부파일 정보
//	 */
//	public BoardFile selectFile(Connection conn, BoardInfo viewBoard);
	
	/**
	 * 게시글 수정
	 * 
	 * @param conn - DB연결 객체
	 * @param board - 수정할 내용을 담은 객체
	 * @return UPDATE 수행 결과
	 */
	public int update(Connection conn, BoardInfo board);

	/**
	 * 게시글에 첨부된 파일 정보 삭제
	 * 
	 * @param conn - DB연결 객체
	 * @param board - 삭제할 게시글 번호
	 * @return UPDATE 수행 결과
	 */
	public int deleteFile(Connection conn, BoardInfo board);

	/**
	 * 게시글 삭제
	 * 
	 * @param conn - DB연결 객체
	 * @param board - 삭제할 게시글 번호
	 * @return UPDATE 수행 결과
	 */
	public int delete(Connection conn, BoardInfo board);

	int insert(Connection conn, BoardInfo board);

	public List<BoardInfo> selectAll(Connection connection, Paging paging);

	public BoardFile selectFile(Connection connection, BoardInfo viewBoard);

	public int insertFile(Connection conn, BoardFile boardFile);





	
}
