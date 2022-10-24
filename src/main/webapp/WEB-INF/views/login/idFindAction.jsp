<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>

<form method="post" action="/id/find">
<h1 style="text-align:center; color: #5B9E28;">아이디 찾기 결과</h1>

<h3>회원님의 아이디는 <%=session.getAttribute("u_id")  %> 입니다.</h3>

</form>

</div>

</body>
</html>