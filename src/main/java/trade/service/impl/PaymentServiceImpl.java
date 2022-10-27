package trade.service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import trade.dao.face.PaymentDao;
import trade.dao.impl.PaymentDaoImpl;
import trade.service.face.PaymentService;

public class PaymentServiceImpl implements PaymentService {


	private PaymentDao paymentDao = new PaymentDaoImpl();
	Connection conn = JDBCTemplate.getConnection();
	
	@Override
	public void pointSend(String loginId, String sellUserId, int point) {
		if( paymentDao.buyersub(conn, loginId, point) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		if( paymentDao.selleradd(conn, sellUserId, point) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}
}
