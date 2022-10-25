<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="<%=request.getContextPath() %>/sources/admin/favicon.ico">
<meta charset="UTF-8">
<title>게시글 관리</title>

<%@ include file="./header.jsp" %>

<style type="text/css">
.configbutton {
	width: 100px;
	height: 30px;
	background-color: white;
	border: solid 1px #029EE4;
	color: #029EE4;
	margin: 10px;
	border-radius: 20px / 30px;
}
</style>

</head>
<body>

<div class="up">
	<div class="lefttopbox">
	메뉴
	</div>
	<div class="righttopbox">
	게시글 관리
	</div>
</div>

<div class="down">
	<div class="leftbottombox">
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainnotice">공지사항</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainconfig">관리자 관리</a>
		</div>
		<div class="menubutton" style="background-color: #e9ecef">
			<a href="<%=request.getContextPath() %>/admin/mainboard">게시글 관리</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainuser">사용자 관리</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/adminlogout">로그아웃</a>
		</div>
	</div>
	<div class="rightbottombox">
		<!-- 여기부터 달라진다 -->
		<!-- 여기부터 달라진다 -->
	</div>
</div>
</body>
</html>