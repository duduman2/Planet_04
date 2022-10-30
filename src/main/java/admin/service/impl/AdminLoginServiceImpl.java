package admin.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import admin.dao.face.AdminLoginDao;
import admin.dao.impl.AdminLoginDaoImpl;
import admin.service.face.AdminLoginService;
import common.JDBCTemplate;
import common.Paging;
import dto.AdminInfo;
import dto.AdminRecode;
import dto.BoardInfo;
import dto.Notice;
import dto.NoticeFile;
import dto.UserInfo;

public class AdminLoginServiceImpl implements AdminLoginService {
	AdminLoginDao adminDao = new AdminLoginDaoImpl();

	@Override
	public AdminInfo getAdminInfo(HttpServletRequest req) {
		
		System.out.println("AdminServiceImpl.getAdminInfo Start");
		
		AdminInfo adminInfo = new AdminInfo();
		
		if( req.getParameter("userid") != null) {
			adminInfo.setAdminId( req.getParameter("userid") );
		} else {
			adminInfo.setAdminId("");
		}
		
		adminInfo.setAdminPw( req.getParameter("userpw") );
		
		System.out.println("AdminServiceImpl.getAdminInfo End");
		
		return adminInfo;
	}

	@Override
	public Boolean AdminLogin(AdminInfo adminInfo) {
		
		System.out.println("AdminServiceImpl.AdminLogin Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.select_tbl_admininfo(conn, adminInfo) > 0 ) {
			// JDBCTemplate.close(conn); 왜 이거 있으면 에러떨어지지?
			return true;
		}
		
		// JDBCTemplate.close(conn); 그럼 conn은 종료 안해도 문제가 없나?
		
		System.out.println("AdminServiceImpl.AdminLogin End");
		
		return false;
		
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		System.out.println("AdminServiceImpl.getPaging Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		//총 관리자리스트 수 조회하기
		int totalCount = adminDao.selectCntAll(conn);
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage"); // url의 curPage파라미터값 조회
		
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		System.out.println("AdminServiceImpl.getPaging End");
				
		return paging;
				
	}

	@Override
	public List<AdminInfo> getList(Paging paging) {
		
		System.out.println("AdminServiceImpl.getList Start");
		
		System.out.println("AdminServiceImpl.getList End");
		
		return adminDao.selectAll(JDBCTemplate.getConnection(), paging);
		
	}

	@Override
	public Boolean AdminCreate(AdminInfo adminInfo) {
		System.out.println("AdminServiceImpl.AdminCreate Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.create_tbl_admininfo(conn, adminInfo) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
		}
		
		JDBCTemplate.rollback(conn);
		
		System.out.println("AdminServiceImpl.AdminCreate End");
		
		return false;
	}

	@Override
	public Boolean AdminDelete(AdminInfo adminInfo) {
		System.out.println("AdminServiceImpl.AdminDelete Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.delete_tbl_admininfo(conn, adminInfo) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
		}
		
		JDBCTemplate.rollback(conn);
		
		System.out.println("AdminServiceImpl.AdminDelete End");
		
		return false;
	}

	@Override
	public Paging getPaging(HttpServletRequest req, AdminInfo adminInfo) {
		
		System.out.println("AdminServiceImpl.getPaging Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		//총 관리자리스트 수 조회하기
		int totalCount = adminDao.selectCntAll(conn, adminInfo);
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage"); // url의 curPage파라미터값 조회
		
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		System.out.println("AdminServiceImpl.getPaging End");
				
		return paging;

	}

	@Override
	public List<AdminInfo> getList(Paging paging, AdminInfo adminInfo) {
		
		System.out.println("AdminServiceImpl.getList Start");
		
		System.out.println("AdminServiceImpl.getList End");
		
		return adminDao.selectAll(JDBCTemplate.getConnection(), paging, adminInfo);
		
	}

	@Override
	public UserInfo getUserInfo(HttpServletRequest req) {
		
		System.out.println("AdminServiceImpl.getUserInfo Start");
		
		UserInfo userInfo = new UserInfo();
		
		if( req.getParameter("userid") != null) {
			userInfo.setU_id( req.getParameter("userid") );
		} else {
			userInfo.setU_id("");
		}
		
		userInfo.setU_pw(req.getParameter("userpw"));
		userInfo.setU_name(req.getParameter("name"));
		userInfo.setU_phone(req.getParameter("phone"));
		userInfo.setU_email(req.getParameter("email"));
		userInfo.setU_address(req.getParameter("add1"));
		userInfo.setU_nick(req.getParameter("usernick"));
		userInfo.setB_business_number(req.getParameter("userbsno"));
		userInfo.setGrade(req.getParameter("grade"));
		
		// string으로 가져온 birth를 date로 바꿔서 dto에 저장하는 구문
		String from = req.getParameter("birth");
		if( from != null) {
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			try {
				userInfo.setU_birth(fm.parse(from));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		userInfo.setU_gender(req.getParameter("gender"));
		userInfo.setU_trade_user(req.getParameter("tradeuser"));
		
		System.out.println("AdminServiceImpl.getUserInfo End");
		
		return userInfo;
		
	}

	@Override
	public Boolean UserCreate(UserInfo userInfo) {
		
		System.out.println("AdminServiceImpl.UserCreate Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.create_tbl_user(conn, userInfo) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
		}
		
		JDBCTemplate.rollback(conn);
		
		System.out.println("AdminServiceImpl.UserCreate End");
		
		return false;
		
	}

	@Override
	public Boolean UserDelete(UserInfo userInfo) {
		
		System.out.println("AdminServiceImpl.UserDelete Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.delete_tbl_user(conn, userInfo) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
		}
		
		JDBCTemplate.rollback(conn);
		
		System.out.println("AdminServiceImpl.UserDelete End");
		
		return false;
		
	}

	@Override
	public UserInfo UserSearch(UserInfo userInfo) {
		
		System.out.println("AdminServiceImpl.UserSearch Start");
		
		System.out.println("AdminServiceImpl.UserSearch End");
		
		return adminDao.selectUser(JDBCTemplate.getConnection(), userInfo);
		
	}

	@Override
	public Paging getPaging(HttpServletRequest req, UserInfo userInfo) {
		
		System.out.println("AdminServiceImpl.getPaging3 Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		//총 관리자리스트 수 조회하기
		int totalCount = adminDao.selectCntAll(conn, userInfo);
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage"); // url의 curPage파라미터값 조회
		
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		System.out.println("AdminServiceImpl.getPaging3 End");
				
		return paging;
		
	}

	@Override
	public List<UserInfo> getList(Paging paging, UserInfo userInfo) {
		
		System.out.println("AdminServiceImpl.getList3 Start");
		
		System.out.println("AdminServiceImpl.getList3 End");
		
		return adminDao.selectAll(JDBCTemplate.getConnection(), paging, userInfo);
		
	}

	@Override
	public Boolean UserUpdate(UserInfo userInfo) {
		
		System.out.println("AdminServiceImpl.UserUpdate Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.update_tbl_user(conn, userInfo) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
		}
		
		JDBCTemplate.rollback(conn);
		
		System.out.println("AdminServiceImpl.UserUpdate End");
		
		return false;
		
	}

	@Override
	public UserInfo UserSearch2(HttpServletRequest req) {
		
		System.out.println("AdminServiceImpl.UserSearch2 Start");
		
		UserInfo userInfo = new UserInfo();
		
		userInfo.setU_no(Integer.parseInt(req.getParameter("userno")));
		userInfo.setU_id(req.getParameter("userid"));
		userInfo.setU_pw(req.getParameter("userpw"));
		userInfo.setU_name(req.getParameter("name"));
		userInfo.setU_phone(req.getParameter("phone"));
		userInfo.setU_email(req.getParameter("email"));
		userInfo.setU_address(req.getParameter("add1"));
		userInfo.setU_nick(req.getParameter("usernick"));
		userInfo.setB_business_number(req.getParameter("userbsno"));
		userInfo.setGrade(req.getParameter("grade"));
		userInfo.setReportcode(req.getParameter("reportcode"));
		
		// string으로 가져온 birth를 date로 바꿔서 dto에 저장하는 구문
		String from = req.getParameter("birth");
		if( from != null) {
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			try {
				userInfo.setU_birth(fm.parse(from));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		userInfo.setU_gender(req.getParameter("gender"));
		userInfo.setU_trade_user(req.getParameter("tradeuser"));
		
		System.out.println("AdminServiceImpl.UserSearch2 End");
		
		return userInfo;
		
	}

	@Override
	public Boolean AdminCheck(AdminInfo adminInfo) {
		System.out.println("AdminServiceImpl.AdminCheck Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.select_tbl_admininfo2(conn, adminInfo) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
		}
		
		JDBCTemplate.rollback(conn);
		
		System.out.println("AdminServiceImpl.AdminCheck End");
		
		return false;
	}

	@Override
	public Notice getNoticeInfo(HttpServletRequest req) {
		
		System.out.println("AdminServiceImpl.getNoticeInfo Start");
		
		Notice notice = new Notice();
		
		if( req.getParameter("title") != null) {
			notice.setTitle( req.getParameter("title") );
		} else {
			notice.setTitle("");
		}
		
		if( req.getParameter("admin_id") != null) {
			notice.setAdmin_id( req.getParameter("admin_id") );
		} else {
			notice.setAdmin_id("");
		}
		
		System.out.println("AdminServiceImpl.getNoticeInfo End");
		
		return notice;
		
	}

	@Override
	public Paging getPaging1(HttpServletRequest req, Notice notice) {
		
		System.out.println("AdminServiceImpl.getPaging1 Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		//총 관리자리스트 수 조회하기
		int totalCount = adminDao.selectCntAll1(conn, notice);
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage"); // url의 curPage파라미터값 조회
		
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		System.out.println("AdminServiceImpl.getPaging1 End");
				
		return paging;
		
	}

	@Override
	public Paging getPaging2(HttpServletRequest req, Notice notice) {
		
		System.out.println("AdminServiceImpl.getPaging2 Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		//총 관리자리스트 수 조회하기
		int totalCount = adminDao.selectCntAll2(conn, notice);
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage"); // url의 curPage파라미터값 조회
		
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		System.out.println("AdminServiceImpl.getPaging2 End");
				
		return paging;
		
	}

	@Override
	public List<Notice> getList1(Paging paging, Notice notice) {
		System.out.println("AdminServiceImpl.getList1 Start");
		
		System.out.println("AdminServiceImpl.getList1 End");
		
		return adminDao.selectAll1(JDBCTemplate.getConnection(), paging, notice);
	}

	@Override
	public List<Notice> getList2(Paging paging, Notice notice) {
		System.out.println("AdminServiceImpl.getList2 Start");
		
		System.out.println("AdminServiceImpl.getList2 End");
		
		return adminDao.selectAll2(JDBCTemplate.getConnection(), paging, notice);
	}

	@Override
	public Notice getNoticeno(HttpServletRequest req) {
		System.out.println("AdminServiceImpl.getNoticeno Start");
		
		//전달파라미터를 저장할 객체 생성
		Notice notice = new Notice();
		
		//전달파라미터 notice_no 추출(파싱)
		String param = req.getParameter("notice_no");
		if( null != param && !"".equals(param) ) { //전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리 
			notice.setNotice_no( Integer.parseInt(param) );
		}
		
		notice.setTitle(req.getParameter("notice_title"));
		notice.setNotice_content(req.getParameter("notice_content"));
		
		System.out.println("AdminServiceImpl.getNoticeno End");
		return notice;
	}

	@Override
	public Notice noticeView(Notice notice_no) {
		System.out.println("AdminServiceImpl.noticeView Start");
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		if( adminDao.updateHit(conn, notice_no) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//게시글 조회
		Notice notice = adminDao.selectNoticeBynotice_no(conn, notice_no);
		
		//조회된 게시글 리턴
		System.out.println("AdminServiceImpl.noticeView End");
		return notice;
	}

	@Override
	public void write(HttpServletRequest req) {
		System.out.println("AdminServiceImpl.write Start");
		
		// 지금 응답데이터가 multipart형식인지 알아보는 메소드. true / false로 반환함
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		// multipart가 아니면 fileupload 메소드 중단
		if( !isMultipart ) {
			System.out.println("[ERROR] 파일 업로드 형식 데이터가 아님");
			return; // fileupload 메소드를 여기서 중단시켜버리고 반환해버림. 밑의 코드는 진행되지 않는다.
		}
		
		// DiskFileItemFactory : 디스크 기반으로 FileItem을 처리하는 팩토리 클래스. 파일 용량이 적으면 메모리에, 크면 하드에서 처리
		// FileItemFactory : FileItem객체를 처리하는 방식에 대한 설정값을 저장해둔 클래스
		// FileItem : 클라이언트에서 전송한 전달 파라미터를 객체로 만든 것(폼필드, 파일 모두 객체화)
		// 폼필드 : 파일이 아닌 전달 파라미터
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//메모리 처리 사이즈 설정
		int maxMem = 1 * 1024 * 1024;	// 1024B * 1024B = 즉 1MB를 의미
		factory.setSizeThreshold(maxMem); // 1MB보다 작으면 메모리에서 처리

		//서블릿 컨텍스트 객체
		// 요청받은 데이터(req)를 처리하고 있는 서블릿의 정보를 확인할 수 있다. ServletContext 클래스타입의 변수에만 담을 수 있음.
		ServletContext context = req.getServletContext();
		
		//임시 파일 저장 폴더
		String path = context.getRealPath("tmp"); // 서블릿 정보를 통해 실제 서버의 "tmp"폴더 경로를 알아낸다
		File tmpRepository = new File(path); // tmpPath를 가지고 임시 파일을 저장할 File객체 생성
		tmpRepository.mkdir(); // 폴더 생성하기. tmp 폴더가 있으면 생성하지 않는다.
		factory.setRepository(tmpRepository); // temRepository 객체를 토대로 임시 파일을 저장할 폴더를 factory 객체에 설정.

		// 파일 업로드를 수행하는 upload 객체 생성 // 파라미터로 factory 객체 필요
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//파일 업로드 용량 제한
		int maxFile = 10 * 1024 * 1024; // 10MB // 최대 업로드 허용 사이즈
		upload.setFileSizeMax(maxFile); // 파일 업로드 용량 제한

		//파일 업로드된 데이터 파싱
		List<FileItem> items = null;  // FileItem 클래스 형식으로 제네릭설정하여 List객체로 items 변수 생성
		try {
			// 요청객체에 담겨있는 전달 파라미터를 파싱
			// 폼 필드를 추출하면서 파일도 서버로 업로드를 수행함
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		// 추출된 전달 파라미터 데이터를 처리해야 함. List<FileItem> 객체에 파일과 폼필드 데이터가 파싱되어 들어있음.
		// 용량이 0인 빈 파일은 무시하고 파일은 디스크에 저장.
		// 폼필드 정보와 파일 정보는 DTO객체에 저장해서 DB에도 삽입 필요.

		//공지사항 정보 DTO객체
		Notice notice = new Notice();
		
		//공지사항 첨부파일 정보 DTO객체
		NoticeFile noticeFile = new NoticeFile();
	
		//파일아이템의 반복자
		Iterator<FileItem> iter = items.iterator(); // <FileItem>은 제네릭 형식이고 items는 List객체의 변수지?

		while( iter.hasNext() ) { // FileItem에 처리할 놈이 있으면 true, 없으면 false임.
			
			FileItem item = iter.next(); // 전달 파라미터 FileItem을 하나씩 꺼내서 적용하기
			
			//--- 1) 빈 파일에 대한 처리 ---
			if( item.getSize() <= 0 ) { //전달 데이터의 크기 // 빈 파일이면 바로 다음 파일로 while문 진행
				//빈 파일은 무시하고 다음 FileItem처리로 넘어간다
				continue;
			}
			
			//--- 2) 폼 필드에 대한 처리 ---
			if( item.isFormField() ) { // FileItem 객체의 값이 폼필드 형식이면
				
				// 폼필드는 key=value쌍으로 전달됨
				// key는 item.getFieldName()으로, value는 item.getString("UTF-8")으로 얻어올 수 있음
				
				//키(key) 추출하기
				String key = item.getFieldName();
				
				//값(value) 추출하기
				String value = null;
				try {
					value = item.getString("UTF-8"); //한글 인코딩 지정
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				//key에 맞게 value를 DTO에 삽입하기
				if( "title".equals(key) ) {
					notice.setTitle(value);
				}
				if( "notice_content".equals(key) ) {
					notice.setNotice_content(value);
				}
			} // if( item.isFormField() ) end
			
			
			
			//--- 3) 파일에 대한 처리 ---
			if( !item.isFormField() ) { // FileItem 객체의 값이 폼필드 형식이 아니면 = 즉 파일이면
				
				// 서버는 파일의 이름을 원본과 다르게 바꿔서 저장해야 함(중복 방지)
				// 그러므로 원본 이름과 변경되는 이름 둘다 DB에 기록 필요
				
				// 날짜를 문자열로 변환해주는 SimpleDateFormat 객체 생성
				
				//저장 파일명 처리
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
				String rename = sdf.format(new Date()); //현재시간
				
				//파일 업로드 폴더
				File uploadFolder = new File( context.getRealPath("upload") );
				uploadFolder.mkdir();
				
				// new File(context.getRealPath("upload")).mkdir(); 이거랑 같은 이야기지.
				
				// 파일경로는 알고. mkdir();이 폴더 생성하는 메소드지? 근데 이 메소드 File클래스 꺼지?
				// 그래서 File객체 new로 새롭게 생성해주면서 메소드 쓰는거지. 이게 자바의 특성임. 
				// 특정 클래d스의 메소드 쓰려면 그 클래스 객체로 인스턴스 생성하는거.
				
				//업로드할 파일 객체 생성하기
				File up = new File(uploadFolder, rename);
				try {
					item.write(up);	//임시파일을 실제 업로드 파일로 출력한다
					item.delete(); //임시파일 제거
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//업로드된 파일의 정보를 DTO객체에 저장하기
				noticeFile.setOriginname(item.getName());
				noticeFile.setStoredname(rename);
				noticeFile.setFilesize((int)item.getSize());
				
			} // if( !item.isFormField() ) end
			
		} // while( iter.hasNext() ) end

		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 번호 생성
		int noticeno = adminDao.selectNextNoticeno(conn);
		
		
		//게시글 번호 삽입
		notice.setNotice_no(noticeno);

		//작성자 ID 처리
		notice.setAdmin_id( (String) req.getSession().getAttribute("userid") );
		
		if( adminDao.insert(conn, notice, req) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		
		//첨부파일 정보 삽입
		if( noticeFile.getFilesize() != 0 ) { //첨부 파일이 존재할 때에만 동작
			
			//게시글 번호 삽입 (FK)
			noticeFile.setnoticeno(noticeno);
			
			if( adminDao.insertFile(conn, noticeFile) > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
		}
		
		//----------------------------------------------
		
		System.out.println("AdminServiceImpl.write End");
	}

	@Override
	public String getOriginname(Notice notice) {
		System.out.println("AdminServiceImpl.getOriginname Start");
		
		System.out.println("AdminServiceImpl.getOriginname End");
		return adminDao.selectOriginname(JDBCTemplate.getConnection(), notice);
	}
	
	@Override
	public String getStoredname(Notice notice) {
		System.out.println("AdminServiceImpl.getStoredname Start");
		
		System.out.println("AdminServiceImpl.getStoredname End");
		return adminDao.selectStoredname(JDBCTemplate.getConnection(), notice);
	}

	@Override
	public void deleteNotice(Notice notice) {
		System.out.println("AdminServiceImpl.deleteNotice Start");
		
		Connection conn = JDBCTemplate.getConnection();
		adminDao.deleteNotice(conn, notice);
		JDBCTemplate.commit(conn);
		
		System.out.println("AdminServiceImpl.deleteNotice End");
	}

	@Override
	public void deleteNoticeFile(Notice notice, HttpServletRequest req) {
		System.out.println("AdminServiceImpl.deleteNoticeFile Start");
		
		Connection conn = JDBCTemplate.getConnection();
		String storedname = adminDao.selectStoredname(conn, notice);
		String result = "\\";
		
		ServletContext context = req.getServletContext();
		File file = new File( context.getRealPath("upload") + result + storedname );
			
		if( file.exists() ) {
			file.delete();
		}
		
		adminDao.deleteNoticeFile(conn, notice);
		JDBCTemplate.commit(conn);
		
		System.out.println("AdminServiceImpl.deleteNoticeFile End");
	}

	@Override
	public Notice view(Notice noticeno) {
		
		System.out.println("AdminServiceImpl.view Start");
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//조회수 증가
		if( adminDao.updateHit(conn, noticeno) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//게시글 조회
		Notice notice = adminDao.selectNoticeByNoticeno(conn, noticeno);
		
		//조회된 게시글 리턴
		System.out.println("AdminServiceImpl.view End");
		return notice;
		
	}

	@Override
	public NoticeFile viewFile(Notice updateNotice) {
		System.out.println("AdminServiceImpl.viewFile Start");
		
		System.out.println("AdminServiceImpl.viewFile End");
		
		return adminDao.selectFile(JDBCTemplate.getConnection(), updateNotice);
	}

	@Override
	public int update(HttpServletRequest req) {
		System.out.println("AdminServiceImpl.update Start");
		
				//multipart/form-data 인코딩 확인
				boolean isMultipart = ServletFileUpload.isMultipartContent(req);
				
				//multipar형식이 아닐 경우 처리 중단
				if( !isMultipart ) {
					System.out.println("[ERROR] 파일 업로드 형식 데이터가 아님");
					return 0;
				}
				
				DiskFileItemFactory factory = new DiskFileItemFactory();
				
				//메모리 처리 사이즈 설정
				int maxMem = 1 * 1024 * 1024;	// 1 MB == 1048576 B
				factory.setSizeThreshold(maxMem);

				//서블릿 컨텍스트 객체
				ServletContext context = req.getServletContext();
				
				//임시 파일 저장 폴더
				String path = context.getRealPath("tmp");
				File tmpRepository = new File(path);
				tmpRepository.mkdir();
				factory.setRepository(tmpRepository);

				//파일 업로드 수행 객체
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				//파일 업로드 용량 제한
				int maxFile = 10 * 1024 * 1024; // 10MB
				upload.setFileSizeMax(maxFile);

				//파일 업로드된 데이터 파싱
				List<FileItem> items = null;
				try {
					items = upload.parseRequest(req);
				} catch (FileUploadException e) {
					e.printStackTrace();
				}

				//게시글 정보 DTO객체
				Notice notice = new Notice();
				
				//게시글 첨부파일 정보 DTO객체
				NoticeFile noticeFile = new NoticeFile();
			
				//파일아이템의 반복자
				Iterator<FileItem> iter = items.iterator();

				while( iter.hasNext() ) {
					FileItem item = iter.next();
					
					//--- 1) 빈 파일에 대한 처리 ---
					if( item.getSize() <= 0 ) { //전달 데이터의 크기
						//빈 파일은 무시하고 다음 FileItem처리로 넘어간다
						continue;
					}
					
					//--- 2) 폼 필드에 대한 처리 ---
					if( item.isFormField() ) {
						
						//키(key) 추출하기
						String key = item.getFieldName();
						
						//값(value) 추출하기
						String value = null;
						try {
							value = item.getString("UTF-8"); //한글 인코딩 지정
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						
						//key에 맞게 value를 DTO에 삽입하기
						if( "notice_no".equals(key) ) {
							notice.setNotice_no(Integer.parseInt(value));
						}
						if( "title".equals(key) ) {
							notice.setTitle(value);
						}
						if( "notice_content".equals(key) ) {
							notice.setNotice_content(value);
						}
						
					} // if( item.isFormField() ) end
					
					
					
					//--- 3) 파일에 대한 처리 ---
					if( !item.isFormField() ) {
						
						//저장 파일명 처리
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
						String rename = sdf.format(new Date()); //현재시간
						
						//파일 업로드 폴더
						File uploadFolder = new File( context.getRealPath("upload") );
						uploadFolder.mkdir();
						
						//업로드할 파일 객체 생성하기
						File up = new File(uploadFolder, rename);
						try {
							item.write(up);	//임시파일을 실제 업로드 파일로 출력한다
							item.delete(); //임시파일 제거
							
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						//업로드된 파일의 정보를 DTO객체에 저장하기
						noticeFile.setOriginname(item.getName());
						noticeFile.setStoredname(rename);
						noticeFile.setFilesize((int)item.getSize());
						
					} // if( !item.isFormField() ) end
					
				} // while( iter.hasNext() ) end

				
				//DB연결 객체
				Connection conn = JDBCTemplate.getConnection();
				
				if( adminDao.update(conn, notice) > 0 ) {
					JDBCTemplate.commit(conn);
				} else {
					JDBCTemplate.rollback(conn);
				}

				
				//첨부파일 정보 삽입
				if( noticeFile.getFilesize() != 0 ) { //첨부 파일이 존재할 때에만 동작
					
					//게시글 번호 삽입 (FK)
					noticeFile.setnoticeno(notice.getNotice_no());
					
					if( adminDao.insertFile(conn, noticeFile) > 0 ) {
						JDBCTemplate.commit(conn);
					} else {
						JDBCTemplate.rollback(conn);
					}
					
				}
				
		System.out.println("AdminServiceImpl.update End");
				
		return notice.getNotice_no();
		
	}

	@Override
	public BoardInfo getBoardInfo(HttpServletRequest req) {
		System.out.println("AdminServiceImpl.getBoardInfo Start");
		
		BoardInfo boardInfo = new BoardInfo();
		
		if( req.getParameter("title") != null) {
			boardInfo.setBoardTitle( req.getParameter("title") );
		} else {
			boardInfo.setBoardTitle("");
		}
		System.out.println("AdminServiceImpl.getBoardInfo End");
		
		return boardInfo;
	}

	@Override
	public Paging getPaging(HttpServletRequest req, BoardInfo boardInfo) {
		
		System.out.println("AdminServiceImpl.getPaging4 Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		//총 관리자리스트 수 조회하기
		int totalCount = adminDao.selectCntAll(conn, boardInfo);
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage"); // url의 curPage파라미터값 조회
		
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		System.out.println("AdminServiceImpl.getPaging4 End");
				
		return paging;
	}

	@Override
	public List<BoardInfo> getList(Paging paging, BoardInfo boardInfo) {
		System.out.println("AdminServiceImpl.getList4 Start");
		
		System.out.println("AdminServiceImpl.getList4 End");
		
		return adminDao.selectAll(JDBCTemplate.getConnection(), paging, boardInfo);
	}

	@Override
	public void deleteBoard(BoardInfo boardInfo) {
		System.out.println("AdminServiceImpl.deleteBoard Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		adminDao.deleteBoard(conn, boardInfo);
		
		JDBCTemplate.commit(conn);
		
		System.out.println("AdminServiceImpl.deleteBoard End");
	}

	@Override
	public void sendAdminLogin(String adminId) {
		System.out.println("AdminServiceImpl.sendAdminLogin Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		adminDao.sendAdminLogin(conn, adminId);
		
		JDBCTemplate.commit(conn);
		
		System.out.println("AdminServiceImpl.sendAdminLogin End");
	}

	@Override
	public void sendAdminLogout(String adminId) {
		System.out.println("AdminServiceImpl.sendAdminLogout Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		adminDao.sendAdminLogout(conn, adminId);
		
		JDBCTemplate.commit(conn);
		
		System.out.println("AdminServiceImpl.sendAdminLogout End");
	}

	@Override
	public AdminRecode getAdminInfo2(HttpServletRequest req) {
		
		System.out.println("AdminServiceImpl.getAdminInfo2 Start");
		
		AdminRecode adminRecode = new AdminRecode();
		
		if( req.getParameter("userid") != null) {
			adminRecode.setAdminid( req.getParameter("userid") );
		} else {
			adminRecode.setAdminid("");
		}
		
		System.out.println("AdminServiceImpl.getAdminInfo2 End");
		
		return adminRecode;
	}

	@Override
	public Paging getPaging(HttpServletRequest req, AdminRecode adminRecode) {
		
		System.out.println("AdminServiceImpl.getPaging5 Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		//총 관리자리스트 수 조회하기
		int totalCount = adminDao.selectCntAll(conn, adminRecode);
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage"); // url의 curPage파라미터값 조회
		
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		System.out.println("AdminServiceImpl.getPaging5 End");
		
		return paging;
	}

	@Override
	public List<AdminRecode> getList(Paging paging, AdminRecode adminRecode) {
		System.out.println("AdminServiceImpl.getList5 Start");
		
		System.out.println("AdminServiceImpl.getList5 End");
		
		return adminDao.selectAll(JDBCTemplate.getConnection(), paging, adminRecode);
	}

	@Override
	public void sendAdminCreate(String adminId, AdminInfo adminInfo) {
		System.out.println("AdminServiceImpl.sendAdminCreate Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		adminDao.sendAdminCreate(conn, adminId, adminInfo);
		
		JDBCTemplate.commit(conn);
		
		System.out.println("AdminServiceImpl.sendAdminCreate End");
	}

	@Override
	public void sendAdminDelete(String adminId, AdminInfo adminInfo) {
		System.out.println("AdminServiceImpl.sendAdminDelete Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		adminDao.sendAdminDelete(conn, adminId, adminInfo);
		
		JDBCTemplate.commit(conn);
		
		System.out.println("AdminServiceImpl.sendAdminDelete End");
	}

	@Override
	public void sendBoardDelete(String adminId, BoardInfo boardInfo) {
	System.out.println("AdminServiceImpl.sendBoardDelete Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		adminDao.sendBoardDelete(conn, adminId, boardInfo);
		
		JDBCTemplate.commit(conn);
		
		System.out.println("AdminServiceImpl.sendBoardDelete End");
	}

	@Override
	public BoardInfo selectBoard(HttpServletRequest req) {
		System.out.println("AdminServiceImpl.selectBoard Start");
		
		BoardInfo boardInfo = new BoardInfo();
		
		int boardNo = Integer.parseInt( req.getParameter("boardno") );
		
		boardInfo.setBoardNo( boardNo );
		boardInfo.setBoardTitle( req.getParameter("boardtitle") );
		boardInfo.setBoardContent( req.getParameter("boardcontent") );
		
		System.out.println("AdminServiceImpl.selectBoard End");
		
		return boardInfo;
	}

	@Override
	public void sendUserCreate(String adminId, UserInfo userInfo) {
		System.out.println("AdminServiceImpl.sendUserCreate Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		adminDao.sendUserCreate(conn, adminId, userInfo);
		
		JDBCTemplate.commit(conn);
		
		System.out.println("AdminServiceImpl.sendUserCreate End");
	}

	@Override
	public void sendUserDelete(String adminId, UserInfo userInfo) {
		System.out.println("AdminServiceImpl.sendUserDelete Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		adminDao.sendUserDelete(conn, adminId, userInfo);
		
		JDBCTemplate.commit(conn);
		
		System.out.println("AdminServiceImpl.sendUserDelete End");
	}

	@Override
	public void sendUserUpdate(String adminId, UserInfo userInfo) {
		System.out.println("AdminServiceImpl.sendUserUpdate Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		adminDao.sendUserUpdate(conn, adminId, userInfo);
		
		JDBCTemplate.commit(conn);
		
		System.out.println("AdminServiceImpl.sendUserUpdate End");
	}

	@Override
	public void sendNoticeUpdate(String adminId, int test) {
		System.out.println("AdminServiceImpl.sendNoticeUpdate Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		adminDao.sendNoticeUpdate(conn, adminId, test);
		
		JDBCTemplate.commit(conn);
		
		System.out.println("AdminServiceImpl.sendNoticeUpdate End");
	}

	@Override
	public void sendNoticeDelete(String adminId, Notice notice) {
		System.out.println("AdminServiceImpl.sendNoticeDelete Start");
		
		Connection conn = JDBCTemplate.getConnection();
		
		adminDao.sendNoticeDelete(conn, adminId, notice);
		
		JDBCTemplate.commit(conn);
		
		System.out.println("AdminServiceImpl.sendNoticeDelete End");
	}

}
