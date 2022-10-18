package trade.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Uploadfile;

public interface FileService {

	/**
	 * COS 라이브러리를 이용한 파일 업로드 처리
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void cosFileupload(HttpServletRequest req);
	
	/**
	 * 업로드된 파일의 전체 정보를 조회한다
	 * 
	 * @return 조회된 전체 파일 목록
	 */
	public List<Uploadfile> list();

}
