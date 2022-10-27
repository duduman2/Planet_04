<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../layout/header.jsp"%>
<%Product productView = (Product)request.getAttribute("buyinfo"); %>

판매글 번호 : <%=productView.getProductNo()%> <br>
판매자 : <%=productView.getProuserId()%>		<br>
금액 : <%=productView.getProductPrice()%>	<br>
수량 : <%=request.getAttribute("proquan")%>

<%@ include file="../layout/footer.jsp"%>