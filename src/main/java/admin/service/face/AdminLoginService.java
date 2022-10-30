package admin.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.AdminInfo;
import dto.AdminRecode;
import dto.BoardInfo;
import dto.Notice;
import dto.NoticeFile;
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
	 * 관리자 아이디 중복검사ddd
	 * 
	 * @param adminInfo 관리자 아이디
	 * @return 결과값
	 */
	public Boolean AdminCheck(AdminInfo adminInfo);

	/**
	 * adminMainNotice.jsp로부터 받아온 값 dto에 추가
	 * 
	 * @param req 요청정보(title이거나 admin_id거나)
	 * @return 값이 추가된 dto
	 */
	public Notice getNoticeInfo(HttpServletRequest req);

	/**
	 * 공지사항 페이징 객체 생성
	 * 
	 * @param req 요청정보
	 * @param notice Notice dto
	 * @return 계산된 페이징 객체
	 */
	public Paging getPaging1(HttpServletRequest req, Notice notice);

	/**
	 * 공지사항 페이징 객체 생성
	 * 
	 * @param req 요청정보
	 * @param notice Notice dto
	 * @return 계산된 페이징 객체
	 */
	public Paging getPaging2(HttpServletRequest req, Notice notice);
	
	/**
	 * 공지사항 리스트 조회
	 * 
	 * @param paging 계산된 페이징 객체
	 * @param notice Notice dto(title)
	 * @return
	 */
	public List<Notice> getList1(Paging paging, Notice notice);
	
	/**
	 * 공지사항 리스트 조회
	 * 
	 * @param paging 계산된 페이징 객체
	 * @param notice Notice dto(admin_id)
	 * @return
	 */
	public List<Notice> getList2(Paging paging, Notice notice);

	/**
	 * notice_no 받아다가 dto에 저장
	 * 
	 * @param req 요청정보
	 * @return 반환되는 dto
	 */
	public Notice getNoticeno(HttpServletRequest req);

	/**
	 * dto의 정보 받아다가 전체정보 반환
	 * 
	 * @param notice notice_no
	 * @return notice 풀정보
	 */
	public Notice noticeView(Notice notice);

	/**
	 * 작성한 게시글을 DB에 저장
	 * 
	 * @param req 요청 정보 객체
	 */
	public void write(HttpServletRequest req);

	/**
	 * 공지번호로 파일 원본명, 저장명 가져오기
	 * 
	 * @param notice 공지번호
	 * @return 파일 원본명 저장명
	 */
	public String getOriginname(Notice notice);
	public String getStoredname(Notice notice);

	/**
	 * 공지 삭제
	 * 
	 * @param notice 공지 번호
	 */
	public void deleteNotice(Notice notice);

	/**
	 * 공지 첨부파일 삭제
	 * 
	 * @param notice 공지 번호
	 * @param req 요청정보
	 */
	public void deleteNoticeFile(Notice notice, HttpServletRequest req);

	/**
	 * 공지사항 상세조회
	 * 
	 * @param noticeno 공지번호
	 * @return 공지값 저장된 dto객체
	 */
	public Notice view(Notice noticeno);

	/**
	 * 첨부파일 정보 반환
	 * 
	 * @param updateNotice Notice의 공지번호로 찾겠지?
	 * @return 첨부파일 정보 담긴 NoticeFile dto
	 */
	public NoticeFile viewFile(Notice updateNotice);

	/**
	 * 공지 수정
	 * 
	 * @param req 요청 정보 객체
	 * @return 
	 */
	public int update(HttpServletRequest req);

	public BoardInfo getBoardInfo(HttpServletRequest req);

	public Paging getPaging(HttpServletRequest req, BoardInfo boardInfo);

	public List<BoardInfo> getList(Paging paging, BoardInfo boardInfo);

	public void deleteBoard(BoardInfo boardInfo);

	public void sendAdminLogin(String adminId);

	public void sendAdminLogout(String adminId);

	public AdminRecode getAdminInfo2(HttpServletRequest req);

	public Paging getPaging(HttpServletRequest req, AdminRecode adminRecode);

	public List<AdminRecode> getList(Paging paging, AdminRecode adminRecode);

	public void sendAdminCreate(String adminId, AdminInfo adminInfo);

	public void sendAdminDelete(String adminId, AdminInfo adminInfo);

	public void sendBoardDelete(String adminId, BoardInfo boardInfo);

	public BoardInfo selectBoard(HttpServletRequest req);

	public void sendUserCreate(String adminId, UserInfo userInfo);

	public void sendUserDelete(String adminId, UserInfo userInfo);

	public void sendUserUpdate(String adminId, UserInfo userInfo);

	public void sendNoticeUpdate(String adminId, int test);

	public void sendNoticeDelete(String adminId, Notice notice);

}
