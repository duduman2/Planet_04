package admin.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.AdminInfo;
import dto.UserInfo;

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

	// getPaging에 userid 오버로딩
	public Paging getPaging(HttpServletRequest req, AdminInfo adminInfo);

	// getList에 userid 오버로딩
	public List<AdminInfo> getList(Paging paging, AdminInfo adminInfo);

	/**
	 * jsp로부터 받아오는 정보 dto에 추가
	 * 
	 * @param req jsp로부터 받아온 정보
	 * @return 정보가 추가된 dto
	 */
	public UserInfo getUserInfo(HttpServletRequest req);

	/**
	 * 사용자 생성
	 * 
	 * @param userInfo 사용자 dto
	 * @return 성공/실패값 반환
	 */
	public Boolean UserCreate(UserInfo userInfo);

	/**
	 * 사용자 삭제
	 * 
	 * @param userInfo 사용자 dto
	 * @return 성공/실패값 반환
	 */
	public Boolean UserDelete(UserInfo userInfo);

	/**
	 * 사용자 검색
	 * 
	 * @param userInfo 사용자 아이디
	 * @return 사용자 정보 반환
	 */
	public UserInfo UserSearch(UserInfo userInfo);

	/**
	 * 페이징 계산
	 * 
	 * @param req 요청정보
	 * @param userInfo 사용자id
	 * @return 페이징 계산 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req, UserInfo userInfo);

	/**
	 * 사용자 리스트 조회
	 * 
	 * @param paging 페이징 계산된 객체
	 * @param userInfo 사용자 정보
	 * @return 사용자 리스트
	 */
	public List<UserInfo> getList(Paging paging, UserInfo userInfo);

	/**
	 * 사용자 정보 변경
	 * 
	 * @param userInfo 사용자 정보
	 * @return 결과
	 */
	public Boolean UserUpdate(UserInfo userInfo);

	/**
	 * 변경할 사용자값 dto에 저장
	 * 
	 * @param req 사용자 고유번호
	 * @return 사용자 정보 반환
	 */
	public UserInfo UserSearch2(HttpServletRequest req);
	
	/**
	 * 관리자 아이디 중복검사
	 * 
	 * @param adminInfo 관리자 아이디
	 * @return 결과값
	 */
	public Boolean AdminCheck(AdminInfo adminInfo);
	
}
