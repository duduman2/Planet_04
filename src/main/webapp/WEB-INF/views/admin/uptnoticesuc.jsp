<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

alert("작업이 완료되었습니다.")

var url = "<%=request.getContextPath() %>/admin/mainnotice";

location.href = url; // 해당 url로 리다이렉트

</script>

</head>
<body>

</body>
</html>