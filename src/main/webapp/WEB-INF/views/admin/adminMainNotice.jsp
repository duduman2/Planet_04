<%@page import="java.util.List"%>
<%@page import="dto.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Boolean result = (Boolean) request.getAttribute("result"); %>
<% String title = (String) request.getAttribute("title"); %>
<% String admin_id = (String) request.getAttribute("admin_id"); %>
<% List<Notice> noticeList = (List) request.getAttribute("noticeList"); %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="<%=request.getContextPath() %>/sources/admin/favicon.ico">
<meta charset="UTF-8">
<title>공지사항</title>

<%@ include file="./header.jsp" %>

<style type="text/css">
.hide {
	display: none;
}
.configbutton {
	width: 120px;
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

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	var result = <%=request.getAttribute("result")%>
	
	let elInputSearch1 = document.querySelector('#search1');
	let elInputSearch2 = document.querySelector('#search2');
	
	console.log(result);

		$("select[name=category]").change(function(){
			var selectcategory = $(this).val();
			// console.log($(this).val()); //value값 가져오기
			// console.log($("select[name=category] option:selected").text()); //text값 가져오기
			
			if(selectcategory == 'title') {
				elInputSearch2.classList.add('hide');
				elInputSearch1.classList.remove('hide');
			} else {
				elInputSearch1.classList.add('hide');
				elInputSearch2.classList.remove('hide');
			}
			
		});
	
})

function createnotice() {
	
	const width = 800;
	const height = 650;
	let left = (document.body.offsetWidth / 2) - (width / 2);
	let tops = (document.body.offsetHeight / 2) - (height / 2);
	left += window.screenLeft;
	const popup = window.open('<%=request.getContextPath() %>/admin/crenotice', 'crenotice', 'width='+ width +',height='+ height +',left='+ left +',top='+ tops);
	 
}
</script>

</head>
<body>

<div class="up">
	<div class="lefttopbox">
	메뉴
	</div>
	<div class="righttopbox">
	공지사항
	</div>
</div>

<div class="down">
	<div class="leftbottombox">
		<div class="menubutton" style="background-color: #e9ecef">
			<a href="<%=request.getContextPath() %>/admin/mainnotice">공지사항</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainconfig">관리자 관리</a>
		</div>
		<div class="menubutton">
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
			<button class="configbutton" onclick="createnotice();">공지사항 작성</button>
			
			<%if(result == true) {%>
			<select name="category">
		    	<option selected value="title">제목</option>
		    	<option value="admin_id">작성자</option>
			</select>
			<form id=search1 action="<%=request.getContextPath() %>/admin/mainnotice" method="get" style="display: inline;">
				<input type="search" style="margin-left: 10px; border-color: #029EE4" name="title" placeholder="제목" value="<%=title%>">
				<button>검색</button>
				<button type="button" onclick="location.href='/admin/mainnotice'">초기화</button>
			</form>
			<form id=search2 class="hide" action="<%=request.getContextPath() %>/admin/mainnotice2" method="get" style="display: inline;">
				<input type="search" style="margin-left: 10px; border-color: #029EE4" name="admin_id" placeholder="작성자" value="">
				<button>검색</button>
				<button type="button" onclick="location.href='/admin/mainnotice'">초기화</button>
			</form>
			<%} else {%>
			<select name="category">
				<option value="title">제목</option>
				<option selected value="admin_id">작성자</option>
			</select>
			<form id=search1 class="hide" action="<%=request.getContextPath() %>/admin/mainnotice" method="get" style="display: inline;">
				<input type="search" style="margin-left: 10px; border-color: #029EE4" name="title" placeholder="제목" value="">
				<button>검색</button>
				<button type="button" onclick="location.href='/admin/mainnotice'">초기화</button>
			</form>
			<form id=search2 action="<%=request.getContextPath() %>/admin/mainnotice2" method="get" style="display: inline;">
				<input type="search" style="margin-left: 10px; border-color: #029EE4" name="admin_id" placeholder="작성자" value="<%=admin_id%>">
				<button>검색</button>
				<button type="button" onclick="location.href='/admin/mainnotice'">초기화</button>
			</form>
			<%}%>
			
			
			<br>
			<table class="admintable table table-striped table-hover table-condensed">
			<tr>
				<th class="text-center">번호</th>
				<th class="text-center">조회수</th>
				<th class="text-center">제목</th>
				<th class="text-center">본문</th>
				<th class="text-center">작성일자</th>
				<th class="text-center">관리자</th>
			</tr>
			<% for(int i=0; i<noticeList.size(); i++) { %>			
			<tr>
				<td style="width: 5%"><%=noticeList.get(i).getNotice_no() %></td>
				<td style="width: 5%"><%=noticeList.get(i).getHit() %></td>
				<td style="width: 10%">
					<a href="/admin/mainnotice/view?notice_no=<%=noticeList.get(i).getNotice_no() %>"><%=noticeList.get(i).getTitle() %>
					</a>
				</td>
				<td style="width: 60%"><%=noticeList.get(i).getNotice_content() %></td>
				<td style="width: 10%"><%=noticeList.get(i).getInsert_dat() %></td>
				<td style="width: 10%"><%=noticeList.get(i).getAdmin_id() %></td>
			</tr>
			<% } %>
		</table>
		
		<%if(result == true) {%>
			<%@ include file="./noticepaging.jsp" %>
		<%} else {%>
			<%@ include file="./noticepaging1.jsp" %>
		<%}%>
			
		<!-- 여기부터 달라진다 -->
	</div>
</div>
<%@ include file="./footer.jsp" %>