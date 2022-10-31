<%@page import="dto.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% UserInfo userInfo = (UserInfo)request.getAttribute("userInfo"); %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 관리</title>
<style type="text/css">
td {
	padding-bottom: 20px;
}
</style>
</head>
<body>

<form action="<%=request.getContextPath() %>/admin/uptuser" method="post">
	<div style="color: #029EE4; font-size: 1.2em">사용자 수정</div><br>
	번호(변경불가) <input type="text" name="userno" value="<%=userInfo.getU_no() %>" readonly="readonly"><br><br>
	<table>
			<tr>
				<td>아이디 <input type="text" name="userid" placeholder="아이디(필수)" value="<%=userInfo.getU_id() %>"></td>
				<td>비밀번호 <input type="text" name="userpw" placeholder="비밀번호(필수)" value="<%=userInfo.getU_pw() %>"></td>
			</tr>
			<tr>
				<td>이름&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name" placeholder="이름(필수)" value="<%=userInfo.getU_name() %>"></td>
				<td>휴대폰&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="phone" placeholder="휴대폰" value="<%=userInfo.getU_phone() %>"></td>
			</tr>
			<tr>
				<td>이메일 <input type="text" name="email" placeholder="이메일" value="<%=userInfo.getU_email() %>"></td>
				<td>주소&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="add1" placeholder="주소" value="<%=userInfo.getU_address() %>"></td>
			</tr>
			<tr>
				<td>닉네임 <input type="text" name="usernick" placeholder="닉네임(필수)" value="<%=userInfo.getU_nick() %>"></td>
				<td>사업자&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userbsno" placeholder="사업자" value="<%=userInfo.getB_business_number() %>"></td>
			</tr>
			<tr>
				<td>등급&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="grade" placeholder="등급" value="<%=userInfo.getGrade() %>"></td>
				<td>신고&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="reportcode" placeholder="신고" value="<%=userInfo.getReportcode() %>"></td>
			</tr>
	</table>
	생일(필수) : <input type="date" name="birth" value="<%=userInfo.getU_birth() %>"><br><br>
	성별(필수) :
	<%if ( userInfo.getU_gender().equals("남자") ) {%>
	<input type="radio" id="contactChoice1" name="gender" value="남자" checked="checked">
    <label for="contactChoice1">남자</label>
    <input type="radio" id="contactChoice1" name="gender" value="여자">
    <label for="contactChoice2">여자</label><br><br>
    <%} else {%>
    <input type="radio" id="contactChoice1" name="gender" value="남자">
    <label for="contactChoice1">남자</label>
    <input type="radio" id="contactChoice1" name="gender" value="여자" checked="checked">
    <label for="contactChoice2">여자</label><br><br>
    <%}%>
    사업자유무 : 
    <%if ( userInfo.getU_trade_user().equals("사업자") ) {%>
    <input type="radio" id="contactChoice2" name="tradeuser" value="사업자" checked="checked">
    <label for="contactChoice1">사업자</label>
    <input type="radio" id="contactChoice2" name="tradeuser" value="개인">
    <label for="contactChoice2">개인</label><br><br>
    <%} else {%>
    <input type="radio" id="contactChoice2" name="tradeuser" value="사업자">
    <label for="contactChoice1">사업자</label>
    <input type="radio" id="contactChoice2" name="tradeuser" value="개인" checked="checked">
    <label for="contactChoice2">개인</label><br><br>
    <%}%>
	<button>수정</button>
</form>

</body>
</html>