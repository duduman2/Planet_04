<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 메뉴 스타일 css -->
<!-- <link rel="stylesheet" type="text/css" href="../sources/main/menuStyle.css"> -->

<!-- 파비콘 -->
<link rel="icon" href="/favicon.ico" type="../sources/admin/favicon">

<style type="text/css">

/* --- jQuery Class --- */
.green {
	color : green !important;
	font-weight: bold !important;
}

.gray {
	background-color : gray;
}

/* --------------------- */

#logo {
	float:left;
}

#top-menu {
	width: 1140px;
	height: 60px;
	margin: 0 auto;
}

.btn_login {
    background-color: #5B9E28;
    border-radius: 7px;
    border: thin solid #5B9E28;
    font-weight: bold;
    color: white;
    height: 26px;
}

.btn_search {
    background-color: #5B9E28;
    border-radius: 0 7px 7px 0;
    font-weight: bold;
    color: white;
    height: 26px;
    border : none;
    float: left;
}

.btn_write {
background-color: #5B9E28;
    border-radius: 0 7px 7px 0;
    font-weight: bold;
    color: white;
    height: 26px;
    border : none;
    float: left;
}

.btn_cart {
	background-color: white;
	border: none;
}

#keywordInput {
    width: 350px;
    height: 22px;
    float: left;
    border: 1px solid #5B9E28;
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
	font-size: 18px;
	font-weight: bold;
	color: green;
}

.search {
	float: left;
	width: 500px;
	margin: 16px 0 0 20px;
}

#searchType {
	float: left;
	border: 1px solid #5B9E28;
}

#sec-menu {
	width: 1140px;
	height: 27px;
	margin: 0 auto;

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
	padding: auto 0;
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
	font-size: 16px;
	letter-spacing: -1px;
	text-align: center;
	position: relative;
}

ul.nav2 > li > a {
	text-decoration: none;
	color: black;
}

ul.nav2 > li > ul > li > a {
	text-decoration: none;
	color: black;
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
	width: 190px;
	padding-left: 10px;
	font-size: 15px;
	letter-spacing: -1px;
	text-align: left;
	line-height: 40px;
	background: lightgray;
	text-decoration: none;
}

.headerhr {
	border: 1px solid #f3f3f3;
	
}

.container {
	width: 1140px;
	margin: 0 auto;
}

footer {
	clear: both;
    text-align: center;
    font-size: 13px;
}

.view {
	height: 40px !important;
	width: 190px;
	padding-left: 10px;
	font-size: 15px !important;
	letter-spacing: -1px;
	text-align: left;
	line-height: 40px !important;
	background: lightgray;
	text-decoration: none;
}

ul.allmenu > li {
	width: 1000px !important;
}

li.category:hover {
	color : green;
	font-weight: bold;
}
</style>

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
	
	//전체메뉴에 마우스오버시 전체메뉴 보이기
	$(".category").mouseover(function() {
		$(".cate_list > ul > li").addClass('view')
	})
	
	//전체메뉴에 마우스오버 해제 시 전체메뉴 숨기기
	$(".category").mouseleave(function() {
		$(".cate_list > ul > li").removeClass('view')
	})
	
})
</script>

<title></title>

</head>

<body>

<header id="header">
<div id="top-menu">
	<div id="logo"><a href="/main"><img src="../sources/admin/logo.png" style="height:60px;"></a></div>
	<div class="store"> | <button onclick="location.href='/tradeboard'">플래닛 스토어</button></div>
	<div class="search">
		<form action="/search" method="post">
			<select name="searchType" id="searchType" style="height:26px;">
				<option value="a">통합검색</option>
				<option value="t">제목</option>
				<option value="c">본문</option>
				<option value="n">작성자</option>
			</select>
			<input type="text" placeholder="검색어를 입력하세요"
				id="keywordInput" name="keywordInput">
			<button class="btn_search" onclick="location.href='/search'">
				<img src="../sources/main/img/search.png" style="height:18px;">
			</button>
		</form>
	</div>
	
	<ul class="nav1-2">
		<li>
			<button onclick="location.href='/cart/list'" class="btn_cart"><img src="../sources/main/img/shopping-cart.png" style="height:20px;"></button>
		</li>
		
		<!-- 비로그인 상태 -->
		<% if( null == session.getAttribute("login") || !(Boolean) session.getAttribute("login") ) { %>
		<li>
			<button onclick="location.href='/login/con'" class="btn_login">로그인</button>
		</li>
		<% } %>
		
		<!-- 로그인 상태 -->
		<% if( null != session.getAttribute("login") && (Boolean) session.getAttribute("login") ) { %>
		<li>
			<img src="../sources/main/img/bell.png" style="height:20px;">
		</li>
		<li>
			<img src="../sources/main/img/user.png" style="height:20px;">
			<ul>
				<li><a>마이페이지</a></li>
				<li><a>나의 쇼핑</a></li>
				<li><a>내가 쓴 글</a></li>
				<li><a>회원 탈퇴</a></li>
			</ul>
		</li>
		<li>
			<button onclick="location.href='/login/con'" class="btn_login">로그아웃</button>
		</li>
		<li>
			<button type="button" class="btn_login">게시글 작성</button>
		</li>
		<% } %>
	</ul>
	
	
</div><!-- top-menu end -->
<hr class="headerhr">
<div id="sec-menu">
	<ul class="nav2">
		<li class="category">
		<img src="../sources/main/img/menu-burger.png" style="height:20px;"> 전체메뉴
			<ul class="allmenu">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</li>
		
		<li class="cate_list">
			<a href="/board/main.jsp">커뮤니티</a>
			<ul>
				<li><a href="/board/main.jsp">일반 게시판</a></li>
				<li><a href="/board/main.jsp">자랑하기</a></li>
				<li><a href="/board/main.jsp">소품 추천</a></li>
				<li><a href="/board/main.jsp">인테리어 후기</a></li>
				<li><a href="/board/main.jsp">모임 게시판</a></li>
			</ul>
		</li>
		
		<li class="cate_list">
			<a href="/board/main.jsp">Q&A</a>
			<ul>
				<li><a href="/board/main.jsp">일반 게시판</a></li>
				<li><a href="/board/main.jsp">자랑하기</a></li>
				<li><a href="/board/main.jsp">소품 추천</a></li>
				<li><a href="/board/main.jsp">인테리어 후기</a></li>
				<li><a href="/board/main.jsp">모임 게시판</a></li>
			</ul>
		</li>
		
		<li style="border:none;" class="cate_list">
			<a href="/trade">분양/중고거래</a>
			<ul>
				<li><a href="/board/main.jsp">일반 게시판</a></li>
				<li><a href="/board/main.jsp">자랑하기</a></li>
				<li><a href="/board/main.jsp">소품 추천</a></li>
				<li><a href="/board/main.jsp">인테리어 후기</a></li>
				<li><a href="/board/main.jsp">모임 게시판</a></li>
			</ul>
		</li>
	</ul>
</div><!-- sec-menu end -->
<hr class="headerhr">
</header>

<div class="container">