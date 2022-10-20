package dto;

import java.util.Date;

public class Cart {

	private int carNo;
	private int u_no;
	private int totalPrice;
	private Date paymentDate;
	
	public Cart() {	}

	public Cart(int carNo, int u_no, int totalPrice, Date paymentDate) {
		super();
		this.carNo = carNo;
		this.u_no = u_no;
		this.totalPrice = totalPrice;
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Cart [carNo=" + carNo + ", u_no=" + u_no + ", totalPrice=" + totalPrice + ", paymentDate=" + paymentDate
				+ "]";
	}

	public int getCarNo() {
		return carNo;
	}

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}
