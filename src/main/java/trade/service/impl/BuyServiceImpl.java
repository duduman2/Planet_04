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
	public void pointSend(String loginId, String sellUserId, int point) {
		if( buyDao.buyersub(conn, loginId, point) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		if( buyDao.selleradd(conn, sellUserId, point) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}

	@Override
	public int myPoint(String loginId) {
		return 0;
	}

}
