<%@page import="dto.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>마이페이지</title>

<%@include file="../layout/header2.jsp" %>

<%-- 모델값 전달받기 --%>
<% 	UserInfo uList = (UserInfo) request.getAttribute("data"); %>



<script type="text/javascript">
<script type="text/javascript">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>>
</script>


<style type="text/css">
@import url("../sources/mypage/mypage.css");

</style>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnUserInfo").click(function() {
		$(location).attr("href", "/user/info")
	})
	$("#btncartList").click(function() {
		$(location).attr("href", "/cart/list")
	})
	$("#btnBoard").click(function() { //일반 게시판 페이지 이동
		$(location).attr("href", "/board/list")
	})
	$("#btnMeetBoard").click(function() { //모임 게시판 페이지 이동
		$(location).attr("href", "/board/list")
	})
	$("#btnOldTrade").click(function() { //중고 거래 페이지 이동
		$(location).attr("href", "/trade")
	})

})

</script>

<!-- </head> -->
<!-- <body> -->


<link rel="icon" href="<%=request.getContextPath() %>/sources/admin/favicon.ico">

<h3>&nbsp;&nbsp;&nbsp;마이페이지</h3>
<!-- 회원정보 조회,수정,탈퇴 / 내가 작성한 글 확인,수정,삭제 / 장바구니 확인,수정,삭제 / 내가 구매한 리스트 / 등급 확인 / 등 꾸미기 -->
<hr>

<div class="main" style="width: 100%;"> 

<!-- left profile section -->
<div class="left_section" id="left_section" style="width: 30%; float: left;">
<table class="table ">
	<tr>
		<th class="bg-success" colspan="2" style="color: #128525;">
		<a href="/user/info" style="color: #5B9E28">프로필 설정</a>
		<button type="button" style="float: right;" id="btnUserInfo" class="btn btn-default">설정</button></th>
	</tr>
	
	<tr style="height: 300px;">
		<td colspan="2" style="text-align: center;"><img src="<%=request.getContextPath() %>../sources/mypage/DefaultImage.png" 
		alt="기본이미지" style="width: 200px; height:200px; border-radius: 50%; 
		display: block; margin: auto; margin-top: 20px; padding: 10px;" ></img>
		
		<%-- (font-style) (font-weight) (font-size)/줄간격(font-height) 글꼴(font-family)  --%>
		<h3 style="font-style: italic; font-weight: bold; font-size= 2em; color: #5B9E28"><%=uList.getU_nick() %></h3>
<!-- 		<h3>닉네임 불러오기</h3> -->
		</td>
	</tr>
	
	<tr>
		<th style="text-align: center; height: 50px;">회원 등급</th>
 		<td><a href="/grade/info" style="color: #5B9E28"><%=uList.getGrade() %></a></td>
<!-- 		<td>회원 등급값 가져오기</td> -->
	</tr>	

	<tr>
		<th style="text-align: center; height: 50px;">내 포인트</th>
<!-- 		<td>포인트값 가져오기 + P</td> -->
		<td><%=uList.getU_point() %> P</td>
	</tr>
		
	<tr>
		<th style="text-align: center; height: 50px;">내가 쓴 글</th>
<!-- 		<td>내가쓴글ctn 가져오기</td> -->
		<td> </td>
	</tr>
	
	</table>	
</div>


<!-- verticalline section -->
<div class="verticalline" id="verticalline"  style="float: left;">
<!-- 	<div style="color: white;">v</div> -->
<!-- 	<div>v</div> -->
</div>


<!-- right table's section -->
<div class="right_section" id="right_section"  style="width: 67%; float: left; text-align: center;">
	<table class="table " style="text-align: center;" >
<!-- 	<table style="text-align: center;" > -->
		<tr>
			<th class="bg-success" colspan="3" style="color: #3471C;">나의 쇼핑<button style="float: right;" class="btn btn-default">+전체보기</button></th>
		</tr>
		<tr>
<!-- 			<td><button id="btncartList">+장바구니</button></td> -->
			<td><a id="btncartList"  class="btn btn-default" style="width: 150px; height: 100px; 
				padding-top: 38px; font-size: larger;">+장바구니</a></td>
				
			<td><a id="deleveryCheck"  class="btn btn-default" style="width: 150px; height: 100px; 
				padding-top: 38px; font-size: larger;">+배송 확인</a></td>
				
			<td><a id="refund"  class="btn btn-default" style="width: 150px; height: 100px; 
				padding-top: 38px; font-size: larger;">+환불/반품</a></td>
		</tr>
		<tr>
			<td><a id="point"  class="btn btn-default" style="width: 150px; height: 100px; 
				padding-top: 38px; font-size: larger;">+포인트</a></td>
				
			<td><a id="question"  class="btn btn-default" style="width: 150px; height: 100px; 
				padding-top: 38px; font-size: larger;">+문의 사항</a></td>
				
			<td><a id="costomerCenter"  class="btn btn-default" style="width: 150px; height: 100px; 
				padding-top: 38px; font-size: larger;">+고객센터</a></td>
		</tr>

	</table>  <!-- first table end -->
	
	<table class="table">
		<tr>
			<th class="bg-success" colspan="2" style="color: #3471C;">내가 작성한 글 확인하기<button style="float: right;" class="btn btn-default">+전체보기</button></th>
		</tr>
		<tr>
			<td>게시판</td>
			<td>
			<button class="btn btn-default" id="btnBoard">일반 게시판</button>
			<button class="btn btn-default" id="btnMeetBoard">모임 게시판</button>
			<button class="btn btn-default" id="btnOldTrade">중고 거래</button>
			
			</td>
		</tr>
		<tr>
			<td>댓글</td>
			<td><button class="btn btn-default">나의 댓글</button></td>
		</tr>

	</table>  <!-- second table end -->
	
	<table class="table">
		<tr>
			<th class="bg-success" colspan="2" style="color: #3471C;">내가 구매한 리스트<button style="float: right;" class="btn btn-default">+전체보기</button></th>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table>  <!-- third table end -->
			
	<table class="table">
		<tr>
			<th class="bg-success" colspan="2" style="color: #3471C;">Q n A
			<button style="float: right;" class="btn btn-default" id="">+전체보기</button></th>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table>  <!--forth table end -->		
	
</div> <!-- right_section  end -->
	
</div><!-- verticalline  end -->
</table>


<div id="blank" style="height: 100px; margin-bottom: 600px;"> </div>

<%@include file="../layout/footer.jsp" %>

<!-- </body> -->
<!-- </html> -->