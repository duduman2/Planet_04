<%@page import="dto.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>장바구니 리스트</title>

<%@include file="../layout/header.jsp" %>

<%-- 모델값 전달받기 --%>
<%	List<Cart> cList = (List) request.getAttribute("cartlist"); %>


<script type="text/javascript">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</script>


<style type="text/css">
@import url("../sources/mypage/mypage.css");

table {  width: 100%; }
table, tr, th, td { border: 1px solid #ccc; }
th { text-align: center; }

</style>
<!-- </head> -->
<!-- <body> -->

<h1>장바구니 리스트</h1>
<hr>

<div id="cartResult">
	장바구니 내역 보여주기 

<table class="table table-hover">
	<thead>
		<tr>
			<th>번호</th>
			<th>제품 번호</th>
			<th>제품명</th>
			<th>제품 가격</th>
			<th>배송비</th>
		</tr>	
	</thead>
	<tbody> 
		<% for(int i=0; i<cList.size(); i++) { %>
		<tr>
			<td style="text-align: center;"><%= cList.get(i).getCarNo()	%> 번</td>
			<td><%= cList.get(i).getProduct_no()	%></td>
			<td><%= cList.get(i).getProduct_name()	%>상품명+링크</td>
			<td><%= cList.get(i).getPrice()	%>제품 가격</td>
			<td><%= cList.get(i).getDeliveryfee()	%>배송비유무</td>
<!-- 			<td>제품세부사항(컬러, 사이즈)+수정하기</td> -->

		</tr>
		<% } %>
	</tbody>
</table>
	
<table class="table table-hover">
<thead>
		<tr>	
			<th>제품 총 수량</th>
			<th>예상 할인금액</th>
			<th>총 금액</th>
		</tr>
</thead>
<tbody>
		<tr>
		<% for(int i=0; i<cList.size(); i++) { %>
<%-- 			<td style="text-align: right;"><%= cList.get(i).getWish_amount() %> 개</td>		 --%>
<%-- 			<td style="text-align: right;"><%= cList.get(i).getTotalPrice() %> 원</td> --%>
		</tr>
		<% } %>
		
		
		
</tbody>		
</table>	
		<div class="text-center" >
			<button style="width: 120px; height: 70px; float: center;" >결제하기</button>
			&nbsp;&nbsp;&nbsp;
			<button id="btnBack" class="btnBack" style="width: 120px; 
				height: 50px;" onclick="history.go(-1)">되돌아가기</button>
		</div>

<div id="blank" style="height: 100px;"></div>

</div><!-- cartResult end -->



<%@ include file="../layout/footer.jsp"%>