package trade.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import common.JDBCTemplate;
import dto.Paramdata;
import dto.Uploadfile;
import trade.dao.face.ParamdataDao;
import trade.dao.face.UploadfileDao;
import trade.dao.impl.ParamdataDaoImpl;
import trade.dao.impl.UploadfileDaoImpl;
import trade.service.face.FileService;

public class FileServiceImpl implements FileService {

	//DAO객체
	private ParamdataDao paramdataDao = new ParamdataDaoImpl();
	private UploadfileDao uploadfileDao = new UploadfileDaoImpl();
	
	@Override
	public void cosFileupload(HttpServletRequest req) {
		//--- COS 라이브러리를 이용한 파일업로드 처리 ---
		
				//1. 전달파라미터를 가진 요청 정보 객체
				//	-> req

				
				//2. 업로드된 파일이 저장될 경로
				String saveDirectory = req.getServletContext().getRealPath("upload");
				
				System.out.println("파일경로 : " + saveDirectory);
				//폴더가 없을 경우 폴더 생성
				File directory = new File(saveDirectory);
				directory.mkdir();
				System.out.println("폴더 " +directory);
				//3. 업로드 용량 제한 크기
				int maxPostSize = 10 * 1024 * 1024;

				//인코딩 설정(한글)
				String encoding = "UTF-8";

				//중복된 파일이름을 처리하는 정책
				FileRenamePolicy policy = new DefaultFileRenamePolicy();

				//** DefaultFileRenamePolicy 클래스
				//	-> 기본 중복 파일이름 처리 정책 클래스
				//	-> 업로드된 파일이 이미 중복된 이름을 가진 파일을 만나면 파일 이름 뒤에 번호를 붙인다
				//	-> 자동으로 1부터 1씩 증가하면서 부여된다
				
				//--------------------------------------------------
				
				//MultipartRequest 객체 생성
				//	-> 객체 생성되면서 파일 업로드 수행
				MultipartRequest mul = null;
				try {
					mul = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, policy);
				} catch (IOException e) {
					e.printStackTrace();
				}

				//--------------------------------------------------
				
				//파일 전달 파라미터 정보
				
				//원본 파일 이름
				String origin = mul.getOriginalFileName("upfile");

				//저장된 파일 이름
				String stored = mul.getFilesystemName("upfile");

				//업로드 파일 정보 DTO
				Uploadfile uploadfile = new Uploadfile();
				uploadfile.setOriginName(origin);
				uploadfile.setStoredName(stored);
				uploadfile.setFilePath(saveDirectory); //파일 경로 저장
				
				Connection conn = JDBCTemplate.getConnection();
				int res = uploadfileDao.insert(conn, uploadfile);
				if(res >0) {
					JDBCTemplate.commit(conn);
				}else {
					JDBCTemplate.rollback(conn);
				}
				

				//--------------------------------------------------
				
				//폼필더 전달 파라미터 정보
				
				Paramdata paramdata = new Paramdata();
				paramdata.setTitle(mul.getParameter("title"));
				paramdata.setData1(mul.getParameter("data1"));
				
				int res2 = paramdataDao.insert(conn, paramdata);
				if(res2 >0 ) {
					JDBCTemplate.commit(conn);
				} else {
					JDBCTemplate.rollback(conn);
				}
	}

	@Override
	public List<Uploadfile> list() {
		return uploadfileDao.selectAll(JDBCTemplate.getConnection());
	}

}
