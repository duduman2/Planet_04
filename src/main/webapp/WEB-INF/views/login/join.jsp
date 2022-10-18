<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function() {
	
	//아이디 입력창에 포커스주기
	$("input").eq(0).focus()
	
	//닉네임 입력창에 엔터키 입력 시 submit
	$("input").eq(2).keydown(function(e) {
		if( e.keyCode == 13 ) { //엔터키
			$("#btnJoin").click();
		}
	})
	
	
	//회원가입 버튼
	$("#btnJoin").click(function() {
		$(this).parents("form").submit();
	})
	
	//취소 버튼
	$("#btnCancel").click(function() {
// 		history.go(-1) //뒤로가기
		$(location).attr('href', '/') //메인으로 가기
	})
})
</script>


<style type="text/css">

label {
	width: 120px;
	display: inline-block;
	font-weight: bold;
	color: #585252;
	margin-left: 110px;
}

</style>


</head>
<body>

<h1>회원가입</h1>

<fieldset>
<div class="signin-sns cont">
<h3 style="color: #585252; text-align: center;">SNS 간편 회원가입</h3>


</div>
</fieldset> <!-- SNS 간편 로그인 폼 끝-->

<hr>

<fieldset disabled>
<div class="signin-email cont">
<h3 style="color: #585252; text-align: center;">이메일 간편 회원 가입</h3>
	<form method="post" action="/join/con" class="form-horizontal">
	
		<div class="text-center">
			<label for="id">아이디</label>
			<input type="text" id="id" name="id" required="required" style="width: 232px; border: 1px solid gray;">
		
			<!-- 로그인 중복확인 -->
			<button type="button" onclick="fn_dbCheckId()" name="dbCheckId" class="checkId">중복확인</button>
			<input type="hidden" name="idDuplication" value="idUncheck"/>
		</div>
			
		<div class="text-center">
			<label for="password">비밀번호</label> 
			<input type="password" name="pw" required="required" style="width: 232px; border: 1px solid gray;"> 
		</div>
			
		<div class="text-center">
			<label for="password">비밀번호확인</label> 
			<input type="password" name="pw" required="required" style="width: 232px; border: 1px solid gray;"> 
		</div>
			
		<div class="text-center">
			<label for="name">이름</label> 
			<input type="text" name="name" style="width: 232px; border: 1px solid gray;"> 
		</div>
			
		<div class="text-center">
			<label for="email">이메일</label> 
			<input type="email" name="email" required="required" style="width: 232px; border: 1px solid gray;"> 
			
			<!-- 이메일 중복확인 -->
			<button type="button" onclick="fn_dbCheckEmail()" name="dbCheckEmail" class="checkEmail">중복확인</button>
			<input type="hidden" name="emailDuplication" value="emailUncheck"/>

		</div>
			
		<div class="text-center">
			<label for="tel">휴대폰</label>
			<input type="text" name="tel" style="width: 232px; border: 1px solid gray;">
		</div>
			
		<div class="text-center">
			<label for="address">주소</label>
			<input type="text" name="address" style="width: 232px; border: 1px solid gray;">
		</div>
		
		<div class="text-center">
		<button type="button" class="btn btn-primary" id="btnJoin">회원가입</button>
		<button type="button" class="btn btn-danger" id="btnCancel">취소</button>
	</div>
		
	</form>
</div>
</fieldset> <!-- 회원가입 폼 끝 -->





</body>
</html>