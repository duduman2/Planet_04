<%@page import="dto.BoardInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<% List<BoardInfo> boardList = (List) request.getAttribute("board"); %>

<h1>서치결과페이지</h1>

<h3>본문 <%=session.getAttribute("keyword") %> 검색 결과</h3>

<table class="table table-striped table-hover table-condensed">

<tr>
	<th>글번호</th>
	<th>제목</th>
	<th>본문</th>
	<th>작성자</th>
	<th>조회수</th>
</tr>

<% for(int i=0; i<boardList.size(); i++) { %>
<tr>
	<td><%=boardList.get(i).getBoardNo() %></td>
	<td><%=boardList.get(i).getBoardTitle() %></td>
	<td><%=boardList.get(i).getBoardContent() %></td>
	<td><%=boardList.get(i).getUserNick() %></td>
	<td><%=boardList.get(i).getBoardHit() %></td>
</tr>
<% } %>

</table>

<%@ include file="../layout/footer.jsp"%>