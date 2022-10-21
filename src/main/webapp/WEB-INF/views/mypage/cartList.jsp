<%@page import="dto.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>

<%	List<Cart> cList = (List) request.getAttribute("cartList"); %>

<title>cartList</title>
<style type="text/css">
@import url("../sources/mypage/mypage.css");

</style>
</head>
<body>

<h1>장바구니 리스트</h1>
<hr>

<div id="cartResult">
	장바구니 내역 보여주기

	<table>
	<thead>
		<tr> <%-- wish_no, wish_total_price, product_no, wish_amount --%>
			<th style="width: 20%">장바구니 번호</th>
			<th style="width: 30%">총 금액</th>
			<th style="width: 30%">제품 번호</th>
			<th style="width: 20%">제품 총 수량</th>
		</tr>
	</thead>
	<tbody>
		
	
	</tbody>
	</table>

</div>



<%@ include file="../layout/footer.jsp"%>