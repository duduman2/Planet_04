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
	분류 <br>
	<input type="hidden" name="class" value="전체" checked="checked">
	<input type="radio" name="class" id="class1" value="관엽/공기정화식물"><label for="class1">관엽/공기정화식물</label><br>
	<input type="radio" name="class" id="class2" value="다육/선인장"><label for="class2">다육/선인장</label><br>
	<input type="radio" name="class" id="class3" value="야생화"><label for="class3">야생화</label><br>
	<input type="radio" name="class" id="class4" value="분재"><label for="class4">분재</label><br>
	<input type="radio" name="class" id="class5" value="동양란/서양란"><label for="class5">동양란/서양란</label><br>
	<input type="radio" name="class" id="class6" value="화분"><label for="class6">화분</label><br>
	<input type="radio" name="class" id="class7" value="원예자재류"><label for="class7">원예자재류</label><br>
	<input type="radio" name="class" id="class8" value="기타"><label for="class8">기타</label><br>
	
	<label>이미지<input type="file" name="upfile"></label><br>

	<button>전송</button>
	
</form>

<%@ include file="../layout/footer.jsp"%>