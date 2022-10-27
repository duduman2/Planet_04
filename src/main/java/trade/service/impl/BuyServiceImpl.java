package trade.service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import trade.dao.face.BuyDao;
import trade.dao.impl.BuyDaoImpl;
import trade.service.face.BuyService;

public class BuyServiceImpl implements BuyService {
	
	private BuyDao buyDao = new BuyDaoImpl();
	Connection conn = JDBCTemplate.getConnection();

	@Override
	public int myPoint(String loginId) {
		int point = buyDao.pointView(conn, loginId);
		return point;
	}

}
