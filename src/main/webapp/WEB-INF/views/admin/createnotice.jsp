<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./header.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 스마트 에디터2 설치 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/sources/admin/se2/js/service/HuskyEZCreator.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼
	$("#btnWrite").click(function() {
		
		//작성된 내용을 <textarea>에 적용하기
		updateContents()

		$("form").submit();
	})
	
	//취소버튼
	$("#btnCancel").click(function() {
		window.location.reload();
	})
	
})

function updateContents() {
	
	//스마트 에디터에 작성된 내용을 #content에 반영한다
	oEditors.getById["notice_content"].exec("UPDATE_CONTENTS_FIELD", [])
	
}

</script>

</head>
<body>

<h1>공지사항 작성</h1>
<hr>

<form action="<%=request.getContextPath() %>/admin/crenotice" method="post" enctype="multipart/form-data">

<table class="table table-bordered">
<tr><td class="info">아이디</td><td><%=session.getAttribute("userid") %></td></tr>
<tr><td class="info">제목</td><td><input type="text" name="title" style="width:100%;"></td></tr>
<tr><td class="info" colspan="2">본문</td></tr>
<tr><td colspan="2"><textarea id="notice_content" name="notice_content" style="width: 100%; height: 200px;"></textarea></td></tr>
</table>

첨부파일 <input type="file" name="file">

</form>

<div class="text-center">
	<button id="btnWrite" class="btn btn-primary">작성</button>
	<button id="btnCancel" class="btn btn-danger">초기화</button>
</div>

<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "notice_content", //에디터가 적용될 <textarea>의 id 적기
	sSkinURI: "<%=request.getContextPath() %>/sources/admin/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
})
</script>

</body>
</html>