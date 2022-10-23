package main.service.impl;

import java.sql.Connection;
import java.util.List;

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
	public List<BoardInfo> writer(String keyword) {

		Connection conn = JDBCTemplate.getConnection();
		
		return searchBoardDao.selectByWriter(conn, keyword);
	}

	
}
