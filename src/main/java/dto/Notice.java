package dto;

import java.sql.Date;

public class Notice {
	
	private int notice_no;
	private int hit;
	private String title;
	private String notice_content;
	private Date insert_dat;
	private int admin_no;
	
	public Notice() {
	}

	public Notice(int notice_no, int hit, String title, String notice_content, Date insert_dat, int admin_no) {
		super();
		this.notice_no = notice_no;
		this.hit = hit;
		this.title = title;
		this.notice_content = notice_content;
		this.insert_dat = insert_dat;
		this.admin_no = admin_no;
	}

	@Override
	public String toString() {
		return "Notice [notice_no=" + notice_no + ", hit=" + hit + ", title=" + title + ", notice_content="
				+ notice_content + ", insert_dat=" + insert_dat + ", admin_no=" + admin_no + "]";
	}

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public Date getInsert_dat() {
		return insert_dat;
	}

	public void setInsert_dat(Date insert_dat) {
		this.insert_dat = insert_dat;
	}

	public int getAdmin_no() {
		return admin_no;
	}

	public void setAdmin_no(int admin_no) {
		this.admin_no = admin_no;
	}

}
