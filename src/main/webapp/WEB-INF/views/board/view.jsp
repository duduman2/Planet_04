<%@page import="dto.BoardFile"%>
<%@page import="dto.BoardInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Planet View</title>


<style type="text/css">

header{

	text-align: center;
	color: #003300;

}

</style>

</head>
<body>

<!-- ---------------------------------------------------------------------------- -->

<!-- 헤더 -->
<header>
	<div class="container">
		<br>
		<h1>Planet</h1>
		<br>
		<hr>
	</div>
</header>

<!-- ---------------------------------------------------------------------------- -->

<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #e4f7ba; text-align: center;">
							게시판 글 보기</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%; background-color: #e4f7ba;">제목</td>
						<td style="background-color: #FFFFFF; border: 1px solid #EEEEEE;">뚱인데요</td>
					</tr>
					<tr>
					</tr>
					<tr>
						<td style="width: 20%; background-color: #e4f7ba;">작성자</td>
						<td style="background-color: #FFFFFF; border: 1px solid #EEEEEE;">이웃</td>
					</tr>
					<tr>
						<td style="width: 20%; background-color: #e4f7ba;">내용</td>
						<td colspan ="2" style = "min-height:200px; text-align: center">선장님 네모네모스폰지밥 
						게살버거 한개 포장이요</td>
					</tr>
					
					
				</tbody>
			</table>
			<button onclick="location.href='http://localhost:8888/board/list'" type="button"
					class="btn btn-primary float-right"
					style="background-color: #003300;">목록</button>

		</div>
	</div>









</head>
<body>












































