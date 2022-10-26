package admin.dao.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.AdminInfo;
import dto.Notice;
import dto.NoticeFile;
import dto.UserInfo;

public interface AdminLoginDao {

	/**
	 * jsp로부터 얻어온 파라미터값 테이블과 비교하여 조회 결과 반환
	 * 
	 * @param conn - db객체
	 * @param adminInfo - dto객체
	 * @return select 결과값 반환
	 */
	public int select_tbl_admininfo(Connection conn, AdminInfo adminInfo);

	/**
	 * 총 관리자수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);

	/**
	 * 리스트 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<AdminInfo> - 테이블 페이징 목록 조회 결과
	 */
	public List<AdminInfo> selectAll(Connection conn, Paging paging);

	/**
	 * 
	 * @param conn - DB 연결 객체
	 * @param adminInfo - 생성할 관리자 정보
	 * @return 결과값 반환
	 */
	public int create_tbl_admininfo(Connection conn, AdminInfo adminInfo);

	/**
	 * 
	 * @param conn - DB 연결 객체
	 * @param adminInfo - 삭제할 관리자 정보
	 * @return 결과값 반환
	 */
	public int delete_tbl_admininfo(Connection conn, AdminInfo adminInfo);

	// selectCntAll에 userid 오버로딩
	public int selectCntAll(Connection conn, AdminInfo adminInfo);

	// selectAll에 userid 오버로딩
	public List<AdminInfo> selectAll(Connection connection, Paging paging, AdminInfo adminInfo);

	/**
	 * 사용자 계정 추가
	 * 
	 * @param conn DB객체
	 * @param userInfo 사용자정보
	 * @return 결과값
	 */
	public int create_tbl_user(Connection conn, UserInfo userInfo);

	/**
	 * 사용자 계정 삭제
	 * 
	 * @param conn DB객체
	 * @param userInfo 사용자정보
	 * @return 결과값
	 */
	public int delete_tbl_user(Connection conn, UserInfo userInfo);

	/**
	 * 사용자 정보 검색
	 * 
	 * @param connection DB객체
	 * @param userInfo 사용자 아이디
	 * @return 사용자 정보
	 */
	public UserInfo selectUser(Connection conn, UserInfo userInfo);

	/**
	 * 총 유저수 조회
	 * 
	 * @param conn DB객체
	 * @param userInfo 사용자id
	 * @return 테이블 전체 행수
	 */
	public int selectCntAll(Connection conn, UserInfo userInfo);

	/**
	 * 테이블 목록 조회
	 * 
	 * @param connection DB객체
	 * @param paging 페이징객체
	 * @param userInfo 사용자정보
	 * @return 결과값
	 */
	public List<UserInfo> selectAll(Connection connection, Paging paging, UserInfo userInfo);

	/**
	 * 사용자 정보 변경
	 * 
	 * @param conn DB객체
	 * @param userInfo 사용자정보
	 * @return 결과값
	 */
	public int update_tbl_user(Connection conn, UserInfo userInfo);
	
	/**
	 * 사용자 정보 검색
	 * 
	 * @param connection DB객체
	 * @param userInfo 사용자 고유번호
	 * @return 사용자 정보
	 */
	public UserInfo selectUser2(Connection connection, UserInfo userInfo);

	/**
	 * 관리자 아이디 검색
	 * 
	 * @param conn DB객체
	 * @param adminInfo 사용자 ID값
	 * @return 결과값
	 */
	public int select_tbl_admininfo2(Connection conn, AdminInfo adminInfo);

	/**
	 * 총 공지사항 갯수 조회
	 * 
	 * @param conn DB객체
	 * @param notice 제목
	 * @return
	 */
	public int selectCntAll1(Connection conn, Notice notice);
	
	/**
	 * 총 공지사항 갯수 조회
	 * 
	 * @param conn DB객체
	 * @param notice 작성자 아이디
	 * @return
	 */
	public int selectCntAll2(Connection conn, Notice notice);

	/**
	 * 공지사항 리스트 조회
	 * 
	 * @param connection DB객체
	 * @param paging 페이징 값
	 * @param notice admin_id 값
	 * @return 결과
	 */
	public List<Notice> selectAll1(Connection connection, Paging paging, Notice notice);

	/**
	 * 공지사항 리스트 조회
	 * 
	 * @param connection DB객체
	 * @param paging 페이징 값
	 * @param notice admin_id 값
	 * @return 결과
	 */
	public List<Notice> selectAll2(Connection connection, Paging paging, Notice notice);

	/**
	 * 클릭한 공지글 조회수 늘리기
	 * 
	 * @param conn DB객체
	 * @param notice 공지번호
	 * @return 조회수 반환
	 */
	public int updateHit(Connection conn, Notice notice);

	/**
	 * notice_no로 조건검색해서 공지사항 정보 가져오기
	 * 
	 * @param conn DB객체
	 * @param notice_no 공지번호
	 * @return 풀dto객체
	 */
	public Notice selectNoticeBynotice_no(Connection conn, Notice notice_no);

	/**
	 * 시퀀스를 이용하여 다음 게시글 번호 조회하기
	 * 
	 * @param conn DB 객체
	 * @return 다음 게시글 번호
	 */
	public int selectNextNoticeno(Connection conn);

	/**
	 * 게시글 입력
	 * 
	 * @param conn DB객체
	 * @param notice 게시글dto
	 * @param req 
	 * @return 수행 결과
	 */
	public int insert(Connection conn, Notice notice, HttpServletRequest req);

	/**
	 * 첨부파일 삽입
	 * 
	 * @param conn DB 객체
	 * @param noticeFile 첨부파일 정보
	 * @return 수행 결과
	 */
	public int insertFile(Connection conn, NoticeFile noticeFile);

	/**
	 * notice_no로 originname이나 storedname 찾기
	 * 
	 * @param connection DB 객체
	 * @param notice notice_no
	 * @return 원본명 또는 저장명 반환
	 */
	public String selectOriginname(Connection connection, Notice notice);
	public String selectStoredname(Connection connection, Notice notice);

	/**
	 * 공지 삭제
	 * 
	 * @param connection db 객체
	 * @param notice 공지 번호
	 */
	public void deleteNotice(Connection connection, Notice notice);

}
