package dto;

import java.util.Date;

public class StoryBoard {

	private int storyBoard;
	private int u_no;
	private int categoryNo;
	private String storyContent;
	private Date storyWriteDate;
	private int showLevel;  	 //회원등급 - int로 해도되나? String말고? (새싹,열매,,,)
	
	public StoryBoard() {	}

	public StoryBoard(int storyBoard, int u_no, int categoryNo, String storyContent, Date storyWriteDate,
			int showLevel) {
		super();
		this.storyBoard = storyBoard;
		this.u_no = u_no;
		this.categoryNo = categoryNo;
		this.storyContent = storyContent;
		this.storyWriteDate = storyWriteDate;
		this.showLevel = showLevel;
	}

	@Override
	public String toString() {
		return "StoryBoard [storyBoard=" + storyBoard + ", u_no=" + u_no + ", categoryNo=" + categoryNo
				+ ", storyContent=" + storyContent + ", storyWriteDate=" + storyWriteDate + ", showLevel=" + showLevel
				+ "]";
	}

	public int getStoryBoard() {
		return storyBoard;
	}

	public void setStoryBoard(int storyBoard) {
		this.storyBoard = storyBoard;
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

	public String getStoryContent() {
		return storyContent;
	}

	public void setStoryContent(String storyContent) {
		this.storyContent = storyContent;
	}

	public Date getStoryWriteDate() {
		return storyWriteDate;
	}

	public void setStoryWriteDate(Date storyWriteDate) {
		this.storyWriteDate = storyWriteDate;
	}

	public int getShowLevel() {
		return showLevel;
	}

	public void setShowLevel(int showLevel) {
		this.showLevel = showLevel;
	}
	
	
	
}
