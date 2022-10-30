<%@page import="java.util.List"%>
<%@page import="dto.BoardInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="<%=request.getContextPath() %>/sources/admin/favicon.ico">
<meta charset="UTF-8">
<title>게시글 관리</title>

<%@ include file="./header.jsp" %>

<% List<BoardInfo> boardList = (List) request.getAttribute("boardList"); %>
<% String title = (String) request.getAttribute("title"); %>

<style type="text/css">
.configbutton {
	width: 100px;
	height: 30px;
	background-color: white;
	border: solid 1px #029EE4;
	color: #029EE4;
	margin: 10px;
	border-radius: 20px / 30px;
}
.admintable {
	width: 98%;
	height: 100px;
	margin-left: 10px;
}

th {
	border: 1px solid gray;
	text-align: center;
}

td {
	border: 1px solid gray;
	text-align: center;
}
</style>

<script type="text/javascript">
function deleteboard( url1, url2, url3 ) {
	location.href="<%=request.getContextPath() %>/admin/mainboard/delete?boardno=" + url1 + "&boardtitle=" + url2 + "&boardcontent=" + url3
}

</script>

</head>
<body>

<div class="up">
	<div class="lefttopbox">
	메뉴
	</div>
	<div class="righttopbox">
	게시글 관리
	</div>
</div>

<div class="down">
	<div class="leftbottombox">
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainnotice">공지사항</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainconfig">관리자 관리</a>
		</div>
		<div class="menubutton" style="background-color: #e9ecef">
			<a href="<%=request.getContextPath() %>/admin/mainboard">게시글 관리</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainuser">사용자 관리</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/management">관리자 로그</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/adminlogout">로그아웃</a>
		</div>
	</div>
	<div class="rightbottombox">
		<!-- 여기부터 달라진다 -->
		<br>
		<form action="<%=request.getContextPath() %>/admin/mainboard" method="get" style="display: inline;">
			<input type="search" style="margin-left: 10px; border-color: #029EE4" name="title" placeholder="제목" value="<%=title%>">
			<button>검색</button>
			<button type="button" onclick="location.href='/admin/mainboard'">초기화</button>
		</form>
		
		<br><br>
		<table class="admintable table table-striped table-hover table-condensed">
			<tr>
				<th class="text-center">번호</th>
				<th class="text-center">제목</th>
				<th class="text-center">본문</th>
				<th class="text-center">작성일자</th>
				<th class="text-center">수정일자</th>
				<th class="text-center">조회수</th>
				<th class="text-center">카테고리</th>
				<th class="text-center">작성자</th>
				<th class="text-center">삭제</th>
			</tr>
			<% for(int i=0; i<boardList.size(); i++) { %>			
			<tr>
				<td style="width: 5%"><%=boardList.get(i).getBoardNo() %></td>
				<td style="width: 5%"><%=boardList.get(i).getBoardTitle() %></td>
				<td style="width: 37%"><%=boardList.get(i).getBoardContent() %></td>
				<td style="width: 10%"><%=boardList.get(i).getBoardDate() %></td>
				<td style="width: 10%"><%=boardList.get(i).getBoardDate() %></td>
				<td style="width: 5%"><%=boardList.get(i).getBoardHit() %></td>
				<td style="width: 5%"><%=boardList.get(i).getCateno() %></td>
				<td style="width: 10%"><%=boardList.get(i).getUserId() %></td>
				<td style="width: 3%">
				<input type="button" value="삭제" onclick="deleteboard('<%=boardList.get(i).getBoardNo() %>', '<%=boardList.get(i).getBoardTitle() %>', '<%=boardList.get(i).getBoardContent() %>')"/>
				<!-- 자바스크립트 함수에 String 매개변수 넣을거면 꼭 ''으로 감싸줘야 한다. ""도 안됨. -->
				</td>
			</tr>
			<% } %>
		</table>
		<%@ include file="./paging3.jsp" %>
		
	</div>
</div>
</body>
</html>