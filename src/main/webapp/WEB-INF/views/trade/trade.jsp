<%@page import="dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Product> boardList = (List)request.getAttribute("boardList"); %>
<%@ include file="../layout/header.jsp"%>

<!-- 부트스트랩 3-->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>
.tradeboard {
	display : flex;
	justify-content: space-around;
	flex-wrap: wrap;
}


.tradeitem img {
	width : 250px;
	height : 300px;
	margin-bottom: 15px;
}

.classlist button {
	margin-right: 50px;
}

#topButton {
	position: fixed;
	right: 2%;
	bottom: 50px;
	display: none;
	z-index: 999;
}
</style>
<script type="text/javascript">
$( document ).ready( function() {
	    
	 $(".cate").click(function(){
// 	    	alert($(this).val());
			location.href = '?cate='+ $(this).val();
	    });
//     $(".cate").click(function(){
//     	$(".tradeboard").hide()
// 		$.ajax({
// 			type: "post"			//요청 메소드
// 			,url: "/tradelist"	//요청 URL
// 			,data: {				//요청 파라미터
// 				cate : $(this).val()
// 			}
// 			,dataType: "html"		//응답 데이터 형식
// 			,success:function(res){
// 				console.log("AJAX 성공")
				
// 				//응답 데이터 반영
// 				$(".tradeboard2").html(res)
// 			}
// 			,error:function(){
// 				console.log("AJAX 실패")
// 			}
// 		})
//     });
	
	$(window).scroll(function() {
	    if ($(this).scrollTop() > 300) {
	        $('#topButton').fadeIn();
	    } else {
	        $('#topButton').fadeOut();
	    }
	});
	function goTop(){
		$('html').scrollTop(0);
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
	$("#proWrite").click(function(){	
		$.loginCheck()
	})
	
});
</script>


<br><br>
<button id="proWrite"><a href="/trade/productupload">상품등록</a></button><br><br><br>
<div class="catelist">

	<button class="cate" value="all">전체</button>
	<button class="cate" value="air">관엽/공기정화식물</button>
	<button class="cate" value="cac">다육/선인장</button>
	<button class="cate" value="wild">야생화</button>
	<button class="cate" value="bon">분재</button>
	<button class="cate" value="orc">동양란/서양란</button>
	<button class="cate" value="pot">화분</button>
	<button class="cate" value="mate">원예자재류</button>

</div>

<br><br><br>

<div class="tradeboard">
<% for(int i=0; i <boardList.size(); i++) { %>
		<div class="tradeitem"><a href="/trade/view?productno=<%=boardList.get(i).getProductNo()%>">
			<img src="/imagepath/<%=boardList.get(i).getFileName()%>"><br>
			제품명 : <%=boardList.get(i).getProductName()%><br>
			가격 : <%=boardList.get(i).getProductPrice()%>원<br>
			</a>
		</div>
<%} %>
</div>


<button type="button" id="topButton" onclick="goTop()">맨 위로 ↑</button>
<%@ include file="/WEB-INF/views/trade/paging2.jsp"%> <!-- ./paging2.jsp로 하면 추가가 안됩니다 -->
<%@ include file="../layout/footer.jsp"%>