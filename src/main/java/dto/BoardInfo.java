package dto;

import java.util.Date;

public class BoardInfo {
	
	private String userId;
	private String userNick;
	private String userRank;
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private int boardHit;
	private int cateno;
	private int userno;
	
	public BoardInfo() {
	}

	public BoardInfo(String userId, String userNick, String userRank, int boardNo, String boardTitle, String boardContent,
			Date boardDate, int boardHit) {
		super();
		this.userId = userId;
		this.userNick = userNick;
		this.userRank = userRank;
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardHit = boardHit;
	}

	@Override
	public String toString() {
		return "BoardInfo [userId=" + userId + ", userNick=" + userNick + ", userRank=" + userRank + ", boardNo="
				+ boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardDate=" + boardDate
				+ ", boardHit=" + boardHit + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserRank() {
		return userRank;
	}

	public void setUserRank(String userRank) {
		this.userRank = userRank;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardHit() {
		return boardHit;
	}

	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}

	public int getCateno() {
		return cateno;
	}

	public void setCateno(int cateno) {
		this.cateno = cateno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}
	
}
