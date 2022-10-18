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
	$("li").mouseover(function() {
		$(this).attr("style", "color : green;")
	})
	
	//마우스오버 해제 시 메뉴 색 원래대로
	$("li").mouseleave(function() {
		$(this).attr("style", "color : black;")
	})
})
</script>

<!-- 추후 css따로 뺄 예정 -->
<!-- <link rel="stylesheet" type="text/css" href="/css/menu-style.css"> -->

<style type="text/css">
#logo {
	float:left;
	width: 200px;
	border: 1px solid green;
}

#top-menu {
	box-sizing:border-box;
	float: left;
}

#sec-menu {
	clear: both;
}

ul.nav1 {
	list-style-type: none;
	padding: 0;
	margin: 0;
}

ul.nav1 > li {
	float: left;
	border: 1px solid green;
}

ul.nav2 {
	list-style-type: none;
	padding: 0;
	margin: 0;
}

ul.nav2 > li {
	float: left;
	border: 1px solid green;
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
	font-size: 15px;
	line-height: 40px;

	text-decoration: none;
}

</style>

</head>
<body>

<header id="header" class="text-center">

<div id="logo">PLanet</div>

<div id="top-menu">
	<ul class="nav1">
		<li>스토어</li>
		<li>검색</li>
		<li>장바구니</li>
		<li>마이페이지</li>
	</ul>
</div>

<div id="sec-menu">
	<ul class="nav2">
		<li>전체메뉴</li>
		
		<li>
			<a>커뮤니티</a>
			<ul>
				<li><a>일반 게시판</a></li>
				<li><a>자랑하기</a></li>
				<li><a>소품 추천</a></li>
				<li><a>인테리어 후기</a></li>
				<li><a>모임 게시판</a></li>
			</ul>
		</li>
		
		<li>
			<a>노하우</a>
			<ul>
				<li><a>일반 게시판</a></li>
				<li><a>자랑하기</a></li>
				<li><a>소품 추천</a></li>
				<li><a>인테리어 후기</a></li>
				<li><a>모임 게시판</a></li>
			</ul>
		</li>
		
		<li>
			<a>분양/중고거래</a>
			<ul>
				<li><a>일반 게시판</a></li>
				<li><a>자랑하기</a></li>
				<li><a>소품 추천</a></li>
				<li><a>인테리어 후기</a></li>
				<li><a>모임 게시판</a></li>
			</ul>
		</li>
	</ul>
</div>

</header>
<div class="container">