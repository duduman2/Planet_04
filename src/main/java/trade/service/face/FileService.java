package trade.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardInfo;
import dto.Product;
import dto.Uploadfile;
import trade.util.Paging;

public interface FileService {

	/**
	 * COS 라이브러리를 이용한 파일 업로드 처리
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void cosFileupload(HttpServletRequest req);
	

	public List<Product> boardList(Product product, String cl, Paging paging);


	public Paging getPaging(HttpServletRequest req, String cl);

}
