<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>

<style type="text/css">

/* html, body를 100% 안하면 아래 div요소는 hmtl, body 내에서 100%임 */
html, body {
	height: 100%;
	margin: 0px;
}

input {
	width: 300px;
	height: 25px;
}

button {
	width: 310px;
	height: 30px;
	background-color: #029EE4;
	border-color: #029EE4;
	border: 0px;
	color: white;
}

button:hover {
	cursor: pointer;
}

.background {
	display: flex;
	justify-content: center; /* flex 수평 정렬 */
    align-items: center; /* flex 수직 정렬 */
    
	height: 100%;
	background-color: #C0ED7050;
}

.mainbox {
	width: 400px;
	height: 550px;
	background-color: white;
	border: solid 1px gray;
}

.top {
	height: 25%;
	background-color: white;
	
	display: flex;
	justify-content: center;
    align-items: center;
}

.middle1 {
	height: 5px;
	background-color: #029EE4;
}

.middle2 {
	height: 45%;
	background-color: white;
	text-align: center; /* 인라인 요소 가운데 정렬 */
	
	display: flex;
	justify-content: center;
    align-items: center;
}

.bottom {
	height: 160px; /* 어떻게 '나머지 영역을 가득 채운다'를 설정하지?? */
	background-color: #D3D3D3;
	text-align: center;
	font-size: 0.8em;
	line-height: 1.8em; /* 세로간 행 간격 늘리기 */
	
	display: flex;
	justify-content: center;
    align-items: center;
}

</style>

</head>
<body>

<div class="background">
	<div class="mainbox">
		<div class="top">
			<img src="<%=request.getContextPath() %>/sources/admin/logo.png">
			<!-- WEB-INF 내의 파일은 브라우저에서 직접 접근이 불가하므로 컨트롤러를 거쳐야 한다. -->
		</div>
		<div class="middle1">
		</div>
		<div class="middle2">
			<form action="<%=request.getContextPath() %>/adminlogin" method="post">
				<div style="color: #029EE4; font-size: 1.2em">관리자 로그인<br><br></div>
				<input type="text" name="userid" placeholder="로그인 아이디"><br><br>
				<input type="password" name="userpw" placeholder="비밀번호"><br><br>
				<button>Login</button>
			</form>
		</div>
		<div class="bottom">
		본 시스템은 개인정보처리시스템 입니다.<br>
		본 시스템을 통해 습득한 개인정보를 무단으로 외부에 유출할 경우,<br>
		5년 이하의 징역 또는 5천만원 이하의 벌금에 처해질 수 있습니다.<br>
		처벌근거 : 정보통신망법 제 71조(벌칙), 개인정보보호법 제 71조<br>
		본 시스템의 보안등급 : 3(최고등급, Very high)
		</div>
	</div>
</div>

</body>
</html>