<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Planet Write</title>

<style type="text/css">

header{

	text-align: center;
	color: #003300;

}

</style>


</head>
<body>
	
<!-- 헤더 -->
<header>
	<div class="container">
		<br>
		<h1>Planet</h1>
		<br>
		<hr>
	</div>
</header>


  
<div class = "container">
	<form method="post" action="writeAction.jsp">
		<table class = "table table-striped" style="text-align: center; boerder: 1px solid #dddddd; background-color: #FFFFFF;"> 
			<thead>
				<tr>
					<th colspan ="2" style="background-color: #e4f7ba; text-align: center;">게시판</th>
				</tr>				
			</thead>
			<tbody>
				<tr>
					<td><input type = "text" class="form-control" placeholder="제목을 입력하세요" name="Title" maxlength="50"></td>
					<!-- input 타입은 특정한 정보를 Action 페이지에 보낼때 필요 -->
				</tr>
						
				<tr>
					<td><textarea class="form-control" placeholder="내용을 입력하세요" name="Content" maxlength="2048" style="height: 350px;"></textarea></td>
				</tr>
			</tbody>
			<!-- Action 페이지로 보낼 수 있음 -->
		</table>
		<input type="submit" style="background-color: #003300;" class="btn btn-primary float-right" value = "글쓰기">
	</form>
</div>
	
	

</body>
</html>



























































