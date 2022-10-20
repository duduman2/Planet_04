package dto;

import java.util.Date;

public class AdminInfo {
	
	private int adminNo;
	private String adminId;
	private String adminPw;
	private Date adminDate;
	
	public AdminInfo() {
	}

	public AdminInfo(int adminNo, String adminId, String adminPw, Date adminDate) {
		super();
		this.adminNo = adminNo;
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.adminDate = adminDate;
	}

	@Override
	public String toString() {
		return "AdminInfo [adminNo=" + adminNo + ", adminId=" + adminId + ", adminPw=" + adminPw + ", adminDate="
				+ adminDate + "]";
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public Date getAdminDate() {
		return adminDate;
	}

	public void setAdminDate(Date adminDate) {
		this.adminDate = adminDate;
	}
	
}
