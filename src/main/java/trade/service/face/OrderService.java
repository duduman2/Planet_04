package trade.service.face;

import dto.Payment;

public interface OrderService {

	public Payment saveOrder(String loginId);

	public void insertPoint(Payment payment);

}
