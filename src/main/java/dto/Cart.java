package dto;

import java.util.Date;

public class Cart {

	// wish_no, wish_total_price, product_no, wish_amount,product_name,price,deliveryfee
	
	private int carNo;
	private int totalPrice;
	private int product_no;
	private int wish_amount;
	private String product_name;
	private int price;
	private int deliveryfee;
	
	//추가할거!!  /제품세부사항(컬러, 사이즈)
	
	public Cart() {	}

	public Cart(int carNo, int totalPrice, int product_no, int wish_amount, String product_name, int price,
			int deliveryfee) {
		super();
		this.carNo = carNo;
		this.totalPrice = totalPrice;
		this.product_no = product_no;
		this.wish_amount = wish_amount;
		this.product_name = product_name;
		this.price = price;
		this.deliveryfee = deliveryfee;
	}

	@Override
	public String toString() {
		return "Cart [carNo=" + carNo + ", totalPrice=" + totalPrice + ", product_no=" + product_no + ", wish_amount="
				+ wish_amount + ", product_name=" + product_name + ", price=" + price + ", deliveryfee=" + deliveryfee
				+ "]";
	}

	public int getCarNo() {
		return carNo;
	}

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
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

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDeliveryfee() {
		return deliveryfee;
	}

	public void setDeliveryfee(int deliveryfee) {
		this.deliveryfee = deliveryfee;
	}

	
	
	
	
}
