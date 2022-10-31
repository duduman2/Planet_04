<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>회원 등급 안내</title>

<%@include file="../layout/header2.jsp" %>

<script type="text/javascript">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>>
</script>

<style type="text/css">
/* @import url("../sources/mypage/mypage.css"); */
* { font-size: 1.05em;}
table, tr, th, td { 
	border: 3px solid #ccc; 
	border-collapse: collapse;
	padding: 30px;
/* 	left: 300px; */
	float: middle;
}
table { 
/* 	margin-left:auto;  */
/*     margin-right:auto; */
    margin-top: 50px;
    
}
tr { text-align: center; } 
td { width: 600px;
	text-align: left;
}
th { color: #5B9E28; }

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
	$("#btnMyMain").click(function() {
		$(location).attr("href", "/mypage/main")
	})
	$("#btnGradeInfo").click(function() {
		$(location).attr("href", "/grade/info")
	})
	
})

</script>
<h3>&nbsp;&nbsp;&nbsp;회원 등급 안내</h3>
<!-- &nbsp;&nbsp;&nbsp;<p>씨앗 > 새싹 > 꽃잎 > 열매 > 나무</p> -->
<hr>

<div class="main">

<!-- <ul> -->
<!-- 	<li>씨앗</li> -->
<!-- 	<li>새싹</li> -->
<!-- 	<li>꽃잎</li> -->
<!-- 	<li>열매</li> -->
<!-- 	<li>나무</li> -->
<!-- </ul> -->

	<div id="uinfoMenu">
		<ul style="list-style: none;">
			<li><a id="btnGradeInfo">회원 등급 안내</a></li>
			<li><a id="btnUserInfo">회원 정보 확인</a></li>
			<li><a id="btnUserInfoModi">회원 정보 수정</a></li>
			<li><a id="btnUserInfoDeleteMenu">회원 탈퇴</a></li>
		</ul>
	</div>
	
	<div class="line" id="line">  </div>
	
	
<div id="uinfoRight">
<table>
	<thead> 
	<tr style="border-bottom: double;">
		<th style="color: black;">등급 이름</th>
		<th style="color: black;">회원 등급 업그레이드 조건</th>
	</tr>
	</thead>

	<tr>
		<th>&nbsp;&nbsp;&nbsp;&nbsp;씨앗</th>
		<td>
		 신규 가입자 누구나
		</td>
	</tr>
	<tr>
		<th>&nbsp;&nbsp;&nbsp;&nbsp;새싹</th>
		<td>
		댓글 5회<br>
		게시글 2회 
		</td>
	</tr>
	<tr>
		<th>&nbsp;&nbsp;&nbsp;&nbsp;꽃잎</th>
		<td>
		댓글 10회<br>
		게시글 5회 
		</td>
	</tr>
	<tr>
		<th>&nbsp;&nbsp;&nbsp;&nbsp;열매</th>
		<td>
		댓글 20회<br>
		게시글 10회 
		</td>
	</tr>
	<tr>
		<th>&nbsp;&nbsp;&nbsp;&nbsp;나무</th>
		<td>
		댓글 30회<br>
		게시글 20회 	
		</td>
	</tr>
</table>
</div>

<div class="text-center">
	<br>		
	<button id="btnBack" class="btn btn-default" style="width: 120px; 
		height: 50px;" onclick="history.go(-1)">이전으로</button>
		
	&nbsp;&nbsp;&nbsp;
			
	<button id="btnMyMain" class="btn btn-default"  
		style="width: 155px; height: 50px;">마이페이지-메인으로</button>			
</div>



<div id="blank" style="height: 100px; margin-bottom: 100px;"> </div>

</div><!--<div class=main> end -->


<%@ include file="../layout/footer.jsp"%>