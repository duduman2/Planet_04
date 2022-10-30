package trade.service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import dto.Payment;
import trade.dao.face.OrderDao;
import trade.dao.impl.OrderDaoImpl;
import trade.service.face.OrderService;

public class OrderServiceImpl implements OrderService {

	OrderDao orderDao = new OrderDaoImpl();
	Connection conn = JDBCTemplate.getConnection();
	
	@Override
	public Payment saveOrder(String loginId) {
		Payment payment = new Payment();
		payment = orderDao.viewinfo(conn,loginId);
		System.out.println("orderservice-payment : " +payment);
		if( orderDao.saveOrder(conn,payment) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return payment;
		
	}

	@Override
	public void insertPoint(Payment payment) {
		if( orderDao.insertPoint(conn,payment) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		if( orderDao.pointAdd(conn,payment) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}

}
