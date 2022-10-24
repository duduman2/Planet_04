<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="../layout/header.jsp" %>


<title>개인정보 수정하기</title>
<style type="text/css">
@import url("../sources/mypage/mypage.css");

</style>
<script type="text/javascript">
$(document).ready(function() {
	
// 	$(".btnBack").click(function() { //실행안됨!!
// 		$(location).attr("href", "/mypage/controller")
// 	})

	})
})

</script>
</head>
<body>
<h1>개인정보 확인하기</h1>
<hr>
<div class="main" style="width: 100%;">




<table class="table table-striped table-hover" id="userinfo">
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

<tr>
	<th>회원 번호</th>
	<td>번호</td>
</tr>
<tr>
	<th>회원 아이디</th>
	<td>회원</td>
</tr>
<tr>
	<th>회원 패스워드</th>
	<td>회원</td>
</tr>
<tr>
	<th>회원 이름</th>
	<td>이메일</td>
</tr>
<%-- 4개 --%>

<tr>
	<th>생년월일</th>
	<td>번호</td>
</tr>
<tr>
	<th>성별</th>
	<td>회원</td>
</tr>
<tr>
	<th>전화번호</th>
	<td>회원</td>
</tr>
<tr>
	<th>이메일</th>
	<td>이메일</td>
</tr>
<%-- 8개--%>


<tr>
	<th>주소</th>
	<td>번호</td>
</tr>
<tr>
	<th>회원 닉네임</th>
	<td>회원</td>
</tr>
<tr>
	<th>생성날짜</th>
	<td>회원</td>
</tr>
<tr>
	<th>사업자유저</th>
	<td>이메일</td>
</tr>
<%-- 12개--%>


<tr>
	<th>사업자번호</th>
	<td>번호</td>
</tr>
<tr>
	<th>등급코드</th>
	<td>회원</td>
</tr>
<tr>
	<th>신고코드</th>
	<td>회원</td>
</tr>
<tr>
	<th>장바구니번호</th>
	<td>이메일</td>
</tr>
<%-- 16개--%>


</table>

<div class="text-center" >
<button id="btnUserInfoUpdate" class="btnUserInfoUpdate" 
style="width: 100px; height: 50px;">수정하기</button> 
&nbsp;&nbsp;&nbsp;
<button id="btnBack" class="btnBack" style="width: 100px; 
height: 50px;" onclick="history.go(-1)">되돌아가기</button>
</div>

<div></div>

<div id="blank" style="height: 100px;"> </div>


</div><!--<div class=main> end -->

<script type="text/javascript">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</script>

<%@ include file="../layout/footer.jsp"%>
