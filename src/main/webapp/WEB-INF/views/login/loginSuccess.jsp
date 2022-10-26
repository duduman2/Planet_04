<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 파비콘 -->
<link rel="icon" href="/sources/admin/logo.png">

<style type="text/css">

h1{color: blue; text-align: center;}

h2{display: none;}

div{
	position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    padding-top: 40px;
    padding-bottom: 40px;
    padding-right: 70px;
    padding-left: 70px;
    border: 1px solid #5B9E28;
    text-align: center;
}

a{color:#5B9E28; font-weight: bold; text-decoration: none;}

</style>

</head>
<body>

<div>
	<h1>로그인 성공</h1><br>
	<hr><br><br>
	
	<h2>로그인 상태 : <%=session.getAttribute("login") %></h2>
	
	<h3><%=session.getAttribute("loginid") %>님, 로그인되었습니다</h3><br><br>
	
	<a href="/main" style="margin-left: 15px;">메인 화면</a>
	<a href="/logout/con">로그아웃</a><br>
	
</div>

</body>
</html>