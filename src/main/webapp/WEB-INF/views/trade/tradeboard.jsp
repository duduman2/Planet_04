<%@page import="dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<% List<Product> boardlist = (List)request.getAttribute("boardList"); %>

<div class="tradeboard">
<button><a href="/trade/productupload">상품등록</a></button><br><br><br>


<!-- <table class="table table-bordered"> -->
<!-- <tr> -->
<!-- 	<th>제품명</th> -->
<!-- 	<th>가격</th> -->
<!-- 	<th>제품사진</th> -->
<!-- </tr> -->
<%-- <% for(int i=0; i <boardlist.size(); i++) { %> --%>
<!-- <tr> -->
<%-- 	<td><%=boardlist.get(i).getProductname()%></td>	 --%>
<%-- 	<td><%=boardlist.get(i).getProductprice()%></td>	 --%>
	
<%-- 	<td><img src="/imagepath/<%=boardlist.get(i).getFilename()%>" width="100" height="200"></td> --%>
<!-- </tr> -->
<%-- <%} %> --%>
<% for(int i=0; i <boardlist.size(); i++) { %>
	<div>
		<img src="/imagepath/<%=boardlist.get(i).getFilename()%>" width="100" height="200"><br>
		제품명 : <%=boardlist.get(i).getProductname()%><br>
		가격 : <%=boardlist.get(i).getProductprice()%> 원<br><br>
	</div>
<%} %>

</div> <!-- end tradeboard  -->

<%@ include file="../layout/footer.jsp"%>