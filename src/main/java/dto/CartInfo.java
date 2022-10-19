package dto;

import java.util.Date;

public class CartInfo {

	private int cartNo;
	private String categoryName;
	private int productPrice;
	private int productCheck;
	private Date paymentDate;
	
	public CartInfo() {	}

	public CartInfo(int cartNo, String categoryName, int productPrice, int productCheck, Date paymentDate) {
		super();
		this.cartNo = cartNo;
		this.categoryName = categoryName;
		this.productPrice = productPrice;
		this.productCheck = productCheck;
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "CartInfo [cartNo=" + cartNo + ", categoryName=" + categoryName + ", productPrice=" + productPrice
				+ ", productCheck=" + productCheck + ", paymentDate=" + paymentDate + "]";
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductCheck() {
		return productCheck;
	}

	public void setProductCheck(int productCheck) {
		this.productCheck = productCheck;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}
