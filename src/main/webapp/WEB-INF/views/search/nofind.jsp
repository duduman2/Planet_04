<%@page import="dto.BoardInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<% List<BoardInfo> boardList = (List) request.getAttribute("board"); %>

<h1>서치결과페이지</h1>

<h3><%=session.getAttribute("keyword") %>에 대한 검색결과가 없습니다.</h3>



<%@ include file="../layout/footer.jsp"%>