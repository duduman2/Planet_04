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

table {  width: 100%; }
table, tr, th, td { border: 1px solid #ccc; }
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
			<th>장바구니 번호</th>
			<th>제품 번호</th>
		</tr>	
	</thead>
	<tbody> 
		<% for(int i=0; i<cList.size(); i++) { %>
		<tr>
			<td><%= cList.get(i).getCarNo()	%> 번</td>
<!-- 			<td>상품명+링크 추가하기</td> -->
<!-- 			<td>제품세부사항(컬러, 사이즈)+수정하기</td> -->
			<td><%= cList.get(i).getProduct_no()	%></td>
<!-- 			<td>제품 가격</td> -->
<!-- 			<td>배송비유무</td> -->

		</tr>
<%-- 		<% } %> --%>
	
	</tbody>
	<tfoot>
		<tr>	
<%-- 		<% for(int i=0; i<cList.size(); i++) { %> --%>
			<th>제품 총 수량</th>
			<th>총 금액</th>
		</tr>
		<tr>
			<td style="text-align: right;"><%= cList.get(i).getWish_amount() %> 개</td>		
			<td style="text-align: right;"><%= cList.get(i).getTotalPrice() %> 원</td>
		</tr>
		<% } %>
	</tfoot>
</table>

<div id="blank" style="height: 100px;"></div>

</div>



<%@ include file="../layout/footer.jsp"%>