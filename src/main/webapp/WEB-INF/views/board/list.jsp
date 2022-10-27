<%-- <%@page import="dto.BoardInfo"%> --%>
<%-- <%@page import="java.util.List"%> --%>
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
<title>Planet List</title>

<style type="text/css">

tr td{

	text-align: center;

}

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



<!-- <h1>안보인다</h1> -->
<div class="container">
	<table class="table table-hover">
		<thead>
		<tr>
			<th style="background-color: #e4f7ba; text-align: center;">번호</th>	
			<th style="background-color: #e4f7ba; text-align: center;">제목</th>	
			<th style="background-color: #e4f7ba; text-align: center;">작성자</th>	
			<th style="background-color: #e4f7ba; text-align: center;">날짜</th>	
			<th style="background-color: #e4f7ba; text-align: center;">조회수</th>	
		</tr>
		</thead>
		<tbody>
		<tr>
			<td onclick="location.href='http://localhost:8888/board/view'">1</td>
			<td onclick="location.href='http://localhost:8888/board/view'">뚱인데요</td>
			<td>이웃</td>
			<td>2022.10.26</td>
			<td>27</td>
		</tr>
		<tr>
			<td>2</td>
			<td>말인데요</td>
			<td>말</td>
			<td>2022.10.26</td>
			<td>35</td>
		</tr>
		<tr>
			<td>3</td>
			<td>밥인데요</td>
			<td>기</td>
			<td>2022.10.26</td>
			<td>13</td>
		</tr>
		<tr>
			<td>4</td>
			<td>전인데요</td>
			<td>전</td>
			<td>2022.10.26</td>
			<td>4</td>
		</tr>
		<tr>
			<td>5</td>
			<td>란란루</td>
			<td>룰루</td>
			<td>2022.10.26</td>
			<td>37</td>
		</tr>
	</tbody>
</table>
<hr>


<!-- 버튼 12345 -->
<button onclick="location.href='http://localhost:8888/board/write'" type="button" class="btn btn-primary float-right"
style="background-color: #003300;">글작성</button>


<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">4</a></li>
    <li class="page-item"><a class="page-link" href="#">5</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>


</body>
</html>


































