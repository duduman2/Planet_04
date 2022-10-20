<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<h1>서치결과페이지</h1>

<%=request.getParameter("keyword") %>검색 결과

<div>
게시판명이랑 내용
</div>

<%@ include file="../layout/footer.jsp"%>