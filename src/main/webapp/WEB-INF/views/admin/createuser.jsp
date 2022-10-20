<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 관리</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/admin/adduser" method="post">
	<div style="color: #029EE4; font-size: 1.2em">사용자 생성</div><br>
	<input type="text" name="userid" placeholder="아이디(필수)">
	<input type="password" name="userpw" placeholder="비밀번호(필수)"><br><br>
	<input type="text" name="name" placeholder="이름(필수)">
	<input type="text" name="phone" placeholder="휴대폰"><br><br>
	<input type="text" name="email" placeholder="이메일">
	<input type="text" name="add1" placeholder="주소"><br><br>
	<input type="text" name="usernick" placeholder="닉네임(필수)">
	<input type="text" name="userbsno" placeholder="사업자번호"><br><br>
	생일 : <input type="date" name="birth"><br><br>
	
	<input type="radio" id="contactChoice1" name="gender">
    <label for="contactChoice1">남자</label>
    <input type="radio" id="contactChoice2" name="gender">
    <label for="contactChoice2">여자</label><br><br>
    
    <input type="radio" id="contactChoice3" name="tradeuser">
    <label for="contactChoice1">사업자</label>
    <input type="radio" id="contactChoice4" name="tradeuser">
    <label for="contactChoice2">개인</label><br><br>
	<button>생성</button>
</form>

</body>
</html>