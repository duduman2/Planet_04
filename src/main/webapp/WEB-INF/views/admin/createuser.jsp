<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 관리</title>
<!-- getElementByName는 왜 에러가 발생하지?? -->
</head>
<body>
<form action="<%=request.getContextPath() %>/admin/adduser" method="post">
	<div style="color: #029EE4; font-size: 1.2em">사용자 생성</div><br>
	<input type="text" id="userid" name="userid" placeholder="아이디(필수)">
	<input type="password" id="userpw" name="userpw" placeholder="비밀번호(필수)"><br><br>
	<input type="text" id="name" name="name" placeholder="이름(필수)">
	<input type="text" id="phone" name="phone" placeholder="휴대폰"><br><br>
	<input type="text" id="email" name="email" placeholder="이메일">
	<input type="text" id="add1" name="add1" placeholder="주소"><br><br>
	<input type="text" id="usernick" name="usernick" placeholder="닉네임(필수)">
	<input type="text" id="userbsno" name="userbsno" placeholder="사업자번호"><br><br>
	<input type="text" id="grade" name="grade" placeholder="등급"><br><br>
	생일(필수) : <input type="date" name="birth"><br><br>
	성별(필수) :
	<input type="radio" id="contactChoice1" name="gender" value="남자">
    <label for="contactChoice1">남자</label>
    <input type="radio" id="contactChoice2" name="gender" value="여자">
    <label for="contactChoice2">여자</label><br><br>
    사업자유무 : 
    <input type="radio" id="contactChoice3" name="tradeuser" value="사업자">
    <label for="contactChoice1">사업자</label>
    <input type="radio" id="contactChoice4" name="tradeuser" value="개인">
    <label for="contactChoice2">개인</label><br><br>
	<button>생성</button>
</form>

</body>
</html>