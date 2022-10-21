<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 관리</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/admin/srhuser" method="post">
	<div style="color: #029EE4; font-size: 1.2em">사용자 검색<br><br></div>
	<input type="text" name="userid" placeholder="아이디"><br><br>
	<button>검색</button>
</form>

</body>
</html>