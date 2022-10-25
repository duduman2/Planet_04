<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%Product productView = (Product)request.getAttribute("view"); %>
<% int quan = Integer.parseInt(request.getParameter("quanInput"));%>

<%= quan* productView.getProductPrice() %>