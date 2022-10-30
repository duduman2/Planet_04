<%@page import="dto.Payment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>충전소</title>
<%Payment payment = (Payment)request.getAttribute("payment"); %>
<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<!-- 부트스트랩 3-->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
.table{
	margin: 0 auto;
}
.table td{
	font-size: 20px;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$.point = function(){	//결제금액 계산
		price = $("#chargePoing").val()	//가격 불러오고 입력창에 값 곱하기
		$("#payment").html(price).append("원")	//총 결제 금액
	}
	
	$("#chargePoing").blur(function(){
		console.log("#chargePoing blur")
		$.point()
	})
	
	$("#chargePoing").keyup(function(e) {	// 입력창 값 입력후 엔터시 결제금액 계산
// 		if (e.keyCode == 13) {
			console.log("#chargePoing keydown")
			$.point()	//결제금액 계산
// 		}
	});
	$.paySuccessAlert = function(){
		$(document).ready(function(){
			alert("충전이 완료되었습니다.")
			opener.parent.location.reload();
			window.close()
		})
	}
	
	
})
</script>

<script type="text/javascript"> // 아임포트 api
// $(document).ready(function(){
	
var IMP = window.IMP; // 생략 가능
IMP.init("imp10365418"); // 예: imp00000000
function requestPay() {
	console.log("결제하기 클릭")
    // IMP.request_pay(param, callback) 결제창 호출
    IMP.request_pay({ // param
        pg: "kakaopay",
        pay_method: "kakaopay",
        merchant_uid: '<%=payment.getPayNo()%>', //결제번호
        name: "Point",
        amount: $("#chargePoing").val(),
//         buyer_email: "gildong@gmail.com",
        buyer_name: '<%=payment.getBuyerId()%>', //구매자 아이디
        buyer_tel: '<%=payment.getBuyerTel()%>'	//구매자 전화번호
//         buyer_addr: "서울특별시 강남구 신사동",
//         buyer_postcode: "01181"
    }, function (rsp) { // callback
        if (rsp.success) {
        	// jQuery로 HTTP 요청
            jQuery.ajax({
                url: "/paysuccess", // 예: https://www.myservice.com/payments/complete
                method: "get",
                headers: { "Content-Type": "application/json" },
                data: {
                    imp_uid: rsp.imp_uid,	//아임포트 고유 결제번호
                    merchant_uid: rsp.merchant_uid, //결제번호	
                    mypoint : '<%=request.getAttribute("myPoint")%>', //결제전 포인트
                    amount: $("#chargePoing").val() //결제포인트
                }
            }).done(function (data) {
              // 가맹점 서버 결제 API 성공시 로직
              console.log("결제 성공")
              	$.paySuccessAlert()
//               location.href='/paysuccess'
//               window.open('/paysuccess', '_self');
            })
          } else {
            alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
          }
        
    });
  }
  
  
// })
</script>
</head>
<body>
<h1>충전소</h1>
<hr>
<form onsubmit="return false">
<table class="table">
<tr>
	<td>내 보유 포인트</td>
	<td><%=request.getAttribute("myPoint")%></td>
</tr>
<tr>
	<td>충전할 포인트</td>
	<td><input type="text" id="chargePoing" value=""></td>
</tr>
<tr>
	<td>결제 금액</td>
	<td><span id="payment"></span></td>
</tr>
</form>
<tr>
	<td colspan="2" align="center"><button type="button" id="goPayment" class="btn btn-success" onclick="requestPay()">결제하기</button></td>
</tr>
</table>
</body>
</html>