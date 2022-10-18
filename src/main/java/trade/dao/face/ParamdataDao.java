package trade.dao.face;

import java.sql.Connection;

import dto.Paramdata;

public interface ParamdataDao {

	/**
	 * 폼필드 전달파라미터 데이터 삽입하기
	 * 
	 * @param conn - DB연결 객체
	 * @param paramdata - 폼필드 전달데이터 정보
	 * @return 삽입 수행 결과 ( 1-정상 삽입, 0-삽입 실패)
	 */
	public int insert(Connection conn, Paramdata paramdata);
}
