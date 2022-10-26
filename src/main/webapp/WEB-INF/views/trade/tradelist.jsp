<%@page import="dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="board.controller.BoardListController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Product> boardList = (List)request.getAttribute("boardList"); %>
<% for(int i=0; i <boardList.size(); i++) { %>
		<div class="tradeitem"><a href="/trade/view?productno=<%=boardList.get(i).getProductNo()%>">
			<img src="/imagepath/<%=boardList.get(i).getFileName()%>"><br>
			제품명 : <%=boardList.get(i).getProductName()%><br>
			가격 : <%=boardList.get(i).getProductPrice()%>원<br>
			</a>
		</div>
<%} %>

