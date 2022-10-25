<%@page import="dto.AdminInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="<%=request.getContextPath() %>/sources/admin/favicon.ico">
<meta charset="UTF-8">
<title>관리자 관리</title>

<%@ include file="./header.jsp" %>

<% List<AdminInfo> adminList = (List) request.getAttribute("adminList"); %>
<% String userid = (String) request.getAttribute("userid"); %>

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
function createadmin() {
 
    var _width = '600';
    var _height = '300';
 
    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
    var _left = Math.ceil(( window.screen.width - _width )/2);
    var _top = Math.ceil(( window.screen.height - _height )/2); 
 
	// 이거 위치조정 왜 안되냐??
    window.open('<%=request.getContextPath() %>/admin/addadmin', 'addadmin', 'width='+ _width +',height='+ _height +',left='+ _left +',top='+ _top );
 
}

function deleteadmin() {
	 
	    var _width = '600';
	    var _height = '300';
	 
	    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
	    var _left = Math.ceil(( window.screen.width - _width )/2);
	    var _top = Math.ceil(( window.screen.height - _height )/2); 
	 
	    window.open('<%=request.getContextPath() %>/admin/deladmin', 'deladmin', 'width='+ _width +',height='+ _height +',left='+ _left +',top='+ _top );
	 
}
</script>

</head>
<body>

<div class="up">
	<div class="lefttopbox">
	메뉴
	</div>
	<div class="righttopbox">
	관리자 관리
	</div>
</div>

<div class="down">
	<div class="leftbottombox">
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainnotice">공지사항</a>
		</div>
		<div class="menubutton" style="background-color: #e9ecef">
			<a href="<%=request.getContextPath() %>/admin/mainconfig">관리자 관리</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainboard">게시글 관리</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainuser">사용자 관리</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/adminlogout">로그아웃</a>
		</div>
	</div>
	<div class="rightbottombox">
		<!-- 여기부터 달라진다 -->
		
		<button class="configbutton" onclick="createadmin();">관리자 추가</button>
		<button class="configbutton" onclick="deleteadmin();">관리자 삭제</button>
		<form action="<%=request.getContextPath() %>/admin/mainconfig" method="get" style="display: inline;">
			<!-- 이거 테두리 어떻게 음영 지우지?? -->
			<input type="search" style="margin-left: 10px; border-color: #029EE4" name="userid" placeholder="아이디" value="<%=userid%>">
			<button>검색</button>
			<button type="button" onclick="location.href='/admin/mainconfig'">초기화</button>
		</form>
		<br>
		<table class="admintable table table-striped table-hover table-condensed">
			<tr>
				<th class="text-center">번호</th>
				<th class="text-center">아이디</th>
				<th class="text-center">생성일자</th>
				<th class="text-center">비고</th>
			</tr>
			<% for(int i=0; i<adminList.size(); i++) { %>			
			<tr>
				<td style="width: 5%"><%=adminList.get(i).getAdminNo() %></td>
				<td style="width: 10%"><%=adminList.get(i).getAdminId() %></td>
				<td style="width: 15%"><%=adminList.get(i).getAdminDate() %></td>
				<td style="width: 70%"></td>
			</tr>
			<% } %>
		</table>
		<%@ include file="./paging.jsp" %>
		
		<!-- 여기부터 달라진다 -->
	</div>
</div>
</body>
</html>