<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Planet</title>
</head>
<body>
	<%
		String userId = null; /* Id 임 */
		if(session.getAttribute("userId") !=null){
			userId=(String) session.getAttribute("userId");
		}
	
	%>

	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/board/main.jsp">Planet</a> <!-- /board 추가한거  -->
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/board/main.jsp">메인</a></li>
				<li class="active"><a href="/board/bbs.jsp">게시판</a></li> <!-- 이게 게시판 보드임 -->
			</ul>

			<%
			
				if(userId == null){
			
			%>
			
			
<!-- 			<ul class="nav navbar-nav navbar-right"> -->
<!-- 				<li class="dropdown"> -->
<!-- 					<a href="#" class="dropdown-toggle" -->
<!-- 						data-toggle="dropdown" role="button" aria-haspopup="true" -->
<!-- 						aria-expanded="false">접속하기<span class="caret"></span></a> -->
<!-- 					<ul class="dropdown-menu"> -->
<!-- 						<li><a href="login.jsp">로그인</a><li> -->
<!-- 						<li><a href="join.jsp">회원가입</a><li> -->
<!-- 					</ul> -->
<!-- 				</li>	 -->
<!-- 			</ul> -->

			<%
			
				}else{
			
			%>		
					<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="">로그아웃</a><li>
					</ul>
				</li>	
			</ul>
			
			
			<% 
			
				}
			
			%>

		
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align : center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #e4f7ba; text-align: center;">번호</th>
						<th style="background-color: #e4f7ba; text-align: center;">제목</th>
						<th style="background-color: #e4f7ba; text-align: center;">작성자</th>
						<th style="background-color: #e4f7ba; text-align: center;">작성일</th>
					</tr>				
				</thead>
				<tbody>
					<tr>
						<td>1</td>					
						<td>안녕하세요</td>					
						<td>ㅁㄴㅇ</td>					
						<td>2022-12-31</td>					
					</tr>
				</tbody>
			</table>
			<a href="/board/write.jsp" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>

	
	
	<script src="https;//code.jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>

</body>
</html>



























































