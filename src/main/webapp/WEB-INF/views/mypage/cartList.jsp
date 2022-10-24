<%@page import="dto.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>

<%-- 모델값 전달받기 --%>
<%	List<Cart> cList = (List) request.getAttribute("cartlist"); %>

<title>cartList</title>
<style type="text/css">
@import url("../sources/mypage/mypage.css");

table, tr, th, td { border: 1px solid #ccc; width: 100%; }
th { text-align: center; }

</style>
</head>
<body>

<h1>장바구니 리스트</h1>
<hr>

<div id="cartResult">
	장바구니 내역 보여주기 <%-- wish_no, wish_total_price, product_no, wish_amount --%>

<table class="table table-hover">
	<thead>
		<tr>
			<th style="width: 20%;">장바구니 번호</th>
			<th style="width: 30%;">총 금액</th>
			<th style="width: 30%;">제품 번호</th>
			<th style="width: 20%;">제품 총 수량</th>
		</tr>
	</thead>
	<tbody> 
		<% for(int i=0; i<cList.size(); i++) { %>
		<tr>
			<td><%= cList.get(i).getCarNo()	%></td>
			<td><%= cList.get(i).getTotalPrice()	%></td>
			<td><%= cList.get(i).getProduct_no()	%></td>
			<td><%= cList.get(i).getWish_amount() %></td>		
		</tr>
		<% } %>
	
	</tbody>
</table>

<div id="blank" style="height: 100px;"></div>

</div>



<%@ include file="../layout/footer.jsp"%>