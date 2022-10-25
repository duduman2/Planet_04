<%@page import="dto.BoardInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<BoardInfo> boardList = (List) request.getAttribute("boardlist"); %>
<style type="text/css">
table, th, td {
	border: 1px solid #000;
	border-collapse: collapse;
}
</style>

<div id="hitRank">
<p>오늘의 인기글</p>

		<p>게시글 추천수 정렬</p>
		
		<table class="table table-striped table-hover table-condensed">
		
		<tr>
			<th>제목</th>
			<th>본문</th>
			<th>조회수</th>
		</tr>
		
		<% for(int i=0; i<=10; i++) { %>
		<tr>
			<td><%=boardList.get(i).getBoardTitle() %></td>
			<td><%=boardList.get(i).getBoardContent() %></td>
			<td><%=boardList.get(i).getBoardHit() %></td>
		</tr>
		<% } %>
		
		</table>

</div>