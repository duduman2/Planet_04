package dto;

import java.util.Date;

public class AskBoard {

	private int askBoard;
	private int u_no;
	private int categoryNo;
	private String askContent;
	private Date askDate;
	
	public AskBoard() {	}

	public AskBoard(int askBoard, int u_no, int categoryNo, String askContent, Date askDate) {
		super();
		this.askBoard = askBoard;
		this.u_no = u_no;
		this.categoryNo = categoryNo;
		this.askContent = askContent;
		this.askDate = askDate;
	}

	@Override
	public String toString() {
		return "AskBoard [askBoard=" + askBoard + ", u_no=" + u_no + ", categoryNo=" + categoryNo + ", askContent="
				+ askContent + ", askDate=" + askDate + "]";
	}

	public int getAskBoard() {
		return askBoard;
	}

	public void setAskBoard(int askBoard) {
		this.askBoard = askBoard;
	}

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getAskContent() {
		return askContent;
	}

	public void setAskContent(String askContent) {
		this.askContent = askContent;
	}

	public Date getAskDate() {
		return askDate;
	}

	public void setAskDate(Date askDate) {
		this.askDate = askDate;
	}
	
	
}
