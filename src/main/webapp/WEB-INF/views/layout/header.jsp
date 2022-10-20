<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PLanet</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- 메뉴 스타일 css -->
<link rel="stylesheet" type="text/css" href="../sources/main/menuStyle.css">

<script type="text/javascript">
$(document).ready(function() {
	
	//마우스오버시 메뉴 색 변경
	$("li > a").mouseover(function() {
		$(this).addClass('green')
	})
	
	//마우스오버 해제 시 메뉴 색 원래대로
	$("li > a").mouseleave(function() {
		$(this).removeClass('green')
	})
	
	//전체메뉴 보기
	
})
</script>


</head>
<body>

<header id="header" class="text-center">

<div id="nav0">

<div id="top-menu">
	<div id="logo"><a href="/main">PLanet</a></div>
	<div class="store"> | <button onclick="location.href='/tradeboard'">플래닛 스토어</button></div>
	<div class="search">
		<form action="/search" method="post">
			<select name="searchType" id="searchType" style="height:26px;">
				<option value="a">통합검색</option>
				<option value="t">제목</option>
				<option value="c">내용</option>
				<option value="n">작성자</option>
			</select>
			<input type="text" style="width:450px; float:left;" placeholder="검색어를 입력하세요"
				id="keywordInput" name="keywordInput">
			<button typel="button" style="float:left;">
				<span class="glyphicon glyphicon-search"></span>
			</button>
		</form>
	</div>
	
	<!-- 로그인 상태 -->
	<% if( null != session.getAttribute("login") && (Boolean) session.getAttribute("login") ) { %>
	<button type="button" class="write btn btn-success">게시글 작성</button>
	<% } %>

	<ul class="nav1-2">
		<li>
			<span class="glyphicon glyphicon-shopping-cart"></span>
		</li>
		
		<!-- 비로그인 상태 -->
		<% if( null == session.getAttribute("login") || !(Boolean) session.getAttribute("login") ) { %>
		<button type="button" onclick="location.href='/login/con'" class="btn btn-success">로그인</button>
		<% } %>
		
		<!-- 로그인 상태 -->
		<% if( null != session.getAttribute("login") && (Boolean) session.getAttribute("login") ) { %>
		<li>
			<span class="glyphicon glyphicon-bell"></span>
		</li>
		<li>
			<span class="glyphicon glyphicon-user"></span>
			<ul>
				<li><a>마이페이지</a></li>
				<li><a>나의 쇼핑</a></li>
				<li><a>내가 쓴 글</a></li>
				<li><a>회원 탈퇴</a></li>
			</ul>
		</li>
		<button onclick="location.href='/login/logout'">로그아웃</button>
		<% } %>
	</ul>
	
	
</div>

<div id="sec-menu">
	<ul class="nav2">
		<li class="category">
		<span class="glyphicon glyphicon-menu-hamburger">전체메뉴</span></li>
		
		<li>
			<a href="/board/main.jsp">커뮤니티</a>
			<ul>
				<li><a href="/board/main.jsp">일반 게시판</a></li>
				<li><a href="/board/main.jsp">자랑하기</a></li>
				<li><a href="/board/main.jsp">소품 추천</a></li>
				<li><a href="/board/main.jsp">인테리어 후기</a></li>
				<li><a href="/board/main.jsp">모임 게시판</a></li>
			</ul>
		</li>
		
		<li>
			<a href="/board/main.jsp">노하우</a>
			<ul>
				<li><a href="/board/main.jsp">일반 게시판</a></li>
				<li><a href="/board/main.jsp">자랑하기</a></li>
				<li><a href="/board/main.jsp">소품 추천</a></li>
				<li><a href="/board/main.jsp">인테리어 후기</a></li>
				<li><a href="/board/main.jsp">모임 게시판</a></li>
			</ul>
		</li>
		
		<li style="border:none;">
			<a href="/board/main.jsp">분양/중고거래</a>
			<ul>
				<li><a href="/board/main.jsp">일반 게시판</a></li>
				<li><a href="/board/main.jsp">자랑하기</a></li>
				<li><a href="/board/main.jsp">소품 추천</a></li>
				<li><a href="/board/main.jsp">인테리어 후기</a></li>
				<li><a href="/board/main.jsp">모임 게시판</a></li>
			</ul>
		</li>
	</ul>
</div>
</div>
</header>
<hr class="headerhr">
<div class="container">