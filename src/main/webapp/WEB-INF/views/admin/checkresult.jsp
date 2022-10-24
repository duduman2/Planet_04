<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Boolean result = (Boolean) request.getAttribute("result"); %>

<% if (result == true) { %>
<span style="color: red;">중복된 아이디 입니다.</span>
<%} else {%>
<span style="color: green;">사용 가능한 아이디 입니다.</span>
<%}%>