<%@page import="dto.AdminInfo"%>
<%@page import="java.util.List"%>
<%@page import="common.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 모델값 전달받기 --%>
<% Paging paging = (Paging) request.getAttribute("paging"); %>

<div class="text-center">
	<ul class="pagination">
	
		<%-- 첫 페이지로 이동 --%>
		<li><a href="./mainnotice2?admin_id=<%=admin_id%>">&lt;&lt;</a></li>
	
		<%-- 이전 페이지로 이동 --%>
		<li><a href="./mainnotice2?admin_id=<%=admin_id%>&curPage=<%=paging.getCurPage() - 1 %>">&lt;</a></li>
	
		<%-- 페이지 번호 리스트 --%>
		<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
		<%		if( i == paging.getCurPage() ) { %>
		<li class="active"><a href="./mainnotice2?admin_id=<%=admin_id%>&curPage=<%=i %>"><%=i %></a></li>
		<%		} else { %>
		<li><a href="./mainnotice2?admin_id=<%=admin_id%>&curPage=<%=i %>"><%=i %></a></li>
		<%		} %>
		<%	} %>

		<%-- 다음 페이지로 이동 --%>
		<li><a href="./mainnotice2?admin_id=<%=admin_id%>&curPage=<%=paging.getCurPage() + 1 %>">&gt;</a></li>
		
		<%-- 마지막 페이지로 이동 --%>
		<li><a href="./mainnotice2?admin_id=<%=admin_id%>&curPage=<%=paging.getTotalPage() %>">&gt;&gt;</a></li>
		
	</ul>
</div>







