package main.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardInfo;

public interface SearchBoardService {
	
	/**
	 * 게시글 전체 조회
	 * 
	 * @return List<Board> - 게시글 전체 조회 목록
	 */
	public List<BoardInfo> getList();

	/**
	 * 
	 * @param keyword
	 * @return
	 */
	public List<BoardInfo> writer(String keyword);
	
}
