package trade.dao.face;

import java.sql.Connection;
import java.util.List;

import dto.BoardInfo;
import dto.Product;
import dto.Uploadfile;

public interface UploadfileDao {

	/**
	 * 첨부 파일 정보 십입하기
	 * 
	 * @param conn - DB연결 객체
	 * @param uploadfile - DB에 저장할 업로드된 파일의 정보
	 * @param product 
	 * @return 삽입 수행 결과(1-정상 삽입, 0-삽입 실패)
	 */
	public int insert(Connection conn, Uploadfile uploadfile);

	

	public List<BoardInfo> selectBoardList(Connection connection);
}
