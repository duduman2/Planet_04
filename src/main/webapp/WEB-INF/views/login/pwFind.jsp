<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 파비콘 -->
<link rel="icon" href="/sources/favicon.ico">


<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	$('#u_name').focusout(function(){
	console.log("#u_name focusout")
		
		let u_name = $('#u_name').val(); 
		
		$.ajax({
			url : "/nameCheck/con",
			type : "post",
			data : {u_name: u_name},
			dataType : 'json',
			success : function(result){
				if(result = 0){
					$("#nameCheck").html('이름 정보가 없습니다');
					$("#nameCheck").attr('color','red');
				} else{
					$("#nameCheck").html('이름 확인 성공');
					$("#nameCheck").attr('color','green');
				} 
			},
			error : function(){
				alert("서버요청실패");
			}
		})
		 
	})

	$('#u_id').focusout(function(){
	console.log("#u_id focusout")
		
		let u_id = $('#u_id').val(); 
		
		$.ajax({
			url : "/nickCheck/con",
			type : "post",
			data : {u_id: u_id},
			dataType : 'json',
			success : function(result){
				if(result = 0){
					$("#idCheck").html('아이디 정보가 없습니다');
					$("#idCheck").attr('color','red');
				} else{
					$("#idCheck").html('아이디 확인 성공');
					$("#idCheck").attr('color','green');
				} 
			},
			error : function(){
				alert("서버요청실패");
			}
		})
		 
	})
	
})

</script>

<script type="text/javascript">
$(document).ready(function() {
	
	//비밀번호 찾기 버튼
	$("#pwFind").click(function() {

		
		/*
		if($("input").val()==''){
			alert("정보를 입력해주세요");
			return false;
		} else {
			return true;
		}
		*/
		
		$("form").submit();
	})
	
	//아이디 찾기 버튼
	$("#idFind").click(function() {
		$(location).attr('href', '/id/find') //아이디 찾기 화면으로 가기
	})
	
	
	//취소 버튼
	$("#btnCancel").click(function() {
		$(location).attr('href', '/login/con') //로그인 화면으로 가기
	})
	
	$("input").eq(0).blur(function() {
		
	})

})
</script>

<style type="text/css">
body{margin: 0 auto; width: 700px; height:1000px;}

form{ 
	width: 452px; 
	height:563px;
	border: 1px solid #5B9E28;
	text-align: center;
}

#pwFind {
	width: 370px;
	height: 41px;
	background-color: #5B9E28;
	border-radius: 7px;
	border: thin solid #5B9E28;
	font-weight: bold;
	font-size: 13px;
	color: white;
}

#idFind {
	width: 180px;
	height: 41px;
	background-color: #5B9E28;
	border-radius: 7px;
	border: thin solid #5B9E28;
	font-weight: bold;
	font-size: 13px;
	color: white;
}


#btnCancel {
	width: 180px;
	height: 41px;
	background-color: #5B9E28;
	border-radius: 7px;
	border: thin solid #5B9E28;
	font-weight: bold;
	font-size: 13px;
	color: white;
}

input{
	width: 370px; 
	height: 41px; 
	border: 1px solid gray;
	border-radius: 7px;
}

form{
	position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);}

</style>


</head>
<body>

<div style="display: inline-block;">
<form method="post" action="/password/find">

<br><br><h1 style="text-align:center; color: #5B9E28;">비밀번호 찾기</h1><br><br>

<div class="form-group">
	<input id="u_name" name="u_name" placeholder="이름을 입력해 주세요"><br><br>
	
	<span id="nameCheck" name="nameCheck" size="2"></span><br><br>
	
	
	<input id="u_id" name="u_id" placeholder="아이디를 입력해 주세요"><br><br>
	
	<span id=idCheck" name="idCheck" size="2"></span><br><br>
</div>


<div class="form-group">
	<button type="button" class="btn btn-primary" id="pwFind">비밀번호 찾기</button><br><br><br>
</div>

<div class="form-group">
	<button type="button" class="btn btn-primary" id="idFind" style="margin-right: 6px;">아이디 찾기</button>
	<button type="button" class="btn btn-primary" id="btnCancel">취소</button><br><br>
</div>




</form>

</div>


</body>
</html>