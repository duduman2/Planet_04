<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	let elInputSearch1 = document.querySelector('#search1');
	let elInputSearch2 = document.querySelector('#search2');
	
	$("select[name=category]").change(function(){
		var selectcategory = $(this).val();
		// console.log($(this).val()); //value값 가져오기
		// console.log($("select[name=category] option:selected").text()); //text값 가져오기
		
		if(selectcategory == 'admin_no') {
			elInputSearch1.classList.add('hide');
			elInputSearch2.classList.remove('hide');
		} else {
			elInputSearch2.classList.add('hide');
			elInputSearch1.classList.remove('hide');
		}
		
	});
})

function createnotice() {
	
	const width = 600;
	const height = 600;

	let left = (document.body.offsetWidth / 2) - (width / 2);
	let tops = (document.body.offsetHeight / 2) - (height / 2);

	left += window.screenLeft;

	const popup = window.open('<%=request.getContextPath() %>/admin/crenotice', 'crenotice', 'width='+ width +',height='+ height +',left='+ left +',top='+ tops);
	 
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
	</div>
	<div class="rightbottombox">
		<!-- 여기부터 달라진다 -->
			<button class="configbutton" onclick="createnotice();">공지사항 작성</button>
			<select name="category">
		    	<option value="title">제목</option>
		    	<option value="admin_no">작성자</option>
			</select>
			<form action="<%=request.getContextPath() %>/admin/mainnotice" method="get" style="display: inline;">
				<input type="search" id="search1" style="margin-left: 10px; border-color: #029EE4" name="title" placeholder="제목">
				<input type="search" id="search2" class="hide" style="margin-left: 10px; border-color: #029EE4" name="admin_no" placeholder="작성자">
				<button>검색</button>
				<button type="button" onclick="location.href='/admin/mainnotice'">초기화</button>
			</form>
		<!-- 여기부터 달라진다 -->
	</div>
</div>
</body>
</html>