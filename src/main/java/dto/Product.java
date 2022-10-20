package dto;

import java.util.Date;

public class Product {
	private String productNo;
	private String productname;
	private String productcontent;
	private int productprice;
	private Date productdate;
	private int fileno;
	private String filename;
	private String filepath;
	
	public Product() {}

	public Product(String productNo, String productname, String productcontent, int productprice, Date productdate,
			int fileno, String filename, String filepath) {
		super();
		this.productNo = productNo;
		this.productname = productname;
		this.productcontent = productcontent;
		this.productprice = productprice;
		this.productdate = productdate;
		this.fileno = fileno;
		this.filename = filename;
		this.filepath = filepath;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productname=" + productname + ", productcontent=" + productcontent
				+ ", productprice=" + productprice + ", productdate=" + productdate + ", fileno=" + fileno
				+ ", filename=" + filename + ", filepath=" + filepath + "]";
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductcontent() {
		return productcontent;
	}

	public void setProductcontent(String productcontent) {
		this.productcontent = productcontent;
	}

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public Date getProductdate() {
		return productdate;
	}

	public void setProductdate(Date productdate) {
		this.productdate = productdate;
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}


	
}
