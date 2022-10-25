<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<%@ include file="../layout/loginApi.jsp" %>

<%-- <%@ include file="../login/naver.html" %> --%>

<%-- <%@ include file="../login/callback.html" %> --%>

<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<!-- 아이디 중복 확인 -->
<script type="text/javascript">
$(document).ready(function() {
	
	$('#u_id').focusout(function(){
	console.log("#u_id focusout")
		
		let u_id = $('#u_id').val(); // input_id에 입력되는 값
		
		$.ajax({
			url : "/idCheck/con",
			type : "post",
			data : {u_id: u_id},
			dataType : 'json',
			success : function(result){
				if(result == 0){
					$("#idCheck").html('사용 불가한 아이디입니다.');
					$("#idCheck").attr('color','red');
					
					
				} else{
					$("#idCheck").html('사용 가능한 아이디입니다.');
					$("#idCheck").attr('color','green');
				} 
			},
			error : function(){
				alert("서버요청실패");
			}
		})
		 
	})

	$('#u_nick').focusout(function(){
	console.log("#u_nick focusout")
		
		let u_nick = $('#u_nick').val(); // input_id에 입력되는 값
		
		$.ajax({
			url : "/nickCheck/con",
			type : "post",
			data : {u_nick: u_nick},
			dataType : 'json',
			success : function(result){
				if(result == 0){
					$("#nickCheck").html('사용 불가한 닉네임입니다.');
					$("#nickCheck").attr('color','red');
					
					
				} else{
					$("#nickCheck").html('사용 가능한 닉네임입니다.');
					$("#nickCheck").attr('color','green');
				} 
			},
			error : function(){
				alert("서버요청실패");
			}
		})
	})

	$('#u_email').focusout(function(){
	console.log("#u_email focusout")
		
		let u_email = $('#u_email').val(); // input_id에 입력되는 값
		
		$.ajax({
			url : "/emailCheck/con",
			type : "post",
			data : {u_email: u_email},
			dataType : 'json',
			success : function(result){
				if(result == 0){
					$("#emailCheck").html('사용 불가한 이메일입니다.');
					$("#emailCheck").attr('color','red');
					
					
				} else{
					$("#emailCheck").html('사용 가능한 이메일입니다.');
					$("#emailCheck").attr('color','green');
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
/유효성 검사
function validate() {
	console.log( "form submit" )
	
// 	return false;	//submit 중단시키기
// 	return true;	//submit 허용하기
	
	//-------------------------------------
	
	if( !validateID( $("#u_id").val() ) ) {	//ID유효성 검증 실패
		
		return false;	//submit 중단
	}
	
	if( !validatePW( $("#u_pw").val() ) ) {	//PW유효성 검증 실패
		return false;	//submit 중단
	}
	
	//모든 유효성 검증 성공
	return true;	//submit 허용하기
	
	
}


function validateID( u_id ) {
	//아이디 입력했는지 검증
	if( id == '' ) {
		$("#u_id_msg").html("아이디를 입력해주세요!");
		
		return false;
		
		}
	
	
	//아이디 입력값 검증
	if( !/^[a-zA-Z0-9]{4,12}$/.test( u_id ) ) {
		$("#u_id_msg").html("아이디는 4~12영문자, 숫자가 가능합니다")
		
		return false;
	}

	
	//ID 유효성 검증 완료
	return true;
}


function validatePW( u_pw ) {
	//패스워드를 입력하지 않았을 때
	if( u_pw == '' ) {
		$("#u_pw_msg").html("패스워드를 입력해주세요!")	
		
		return false;
		
	}
	
	//패스워드 입력값 검증
	if( !/^[a-zA-Z]{4,8}$/.test( u_pw ) ) {
		$("#u_pw_msg").html("패스워드는 영어 대소문자 4~8자만 입력하세요!")
		
		return false;
	}
	
	//패스워드와 확인 입력값이 같은 지 검증
	if( u_pw != $("#pwCheck").val() ) {
		$("#pwCheck_msg").html("비밀번호 확인 입력이 동일하지 않습니다")
		
		return false;
	}
	
	//PW 유효성 검증 완료
	return true;
}


window.onload = function() {
	f.onsubmit = function() {
		return validate();
	}
}

</script>



<script type="text/javascript">
$(document).ready(function() {
	
	//입력창에 포커스주기
	$("input").eq(0).focus()
	
	
	//빈칸 확인
// 	$('#btnJoin').click(function() {
// 		if($('#u_id').val()==''){
// 			alert("아이디를 입력해주세요");
// 			return false;
// 		}
		
// 		if($('#u_pw').val()==''){
// 			alert("비밀번호를 입력해 주세요");
// 			return false;
// 		}
		
// 		if($('#pwCheck').val()==''){
// 			alert("비밀번호 확인란에 입력해 주세요");
// 			return false;
// 		}
		
// 		if($('#u_name').val()==''){
// 			alert("이름을 입력해 주세요");
// 			return false;
// 		}
		
// 		if($('#u_nick').val()==''){
// 			alert("닉네임을 입력해 주세요");
// 			return false;
// 		}
		
// 		if($('#u_birth').val()==''){
// 			alert("생년월일을 입력해 주세요");
// 			return false;
// 		}
		
// 		if($('#u_gender').val()==''){
// 			alert("성별을 체크해 주세요");
// 			return false;
// 		}
		
// 		if($('#u_email').val()==''){
// 			alert("이메일을 입력해 주세요");
// 			return false;
// 		}
		
// 		if($('#u_phone').val()==''){
// 			alert("전화번호를 입력해 주세요");
// 			return false;
// 		}
		
// 		if($('#u_address').val()==''){
// 			alert("주소를 입력해 주세요");
			
// 			return false;
// 		}
		
// 		$(this).parents("form").submit();

// 	})	
	
		
/*	
	//비밀번호 정규식
	$('#u_pw').blur(function() {
		var regexPw = /^[A-Za-z0-9`~!@#\$%\^&\*\(\)\{\}\[\]\-_=\+\\|;:'"<>,\./\?]{8,20}$/;
		  if(!regexPw.test('#u_pw')) {
		  	alert("8~20자 영문 대소문자, 숫자, 특수문자를 사용하세요.");
		    return false;
		  }
		  
		  return true;
		
	})
*/

	


	//비밀번호 확인	
	$('#pwCheck').blur(function(){
		if($('#u_pw').val() != $('#pwCheck').val()){
			if($('#pwCheck').val()!=''){
				alert("비밀번호가 일치하지 않습니다.");
				$('#pwCheck').val('');
				$('#pwCheck').focus();
			}
		}
	})  	 
	
	//회원가입 버튼
// 	$("#btnJoin").click(function() {
// 		$(this).parents("form").submit();
		
// 	})
	
	//취소 버튼
	$("#btnCancel").click(function() {
		$(location).attr('href', '/main') //메인으로 가기
	})
	
	//생년월일
	$("#birth").click(function() {
		 var now = new Date();
		 var year = now.getFullYear();
		 var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 
		 var day = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+(now.getDate());           
		 
		 //년도 selectbox만들기               
		 for(var i = 1900 ; i <= year ; i++) {
		     $('#year').append('<option value="' + i + '">' + i + '년</option>');    
		 }

		 // 월별 selectbox 만들기            
		 for(var i=1; i <= 12; i++) {
		     var mm = i > 9 ? i : "0"+i ;            
		     $('#month').append('<option value="' + mm + '">' + mm + '월</option>');    
		 }
		    
		 // 일별 selectbox 만들기
		 for(var i=1; i <= 31; i++) {
		     var dd = i > 9 ? i : "0"+i ;            
		     $('#day').append('<option value="' + dd + '">' + dd+ '일</option>');    
		 }
		 $("#year  > option[value="+year+"]").attr("selected", "true");        
		 $("#month  > option[value="+mon+"]").attr("selected", "true");    
		 $("#day  > option[value="+day+"]").attr("selected", "true");       
	})
	
})
</script>



<!-- 주소API -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>



<style type="text/css">

body{margin: 0 auto; width: 500px;}



input { border-radius: 3px; }

label {
	width: 120px;
	font-weight: bold;
	color: #585252;
	display: inline-block;
}



#btnJoin {
	width: 150px;
	height: 41px;
	background-color: #5B9E28;
	border-radius: 7px;
	border: thin solid #5B9E28;
	font-weight: bold;
	font-size: 13px;
	color: white;
}

#btnCancel {
	width: 150px;
	height: 41px;
	background-color: #5B9E28;
	border-radius: 7px;
	border: thin solid #5B9E28;
	font-weight: bold;
	font-size: 13px;
	color: white;
}

#address {
	border: thin solid #128525;
	border-radius: 3px;
	background-color: white;
	color: #128525;
	height: 25px;
}

#snsForm {
	display: block;
	text-align: center;
}
.msg {
	font-size: 0.5em;
	color: red;
	margin-left: 50px;
}

	
	
 } 
 


</style>


<body>

<h1 style="text-align: center; font-weight: bold;">회원가입</h1><br><br>


<!-- SNS 간편 회원가입 -->
<form  class="form-horizontal" id="snsForm">
<div class="signin-sns cont">
<h3 style="color: #585252; text-align: center;">SNS 간편 회원가입</h3><br><br>

<!-- 카카오 -->
<a datatype="kakao" class="css-l0qndx e1ufx3to0" onclick="kakaoLogin();" href="javascript:void(0)" style="margin-right: 40px;"><svg width="48" height="48" viewBox="0 0 48 48" preserveAspectRatio="xMidYMid meet"><g fill="none" fill-rule="evenodd"><path fill="#FFEB00" d="M0 24C0 10.745 10.745 0 24 0s24 10.745 24 24-10.745 24-24 24S0 37.255 0 24z"></path><path fill="#3C2929" d="M24 11.277c8.284 0 15 5.306 15 11.85 0 6.545-6.716 11.85-15 11.85-.92 0-1.822-.066-2.697-.191l-6.081 4.105a.43.43 0 0 1-.674-.476l1.414-5.282C11.777 31.031 9 27.335 9 23.127c0-6.544 6.716-11.85 15-11.85zm6.22 8.407c-.416 0-.718.297-.718.707v5.939c0 .41.289.686.718.686.41 0 .718-.295.718-.686v-1.932l.515-.526 1.885 2.57c.277.374.426.54.691.568.037.003.075.005.112.005.154 0 .66-.04.716-.563.038-.293-.137-.52-.348-.796l-2.043-2.675 1.727-1.743.176-.196c.234-.26.353-.39.353-.587.009-.422-.34-.652-.687-.661-.274 0-.457.15-.57.262l-2.528 2.634v-2.3c0-.422-.288-.706-.717-.706zm-9.364 0c-.56 0-.918.432-1.067.837l-2.083 5.517a.84.84 0 0 0-.065.315c0 .372.31.663.706.663.359 0 .578-.162.69-.51l.321-.97h2.999l.313.982c.111.335.34.498.7.498.367 0 .655-.273.655-.62 0-.056-.017-.196-.081-.369l-2.019-5.508c-.187-.53-.577-.835-1.069-.835zm-2.92.064h-4.452c-.417 0-.642.337-.642.654 0 .3.168.652.642.652h1.51v5.21c0 .464.274.752.716.752.443 0 .718-.288.718-.751v-5.21h1.508c.474 0 .643-.352.643-.653 0-.317-.225-.654-.643-.654zm7.554-.064c-.442 0-.717.287-.717.75v5.707c0 .497.28.794.75.794h2.674c.434 0 .677-.321.686-.627a.642.642 0 0 0-.17-.479c-.122-.13-.3-.2-.516-.2h-1.99v-5.195c0-.463-.274-.75-.717-.75zm-4.628 1.306l.008.01 1.083 3.265h-2.192L20.842 21a.015.015 0 0 1 .028 0z"></path></g></svg></a>


<!-- 네이버 -->



<!-- <a datatype="naver" class="css-l0qndx e1ufx3to0" id="naverIdLogin_loginButton" href="javascript:void(0)"  style="margin-right: 40px;"><svg width="48" height="48" viewBox="0 0 48 48" preserveAspectRatio="xMidYMid meet"><g fill="none" fill-rule="evenodd"><path fill="#00C63B" d="M0 24C0 10.745 10.745 0 24 0s24 10.745 24 24-10.745 24-24 24S0 37.255 0 24z"></path><path fill="#FFF" d="M21 25.231V34h-7V15h7l6 8.769V15h7v19h-7l-6-8.769z"></path></g></svg></a> -->

<a datatype="naver" class="css-l0qndx e1ufx3to0" id="naverIdLogin_loginButton" href="javascript:void(0)"  style="margin-right: 40px;"><svg width="48" height="48" viewBox="0 0 48 48" preserveAspectRatio="xMidYMid meet"><g fill="none" fill-rule="evenodd"><path fill="#00C63B" d="M0 24C0 10.745 10.745 0 24 0s24 10.745 24 24-10.745 24-24 24S0 37.255 0 24z"></path><path fill="#FFF" d="M21 25.231V34h-7V15h7l6 8.769V15h7v19h-7l-6-8.769z"></path></g></svg></a>

<!-- 구글 -->
<a datatype="google" id="GgCustomLogin" class="css-l0qndx e1ufx3to0" href="javascript:void(0)">

<svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 48 48" preserveAspectRatio="xMidYMid meet">
<g fill="none" fill-rule="evenodd">

<g transform="translate(-90.000000, -398.000000) translate(90.000000, 398.000000)">
<circle cx="22" cy="22" r="22" fill="#F4F4F4"></circle>
<g><path fill="#4285F4" d="M21.56 11.25c0-.78-.07-1.53-.2-2.25H11v4.255h5.92c-.255 1.375-1.03 2.54-2.195 3.32v2.76h3.555c2.08-1.915 3.28-4.735 3.28-8.085z" transform="translate(11.000000, 11.000000)"></path>
<path fill="#34A853" d="M11 22c2.97 0 5.46-.985 7.28-2.665l-3.555-2.76c-.985.66-2.245 1.05-3.725 1.05-2.865 0-5.29-1.935-6.155-4.535H1.17v2.85C2.98 19.535 6.7 22 11 22z" transform="translate(11.000000, 11.000000)"></path>
<path fill="#FBBC05" d="M4.845 13.09c-.22-.66-.345-1.365-.345-2.09 0-.725.125-1.43.345-2.09V6.06H1.17C.425 7.545 0 9.225 0 11c0 1.775.425 3.455 1.17 4.94l3.675-2.85z" transform="translate(11.000000, 11.000000)"></path>
<path fill="#EA4335" d="M11 4.375c1.615 0 3.065.555 4.205 1.645l3.155-3.155C16.455 1.09 13.965 0 11 0 6.7 0 2.98 2.465 1.17 6.06l3.675 2.85C5.71 6.31 8.135 4.375 11 4.375z" transform="translate(11.000000, 11.000000)"></path>
<path d="M0 0L22 0 22 22 0 22z" transform="translate(11.000000, 11.000000)"></path>
</g></g></g></svg></a>

</div>
</form> <!-- SNS 간편 로그인 폼 끝-->

<br><br><br>
<hr>
<br><br><br>


<form method="post" action="./con" class="form-horizontal" id="f" name="emailForm">
<div class="signin-email cont"></div>
<h3 style="color: #585252; text-align: center;">이메일 간편 회원 가입</h3><br><br>
	
		<div class="form-group">
			<label for="id">아이디</label>
			<input type="text" id="u_id" name="u_id" class = "input_id" placeholder="5자 이상 영문과 숫자를 조합해 작성해주세요" required="required" style="width: 232px; height: 25px; border: 1px solid gray;">

			<!-- 로그인 중복확인 -->
			<font id="idCheck" name="idCheck" size="2"></font>
			
			<span id="u_id_msg" class="msg"></span><br>

		</div>
			<br>
			
		<div class="form-group">
			<label for="password">비밀번호</label> 
			<input type="password" name="u_pw" id="u_pw" required="required" style="width: 232px; height: 25px; border: 1px solid gray;"> 
		
			<span id="u_pw_msg" class="msg"></span><br>
		</div>
			<br>
			
		<div class="form-group">
			<label for="password">비밀번호확인</label> 
			<input type="password" name="pwCheck" id="pwCheck" required="required" style="width: 232px; height: 25px; border: 1px solid gray;">
		
			<span id="pwCheck_msg" class="msg"></span><br>
		</div>
			<br>
			
		<div class="form-group">
			<label for="name">이름</label> 
			<input type="text" name="u_name" id="u_name" onchange="isSame" required="required" style="width: 232px; height: 25px; border: 1px solid gray;"> 
		</div>
			<br>
		
		<div class="form-group">
			<label for="nickname">닉네임</label> 
			<input type="text" name="u_nick" id="u_nick" required="required" style="width: 232px; height: 25px; border: 1px solid gray;"> 
			
			<!-- 닉네임 중복확인 -->
			<font id="nickCheck" name="nickCheck" size="2"></font>
			
		</div>
			<br>
			
			
		<div class="form-group">
			<label for="bitrh">생년월일</label> 
			<input type="date" id="u_birth" name="u_birth" required="required" style="width: 232px; height: 25px; border: 1px solid gray;"> 
		</div>
			<br>
			
			<div class="form-group" style="color: #585252;">
			<label for="gender">성별</label> 
			<input type="radio" name="u_gender" id="u_gender" value="male"  required="required"> 남성
			<input type="radio" name="u_gender" id="u_gender" value="female" required="required"> 여성
			
		</div>
			<br>
		
		<div>
			<label for="email">이메일</label> 
			<input type="email" name="u_email" id="u_email" required="required" style="width: 232px; height: 25px; border: 1px solid gray;"> 
			
			<!-- 이메일 중복확인 -->
			<font id="emailCheck" name="emailCheck" size="2"></font>
		</div>
			<br>
							
		<div class="form-group">
			<label for="tel">전화번호</label>
			<input type="text" name="u_phone" id="phone" required="required" placeholder=" '-' 를 제외한 숫자만 입력하세요" style="width: 232px; height: 25px; border: 1px solid gray;">
			<font id="phoneCheck" name="phoneCheck" size="2"></font>
		</div>
			<br>
			
 		<div> 
 			<label for="address">주소</label> 
 			<input type="text" id="sample6_postcode" name="u_address" placeholder="우편번호" required="required" style="width: 232px; height: 25px; border: 1px solid gray;"> 
 			<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" id="address"><br> 
 		</div> 

 		<div >		 
 			<label for="address2"></label> 
			<input type="text" id="sample6_address" placeholder="주소" required="required" style="width: 232px; height: 25px; border: 1px solid gray;"><br> 
 		</div> 
		
		<div> 
 			<label for="address3"></label>	
 			<input type="text" id="sample6_detailAddress" placeholder="상세주소" required="required" style="width: 232px; height: 25px; border: 1px solid gray;"> 
			<input type="text" id="sample6_extraAddress" placeholder="참고항목" style="width: 232px; height: 25px; margin-left:124px; border: 1px solid gray;"> 		
		</div> 
			<br><br><br><br>
		
		<div class="form-group" style="text-align: center;">
			<button type="button" class="btn btn-primary" id="btnJoin" style="margin-right: 15px;">회원가입</button>
			
			<button type="button" class="btn btn-danger" id="btnCancel">취소</button>
		</div>
</form>
</div>


<br><br><br><br><br><br><br><br><br><br><br><br>





</body>
</html>

