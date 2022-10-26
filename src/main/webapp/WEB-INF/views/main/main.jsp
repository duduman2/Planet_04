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
	border: 1px solid orange;
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
<p>판매상품</p>

<p>최신업로드순으로 추천</p>
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

</div>

<p>인기 추천글</p>
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