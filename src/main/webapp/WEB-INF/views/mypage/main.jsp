<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

<!-- 부트스트랩3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- bootstrap -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<!-- 스마트 에디터2 라이브러리 -->
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>

<!-- jQuery 2.2.4 라이브러리 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<style type="text/css">
* { font-size: 1.03em;}
table { border: 1px solid #ccc; border-collapse: collapse }

div {  width: 100%; }
div.left_section { 
	 
	/* 나중에 header 연결 후 수정하기!! */
/* 	width: 40%; */
	
	display: block;
	margin-top: 30px;
 	margin-left: 100px; /* 나중에 header 연결 후 수정하기!! */
	margin-right: 50px;
	float: left;
/* 	background-color: #DBF227; */
}
div.verticalline {
 	width: 0.5%; 
	height: 700px;
 	margin: 30px, 30px; 
	
	border-left-width: medium; 
	border-left-style: solid; 
	border-left-color: block;

	float: left;
/* 	background-color: #005C53; */
 }
div.right_section { 
/* 	width: 55%  */
	margin-left: 50px;
	margin-top: 30px;
	float: left;
/* 	background-color: #D6D58E; */
}
</style>
</head>
<body>

<%-- <%@include file="..//header.jsp" %> --%>

<h1>/mypage/main.jsp</h1>
<h3>마이페이지 메인</h3>
회원정보 조회,수정,탈퇴 / 내가 작성한 글 확인 / 내가 구매한 리스트 <br>
/ 등급 확인 / 나의 장바구니 등 꾸미기
<hr>

<div class="main" style="width: 100%;"> 

<div class="left_section" id="left_section" style="width: 20%; float: left;">
<table class="table">
	<tr>
		<th class="info" colspan="2">프로필 설정<button style="float: right;">설정(수정)</button></th>
	</tr>
	<tr style="height: 300px;">
		<td colspan="2" style="text-align: center;"><img src="../sources/mypage/DefaultImage.png" alt="기본이미지" 
		style="width: 200px; height:200px; border-radius: 50%; display: block; 
		margin: auto; margin-top: 20px; padding: 10px;" ></img><br>아이디? 닉네임?값 가져오기</td>
	</tr>
	<tr>
		<th style="text-align: center; height: 50px;">회원 등급</th>
		<td >회원 등급값 가져오기</td>
	</tr>	

	<tr>
		<th style="text-align: center; height: 50px;">내 포인트</th>
		<td>포인트값 가져오기 + P</td>
	</tr>	
	<tr>
		<th style="text-align: center; height: 50px;">내가 쓴 글</th>
		<td>내가쓴글ctn 가져오기</td>
	</tr>
	</table>	
</div>


<div class="verticalline" id="verticalline"  style="float: left;"></div>
	<div class="right_section" id="right_section"  style="width: 60%; float: left;">
		<table class="table">
			<tr>
				<th class="info" colspan="2">나의 쇼핑</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>

		</table>  <!-- first table end -->
		
		<table class="table">
			<tr>
				<th class="info" colspan="2">내가 작성한 글 확인하기</th>
			</tr>
			<tr>
				<td>게시판</td>
				<td><button>게시판 더보기</button></td>
			</tr>
			<tr>
				<td>댓글</td>
				<td><button>댓글 더보기</button></td>
			</tr>
			<tr>
				<th class="info" colspan="2">내가 구매한 리스트</th>
			</tr>
			<tr>
				<th class="info" colspan="2">장바구니</th>
			</tr>
		</table>  <!-- second table end -->
		
		<table class="table">
			<tr>
				<th class="info" colspan="2">Q n A</th>
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
		
	</div> <!-- right_section  end -->
	
</div><!-- verticalline  end -->
</table>

<%-- <%@include file="..//footer.jsp" %> --%>

</body>
</html>