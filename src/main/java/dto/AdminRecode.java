package dto;

public class AdminRecode {
	
	private int manageno;
	private String adminid;
	private String behavior;
	private String time;
	
	public AdminRecode() {
	}

	public AdminRecode(int manageno, String adminid, String behavior, String time) {
		super();
		this.manageno = manageno;
		this.adminid = adminid;
		this.behavior = behavior;
		this.time = time;
	}

	@Override
	public String toString() {
		return "AdminRecode [manageno=" + manageno + ", adminid=" + adminid + ", behavior=" + behavior + ", time="
				+ time + "]";
	}

	public int getManageno() {
		return manageno;
	}

	public void setManageno(int manageno) {
		this.manageno = manageno;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
