<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 관리</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/admin/addadmin" method="post">
	<div style="color: #029EE4; font-size: 1.2em">관리자 생성<br><br></div>
	<input type="text" name="userid" placeholder="아이디"><br><br>
	<input type="password" name="userpw" placeholder="비밀번호"><br><br>
	<button>생성</button>
</form>

</body>
</html>