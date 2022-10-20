package main.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dto.BoardInfo;
import main.dao.face.SearchBoardDao;
import main.dao.impl.SearchBoardDaoImpl;
import main.service.face.SearchBoardService;

public class SearchBoardServiceImpl implements SearchBoardService {

	private SearchBoardDao searchBoardDao = new SearchBoardDaoImpl();
	
	
	@Override
	public List<BoardInfo> getList() {

		return searchBoardDao.selectAll(JDBCTemplate.getConnection());
		
	}
	
	@Override
	public BoardInfo getBoardTitle(HttpServletRequest req) {
		return null;
	}

}
