package admin.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.AdminInfo;

public interface AdminLoginService {

	/**
	 * adminLogin.jsp로부터 받아온 데이터 dto에 추가
	 * 
	 * @param req - jsp로부터 받아온 요청정보(adminId, adminPw)
	 * @return 값이 설정된 객체
	 */
	public AdminInfo getAdminInfo(HttpServletRequest req);

	/**
	 * dto객체 정보로 tbl_admininfo 테이블과 정보 비교
	 * 
	 * @param adminInfo - 관리자 정보
	 * @return 로그인 성공/실패 반환
	 */
	public Boolean AdminLogin(AdminInfo adminInfo);

	/**
	 * 관리자리스트 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * 관리자리스트 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return 관리자리스트 전체 목록 조회
	 */
	public List<AdminInfo> getList(Paging paging);

	/**
	 * 
	 * @param adminInfo - 관리자 정보
	 * @return 생성여부 반환
	 */
	public Boolean AdminCreate(AdminInfo adminInfo);

	/**
	 * 
	 * @param adminInfo - 관리자 정보
	 * @return 삭제여부 반환
	 */
	public Boolean AdminDelete(AdminInfo adminInfo);
	
}
