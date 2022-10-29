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
	margin: 0 20px 20px 0;
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

.img {
	width: 200px;
	height: 200px;
}

.gray {
	background-color: #f3f3f3;
}

.link {
	clear: both;
	text-align:right;
	padding: 0 0 20px 0;
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

<div id="notice">
<h2>공지사항</h2>

</div>

<hr>

<div id="hitRank">
<h3>🔥방금 올라온 상품</h3>

<!-- 상품이 존재할 때만 리스트 보이기 -->
<% if ( productList.isEmpty() == false ) { %>
	
	<!-- 상품이 5개 이하일 경우 리스트 갯수만큼 반환 -->
	<% if ( productList.size() < 5 ) { %>
		<% for(int i=0; i<productList.size(); i++) { %>
		<table class="sellList">
		<tr class="img">
			<td><a href="/trade/view?productno=<%=productList.get(i).getProductNo()%>"><img src="/imagepath/<%=productList.get(i).getFileName()%>" style="width:200px;"></a></td>
		</tr>
		<tr>
			<td><a href="/trade/view?productno=<%=productList.get(i).getProductNo()%>" style="font-weight: bold; font-size: 18px;"><%=productList.get(i).getProductName() %></a></td>
		</tr>
		</table>
		<% } %>
		
	<!-- 상품이 5개 이상일 경우 5개까지만 화면에 보이기 -->
	<% } else { %>
		<% for(int i=0; i<5; i++) { %>
		<table class="sellList">
		<tr class="img">
			<td><a href="/trade/view?productno=<%=productList.get(i).getProductNo()%>"><img src="/imagepath/<%=productList.get(i).getFileName()%>" style="width:200px;"></a></td>
		</tr>
		<tr>
			<td><a href="/trade/view?productno=<%=productList.get(i).getProductNo()%>" style="font-weight: bold; font-size: 18px;"><%=productList.get(i).getProductName() %></a></td>
		</tr>
		</table>
		<% } %>
	<p class="link">
		<a href="/trade" class="linkin"> > 더보기</a></p>
	<% } %>
<% } else { %>
<h4>상품이 존재하지 않습니다</h4>
<% } %>
</div><!-- hitRank end -->

<hr style="clear:both;">

<h2>인기 추천글</h2>
<div id="commRank">
<h3>🔥<a href="/board/list">커뮤니티</a></h3>

<!-- 게시글이 존재할 때만 리스트 보이기 -->
<% if( boardList.isEmpty() == false ) { %>
	<table class="table">
	<tr>
		<th style="width:10%;">no</th>
		<th style="width:60%;">제목</th>
		<th style="width:20%;">작성자</th>
		<th style="width:10%;">조회수</th>
	</tr>
	
	<!-- 게시글 10개까지만 보이게 하기 -->
	<% if( boardList.size() > 10 ) { %>
		<% for(int i=0; i<10; i++) { %>
		<tr>
			<td class="tabletd"><a href=""><%=boardList.get(i).getBoardNo() %></a></td>
			<td class="tabletd"><a href=""><%=boardList.get(i).getBoardTitle() %></a></td>
			<td class="tabletd"><a href=""><%=boardList.get(i).getUserNick() %></a></td>
			<td class="tabletd"><a href=""><%=boardList.get(i).getBoardHit() %></a></td>
		</tr>
		<% } %>
	<!-- 게시글이 10개보다 적은 경우 -->
	<% } else { %>
		<% for(int i=0; i<boardList.size(); i++) { %>
		<tr>
			<td class="tabletd"><a href=""><%=boardList.get(i).getBoardNo() %></a></td>
			<td class="tabletd"><a href=""><%=boardList.get(i).getBoardTitle() %></a></td>
			<td class="tabletd"><a href=""><%=boardList.get(i).getUserNick() %></a></td>
			<td class="tabletd"><a href=""><%=boardList.get(i).getBoardHit() %></a></td>
		</tr>
		<% } %>
	<% } %>
	
	</table>
	
<!-- 게시글이 존재하지 않을 경우 -->
<%} else { %>
<h4>게시글이 존재하지 않습니다</h4>
<% } %>
</div>

<div id="qnaRank">
<h3>🔥<a href="/board/list">질문답변</a></h3>

<!-- 게시글이 존재할 때만 리스트 보이기 -->
<% if( boardList.isEmpty() == false ) { %>
	<table class="table">
	<tr>
		<th style="width:10%;">no</th>
		<th style="width:60%;">제목</th>
		<th style="width:20%;">작성자</th>
		<th style="width:10%;">조회수</th>
	</tr>
	
	<!-- 게시글 10개까지만 보이게 하기 -->
	<% if( boardList.size() > 10 ) { %>
		<% for(int i=0; i<10; i++) { %>
		<tr>
			<td class="tabletd"><a href=""><%=boardList.get(i).getBoardNo() %></a></td>
			<td class="tabletd"><a href=""><%=boardList.get(i).getBoardTitle() %></a></td>
			<td class="tabletd"><a href=""><%=boardList.get(i).getUserNick() %></a></td>
			<td class="tabletd"><a href=""><%=boardList.get(i).getBoardHit() %></a></td>
		</tr>
		<% } %>
	<!-- 게시글이 10개보다 적은 경우 -->
	<% } else { %>
		<% for(int i=0; i<boardList.size(); i++) { %>
		<tr>
			<td class="tabletd"><a href=""><%=boardList.get(i).getBoardNo() %></a></td>
			<td class="tabletd"><a href=""><%=boardList.get(i).getBoardTitle() %></a></td>
			<td class="tabletd"><a href=""><%=boardList.get(i).getUserNick() %></a></td>
			<td class="tabletd"><a href=""><%=boardList.get(i).getBoardHit() %></a></td>
		</tr>
		<% } %>
	<% } %>
	
	</table>
	
<!-- 게시글이 존재하지 않을 경우 -->
<%} else { %>
<h4>게시글이 존재하지 않습니다</h4>
<% } %>

</table>
</div>

<%@ include file="../layout/footer.jsp"%>