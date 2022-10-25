<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>

<script type="text/javascript">

var url = "<%=request.getContextPath() %>/adminlogin";

alert("아이디 또는 비밀번호가 틀립니다.")

location.href = url; // 해당 url로 리다이렉트

</script>

</head>
<body>

</body>
</html>