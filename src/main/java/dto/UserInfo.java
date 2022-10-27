package dto;

import java.util.Date;

public class UserInfo {

	private int u_no;		// 회원 번호
	private String u_id;	// 회원 아이디
	private String u_pw;	// 회원 패스워드
	private String u_name;	// 회원 이름
	private Date u_birth;	// 생년월일
	private String u_gender;// 성별
	private String u_phone;	// 전화번호
	private String u_email;	// 이메일
	private String u_address;	// 주소
	private String u_nick;		// 회원 닉네임
	private Date u_join_date;	// 생성날짜
	private String u_trade_user;// 사업자유저
	private String b_business_number; 	// 사업자번호
	private String grade;		// 등급코드
	private String reportcode;	// 신고코드
	private String wishno;		// 장바구니번호 
	private int u_point;	//포인트
	
	public UserInfo() {
	}

	public UserInfo(int u_no, String u_id, String u_pw, String u_name, Date u_birth, String u_gender, String u_phone,
			String u_email, String u_address, String u_nick, Date u_join_date, String u_trade_user,
			String b_business_number, String grade, String reportcode, String wishno, int u_point) {
		super();
		this.u_no = u_no;
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_birth = u_birth;
		this.u_gender = u_gender;
		this.u_phone = u_phone;
		this.u_email = u_email;
		this.u_address = u_address;
		this.u_nick = u_nick;
		this.u_join_date = u_join_date;
		this.u_trade_user = u_trade_user;
		this.b_business_number = b_business_number;
		this.grade = grade;
		this.reportcode = reportcode;
		this.wishno = wishno;
		this.u_point = u_point;
	}

	@Override
	public String toString() {
		return "UserInfo [u_no=" + u_no + ", u_id=" + u_id + ", u_pw=" + u_pw + ", u_name=" + u_name + ", u_birth="
				+ u_birth + ", u_gender=" + u_gender + ", u_phone=" + u_phone + ", u_email=" + u_email + ", u_address="
				+ u_address + ", u_nick=" + u_nick + ", u_join_date=" + u_join_date + ", u_trade_user=" + u_trade_user
				+ ", b_business_number=" + b_business_number + ", grade=" + grade + ", reportcode=" + reportcode
				+ ", wishno=" + wishno + ", u_point=" + u_point + "]";
	}

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public Date getU_birth() {
		return u_birth;
	}

	public void setU_birth(Date u_birth) {
		this.u_birth = u_birth;
	}

	public String getU_gender() {
		return u_gender;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public String getU_nick() {
		return u_nick;
	}

	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}

	public Date getU_join_date() {
		return u_join_date;
	}

	public void setU_join_date(Date u_join_date) {
		this.u_join_date = u_join_date;
	}

	public String getU_trade_user() {
		return u_trade_user;
	}

	public void setU_trade_user(String u_trade_user) {
		this.u_trade_user = u_trade_user;
	}

	public String getB_business_number() {
		return b_business_number;
	}

	public void setB_business_number(String b_business_number) {
		this.b_business_number = b_business_number;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getReportcode() {
		return reportcode;
	}

	public void setReportcode(String reportcode) {
		this.reportcode = reportcode;
	}

	public String getWishno() {
		return wishno;
	}

	public void setWishno(String wishno) {
		this.wishno = wishno;
	}

	public int getU_point() {
		return u_point;
	}

	public void setU_point(int u_point) {
		this.u_point = u_point;
	}

	
	
}