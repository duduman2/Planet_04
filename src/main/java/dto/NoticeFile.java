package dto;

import java.sql.Date;

public class NoticeFile {
	
	private int fileno;
	private int noticeno;
	private String originname;
	private String storedname;
	private int filesize;
	private Date write_date;
	
	public NoticeFile() {
	}

	public NoticeFile(int fileno, int noticeno, String originname, String storedname, int filesize, Date write_date) {
		super();
		this.fileno = fileno;
		this.noticeno = noticeno;
		this.originname = originname;
		this.storedname = storedname;
		this.filesize = filesize;
		this.write_date = write_date;
	}

	@Override
	public String toString() {
		return "NoticeFile [fileno=" + fileno + ", noticeno=" + noticeno + ", originname=" + originname + ", storedname="
				+ storedname + ", filesize=" + filesize + ", write_date=" + write_date + "]";
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public int getnoticeno() {
		return noticeno;
	}

	public void setnoticeno(int noticeno) {
		this.noticeno = noticeno;
	}

	public String getOriginname() {
		return originname;
	}

	public void setOriginname(String originname) {
		this.originname = originname;
	}

	public String getStoredname() {
		return storedname;
	}

	public void setStoredname(String storedname) {
		this.storedname = storedname;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	
}
