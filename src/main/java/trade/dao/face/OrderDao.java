package trade.dao.face;

import java.sql.Connection;

import dto.Payment;

public interface OrderDao {

	int saveOrder(Connection conn, Payment payment);

	Payment viewinfo(Connection conn, String loginId);

	int insertPoint(Connection conn, Payment payment);

	int pointAdd(Connection conn, Payment payment);

}
