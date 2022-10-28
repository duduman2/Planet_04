<%@page import="dto.Product"%>
<%@page import="dto.BoardInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>PLanet</title>

<% List<BoardInfo> boardList = (List) request.getAttribute("boardlist"); %>
<% List<Product> productList = (List)request.getAttribute("view"); %>

<%@ include file="../layout/header2.jsp"%>

<style type="text/css">
#hitRank {
}

#qnaRank {
	float: right;
	width: 49%;
	margin-bottom: 10px;
	box-sizing: border-box;
}

#commRank {
	float: left;
	width: 49%;
	margin-bottom: 10px;
	box-sizing: border-box;
}

a {
	text-decoration: none;
	color: black;
}

.sellList {
	float: left;
	margin: 0 20px 0 0;
	width: 100px;
}

.line {
	border: 3px solid green !important;
	box-sizing: border-box;
}

.table {
	width: 100%;
	border: 1px solid black; 
	text-align: center;
}

.table > tr {
	border: 1px solid black; 
}

.tabletd {
	border: 1px solid black;
	border-collapse: collapse;
}

.gray {
	background-color: #f3f3f3;
}

.link {
	clear: both;
	text-align:right;
	padding: 30px 0;
	margin: 0;
}

.linkin {
	color: green;
	font-weight: bold;
}

.underline {
	text-decoration: underline;
}

hr {
	border: 1px dashed #f3f3f3;
}

</style>

<script type="text/javascript">
$(document).ready(function() {
	
	$("a").mouseover(function() {
		$(this).addClass('green')
	})
	
	$("a").mouseleave(function() {
		$(this).removeClass('green')		
	})
	
	$("td > a > img").mouseover(function() {
		$(this).addClass('line')
	})
	
	$("td > a > img").mouseleave(function() {
		$(this).removeClass('line')
	})
	
	$(".tabletd").mouseover(function() {
		$(this).parent().addClass('gray')
		$(this).parent().children().children("a").addClass('green')
	})

	$(".tabletd").mouseleave(function() {
		$(this).parent().removeClass('gray')
		$(this).parent().children().children("a").removeClass('green')
	})
	
	$(".linkin").mouseover(function() {
		$(this).addClass('underline')
	})
	
	$(".linkin").mouseleave(function() {
		$(this).removeClass('underline')
	})
	
})
</script>

<div id="hitRank">
<h3>🔥방금 올라온 상품</h3>
<% for(int i=0; i<5; i++) { %>
<table class="sellList">
<tr>
	<td><a href="/trade/view?productno=<%=productList.get(i).getProductNo()%>"><img src="/imagepath/<%=productList.get(i).getFileName()%>" style="height:200px;"></a></td>
</tr>
<tr>
	<td><a href="/trade/view?productno=<%=productList.get(i).getProductNo()%>" style="font-weight: bold; font-size: 18px;"><%=productList.get(i).getProductName() %></a></td>
</tr>
</table>
<% } %>

<br>
<br>
<br>
<p class="link">
	<a href="/trade" class="linkin"> > 더보기</a></p>

</div>

<hr>

<h2>인기 추천글</h2>
<div id="commRank">
<h3>🔥커뮤니티</h3>
<table class="table">
<tr>
	<th style="width:10%;">no</th>
	<th style="width:60%;">제목</th>
	<th style="width:20%;">작성자</th>
	<th style="width:10%;">조회수</th>
</tr>

<% for(int i=0; i<boardList.size(); i++) { %>
<tr>
	<td class="tabletd"><a href=""><%=boardList.get(i).getBoardNo() %></a></td>
	<td class="tabletd"><a href=""><%=boardList.get(i).getBoardTitle() %></a></td>
	<td class="tabletd"><a href=""><%=boardList.get(i).getUserNick() %></a></td>
	<td class="tabletd"><a href=""><%=boardList.get(i).getBoardHit() %></a></td>
</tr>
<% } %>

</table>

</div>

<div id="qnaRank">
<h3>🔥질문답변</h3>
<table class="table">
<tr>
	<th style="width:10%;">no</th>
	<th style="width:60%;">제목</th>
	<th style="width:20%;">작성자</th>
	<th style="width:10%;">조회수</th>
</tr>

<% for(int i=0; i<boardList.size(); i++) { %>
<tr>
	<td class="tabletd"><a href=""><%=boardList.get(i).getBoardNo() %></a></td>
	<td class="tabletd"><a href=""><%=boardList.get(i).getBoardTitle() %></a></td>
	<td class="tabletd"><a href=""><%=boardList.get(i).getUserNick() %></a></td>
	<td class="tabletd"><a href=""><%=boardList.get(i).getBoardHit() %></a></td>
</tr>
<% } %>

</table>
</div>

<%@ include file="../layout/footer.jsp"%>