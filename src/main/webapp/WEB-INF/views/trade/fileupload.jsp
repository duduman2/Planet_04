<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../layout/header.jsp"%>

<h1>파일 업로드</h1>
<hr>

<form action="/trade/productupload" method="post" enctype="multipart/form-data">

	
	<label>상품명<input type="text" name="title"></label><br>
	<label>상품설명<textarea rows="4" cols="30" name="content"></textarea></label><br>
	<label>금액<input type="text" name="price"></label><br>
	
	<label>이미지<input type="file" name="upfile"></label><br>

	<button>전송</button>
	
</form>

<%@ include file="../layout/footer.jsp"%>