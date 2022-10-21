package dto;

import java.util.Date;

/**
 * @author JJUFE
 *
 */
/**
 * @author JJUFE
 *
 */
public class Product {
	private int productNo;
	private String productName;
	private String productContent;
	private int productPrice;
	private Date productDate;
	private int fileNo;
	private String fileName;
	private String filePath;
	private String productClass;
	
	public Product() {}

	public Product(int productNo, String productName, String productContent, int productPrice, Date productDate,
			int fileNo, String fileName, String filePath, String productClass) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productContent = productContent;
		this.productPrice = productPrice;
		this.productDate = productDate;
		this.fileNo = fileNo;
		this.fileName = fileName;
		this.filePath = filePath;
		this.productClass = productClass;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productName=" + productName + ", productContent=" + productContent
				+ ", productPrice=" + productPrice + ", productDate=" + productDate + ", fileNo=" + fileNo
				+ ", fileName=" + fileName + ", filePath=" + filePath + ", productClass=" + productClass + "]";
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}


	
}
