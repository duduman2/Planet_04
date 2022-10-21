<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%Product productView = (Product)request.getAttribute("view"); %>

<%@ include file="../layout/header.jsp"%>
<style>

img {
	width : 250px;
	height : 300px;
}
</style>
<br><br><br>
<table>
<tr>
<td>제품 사진 : </td>
<td> <img src="/imagepath/<%=productView.getFileName()%>"></td>
</tr>
<tr>
<td>제품 번호 : </td>
<td> <%=productView.getProductNo() %></td>
</tr>

<tr>
<td>제목 : </td>
<td> <%=productView.getProductName()%></td>
</tr>

<tr>
<td >등록일 : </td>
<td> <%=productView.getProductDate() %></td>	
</tr>

<tr>
<td>제품 설명 : </td>
<td> <%=productView.getProductContent() %></td>
</tr>

<tr>
<td>제품 가격 : </td>
<td> <%=productView.getProductPrice() %></td>
</tr>


<!-- <tr> -->
<!-- <td class="info">조회수</td> -->
<%-- <td> <%=productView.getHit() %> </td> --%>
<!-- </tr> -->


</table>

<%@ include file="../layout/footer.jsp"%>