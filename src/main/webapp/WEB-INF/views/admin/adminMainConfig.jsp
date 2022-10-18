<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 관리</title>

<style type="text/css">

html, body {
	height: 100%;
}

.up {
	display: flex;
}

.down {
	display: flex;
	height: 100%;
}

.lefttopbox {
	width: 250px;
	height: 50px;
	background-color: #239600;
	color: white;
	
	display: flex;
	align-items: center; /* flex 수직 정렬 */
	padding-left: 10px;
	margin-right: 10px;
	margin-bottom: 10px;
}

.righttopbox {
	width: 100%;
	height: 50px;
	background-color: #239600;
	color: white;
	
	display: flex;
	align-items: center; /* flex 수직 정렬 */
	padding-left: 10px;
}

.leftbottombox {
	width: 248px;
	height: 100%;
	background-color: white;
	color: white;
	border: solid 1px gray;
	
	display: flex;
	padding-left: 10px;
	margin-right: 10px;
	margin-bottom: 10px;
}

.rightbottombox {
	width: 100%;
	height: 100%;
	background-color: white;
	color: white;
	border: solid 1px gray;
	
	display: flex;
	padding-left: 10px;
}

/* --- --- ---*/

.configbutton {
	width: 100px;
	height: 30px;
	background-color: white;
	border: solid 1px #029EE4;
	color: #029EE4;
	margin: 10px;
}

.configbutton:hover {
	cursor: pointer;
}

</style>

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
	</div>
	<div class="rightbottombox">
		<button class="configbutton">관리자 추가</button>
		<button class="configbutton">관리자 삭제</button>
	</div>
</div>

</body>
</html>