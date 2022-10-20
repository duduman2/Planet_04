<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 관리</title>

<%@ include file="./header.jsp" %>

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
</style>

<script type="text/javascript">
function createuser() {
 
    var _width = '600';
    var _height = '300';
 
    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
    var _left = Math.ceil(( window.screen.width - _width )/2);
    var _top = Math.ceil(( window.screen.height - _height )/2); 
 
    window.open('<%=request.getContextPath() %>/admin/adduser', 'adduser', 'width='+ _width +',height='+ _height +',left='+ _left +',top='+ _top );
 
}

function deleteuser() {
	 
	    var _width = '600';
	    var _height = '300';
	 
	    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
	    var _left = Math.ceil(( window.screen.width - _width )/2);
	    var _top = Math.ceil(( window.screen.height - _height )/2); 
	 
	    window.open('<%=request.getContextPath() %>/admin/deluser', 'deluser', 'width='+ _width +',height='+ _height +',left='+ _left +',top='+ _top );
	 
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
			<a href="<%=request.getContextPath() %>/admin/mainconfig">관리자 관리</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainboard">게시글 관리</a>
		</div>
		<div class="menubutton" style="background-color: #e9ecef">
			<a href="<%=request.getContextPath() %>/admin/mainuser">사용자 관리</a>
		</div>
	</div>
	<div class="rightbottombox">
		<!-- 여기부터 달라진다 -->
		<button class="configbutton" onclick="createuser();">사용자 추가</button>
		<button class="configbutton" onclick="deleteuser();">사용자 삭제</button>
		
		
		<!-- 여기부터 달라진다 -->
	</div>
</div>
</body>
</html>