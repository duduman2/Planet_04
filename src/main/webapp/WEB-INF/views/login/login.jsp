
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

<!-- 파비콘 -->
<link rel="icon" href="/sources/favicon.ico">


<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<!-- 일반 로그인 -->
<script type="text/javascript">
$(document).ready(function() {
	
	//아이디 입력창에 포커스주기
	$("input").eq(0).focus()
	
	//패스워드 입력창에 엔터키 입력 시 submit
	$("input").eq(1).keydown(function(e) {
		if( e.keyCode == 13 ) { //엔터키
			$("#btnLogin").click();
		}
	})
	
	//로그인 버튼
	$("#btnLogin").click(function() {
		$(this).parents("form").submit();
	})
	
	//회원가입 버튼
	$("#btnJoin").click(function() {
		$(location).attr('href', '/join/con') 
	})
	
	//취소 버튼
	$("#btnCancel").click(function() {
		$(location).attr('href', '/main') //메인으로 가기
	})
})
</script>


<style type="text/css">

body{margin: 0 auto; width: 400px; height:1000px;}

input { 
	border-radius: 3px; 
	width: 232px; 
	height: 25px; 
	border: 1px solid gray;
}

label {
	width: 120px;
	font-weight: bold;
	color: #585252;
	display: inline-block;
}

#btnLogin {
	width: 370px;
	height: 41px;
	background-color: #5B9E28;
	border-radius: 7px;
	border: thin solid #5B9E28;
	font-weight: bold;
	font-size: 13px;
	color: white;
}

#btnJoin {
	width: 370px;
	height: 41px;
	background-color: #5B9E28;
	border-radius: 7px;
	border: thin solid #5B9E28;
	font-weight: bold;
	font-size: 13px;
	color: white;
}

#btnCancel {
	width: 370px;
	height: 41px;
	background-color: #5B9E28;
	border-radius: 7px;
	border: thin solid #5B9E28;
	font-weight: bold;
	font-size: 13px;
	color: white;
}

#snsForm {
	display: block;
	text-align: center;
}

section {
	display: block;
	text-align: center;
	text-decoration: none;
	color: #585252;
	
}


</style>

<script async defer crossorigin="anonymous" src="https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v10.0&appId=83895073079499" nonce="SiOBIhLG"></script>

<script>
//기존 로그인 상태를 가져오기 위해 Facebook에 대한 호출
function statusChangeCallback(res){
	statusChangeCallback(response);
}

function fnFbCustomLogin(){
	FB.login(function(response) {
		if (response.status === 'connected') {
			FB.api('/me', 'get', {fields: 'name,email'}, function(r) {
				console.log(r);
			})
		} else if (response.status === 'not_authorized') {
			// 사람은 Facebook에 로그인했지만 앱에는 로그인하지 않았습니다.
			alert('앱에 로그인해야 이용가능한 기능입니다.');
		} else {
			// 그 사람은 Facebook에 로그인하지 않았으므로이 앱에 로그인했는지 여부는 확실하지 않습니다.
			alert('페이스북에 로그인해야 이용가능한 기능입니다.');
		}
	}, {scope: 'public_profile,email'});
}

window.fbAsyncInit = function() {
	FB.init({
		appId      : '83895073079499', // 내 앱 ID를 입력한다.
		cookie     : true,
		xfbml      : true,
		version    : 'v10.0'
	});
	FB.AppEvents.logPageView();   
};
  
  
</script>


</head>

<!-- 로그인 화면 -->
<div class="container">

	<div class="col-lg-4"></div>
	<div class="col-lg-4">
	
	<br><br><br><br>
	<h1 style="color: #13471C; text-align:center; font-size: 130; font-style: italic; font-weight: bold;">PLanet</h1><br>
		
		<div class="jumbotron" style="padding-top:10px">
		
			<form method="post" action="/login/con" class="form-horizontal">
			
				<h3 style="text-align:center; color: #585252;" >이메일 로그인</h3>

				<br><br>
				
				<div class="form-group">
					<label>아이디</label>
					<input type="text" class="form-control" placeholder="아이디 / 이메일" name="u_id" maxlength="20"/>
				</div>
					<br>
				
				<div class="form-group">
					<label>비밀번호</label>
					<input type="password" class="form-control" placeholder="비밀번호" name="u_pw" maxlength="20"/>
				</div>
					<br><br><br>
				
				<div class="form-group">
					<button type="button" class="btn btn-primary" id="btnLogin" >로그인</button>
				</div>
					<br>
				
				<div class="form-group">
					<button type="button" class="btn btn-primary" id="btnCancel" >메인페이지</button>
				</div>
					<br><br><br>
					
			
				<section class="css-hyck8i e5voaya4">
					<a class="css-lpbwa0 e5voaya3" href="/id/find" style="text-decoration: none; color: #585252; margin-right: 15px;">아이디 찾기</a>
					<a class="css-lpbwa0 e5voaya3" href="/password/find" style="text-decoration: none; color: #585252; margin-right: 15px;">비밀번호 찾기</a>
					<a class="css-lpbwa0 e5voaya3" href="/join/con" style="text-decoration: none; color: #585252;">회원가입</a>
				</section>
				<br><br><br>
			
			
			</form>

	
</form>
				
			
		</div>
		
		<div class="col-lg-4"></div>
	</div>
</div>
	
<hr>
<br><br>

<!-- 간편 로그인 화면 -->
<h3 style="text-align:center; color: #585252;" >SNS 간편 로그인</h3>

<br><br><br>

<form class="form-horizontal" id="snsForm">

<!-- SNS 로그인 API -->
<%@ include file="../layout/loginApi.jsp" %>

<!-- 카카오 -->
<a datatype="kakao" class="css-l0qndx e1ufx3to0" onclick="kakaoLogin();" href="javascript:void(0)" style="margin-right: 40px;"><svg width="48" height="48" viewBox="0 0 48 48" preserveAspectRatio="xMidYMid meet"><g fill="none" fill-rule="evenodd"><path fill="#FFEB00" d="M0 24C0 10.745 10.745 0 24 0s24 10.745 24 24-10.745 24-24 24S0 37.255 0 24z"></path><path fill="#3C2929" d="M24 11.277c8.284 0 15 5.306 15 11.85 0 6.545-6.716 11.85-15 11.85-.92 0-1.822-.066-2.697-.191l-6.081 4.105a.43.43 0 0 1-.674-.476l1.414-5.282C11.777 31.031 9 27.335 9 23.127c0-6.544 6.716-11.85 15-11.85zm6.22 8.407c-.416 0-.718.297-.718.707v5.939c0 .41.289.686.718.686.41 0 .718-.295.718-.686v-1.932l.515-.526 1.885 2.57c.277.374.426.54.691.568.037.003.075.005.112.005.154 0 .66-.04.716-.563.038-.293-.137-.52-.348-.796l-2.043-2.675 1.727-1.743.176-.196c.234-.26.353-.39.353-.587.009-.422-.34-.652-.687-.661-.274 0-.457.15-.57.262l-2.528 2.634v-2.3c0-.422-.288-.706-.717-.706zm-9.364 0c-.56 0-.918.432-1.067.837l-2.083 5.517a.84.84 0 0 0-.065.315c0 .372.31.663.706.663.359 0 .578-.162.69-.51l.321-.97h2.999l.313.982c.111.335.34.498.7.498.367 0 .655-.273.655-.62 0-.056-.017-.196-.081-.369l-2.019-5.508c-.187-.53-.577-.835-1.069-.835zm-2.92.064h-4.452c-.417 0-.642.337-.642.654 0 .3.168.652.642.652h1.51v5.21c0 .464.274.752.716.752.443 0 .718-.288.718-.751v-5.21h1.508c.474 0 .643-.352.643-.653 0-.317-.225-.654-.643-.654zm7.554-.064c-.442 0-.717.287-.717.75v5.707c0 .497.28.794.75.794h2.674c.434 0 .677-.321.686-.627a.642.642 0 0 0-.17-.479c-.122-.13-.3-.2-.516-.2h-1.99v-5.195c0-.463-.274-.75-.717-.75zm-4.628 1.306l.008.01 1.083 3.265h-2.192L20.842 21a.015.015 0 0 1 .028 0z"></path></g></svg></a>


<!-- 	<li onclick="kakaoLogout();"> -->
<!--       <a href="javascript:void(0)"> -->
<!--           <span>카카오 로그아웃</span> -->
<!--       </a> -->
<!-- 	</li> -->
<!-- </ul> -->

<!-- 네이버 -->



<!-- <a datatype="naver" class="css-l0qndx e1ufx3to0" style="margin-right: 40px;"><svg width="48" height="48" viewBox="0 0 48 48" preserveAspectRatio="xMidYMid meet"><g fill="none" fill-rule="evenodd"><path fill="#00C63B" d="M0 24C0 10.745 10.745 0 24 0s24 10.745 24 24-10.745 24-24 24S0 37.255 0 24z"></path><path fill="#FFF" d="M21 25.231V34h-7V15h7l6 8.769V15h7v19h-7l-6-8.769z"></path></g></svg></a> -->

<!-- <ul> -->
<!-- 	<li> -->
<!--       아래와같이 아이디를 꼭 써준다. -->
<!--       <a id="naverIdLogin_loginButton" href="javascript:void(0)"> -->
<!--           <span>네이버 로그인</span> -->
<!--       </a> -->
<!-- 	</li> -->
<!-- 	<li onclick="naverLogout(); return false;"> -->
<!--       <a href="javascript:void(0)"> -->
<!--           <span>네이버 로그아웃</span> -->
<!--       </a> -->
<!-- 	</li> -->
<!-- </ul> -->


<!-- 페이스북 -->
<a datatype="facebook" class="css-l0qndx e1ufx3to0" style="margin-right: 40px;"id="fnFbCustomLogin" onclick="fnFbCustomLogin();" href="javascript:void(0)"><svg width="48" height="48" viewBox="0 0 48 48" preserveAspectRatio="xMidYMid meet"><g fill="none" fill-rule="evenodd"><path fill="#3B5998" d="M0 24C0 10.745 10.745 0 24 0s24 10.745 24 24-10.745 24-24 24S0 37.255 0 24z"></path><path fill="#FFF" d="M25.77 35V24h3.384v-3.385h-3.385v-2.538c-.012-.756.08-1.285 1.693-1.692h1.692V13h-3.385c-3.25 0-4.52 1.84-4.23 5.077v2.538H19V24h2.538v11h4.231z"></path></g></svg></a>

<!-- <ul> -->
<!--  <li onclick="fnFbCustomLogin();"> -->
<!--   <a href="javascript:void(0)"> -->
<!--    <span>Login with Facebook</span> -->
<!--   </a> -->
<!--  </li> -->
<!-- </ul> -->




<!-- 구글 -->
<a datatype="google" id="GgCustomLogin" class="css-l0qndx e1ufx3to0" href="javascript:void(0)">

<svg xmlns="http://www.w3.org/2000/svg" width="49" height="49" viewBox="0 0 49 49" preserveAspectRatio="xMidYMid meet">
<g fill="none" fill-rule="evenodd">

<g transform="translate(-90.000000, -398.000000) translate(90.000000, 398.000000)">
<circle cx="22" cy="22" r="22" fill="#F4F4F4"></circle>
<g><path fill="#4285F4" d="M21.56 11.25c0-.78-.07-1.53-.2-2.25H11v4.255h5.92c-.255 1.375-1.03 2.54-2.195 3.32v2.76h3.555c2.08-1.915 3.28-4.735 3.28-8.085z" transform="translate(11.000000, 11.000000)"></path>
<path fill="#34A853" d="M11 22c2.97 0 5.46-.985 7.28-2.665l-3.555-2.76c-.985.66-2.245 1.05-3.725 1.05-2.865 0-5.29-1.935-6.155-4.535H1.17v2.85C2.98 19.535 6.7 22 11 22z" transform="translate(11.000000, 11.000000)"></path>
<path fill="#FBBC05" d="M4.845 13.09c-.22-.66-.345-1.365-.345-2.09 0-.725.125-1.43.345-2.09V6.06H1.17C.425 7.545 0 9.225 0 11c0 1.775.425 3.455 1.17 4.94l3.675-2.85z" transform="translate(11.000000, 11.000000)"></path>
<path fill="#EA4335" d="M11 4.375c1.615 0 3.065.555 4.205 1.645l3.155-3.155C16.455 1.09 13.965 0 11 0 6.7 0 2.98 2.465 1.17 6.06l3.675 2.85C5.71 6.31 8.135 4.375 11 4.375z" transform="translate(11.000000, 11.000000)"></path>
<path d="M0 0L22 0 22 22 0 22z" transform="translate(11.000000, 11.000000)"></path>
</g></g></g></svg></a>



<!-- <ul> -->
<!--  <li id="GgCustomLogin"> -->
<!--   <a href="javascript:void(0)"> -->
<!--    <span>Login with Google</span> -->
<!--   </a> -->
<!--  </li> -->
<!-- </ul> -->

</form>

	

</body>
</html>