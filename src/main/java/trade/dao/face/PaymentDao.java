package trade.dao.face;

import java.sql.Connection;

public interface PaymentDao {

	public int buyersub(Connection conn, String loginId, int point);

	public int selleradd(Connection conn, String sellUserId, int point);
}
