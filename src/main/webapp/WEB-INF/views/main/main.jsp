<%@page import="dto.Product"%>
<%@page import="dto.BoardInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>PLanet</title>

<% List<BoardInfo> boardList = (List) request.getAttribute("boardlist"); %>
<% List<Product> productList = (List)request.getAttribute("view"); %>

<%@ include file="../layout/header.jsp"%>

<style type="text/css">
#hitRank {
	height: 350px;
	box-sizing: border-box;
}

#qnaRank {
	float: left;
	width: 50%;
	height: 300px;
	margin-bottom: 10px;
	border: 1px solid tomato;
	box-sizing: border-box;
}

#commRank {
	float: left;
	width: 50%;
	height: 300px;
	margin-bottom: 10px;
	border: 1px solid blue;
	box-sizing: border-box;
}

table, th, td {
	border: 1px solid #000;
	border-collapse: collapse;
}

.sellList {
	float: left;
	margin: 0 20px 0 0;
	width: 100px;
}

</style>

<div id="hitRank">
<h3>🔥방금 올라온 상품</h3>
<% for(int i=0; i<5; i++) { %>
<table class="sellList">
<tr>
	<td><img src="/imagepath/<%=productList.get(i).getFileName()%>" style="height:200px;"></td>
</tr>
<tr>
	<td><%=productList.get(i).getProductName() %></td>
</tr>
</table>
<% } %>

<br>
<br>
<br>
<p style="clear: both; text-align:right; padding: 30px 0;"><a href="/trade">더보기</a></p>

</div>

<h2>인기 추천글</h2>
<div id="commRank">
<p>커뮤니티 게시글 조회수순으로 추천</p>
<table>

<tr>
	<th>제목</th>
	<th>본문</th>
	<th>조회수</th>
</tr>

<% for(int i=0; i<boardList.size(); i++) { %>
<tr>
<%-- 	<td><%=boardList.get(i).getBoardTitle() %></td> --%>
<%-- 	<td><%=boardList.get(i).getBoardContent() %></td> --%>
<%-- 	<td><%=boardList.get(i).getBoardHit() %></td> --%>
</tr>
<% } %>

</table>

</div>

<div id="qnaRank">
<p>질문답변 게시글 조회수 순으로 추천</p>
<table>

<tr>
	<th>제목</th>
	<th>본문</th>
	<th>조회수</th>
</tr>

<% for(int i=0; i<boardList.size(); i++) { %>
<tr>
	<td><%=boardList.get(i).getBoardTitle() %></td>
	<td><%=boardList.get(i).getBoardContent() %></td>
	<td><%=boardList.get(i).getBoardHit() %></td>
</tr>
<% } %>

</table>
</div>

<%@ include file="../layout/footer.jsp"%>