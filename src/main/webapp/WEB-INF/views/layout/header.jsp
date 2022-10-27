<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 메뉴 스타일 css -->
<link rel="stylesheet" type="text/css" href="../sources/main/menuStyle.css">

<!-- 파비콘 -->
<link rel="icon" href="../sources/admin/favicon.ico">

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
		<li style="margin-top:-3px;">
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
				<li><a href="/mypage/main">마이페이지</a></li>
				<li><a href="/user/info">설정</a></li>
				<li><a>내가 쓴 글</a></li>
			</ul>
		</li>
		<li style="margin-top:-3px;">
			<button onclick="location.href='/logout/con'" class="btn_login">로그아웃</button>
		</li>
		<li style="margin-top:-3px;">
			<button type="button" class="btn_login">게시글 작성</button>
		</li>
		<% } %>
	</ul>
	
	
</div><!-- top-menu end -->
<hr class="headerhr">
<div id="sec-menu">
	<ul class="nav2">
		<li class="category">
		<img src="../sources/main/img/menu-burger.png" style="height:17px;"> 전체메뉴
			<ul class="allmenu">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</li>
		
		<li class="cate_list">
			<a href="/board/list">커뮤니티</a>
			<ul>
				<li><a href="/board/list">일반 게시판</a></li>
				<li><a href="/board/list">자랑하기</a></li>
				<li><a href="/board/list">소품 추천</a></li>
				<li><a href="/board/list">인테리어 후기</a></li>
				<li><a href="/board/list">모임 게시판</a></li>
			</ul>
		</li>
		
		<li class="cate_list">
			<a href="/board/list">Q&A</a>
			<ul>
				<li><a href="/board/list">일반 게시판</a></li>
				<li><a href="/board/list">자랑하기</a></li>
				<li><a href="/board/list">소품 추천</a></li>
				<li><a href="/board/list">인테리어 후기</a></li>
				<li><a href="/board/list">모임 게시판</a></li>
			</ul>
		</li>
		
		<li style="border:none;" class="cate_list">
			<a href="/trade">분양/중고거래</a>
			<ul>
            <li><a href="/trade?cate=air">관엽/공기정화식물</a></li>
            <li><a href="/trade?cate=cac">다육/선인장</a></li>
            <li><a href="/trade?cate=wild">야생화</a></li>
            <li><a href="/trade?cate=bon">분재</a></li>
            <li><a href="/trade?cate=orc">동양란/서양란</a></li>
            <li><a href="/trade?cate=pot">화분</a></li>
            <li><a href="/trade?cate=mate">원예자재류</a></li>
			</ul>
		</li>
	</ul>
</div><!-- sec-menu end -->
<hr class="headerhr">
</header>

<div class="container">