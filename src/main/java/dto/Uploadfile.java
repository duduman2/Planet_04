package dto;

public class Uploadfile {
	private int fileno;
	private String originName;
	private String storedName;
	private String filePath;
	
	public Uploadfile() {	}

	public Uploadfile(int fileno, String originName, String storedName, String filePath) {
		super();
		this.fileno = fileno;
		this.originName = originName;
		this.storedName = storedName;
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "Uploadfile [fileno=" + fileno + ", originName=" + originName + ", storedName=" + storedName
				+ ", filePath=" + filePath + "]";
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getStoredName() {
		return storedName;
	}

	public void setStoredName(String storedName) {
		this.storedName = storedName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
 
	
	
	
}
