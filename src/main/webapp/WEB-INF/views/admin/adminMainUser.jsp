<%@page import="dto.UserInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 관리</title>

<%@ include file="./header.jsp" %>

<% List<UserInfo> userList = (List) request.getAttribute("userList"); %>
<% String userid = (String) request.getAttribute("userid"); %>

<style type="text/css">
.configbutton {
	width: 100px;
	height: 30px;
	background-color: white;
	border: solid 1px #029EE4;
	color: #029EE4;
	margin: 10px;
	border-radius: 20px / 30px;
}
.admintable {
	width: 98%;
	height: 100px;
	margin-left: 10px;
}

th {
	border: 1px solid gray;
	text-align: center;
}

td {
	border: 1px solid gray;
	text-align: center;
}
</style>

<script type="text/javascript">
	function createuser() {
	 
	    var _width = '600';
	    var _height = '300';
	 
	    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
	    var _left = Math.ceil(( window.screen.width - _width )/2);
	    var _top = Math.ceil(( window.screen.height - _height )/2); 
	 
	    window.open('<%=request.getContextPath() %>/admin/adduser', 'adduser', 'width='+ _width +',height='+ _height +',left='+ _left +',top='+ _top );
	 
	}
	
	function deleteuser() {
		 
		    var _width = '600';
		    var _height = '300';
		 
		    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
		    var _left = Math.ceil(( window.screen.width - _width )/2);
		    var _top = Math.ceil(( window.screen.height - _height )/2); 
		 
		    window.open('<%=request.getContextPath() %>/admin/deluser', 'deluser', 'width='+ _width +',height='+ _height +',left='+ _left +',top='+ _top );
		 
	}
	
	function updateuser( url ) {
		 
		    var _width = '600';
		    var _height = '300';
		 
		    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
		    var _left = Math.ceil(( window.screen.width - _width )/2);
		    var _top = Math.ceil(( window.screen.height - _height )/2); 
		 
		    window.open('<%=request.getContextPath() %>/admin/uptuser?userid=' + url , 'uptuser', 'width='+ _width +',height='+ _height +',left='+ _left +',top='+ _top );
		 
	}
</script>

</head>
<body>

<div class="up">
	<div class="lefttopbox">
	메뉴
	</div>
	<div class="righttopbox">
	사용자 관리
	</div>
</div>

<div class="down">
	<div class="leftbottombox">
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainnotice">공지사항</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainconfig">관리자 관리</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/admin/mainboard">게시글 관리</a>
		</div>
		<div class="menubutton" style="background-color: #e9ecef">
			<a href="<%=request.getContextPath() %>/admin/mainuser">사용자 관리</a>
		</div>
		<div class="menubutton">
			<a href="<%=request.getContextPath() %>/adminlogout">로그아웃</a>
		</div>
	</div>
	<div class="rightbottombox">
		<!-- 여기부터 달라진다 -->
		<button class="configbutton" onclick="createuser();">사용자 추가</button>
		<button class="configbutton" onclick="deleteuser();">사용자 삭제</button>
		<form action="<%=request.getContextPath() %>/admin/mainuser" method="get" style="display: inline;">
			<input type="search" style="margin-left: 10px; border-color: #029EE4" name="userid" placeholder="아이디" value="<%=userid%>">
			<button>검색</button>
			<button type="button" onclick="location.href='/admin/mainuser'">초기화</button>
		</form>
		<br>
		<table class="admintable">
			<tr>
				<th class="text-center">번호</th>
				<th class="text-center">아이디</th>
				<th class="text-center">이름</th>
				<th class="text-center">생일</th>
				<th class="text-center">성별</th>
				<th class="text-center">휴대폰</th>
				<th class="text-center">이메일</th>
				<th class="text-center">주소</th>
				<th class="text-center">닉네임</th>
				<th class="text-center">가입일자</th>
				<th class="text-center">사업자유무</th>
				<th class="text-center">사업자번호</th>
				<th class="text-center">등급</th>
				<th class="text-center">신고</th>
				<th class="text-center">편집</th>
			</tr>
			<% for(int i=0; i<userList.size(); i++) { %>			
			<tr>
				<td style="width: 3%"><%=userList.get(i).getU_no() %></td>
				<td style="width: 7%"><%=userList.get(i).getU_id() %></td>
				<td style="width: 5%"><%=userList.get(i).getU_name() %></td>
				<td style="width: 5%"><%=userList.get(i).getU_birth() %></td>
				<td style="width: 3%"><%=userList.get(i).getU_gender() %></td>
				<td style="width: 5%"><%=userList.get(i).getU_phone() %></td>
				<td style="width: 12%"><%=userList.get(i).getU_email() %></td>
				<td style="width: 27%"><%=userList.get(i).getU_address() %></td>
				<td style="width: 7%"><%=userList.get(i).getU_nick() %></td>
				<td style="width: 5%"><%=userList.get(i).getU_join_date() %></td>
				<td style="width: 5%"><%=userList.get(i).getU_trade_user() %></td>
				<td style="width: 7%"><%=userList.get(i).getB_business_number() %></td>
				<td style="width: 3%"><%=userList.get(i).getGrade() %></td>
				<td style="width: 3%"><%=userList.get(i).getReportcode() %></td>
				<td style="width: 3%">
				<input type="button" value="수정" onclick="updateuser('<%=userList.get(i).getU_id() %>')"/>
				<!-- 자바스크립트 함수에 String 매개변수 넣을거면 꼭 ''으로 감싸줘야 한다. ""도 안됨. -->
				</td>
			</tr>
			<% } %>
		</table>
		<%@ include file="./paging2.jsp" %>
		
		<!-- 여기부터 달라진다 -->
	</div>
</div>
</body>
</html>