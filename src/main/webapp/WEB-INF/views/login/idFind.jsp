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

// 		$('#u_name').focusout(function(){
// 		console.log("#u_name focusout")
			
// 			let u_name = $('#u_name').val(); // input_id에 입력되는 값
			
// 			$.ajax({
// 				url : "/nameCheck/con",
// 				type : "post",
// 				data : {u_name: u_name},
// 				dataType : 'json',
// 				success : function(result){
// 					if(result == 0){
// 						$("#nameCheck").html('이름 확인 성공');
// 						$("#nameCheck").attr('color','green');
						
						
// 					} else{
// 						$("#nameCheck").html('이름 정보가 없습니다');
// 						$("#nameCheck").attr('color','red');
// 					} 
// 				},
// 				error : function(){
// 					alert("서버요청실패");
// 				}
// 			})
			 
// 		})


// 		$('#u_email').focusout(function(){
// 		console.log("#u_email focusout")
			
// 			let u_email = $('#u_email').val(); // input_id에 입력되는 값
			
// 			$.ajax({
// 				url : "/emailCheck/con",
// 				type : "post",
// 				data : {u_email: u_email},
// 				dataType : 'json',
// 				success : function(result){
// 					if(result == 0){
// 						$("#emailCheck").html('이메일 정보가 없습니다');
// 						$("#emailCheck").attr('color','red');
						
						
// 					} else{
// 						$("#emailCheck").html('이메일 확인 성공');
// 						$("#emailCheck").attr('color','green');
// 					} 
// 				},
// 				error : function(){
// 					alert("서버요청실패");
// 				}
// 			})
// 		})
// $('#idFind').click(function Validation(){ 
// 		var objName = document.getElementById("u_name"); //이름       
// 		var objEmail = document.getElementById("u_email");//이메일   
		
// 		if(objName.value ==''){            
// 			alert("이름을 입력해주세요.");            
// 			return false;        
// 		}        
// 		if(!n_RegExp.test(objName.value)){            
// 			alert("이름에 특수문자,영어,숫자는 사용할수 없습니다. 한글만 입력하여주세요.");            
// 			return false;        
// 		} 
	
// 		if(objEmail.value == ''){ // 이메일 입력여부 검사            
// 			alert("이메일을 입력해주세요.");            
// 			return false;        
// 		}                
// 		if(!e_RegExp.test(objEmail.value)){ //이메일 유효성 검사            
// 			alert("올바른 이메일 형식이 아닙니다.");            
// 			return false;        
// 		}     
		
// 		$("form").submit();   
		
// 	})
})

</script>


<script type="text/javascript">
$(document).ready(function() {
	
	//아이디 찾기 버튼
	$("#idFind").click(function() { //아이디 검색
		
		var objName = document.getElementById("u_name"); //이름       
		var objEmail = document.getElementById("u_email");//이메일   
		var n_RegExp = /^[가-힣]{2,15}$/; //이름 유효성검사 정규식
		var e_RegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		if(objName.value ==''){            
			alert("이름을 입력해주세요.");            
			return false;        
		}        
		if(!n_RegExp.test(objName.value)){            
			alert("이름에 특수문자,영어,숫자는 사용할수 없습니다. 한글만 입력하여주세요.");            
			return false;        
		} 
	
		if(objEmail.value == ''){ // 이메일 입력여부 검사            
			alert("이메일을 입력해주세요.");            
			return false;        
		}                
		if(!e_RegExp.test(objEmail.value)){ //이메일 유효성 검사            
			alert("올바른 이메일 형식이 아닙니다.");            
			return false;        
		}     
		
		$("form").submit();
	})

	//비밀번호 찾기 버튼
	$("#pwFind").click(function() {
		$(location).attr('href', '/password/find') //비밀번호 찾기 화면으로 가기
	})
	
	//취소 버튼
	$("#btnCancel").click(function() {
		$(location).attr('href', '/login/con') //로그인 화면으로 가기
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

#idFind {
	width: 370px;
	height: 41px;
	background-color: #5B9E28;
	border-radius: 7px;
	border: thin solid #5B9E28;
	font-weight: bold;
	font-size: 13px;
	color: white;
}

#pwFind {
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

	
form{position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);}

</style>



</head>
<body>

<div style="margin: 0 auto; text-align: center;">

<form method="post" action="/id/find" style="margin: 0 auto;">

<br><br><h1 style="text-align:center; color: #5B9E28;">아이디 찾기</h1><br><br>

<div class="form-group" style="margin: 0 auto;">
	<input id="u_name" name="u_name" placeholder="이름을 입력해 주세요"><br><br>
	<font id="nameCheck" name="nameCheck" size="2"></font><br><br>
</div>


<div class="form-group" style="margin: 0 auto;">
	<input id="u_email" name="u_email" placeholder="이메일을 입력해 주세요"><br><br>
	<font id="emailCheck" name="emailCheck" size="2"></font><br><br>
</div>

<div class="form-group" style="margin: 0 auto;">
	<button type="button" class="btn btn-primary" id="idFind" name="idFind">아이디 찾기</button><br><br><br>
</div>

<div class="form-group" style="margin: 0 auto;">
	<button type="button" class="btn btn-primary" id="pwFind" style="margin-right: 6px;">비밀번호 찾기</button>
	<button type="button" class="btn btn-primary" id="btnCancel">취소</button><br><br>
</div>




</form>

</div>


</body>
</html>