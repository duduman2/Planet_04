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
	 * 전달파라미터 boardtitle을 BoardInfo DTO로 저장하여 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return BoardInfo - 
	 */
	public BoardInfo getBoardTitle(HttpServletRequest req);

}
