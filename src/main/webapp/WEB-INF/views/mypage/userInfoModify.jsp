<%@page import="dto.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>회원 정보 수정하기</title>

<%@include file="../layout/header2.jsp" %>

<%-- 모델값 전달받기 --%>
<% 	UserInfo uList = (UserInfo) request.getAttribute("data"); %>


<script type="text/javascript">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>>
</script>


<style type="text/css">
@import url("../sources/mypage/mypage.css");

</style>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnUserInfo").click(function() {
		$(location).attr("href", "/user/info")
	})
	$("#btnUserInfoModi").click(function() {
		$(location).attr("href", "/user/update")
	})
	$("#btnUserInfoDeleteMenu").click(function() {
		$(location).attr("href", "/user/delete")
	})
	$("#btnMyMain").click(function() {
		$(location).attr("href", "/mypage/main")
	})
	$("#btnUserInfoUpdate").click(function() { //하단의 수정완료 버튼
		$(location).attr("href", "/user/updateResult")
// 		$(location).attr("href", "/user/info")
	})
	$("#btnGradeInfo").click(function() {
		$(location).attr("href", "/grade/info")
	})
	
})

</script>
<!-- </head> -->
<!-- <body> -->

<h3>&nbsp;&nbsp;&nbsp;회원 정보 수정하기</h3>
<hr>
<div class="main" style="width: 100%;">

	<div id="uinfoMenu">
		<ul style="list-style: none;">
			<li><a id="btnGradeInfo">회원 등급 안내</a></li>
			<li><a id="btnUserInfo">회원 정보 확인</a></li>
			<li><a id="btnUserInfoModi">회원 정보 수정</a></li>
			<li><a id="btnUserInfoDeleteMenu">회원 탈퇴</a></li>
		</ul>
	</div>



	<div id="uinfoRight">
	<form action="/user/update" method="post" name="userUpdate">
		<table class="table table-striped table-hover" id="userinfo">
		
		<%-- <% for(int i=0; i<uList.size(); i++) { %> --%>
<!-- 		<tr> -->
<!-- 			<th>회원 번호</th> -->
<%-- 			<td><input type="text" name="uNo" value="<%=uList.getU_no() %>"></td> --%>
<!-- 		</tr> -->


		<tr>
			<th>회원 아이디</th>
			<td><input type="text" name="userid" value="<%=uList.getU_id() %>"></td>
		</tr>
		<tr>
			<th>회원 패스워드</th>
			<td><input type="text" name="userpw" value="<%=uList.getU_pw() %>"></td>
		</tr>
		<tr>
			<th>회원 이름</th>
			<td><input type="text" name="username" value="<%=uList.getU_name() %>"></td>
		</tr>
		<%-- 4개 --%>
		
		<tr>
			<th>생년월일</th>
			<td><input type="text" name="userbirth" value="<%=uList.getU_birth() %>"></td>
<%-- 			<td><%=uList.getU_birth() %></td> --%>
		</tr>
		<tr>
			<th>성별</th>
			<td><input type="text" name="usergender" value="<%=uList.getU_gender() %>"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="userphone" value="<%=uList.getU_phone() %>"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="useremail" value="<%=uList.getU_email() %>"></td>
		</tr>
		<%-- 8개--%>
		
		
		<tr>
			<th>주소</th>
			<td><input type="text" name="useradd" value="<%=uList.getU_address() %>"></td>
		</tr>
		<tr>
			<th>회원 닉네임</th>
			<td><input type="text" name="usernick" value="<%=uList.getU_nick() %>"></td>
		</tr>
		<tr>
			<th>가입날짜</th>
			<td><%=uList.getU_join_date() %></td>
		</tr>
		<tr>
			<th>사업자유저</th>
			<td><input type="text" name="bsuser" value="<%=uList.getB_business_number() %>"></td>
		</tr>
		<%-- 12개--%>
		
		
		<tr>
			<th>사업자번호</th>
			<td><input type="text" name="bsnum" value="<%=uList.getB_business_number() %>"></td>
		</tr>
		<tr>
			<th>등급코드</th>
			<td><%=uList.getGrade() %></td>
		</tr>
		<!-- <tr> -->
		<!-- 	<th>신고코드</th> -->
		<%-- 	<td><input type="text" name="" value="<%=uList.getReportcode() %>"></td> --%>
		<!-- </tr> -->
		<!-- <tr> -->
		<!-- 	<th>장바구니번호</th> -->
		<%-- 	<td><input type="text" name="" value="<%=uList.getWishno() %>"></td> --%>
		<!-- </tr> -->
		<tr>
			<th>보유 포인트</th>
			<td><%=uList.getU_point() %> P</td>
		</tr>
		<%-- 17개--%>
		<%-- <% } %> --%>
		<tr>
			<th>이미지 교체</th>
			<td></td>
		</tr>
		</table>
		
		
			<div id="btn" class="text-center">
				<button id="btnBack"  class="btn btn-default" style="width: 120px; 
				height: 50px;" onclick="history.go(-1)">이전으로</button>
				
				&nbsp;&nbsp;&nbsp;
				
<!-- 				<input type="submit" value="저장"> -->
				
				<button type="submit" id="btnUserInfoUpdate"  class="btn btn-info"
				style="width: 100px; height: 50px;">저장</button> 
					
				&nbsp;&nbsp;&nbsp;
				
				<button id="btnMyMain" class="btn btn-default"  
				style="width: 155px; height: 50px;">마이페이지-메인으로</button>
			</div>
		
		</form>
	</div> <!-- uinfoRight end -->



<div id="blank" style="height: 100px;"> </div>


</div><!--<div class=main> end -->

<%@ include file="../layout/footer.jsp"%>
