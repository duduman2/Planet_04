<%@page import="dto.Product"%>
<%@page import="dto.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>장바구니 리스트</title>

<%@include file="../layout/header2.jsp" %>

<%-- 모델값 전달받기 --%>
<%	List<Cart> cList = (List) request.getAttribute("cartlist"); %>
<%  List<Product> pList = (List<Product>) request.getAttribute("productlist"); %>

<script type="text/javascript">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>>
</script>


<style type="text/css">
@import url("../sources/mypage/mypage.css");

table {  width: 100%; }
table, tr, th, td { border: 1px solid #ccc; }
th { text-align: center; }
td { font-size: 1.3em; }
</style>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnMyMain").click(function() {
		$(location).attr("href", "/mypage/main")
	})
	
})

</script>
<!-- </head> -->
<!-- <body> -->

<h3>&nbsp;&nbsp;&nbsp;장바구니 리스트</h3>
<!-- &nbsp;&nbsp;&nbsp;장바구니 내역 보여주기  -->
<hr>

<div id="cartResult">

<table class="table table-hover">
	<thead>
		<tr>
<!-- 			<th>번호</th> -->

			<th>체크</th>
			<th>상품 번호</th>
			<th>상품명</th>
			<th>상품 설명</th>
			<th>상품 가격</th>
			<th>수량</th>
			<th>배송비</th>
		</tr>	
	</thead>
	<tbody> 
<%-- 		<% for(int i=0; i<cList.size(); i++) { %> --%>
		<% for(int j=0; j<pList.size(); j++) { %>
		<tr>
<!-- 			<td>수정할것!! 추가사항</td> -->
<!-- 			<td>상품번호 productNo
					상품명 productName
					가격 productPrice
					수량 productQuan </td> -->

<%-- 			<td style="text-align: center;"><%= cList.get(i).getCarNo()	%> 번</td> --%>

			<td style="text-align: center;"><input type="checkbox" name="checkedCart" value=""  style="zoom:2.0;"></td>
			<td><%= pList.get(j).getProductNo()	%></td>
			<td><%= pList.get(j).getProductName()	%></td>
			<td><%= pList.get(j).getProductContent()	%></td>
			<td style="text-align: right;"><%= pList.get(j).getProductPrice()	%> 원</td>
			<td style="text-align: right;"> 개</td>
			
<%-- 			<td style="text-align: center;"><%= cList.get(i).getDeliveryfee()	%>배송비유무?금액?</td> --%>






		</tr>
		<% } %>
<%-- 		<% } %> --%>
	</tbody>
</table>
	
<table class="table table-hover">
<thead>
		<tr>	
			<th>제품 전체 금액</th>
			<th>제품 총 수량</th>
			<th>예상 할인금액</th>
			<th>최종 금액</th>
		</tr>
</thead>
<tbody>
		<tr>
<%-- 		<% for(int i=0; i<cList.size(); i++) { %> --%>
<%-- 		<% for(int j=0; j<pList.size(); j++) { %> --%>
<%-- 			<td style="text-align: right;"><%= cList.get(i).getWish_amount() %> 개</td>		 --%>
<%-- 			<td style="text-align: right;"><%= cList.get(i).getTotalPrice() %> 원</td> --%>
			<td style="text-align: right;"> 원</td>		
			<td style="text-align: right;"> 개</td>		
			<td style="text-align: right;"> 원</td>
			<td style="text-align: right;"> 원</td>
		</tr>
<%-- 		<% } %> --%>
<%-- 		<% } %> --%>
		
		
		
</tbody>		
</table>	
		<div class="text-center" >
			<button style="width: 120px; height: 70px; float: center;" class="btn btn-info" >결제하기</button>
			
			&nbsp;&nbsp;&nbsp;
			
			<button id="btnBack" class="btn btn-default" style="width: 120px; 
				height: 50px;" onclick="history.go(-1)">이전으로</button>
			
			&nbsp;&nbsp;&nbsp;
			
			<button id="btnMyMain" class="btn btn-default"  
			style="width: 155px; height: 50px;">마이페이지-메인으로</button>
		</div>

<div id="blank" style="height: 100px;"></div>

</div><!-- cartResult end -->



<%@ include file="../layout/footer.jsp"%>