<%@page import="dto.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Notice viewNotice = (Notice) request.getAttribute("viewNotice"); %>

<%@ include file="./header.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<style type="text/css">
#header, #footer {
	background: #f6f;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnList").click(function() {
		$(location).attr("href", "../mainnotice")
	})
	
})
</script>
</head>
<body>


<header id="header" class="text-center">
</header>

<div class="container">

<h1>공지 상세보기</h1>
<hr>

<table class="table table-bordered">

<tr>
	<td class="info">글번호</td>
	<td><%=viewNotice.getNotice_no() %></td>
	
	<td class="info">작성일</td>
	<td><%=viewNotice.getInsert_dat() %></td>
</tr>

<tr>
	<td class="info">아이디</td>
	<td><%=viewNotice.getAdmin_id() %></td>
	
	<td class="info">조회수</td>
	<td colspan="4"><%=viewNotice.getHit() %>
</tr>

<tr>
	<td class="info">제목</td>
	<td colspan="3"><%=viewNotice.getTitle() %></td>
</tr>

<tr>
	<td class="info" colspan="4">본문</td>
</tr>

<tr>
	<td colspan="4"><%=viewNotice.getNotice_content() %></td>
</tr>

</table>

<div class="text-center">
	<button id="btnList" class="btn btn-primary">목록</button>
	<button id="btnUpdate" class="btn btn-info">수정</button>
	<button id="btnDelete" class="btn btn-danger">삭제</button>
</div>

</body>
</html>