package dto;

import java.util.Date;

public class BoardInfo {
	
	private String userId;
	private String userNick;
	private int userRank;
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private int boardHit;
	
	public BoardInfo() {
	}

	public BoardInfo(String userId, String userNick, int userRank, int boardNo, String boardTitle, String boardContent,
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

	public int getUserRank() {
		return userRank;
	}

	public void setUserRank(int userRank) {
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
	
}
