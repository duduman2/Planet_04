<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%Product productView = (Product)request.getAttribute("view"); %>

<%@ include file="../layout/header.jsp"%>
<style>
table {
	border : 1px solid #444444;
	margin: 0 auto;
}
th, td {
	text-align: center;
}
table img {
	width : 450px;
	height : 500px;
}
#paymoney{
	font-size: 25px;
}
</style>

<script type="text/javascript">
$(document).ready(function(){
	$.calc = function(){	//결제금액 계산
		price = <%=productView.getProductPrice()%> * $("#quanInput").val()	//가격 불러오고 입력창에 값 곱하기
		$("#paymoney").html(price).append("원")	//총 결제 금액
	}
	
	$("#quanInput").blur(function(){
		console.log("#quanInput blur")
		$.calc()
	})
	
	$("#quanInput").keydown(function(e) {	// 입력창 값 입력후 엔터시 결제금액 계산
   			if (e.keyCode == 13) {
   				$.calc()	//결제금액 계산
   			}
		});
	$("#add").click(function(){
		console.log("#add click")
		var quan = parseInt($("#quanInput").val())+1	//입력창 값 불러오고 계산
		$("#quanInput").val(quan)	//입력창 반영
		$.calc()	//결제금액 계산
	})
	
	$("#sub").click(function(){
		console.log("#sub click")
		var quan = parseInt($("#quanInput").val())-1	//입력창 값 불러오고 계산
		
		if(quan<1){
			alert("수량은 1개 이상이어야 합니다") //수량 1개 이하일경우 경고
		}else{
			$("#quanInput").val(quan)	//입력창 반영
			$.calc()	//결제금액 계산
		}
	})
	
	var price = <%=productView.getProductPrice()%> * $("#quanInput").val()
	$("#paymoney").html(price).append("원")
	
	$.cartInsert = function(){	// 카트담기
			console.log("ajax 시작")
		$.ajax({
			type: "get"			//요청 메소드
			,url: "/cart/list"	//요청 URL
			,data: {				//요청 파라미터
				productNo : '<%=productView.getProductNo() %>'
				, productName : '<%=productView.getProductName() %>'
				, productPrice : <%=productView.getProductPrice()%>
				, productQuan : $("#quanInput").val()
			}
			,success:function(res){
				console.log("AJAX 성공")
			}
			,error:function(){
				console.log("AJAX 실패")
			}
		})
	}
	
	$.loginCheck = function(){
		var sessionData = <%=session.getAttribute("login")%>
		if(null==sessionData || !sessionData){// 로그인 안됐을경우
			console.log("state : logout")
			if(confirm("로그인이 필요합니다\n로그인페이지로 이동하시겠습니까?")){
				location.replace('/login/con') //로그인 페이지 이동
			}
		}else{
			return true
		}
	}
	$("#goWish").click(function(){		// 장바구니 담기 버튼 클릭
		console.log("goWish click")
		if($.loginCheck()){
			if(confirm("장바구니에 담겼습니다\n장바구니로 이동하시겠습니까?")){
				$.cartInsert()
				location.replace('/cart/list') //장바구니 페이지 이동
			}else {
				$.cartInsert()
				return
			}
		}
	})
	
})


</script>


<br><br><br>
<table>
<tr>
	<td rowspan ="2">제품 사진 : <br>
		<img src="/imagepath/<%=productView.getFileName()%>">
	</td>
	<td>
		제품 번호 : <br>
		<%=productView.getProductNo() %><br><hr>
		제목 :<br>
		<%=productView.getProductName()%><br><hr>
		등록일 :<br>
		<%=productView.getProductDate() %><br><hr>
		제품 설명 :<br>
		<%=productView.getProductContent() %><br><hr>
		제품 가격 : <br>
		<%=productView.getProductPrice() %>원<hr>
	</td>
</tr>
<tr>
		<td>
<!-- 			<form action="/cart/list" method="get"> -->
			수량 선택
			<button type="button" id="sub">-</button><input type="text" value="1" name ="productQuan" id="quanInput"><button type="button" id="add">+</button>
			<br>결제 금액<br>
			<p id="paymoney">원</p>
			
			<button id="goWish">장바구니</button>
<!-- 			</form> -->
		</td>
</tr>

<!-- <tr> -->
<!-- <td class="info">조회수</td> -->
<%-- <td> <%=productView.getHit() %> </td> --%>
<!-- </tr> -->

</table>



<%@ include file="../layout/footer.jsp"%>