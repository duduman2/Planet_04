<%@page import="dto.Uploadfile"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% List<Uploadfile> list = (List)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button><a href="/trade/productupload">상품등록</a></button>

<table>
<tr>
	<th>파일번호</th>
	<th>원본이름</th>
	<th>저장된 이름</th>
	<th>저장된 경로</th>
</tr>
<% for(int i=0; i <list.size(); i++) { %>
<tr>
	<td><%=list.get(i).getFileno() %></td>	
	<td><%=list.get(i).getOriginName() %></td>	
	<td><%=list.get(i).getStoredName() %></td>	
	<td><%=list.get(i).getFilePath()%></td>	
	<td><img src="<%=list.get(i).getFilePath()%>/<%=list.get(i).getStoredName() %>"></td>	
</tr>
<%} %>
</body>
</html>