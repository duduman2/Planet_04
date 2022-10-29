<%@page import="dto.BoardInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header2.jsp"%>
    
<% List<BoardInfo> boardList = (List) request.getAttribute("board"); %>
<% String msg = (String) request.getAttribute("msg"); %>

<title><%=request.getAttribute("keyword") %> : PLanet 통합검색</title>

<style type="text/css">
table, th, td {
	border: 1px solid #000;
	border-collapse: collapse;
}

</style>

<% if( request.getAttribute("msg") != null ) { %>
<h3><%=request.getAttribute("keyword") %> <%=request.getAttribute("msg") %></h3>
<% } else if( request.getAttribute("msg") == null ) { %>

<h3><%=request.getAttribute("keyword") %> 검색 결과</h3>

<table class="table table-striped table-hover table-condensed">

<tr>
	<th>글번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>조회수</th>
</tr>

<% for(int i=0; i<boardList.size(); i++) { %>
<tr>
	<td><%=boardList.get(i).getBoardNo() %></td>
	<td><%=boardList.get(i).getBoardTitle() %></td>
	<td><%=boardList.get(i).getUserNick() %></td>
	<td><%=boardList.get(i).getBoardHit() %></td>
</tr>
<% } %>

</table>
<% } %>

<%@ include file="../layout/footer.jsp"%>