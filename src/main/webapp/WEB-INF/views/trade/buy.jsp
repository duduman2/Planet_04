<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../layout/header.jsp"%>
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
})

</script>

판매글 번호 : <%=productView.getProductNo()%> <br>
판매자 : <%=productView.getProuserId()%>	<br>
금액 : <%=productView.getProductPrice()%><br>
수량 : <%=request.getAttribute("proquan")%><br>
내 보유 포인트 : <%=request.getAttribute("mypoint")%>
<button id="goPayment">결제하기</button>
<%@ include file="../layout/footer.jsp"%>