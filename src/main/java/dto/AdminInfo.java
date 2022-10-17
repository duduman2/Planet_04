package dto;

public class AdminInfo {
	
	private String adminid;
	private String adminPw;
	
	public AdminInfo() {
	}

	public AdminInfo(String adminid, String adminPw) {
		super();
		this.adminid = adminid;
		this.adminPw = adminPw;
	}

	@Override
	public String toString() {
		return "AdminInfo [adminid=" + adminid + ", adminPw=" + adminPw + "]";
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	
}
