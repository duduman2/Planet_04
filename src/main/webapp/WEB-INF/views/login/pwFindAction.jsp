<%@page import="dto.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 파비콘 -->
<link rel="icon" href="/sources/favicon.ico">

<style type="text/css">

body{margin: 0 auto; width: 900px; height:1000px;}

h1{color:#5B9E28;}

a{color:#5B9E28; font-weight: bold; text-decoration: none;} 


div{
	position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);}
    

fieldset {
	border: 1px solid #5B9E28;
	text-align: center;
	width: 450px;
}

</style>

</head>
<body>

<div style="display: inline-block;">
<fieldset>
<br><br><h1>비밀번호 찾기 결과</h1><br>

<hr><br>

<h3>비밀번호는 <%=((UserInfo)request.getAttribute("u_pw")).getU_pw() %>입니다.</h3><br>

<a href="/login/con" style="margin-right: 20px;">로그인</a>
<a href="/main">메인 페이지</a><br><br><br>


</fieldset>
</div>

</body>
</html>