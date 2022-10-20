package dto;

public class StoryFile {

	private int storyFileNo;
	private int storyNo;
	private String storyOriginFileName;
	private String storyRenameFileName;
	
	public StoryFile() {	}

	public StoryFile(int storyFileNo, int storyNo, String storyOriginFileName, String storyRenameFileName) {
		super();
		this.storyFileNo = storyFileNo;
		this.storyNo = storyNo;
		this.storyOriginFileName = storyOriginFileName;
		this.storyRenameFileName = storyRenameFileName;
	}

	@Override
	public String toString() {
		return "StoryFile [storyFileNo=" + storyFileNo + ", storyNo=" + storyNo + ", storyOriginFileName="
				+ storyOriginFileName + ", storyRenameFileName=" + storyRenameFileName + "]";
	}

	public int getStoryFileNo() {
		return storyFileNo;
	}

	public void setStoryFileNo(int storyFileNo) {
		this.storyFileNo = storyFileNo;
	}

	public int getStoryNo() {
		return storyNo;
	}

	public void setStoryNo(int storyNo) {
		this.storyNo = storyNo;
	}

	public String getStoryOriginFileName() {
		return storyOriginFileName;
	}

	public void setStoryOriginFileName(String storyOriginFileName) {
		this.storyOriginFileName = storyOriginFileName;
	}

	public String getStoryRenameFileName() {
		return storyRenameFileName;
	}

	public void setStoryRenameFileName(String storyRenameFileName) {
		this.storyRenameFileName = storyRenameFileName;
	}
	
	
	
}
