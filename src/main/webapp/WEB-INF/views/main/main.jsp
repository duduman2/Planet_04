<%@page import="dto.BoardInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<BoardInfo> boardList = (List) request.getAttribute("boardlist"); %>
<%@ include file="../layout/header.jsp"%>

<style type="text/css">
#hitRank {
	height: 500px;
	border: 1px solid orange;
	box-sizing: border-box;
}

#qnaRank {
	float: left;
	width: 50%;
	height: 300px;
	border: 1px solid tomato;
	box-sizing: border-box;
}

#commRank {
	float: left;
	width: 50%;
	height: 300px;
	border: 1px solid blue;
	box-sizing: border-box;
}

table, th, td {
	border: 1px solid #000;
	border-collapse: collapse;
}

</style>

<script type="text/javascript">
$(document).ready(function() {
	
	$("title").html("PLanet")
	
})
</script>

<div id="hitRank">
<p>인기 판매상품</p>

<p>상품 조회수순으로 추천</p>



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

<% for(int i=0; i<3; i++) { %>
<tr>
	<td><%=boardList.get(i).getBoardTitle() %></td>
	<td><%=boardList.get(i).getBoardContent() %></td>
	<td><%=boardList.get(i).getBoardHit() %></td>
</tr>
<% } %>

</table>

</div>

<div id="qnaRank">
<p>질문답변 게시글 조회수 순으로 추천</p>

</div>

<%@ include file="../layout/footer.jsp"%>