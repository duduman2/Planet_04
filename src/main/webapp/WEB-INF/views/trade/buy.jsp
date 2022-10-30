<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../layout/header2.jsp"%>
<%Product productView = (Product)request.getAttribute("buyinfo"); %>
<script type="text/javascript">
$(document).ready(function(){
	$("#goPayment").click(function(){	
// 		var productNo = $("#productNo").html()
// 		console.log(productNo)
// 				location.replace('/paypay?&productNo=$(".productNo")') //구매페이지 이동
		$.ajax({
			type: "post"			//요청 메소드
			,url: "/paypay"	//요청 URL
			,data: {				//요청 파라미터
				productNo: '<%=productView.getProductNo()%>'
				, productUser: '<%=productView.getProuserId()%>'
				, productPrice: '<%=productView.getProductPrice()%>'
				, productQuan: '<%=request.getAttribute("proquan")%>'
			}
			,dataType: "html"		//응답 데이터 형식
			,success:function(res){
				console.log("AJAX 성공")
				location.href = '/paypay'
			}
			,error:function(){
				console.log("AJAX 실패")
			}
		})
	})
	$("#goCharge").click(function(){	
		window.open('/charging', '_blank','width=500, height=700, left=600, top=200');
	})
	
})

</script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<style>
.table{
	margin : 0 auto;
	width : 600px;
}
</style>
<h1>구매 페이지</h1>
<hr>

<table class="table">
<tr>
	<td>판매자</td>
	<td><%=productView.getProuserId()%></td>
</tr>
<tr>
	<td>금액</td>
	<td><%=productView.getProductPrice()%> P</td>
</tr>
<tr>
	<td>수량</td>
	<td><%=request.getAttribute("proquan")%></td>
</tr>
<tr>
	<td>결제 예정 포인트</td>
	<td><%=(int)request.getAttribute("proquan") * productView.getProductPrice()%> P</td>
</tr>
<tr>
	<td>내 보유 포인트</td>
	<td><%=request.getAttribute("mypoint")%> P</td>
</tr>
<tr>
<td colspan="2" align="right">
<% if( ((int)request.getAttribute("proquan") * productView.getProductPrice()) > (int)request.getAttribute("mypoint")) {%>
<span>잔여 포인트가 부족합니다</span> <button id="goCharge"class="btn btn-success" >충전하기</button>
<% }else {%>
<button id="goPayment"class="btn btn-success" >결제하기</button>
<%} %>
</td>
</tr>
</table>
<%-- 판매글 번호 : <%=productView.getProductNo()%> <br> --%>
<%@ include file="../layout/footer.jsp"%>