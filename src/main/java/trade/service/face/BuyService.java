package trade.service.face;

public interface BuyService {

	public void pointSend(String loginId, String sellUserId, int point);

	public int myPoint(String loginId);

}
