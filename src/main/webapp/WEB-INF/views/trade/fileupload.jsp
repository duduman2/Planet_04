<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../layout/header2.jsp"%>

<style>

table {
	border : 1px solid #444444;
	margin: 0 auto;
}

th, td {
	border: 1px solid #444444;
}

</style>
<h1>상품 등록</h1>
<hr>

<form action="/trade/productupload" method="post" enctype="multipart/form-data">

	<table>
		<tr>
			<td>
				<label>상품명 : <input type="text" name="title"></label><br>
			</td>
			<td>
				<label>금액 : <input type="text" name="price"></label><br>
			</td>

		</tr>
		<tr>
			<td>
				분류 <br>
				<input type="hidden" name="class" value="전체" checked="checked">
				<input type="radio" name="class" id="class1" value="air"><label for="class1">관엽/공기정화식물</label>
				<input type="radio" name="class" id="class2" value="cac"><label for="class2">다육/선인장</label>
				<input type="radio" name="class" id="class3" value="wild"><label for="class3">야생화</label>
				<input type="radio" name="class" id="class4" value="bon"><label for="class4">분재</label><br>
				<input type="radio" name="class" id="class5" value="orc"><label for="class5">동양란/서양란</label>
				<input type="radio" name="class" id="class6" value="pot"><label for="class6">화분</label>
				<input type="radio" name="class" id="class7" value="mate"><label for="class7">원예자재류</label>
				<input type="radio" name="class" id="class8" value="etc"><label for="class8">기타</label>

			</td>
			<td>
				<label>대표이미지 선택<br><input type="file" name="upfile"></label>
			</td>
		</tr>
		<tr>
			<td>
				<label>상품설명<textarea rows="10" cols="50" name="content"></textarea></label><br>
			</td>
			<td>
				<button>작성</button>
			</td>			
		</tr>
	</table>
	
	<br>

	
</form>

<%@ include file="../layout/footer.jsp"%>