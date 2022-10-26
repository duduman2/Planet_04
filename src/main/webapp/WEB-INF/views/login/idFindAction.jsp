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

body{margin: 0 auto;}

div{position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    text-align:center;
    padding-top: 40px;
    padding-bottom: 40px;
    padding-right: 70px;
    padding-left: 70px;
    border: 1px solid #5B9E28;
}

h1{color:#5B9E28;}

</style>

</head>
<body>

<div>

<h1>아이디 찾기 결과</h1><br>

<hr><br>

<h3>아이디는 <%=((UserInfo)request.getAttribute("u_id")).getU_id() %>입니다.</h3>


</div>

</body>
</html>