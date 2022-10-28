<%@page import="dto.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>회원 탈퇴하기</title>

<%@include file="../layout/header.jsp" %>

<%-- 모델값 전달받기 --%>
<%-- <% 	UserInfo uList = (UserInfo) request.getAttribute("data"); %> --%>


<script type="text/javascript">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>>
</script>


<style type="text/css">
@import url("../sources/mypage/mypage.css");

</style>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnUserInfo").click(function() {
		$(location).attr("href", "/user/info")
	})
	$("#btnUserInfoModi").click(function() {
		$(location).attr("href", "/user/update")
	})
	$("#btnUserInfoDeleteMenu").click(function() { //메뉴- 회원탈퇴
		$(location).attr("href", "/user/delete")
	})
	$("#btnUserInfoDelete").click(function(){ //하단의 탈퇴하기 버튼
// 		alert("탈퇴하시겠습니까??")
		uinfoDelete()
	})
	$("#btnMyMain").click(function() {
		$(location).attr("href", "/mypage/main")
	})
	

})
function uinfoDelete() {
	var result = confirm("탈퇴하시겠습니까????");
	if(result==true) {
		alert("회원 탈퇴 - 확인을 눌렀습니다")
	} else {
		alert("회원 탈퇴 - 취소을 눌렀습니다")
	}
}	

</script>
<!-- </head> -->
<!-- <body> -->

<h3>&nbsp;&nbsp;&nbsp회원 탈퇴하기</h3>
<hr>
<div class="main" style="width: 100%;">

	<div id="uinfoMenu">
		<ul>
			<li><a id="btnUserInfo">회원 정보 확인</a></li>
			<li><a id="btnUserInfoModi">회원 정보 수정</a></li>
			<li><a id="btnUserInfoDeleteMenu">회원 탈퇴</a></li>
		</ul>
	</div>



	<div id="uinfoRight">

		<form action="" method="post" style="font-size: 1.2em;">
		탈퇴할 경우 재사용 및 복구가 불가능합니다<br><br>
		탈퇴 안내<br>
		~~안내사항~~<br><br>
		
		<label><input type="checkbox" name="uDelete" value=""> 이에 동의합니다</label>

<!-- 		<div class="text-center" > -->
		<div>
			<br><br>
			
			<button id="btnBack"  class="btn btn-default" style="width: 120px; 
			height: 50px;" onclick="history.go(-1)">이전으로</button>
				
			&nbsp;&nbsp;&nbsp;
	
			<button id="btnMyMain" class="btn btn-default"  
			style="width: 155px; height: 50px;">마이페이지-메인으로</button>
			
			&nbsp;&nbsp;&nbsp;
			
			<button id="btnUserInfoDelete"  class="btn btn-info"
			style="width: 100px; height: 50px;">탈퇴하기</button> 
		</div>
		
		
		</form>
	</div><%-- uinfoRight end --%>




<div id="blank" style="height: 100px;"> </div>


</div><!--<div class=main> end -->

<%@ include file="../layout/footer.jsp"%>
