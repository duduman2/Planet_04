<%@page import="dto.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="icon" href="<%=request.getContextPath() %>/sources/admin/favicon.ico">
<title>개인정보 확인하기</title>

<%@include file="../layout/header.jsp" %>

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
	$("#btnUserInfoUpdate").click(function() {
		$(location).attr("href", "/user/update")
	})
	$("#btnUserInfoDeleteMenu").click(function() {
		$(location).attr("href", "/user/delete")
	})	
	
})

</script>
<!-- </head> -->
<!-- <body> -->

<h3>&nbsp;&nbsp;&nbsp개인정보 확인하기</h3>
<hr>
<div class="main">

	<div id="uinfoMenu">
<!-- 		<ul> -->
<!-- 			<li><a id="btnUserInfo">회원 정보 확인</a></li> -->
<!-- 			<li><a id="btnUserInfoModi">회원 정보 수정</a></li> -->
<!-- 			<li><a id="btnUserInfoDeleteMenu">회원 탈퇴</a></li> -->
<!-- 		</ul> -->
		<table class="table">
			<tr><th>메뉴</th></tr>
			<tr><td><a id="btnUserInfo">회원 정보 확인</a></td></tr>
			<tr><td><a id="btnUserInfoModi">회원 정보 수정</a></td></tr>
			<tr><td><a id="btnUserInfoDeleteMenu">회원 탈퇴</a></td></tr>
		</table>
		
	</div>

	<div class="line" id="line">  </div>

	<div id="uinfoRight">
		<table class="table table-striped table-hover" id="userinfo">
		
		<%-- <% for(int i=0; i<uList.size(); i++) { %> --%>
		<tr>
			<th>회원 번호</th>
			<td><%=uList.getU_no() %></td>
		</tr>
		<tr>
			<th>회원 아이디</th>
			<td><%=uList.getU_id() %></td>
		</tr>
		<tr>
			<th>회원 패스워드</th>
			<td><%=uList.getU_pw() %></td>
		</tr>
		<tr>
			<th>회원 이름</th>
			<td><%=uList.getU_name() %></td>
		</tr>
		<%-- 4개 --%>
		
		<tr>
			<th>생년월일</th>
			<td><%=uList.getU_birth() %></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><%=uList.getU_gender() %></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=uList.getU_phone() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=uList.getU_email() %></td>
		</tr>
		<%-- 8개--%>
		
		
		<tr>
			<th>주소</th>
			<td><%=uList.getU_address() %></td>
		</tr>
		<tr>
			<th>회원 닉네임</th>
			<td><%=uList.getU_nick() %></td>
		</tr>
<!-- 		<tr> -->
<!-- 			<th>생성날짜</th> -->
<%-- 			<td><%=uList.getU_join_date() %></td> --%>
<!-- 		</tr> -->
		<tr>
			<th>사업자유저</th>
			<td><%=uList.getB_business_number() %></td>
		</tr>
		<%-- 12개--%>
		
		
		<tr>
			<th>사업자번호</th>
			<td><%=uList.getB_business_number() %></td>
		</tr>
		<tr>
			<th>등급코드</th>
			<td><%=uList.getGrade() %></td>
		</tr>
		<!-- <tr> -->
		<!-- 	<th>신고코드</th> -->
		<%-- 	<td><%=uList.getReportcode() %></td> --%>
		<!-- </tr> -->
		<!-- <tr> -->
		<!-- 	<th>장바구니번호</th> -->
		<%-- 	<td><%=uList.getWishno() %></td> --%>
		<!-- </tr> -->
		<%-- 16개--%>
		<%-- <% } %> --%>
		</table>
	</div>

<div class="text-center" >
<button id="btnUserInfoUpdate"  class="btn btn-info"
style="width: 100px; height: 50px;">수정하기</button> 
&nbsp;&nbsp;&nbsp;
<button id="btnBack"  class="btn btn-default" style="width: 120px; 
height: 50px;" onclick="history.go(-1)">이전으로</button>
</div>

<div></div>

<div id="blank" style="height: 100px;"> </div>


</div><!--<div class=main> end -->

<%@ include file="../layout/footer.jsp"%>
