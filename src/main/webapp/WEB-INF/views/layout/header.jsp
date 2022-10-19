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
// 	$(".category").on("click", )
	
// 	click(function() {
// 		$("ul.nav2 > li > ul > li").addClass({
// 			"height":"40px"
// 			, "width" : "280px"
// 			, "font-size" : "15px"
// 			, "line-height" : "40px"
// 			, "text-decoration" : "none"})})
	
// 		, function() {
// 			$("ul.nav2 > li > ul > li").css({
// 				"height":"0px"
// 				, "font-size" : "0px"
// 				, "line-height" : "0px"})})
	
})
</script>

<style type="text/css">


/* --- jQuery Class --- */
.green {
	color : green !important;
	font-weight: bold !important;
}

.viewmenu {
	height: 40px;
	width: 280px;
	font-size: 15px;
	line-height: 40px;
	text-decoration: none;
}

.hidemenu {
	height: 0px;
	font-size: 0px;
	line-height: 0px;
}
/* --------------------- */


/* --- BootStrap 무시 --- */
li > a {
	color: black;
}

li > a:hover {
	text-decoration : none;
}
/* --------------------- */


#nav0 {
	width: 1140px;
	height: 100px;
	margin: 0 auto;
}

#logo {
	float:left;
	font-size: 40px;
	font-style:italic;
	font-weight: bold;
	text-align: left;
}

#logo > a {
	color: green;
	text-decoration: none;
}

#top-menu {
	float: left;
	width: 1140px;
	height: 60px;
}

.category {
	width: 150px !important;
	text-align: left !important;
}

.store {
	float: left;
	margin: 15px 0 0 30px;
	font-size: 18px;
	font-weight: bold;
	color: green;
}

.store > button {
	border: none;
	background: none;
}

.search {
	float: left;
	width: 600px;
	margin: 16px 0 0 40px;
}

#searchType {
	float: left;
}

#sec-menu {
	clear: both;
}

ul.nav1 {
	list-style-type: none;
	padding: 0;
	margin: 16px 0;
	float: left;
}

ul.nav1 > li {
	float: left;
}
ul.nav1-2 {
	list-style-type: none;
	padding: 0;
	margin: 16px 0;
	float: right;
}

ul.nav1-2 > li {
	float: left;
	font-size: 20px;
	padding: 0 5px;
	position: relative;
}

ul.nav1-2 > li > ul {
	position: absolute;
	list-style-type: none;
	padding: 0;
	margin: 0;
}

ul.nav1-2 > li > ul > li {
	height: 0;
	font-size: 0;
	line-height: 0;
	z-index: 9999;
}

ul.nav1-2 > li:hover > ul > li {
	width: 100px;
	height: 40px;
	font-size: 15px;
	line-height: 40px;
	
	background: gray;
	
	text-align: left;
	
	text-decoration: none;
}

.write {
	float: right;
	margin: 16px 5px;
}

ul.nav2 {
	list-style-type: none;
	padding: 0;
	margin: 0;
}

ul.nav2 > li {
	float: left;
	border-right: 1px solid #d9d9d9;
	width: 200px;
	font-size: 18px;
	letter-spacing: -1px;
	text-align: center;
	position: relative;
}

ul.nav2 > li > ul {
	position: absolute;
	list-style-type: none;
	padding: 0;
	margin: 0;
}

ul.nav2 > li > ul > li {
	height: 0;
	font-size: 0;
	line-height: 0;
}

ul.nav2 > li:hover > ul > li {
	height: 40px;
	width: 200px;
	padding-left: 10px;
	font-size: 15px;
	letter-spacing: -1px;
	text-align: left;
	line-height: 40px;
	background: lightgray;

	text-decoration: none;
}

.headerhr {
	margin-top: 0;
	margin-bottom: 0px;
}

footer {
	clear: both;
}

</style>

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
		<li>
			<span class="glyphicon glyphicon-bell"></span>
		</li>
		
		<!-- 비로그인 상태 -->
		<% if( null == session.getAttribute("login") || !(Boolean) session.getAttribute("login") ) { %>
		<button type="button" onclick="location.href='/'" class="btn btn-success">로그인</button>
		<% } %>
		
		<!-- 로그인 상태 -->
		<% if( null != session.getAttribute("login") && (Boolean) session.getAttribute("login") ) { %>
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