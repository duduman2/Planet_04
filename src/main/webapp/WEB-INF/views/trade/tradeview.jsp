<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%Product productView = (Product)request.getAttribute("view"); %>

<%@ include file="../layout/header.jsp"%>
<style>

img {
	width : 250px;
	height : 300px;
}
</style>

<!-- <script type="text/javascript"> -->
<!-- // $(document).ready(function(){ -->
<!-- // 	function paycalc(){ -->
<!-- // 		console.log("계산하기") -->
		
<!-- // 		$.ajax({ -->
<!-- // 			type: "post"			//요청 메소드 -->
<!-- // 			,url: "./paymoney.jsp"	//요청 URL -->
<!-- // 			,data: {				//요청 파라미터 -->
<!-- // 				quanInput : $("#quanInput").val() -->
<%-- 				, price : <%=productView.getProductPrice()%> --%>
<!-- // 			} -->
<!-- // 			,dataType: "html"		//응답 데이터 형식 -->
<!-- // 			,success:function(res){ -->
<!-- // 				console.log("AJAX 성공") -->
				
<!-- // 				//응답 데이터 반영 -->
<!-- // 				$("#paymoney").html(res) -->
<!-- // 			} -->
<!-- // 			,error:function(){ -->
<!-- // 				console.log("AJAX 실패") -->
<!-- // 			} -->
<!-- // 		}) -->
		
<!-- // 	} -->
	
<!-- //     $("#add").click(function(){ -->
<!-- // 		console.log("#add click") -->
<!-- // 		var quan = parseInt($("#quanInput").val())+1 -->
<!-- // 		$("#quanInput").val(quan) -->
<!-- // 		paycalc() -->
<!-- //     }) -->
<!-- //     $("#sub").click(function(){ -->
<!-- // 		console.log("#add click") -->
<!-- // 		var quan = parseInt($("#quanInput").val())-1 -->
<!-- // 		if(quan<1){ -->
<!-- // 			alert("수량은 1개 이상이어야 합니다") -->
<!-- // 		}else{ -->
<!-- // 			$("#quanInput").val(quan) -->
<!-- // 			paycalc() -->
<!-- // 		} -->
<!-- //     }) -->


<!-- // }) -->

<!-- </script> -->
<script type="text/javascript">
$(document).ready(function(){
	
	$("#btnCalc").click(function(){
		console.log("#btnCalc 클릭")
		
		$.ajax({
			type: "post"			//요청 메소드
			,url: "./paymoney.jsp"	//요청 URL
				,data: {				//요청 파라미터
	 				quanInput : $("#quanInput").val()
					, price : <%=productView.getProductPrice()%>
	 			}
			,dataType: "html"		//응답 데이터 형식
			,success:function(res){
				console.log("AJAX 성공")
				
				//응답 데이터 반영
				$("#paymoney").html(res)
			}
			,error:function(){
				console.log("AJAX 실패")
			}
		})
	
	})
})
</script>

<br><br><br>
<table>
<tr>
<td>제품 사진 : </td>
<td> <img src="/imagepath/<%=productView.getFileName()%>"></td>
</tr>
<tr>
<td>제품 번호 : </td>
<td> <%=productView.getProductNo() %></td>
</tr>

<tr>
<td>제목 : </td>
<td> <%=productView.getProductName()%></td>
</tr>

<tr>
<td >등록일 : </td>
<td> <%=productView.getProductDate() %></td>	
</tr>

<tr>
<td>제품 설명 : </td>
<td> <%=productView.getProductContent() %></td>
</tr>

<tr>
<td>제품 가격 : </td>
<td> <%=productView.getProductPrice() %>원</td>
</tr>

<!-- <tr> -->
<!-- <td class="info">조회수</td> -->
<%-- <td> <%=productView.getHit() %> </td> --%>
<!-- </tr> -->

</table>
<button id="btnCalc">asd</button>
수량 선택
<button id="sub">-</button><input type="text" value="1" id="quanInput"><button id="add">+</button>
<br>결제 금액<br>
<div id="paymoney"></div>


<%@ include file="../layout/footer.jsp"%>