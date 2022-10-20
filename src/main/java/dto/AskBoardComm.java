package dto;

import java.util.Date;

public class AskBoardComm {
	
	private int askBoardNo;
	private int askCommNo;
	private String commContent;
	private Date commDate;
	
	public AskBoardComm() {	}

	public AskBoardComm(int askBoardNo, int askCommNo, String commContent, Date commDate) {
		super();
		this.askBoardNo = askBoardNo;
		this.askCommNo = askCommNo;
		this.commContent = commContent;
		this.commDate = commDate;
	}

	@Override
	public String toString() {
		return "AskBoardComm [askBoardNo=" + askBoardNo + ", askCommNo=" + askCommNo + ", commContent=" + commContent
				+ ", commDate=" + commDate + "]";
	}

	public int getAskBoardNo() {
		return askBoardNo;
	}

	public void setAskBoardNo(int askBoardNo) {
		this.askBoardNo = askBoardNo;
	}

	public int getAskCommNo() {
		return askCommNo;
	}

	public void setAskCommNo(int askCommNo) {
		this.askCommNo = askCommNo;
	}

	public String getCommContent() {
		return commContent;
	}

	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}

	public Date getCommDate() {
		return commDate;
	}

	public void setCommDate(Date commDate) {
		this.commDate = commDate;
	}

}
