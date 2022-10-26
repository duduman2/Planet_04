package main.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardInfo;
import dto.Product;
import dto.Uploadfile;

public interface SearchBoardService {
	
	/**
	 * 게시글 전체 조회
	 * 
	 * @return List<Board> - 게시글 전체 조회 목록
	 */
	public List<BoardInfo> getList();

	/**
	 * 키워드가 포함된 게시글 전체 조회
	 * 
	 * @param keyword - 입력한 검색어
	 * @return List<BoardInfo> - 게시글 전체 조회 목록
	 */
	public List<BoardInfo> all(String keyword);

	/**
	 * 키워드가 포함된 게시글 전체 조회
	 * 
	 * @param keyword - 입력한 검색어
	 * @return List<BoardInfo> - 게시글 전체 조회 목록
	 */
	public List<BoardInfo> title(String keyword);
	
	/**
	 * 키워드가 포함된 게시글 전체 조회
	 * 
	 * @param keyword - 입력한 검색어
	 * @return List<BoardInfo> - 게시글 전체 조회 목록
	 */
	public List<BoardInfo> content(String keyword);

	/**
	 * 키워드가 포함된 게시글 전체 조회
	 * 
	 * @param keyword - 입력한 검색어
	 * @return List<BoardInfo> - 게시글 전체 조회 목록
	 */
	public List<BoardInfo> writer(String keyword);

	/**
	 * 
	 * @return
	 */
	public List<Product> getProductList();


}
