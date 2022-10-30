package dto;

import java.util.Date;

public class Payment {
    private int payNo;
	private Date payDate;
	private int payPrice;
	private String buyerId;
	private int buyerTel;
	
	public Payment() {	}

	public Payment(int payNo, Date payDate, int payPrice, String buyerId, int buyerTel) {
		super();
		this.payNo = payNo;
		this.payDate = payDate;
		this.payPrice = payPrice;
		this.buyerId = buyerId;
		this.buyerTel = buyerTel;
	}

	@Override
	public String toString() {
		return "Payment [payNo=" + payNo + ", payDate=" + payDate + ", payPrice=" + payPrice + ", buyerId=" + buyerId
				+ ", buyerTel=" + buyerTel + "]";
	}

	public int getPayNo() {
		return payNo;
	}

	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public int getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public int getBuyerTel() {
		return buyerTel;
	}

	public void setBuyerTel(int buyerTel) {
		this.buyerTel = buyerTel;
	}
	
	
}
