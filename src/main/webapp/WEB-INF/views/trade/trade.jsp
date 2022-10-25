<%@page import="dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<% List<Product> boardList = (List)request.getAttribute("boardList"); %>
<style>
.tradeboard {
	display : flex;
	justify-content: space-around;
	flex-wrap: wrap;
	
	
}
.tradeitem{
	margin-bottom: 50px;
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
	    
	    $(".class").click(function(){
// 	    	alert($(this).val());
			location.href = 'trade?class='+ $(this).val();
	    });
	
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
	});
</script>
<br><br>
<button><a href="/trade/productupload">상품등록</a></button><br><br><br>
<div class="classlist">

	<button class="class" value="전체">전체</button>
	<button class="class" value="관엽/공기정화식물">관엽/공기정화식물</button>
	<button class="class" value="다육/선인장">다육/선인장</button>
	<button class="class" value="야생화">야생화</button>
	<button class="class" value="분재">분재</button>
	<button class="class" value="동양란/서양란">동양란/서양란</button>
	<button class="class" value="화분">화분</button>
	<button class="class" value="원예자재류">원예자재류</button>

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

</div> <!-- end tradeboard  -->

<script type="text/javascript">

</script>
<button type="button" id="topButton" onclick="goTop()">맨 위로 ↑</button>
<%@ include file="../layout/footer.jsp"%>