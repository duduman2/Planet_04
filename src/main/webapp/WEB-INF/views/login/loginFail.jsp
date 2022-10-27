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

body{margin: 0 auto; text-align: center;}

a{text-decoration: none;}

div{
	position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}

fieldset {
	border: 1px solid #5B9E28;
	text-align: center;
	width: 450px;
}

a{color:#5B9E28; font-weight: bold;}

</style>

</head>
<body>

<div style="display: inline-block;">

<fieldset>
	<br><br><h1 style="color: red;">로그인 실패</h1><br>
	<hr><br><br>
	
	<h3>ID와 PASSWORD를 다시 확인하세요</h3><br><br>
	
	<a href="/main" style="margin-right: 20px;">메인화면</a>
	<a href="/login/con">로그인 페이지</a><br><br><br>
	
</fieldset>

</div>

</body>
</html>