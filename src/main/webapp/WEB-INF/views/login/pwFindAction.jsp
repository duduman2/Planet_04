<%@page import="dto.UserInfo"%>
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

div{
	position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);}

</style>

</head>
<body>

<div>

<h1 style="margin: 0 auto; text-align:center; color: #5B9E28;">비밀번호 찾기 결과</h1><br><br>

<h3 style="margin: 0 auto; text-align:center;">비밀번호는 <%=((UserInfo)request.getAttribute("u_pw")).getU_pw() %>입니다.</h3>


</div>

</body>
</html>