<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnCancel").click(function() {
		$(location).attr('href', '/main') //메인으로 가기
	})

}
</script>

</head>
<body>

<button id="btnLogout">로그아웃</button>

<%
//Cookie user = new Cookie("id", "");
session.invalidate();//세션의 모든 속성 제거
response.sendRedirect("/main");
%>


</body>
</html>