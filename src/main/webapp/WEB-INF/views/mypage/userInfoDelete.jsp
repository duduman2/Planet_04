<%@page import="dto.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>회원 탈퇴하기</title>

<%@include file="../layout/header2.jsp" %>


<script type="text/javascript">
// <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
// <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
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
		checkYN()
// 		uinfoDelete()
	})
	$("#btnMyMain").click(function() {
		$(location).attr("href", "/mypage/main")
	})
	$("#btnGradeInfo").click(function() {
		$(location).attr("href", "/grade/info")
	})
	
	

})
function uinfoDelete() {
// 	checkYN()
	
	var result = confirm("탈퇴하시겠습니까????");
	if(result==true) {
		alert("회원 탈퇴 - 확인을 눌렀습니다")
		
		alert("PLanet 탈퇴되었습니다")
		
// 		$(location).attr("href", "/userdelete/result")
		var re = window.open("/userdelete/result")
		
	} else {
		alert("회원 탈퇴 - 취소을 눌렀습니다")
	}
}	
function checkYN() {
	if($("#agreeDelete").is(":checked")==true) {
		console.log("checked ok")
// 		alert("회원 탈퇴 - 체크박스를 클릭했습니다")
		uinfoDelete()
	} else  {
		console.log("checked not yet")
		alert("회원 탈퇴 동의 여부 - 체크박스를 클릭해주세요")
// 		history.go(0);
// 		location.href = "/user/delete";
// 		var res = window.open("/user/delete", '_self')
	}
}

</script>
<!-- </head> -->
<!-- <body> -->

<h3>&nbsp;&nbsp;&nbsp;회원 탈퇴하기</h3>
<hr>
<div class="main" style="width: 100%;">

	<div id="uinfoMenu">
		<ul style="list-style: none;">
			<li><a id="btnGradeInfo">회원 등급 안내</a></li>
			<li><a id="btnUserInfo">회원 정보 확인</a></li>
			<li><a id="btnUserInfoModi">회원 정보 수정</a></li>
			<li><a id="btnUserInfoDeleteMenu">회원 탈퇴</a></li>
		</ul>
	</div>



	<div id="uinfoRight">

		<form action="" method="get" style="font-size: 1.2em;">
<!-- 		<form action="" method="post" style="font-size: 1.2em;"> -->
<!-- 		<br><br> -->
		<strong>회원 정보 삭제</strong> <br><br>

<ul><p>		
	<li>회원 탈퇴와 함께 <strong style="font-style: italic; font-weight: bold; font-size= 2em; color: #5B9E28"> PLanet</strong>
	 에 등록된 모든 개인정보는 삭제, 폐기 처리되며 복구되지 않습니다.<br></li>
	<li>회원탈퇴 시 동일 아이디(이메일)로 재가입하실 수 없습니다.<br></li>
	<li>단, 상법 및 '전자상거래 등에서 소비자 보호에 관한 법률' 등 관련 법령의 규정에 의하여 
	다음과 같이 ‘거래 관련 관리의무 관계 확인’ 등을 이유로 일정 기간 보관됩니다.<br></li>
	
	<ul>
	 <li>계약 또는 청약 철회 등에 관한 기록 : 5년<br></li>
	 <li>대금결제 및 재화 등의 공급에 관한 기록 : 5년<br></li>
	 <li>소비자의 불만 또는 분쟁 처리에 관한 기록 : 3년<br></li>
	 <li>설문조사, 이벤트 등 일시적 목적을 위하여 수집한 경우 : 당해 설문조사, 이벤트 등의 종료 시까지</li>
	</ul>

</p></ul>
 <br><br>

<strong>보유자산 소멸 안내</strong> <br><br>
<ul><p>

<li>회원 탈퇴와 함께 <strong style="font-style: italic; font-weight: bold; font-size= 2em; color: #5B9E28"> PLanet</strong> 
에 등록된 모든 개인정보가 삭제됨에 따라 모든 가상자산(보유 포인트)과 기타 보유자산 역시 함께 소멸됩니다.<br></li>
<li><strong style="font-style: italic; font-weight: bold; font-size= 2em; color: #5B9E28"> PLanet</strong> 은 
별도의 환불 서비스를 제공하지 않으며, 탈퇴 시 소멸된 자산은 복구 및 재이용이 불가능합니다.</li></p></ul>
		
		<br>
		
		<label><input type="checkbox" name="agreeDelete" id="agreeDelete"> 이에 동의합니다</label>

<!-- 		<div class="text-center" > -->
		<div>
			<br><br>
			
			<button id="btnBack"  class="btn btn-default" style="width: 120px; 
			height: 50px;" onclick="history.go(-1)">이전으로</button>
				
			&nbsp;&nbsp;&nbsp;
	
<!-- 			<button id="btnMyMain" class="btn btn-default"   -->
<!-- 			style="width: 155px; height: 50px;">마이페이지-메인으로</button> -->
			
<!-- 			&nbsp;&nbsp;&nbsp; -->
			
			<button id="btnUserInfoDelete"  class="btn btn-info"
			style="width: 100px; height: 50px;">탈퇴하기</button> 
		</div>
		
		
		</form>
	</div><%-- uinfoRight end --%>




<div id="blank" style="height: 100px;"> </div>


</div><!--<div class=main> end -->

<%@ include file="../layout/footer.jsp"%>
