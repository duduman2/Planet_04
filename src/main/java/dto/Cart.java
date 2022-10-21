package dto;

import java.util.Date;

public class Cart {

	// wish_no, wish_total_price, product_no, wish_amount
	
	private int carNo;
	private int u_no;
	private int totalPrice;
	private Date paymentDate;
	
	private int product_no;
	private int wish_amount;
	
	public Cart() {	}

	public Cart(int carNo, int u_no, int totalPrice, Date paymentDate, int product_no, int wish_amount) {
		super();
		this.carNo = carNo;
		this.u_no = u_no;
		this.totalPrice = totalPrice;
		this.paymentDate = paymentDate;
		this.product_no = product_no;
		this.wish_amount = wish_amount;
	}

	@Override
	public String toString() {
		return "Cart [carNo=" + carNo + ", u_no=" + u_no + ", totalPrice=" + totalPrice + ", paymentDate=" + paymentDate
				+ ", product_no=" + product_no + ", wish_amount=" + wish_amount + "]";
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

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getWish_amount() {
		return wish_amount;
	}

	public void setWish_amount(int wish_amount) {
		this.wish_amount = wish_amount;
	}
	
	
	
}
