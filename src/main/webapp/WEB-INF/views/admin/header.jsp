<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    
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
	width: 251px;
	height: 100%;
	background-color: white;
	border: solid 1px gray;
	
	margin-right: 10px;
	margin-bottom: 10px;
}

.rightbottombox {
	width: 100%;
	height: 100%;
	background-color: white;
	border: solid 1px gray;
}

.leftbottombox > div {
	width: 100%;
	height: 30px;
	background-color: white;
}

.menubutton > a {
	color: black;
	line-height: 30px;
	padding-left: 10px;
}

.menubutton > a:hover {
	color: black;
	text-decoration: none;
}

</style>