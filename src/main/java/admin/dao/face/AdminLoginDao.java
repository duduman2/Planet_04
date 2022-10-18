package admin.dao.face;

import java.sql.Connection;
import java.util.List;

import common.Paging;
import dto.AdminInfo;

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

}
