package dto;

public class AdminInfo {
	
	private int adminno;
	private String adminid;
	private String adminPw;
	
	public AdminInfo() {
	}
	
	public AdminInfo(int adminno, String adminid, String adminPw) {
		super();
		this.adminno = adminno;
		this.adminid = adminid;
		this.adminPw = adminPw;
	}

	@Override
	public String toString() {
		return "AdminInfo [adminno=" + adminno + ", adminid=" + adminid + ", adminPw=" + adminPw + "]";
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

	public int getAdminno() {
		return adminno;
	}

	public void setAdminno(int adminno) {
		this.adminno = adminno;
	}
	
}
