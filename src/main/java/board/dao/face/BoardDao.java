package board.dao.face;

import java.util.List;

import dto.BoardInfo;

public interface BoardDao {
	
	public List<BoardInfo> boardList() throws Exception;

}
