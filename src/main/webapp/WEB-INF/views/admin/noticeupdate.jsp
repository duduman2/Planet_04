<%@page import="dto.NoticeFile"%>
<%@page import="dto.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>

<%	Notice updateNotice = (Notice) request.getAttribute("updateNotice"); %>
<%	NoticeFile noticeFile = (NoticeFile) request.getAttribute("noticeFile"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>

<!-- 스마트 에디터2 설치 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/sources/admin/se2/js/service/HuskyEZCreator.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼
	$("#btnUpdate").click(function() {
		
		//작성된 내용을 <textarea>에 적용하기
		updateContents()

		$("form").submit();
	})
	
	//취소버튼
	$("#btnCancel").click(function() {
		history.go(-1)
	})
	
	//파일이 있을 경우
	if(<%=noticeFile != null %>) {
		$("#beforeFile").show();
		$("#afterFile").hide();
	}
	
	//파일이 없을 경우
	if(<%=noticeFile == null %>) {
		$("#beforeFile").hide();
		$("#afterFile").show();
	}
	
	//파일 삭제 버튼(X) 처리
	$("#delFile").click(function() {
		$("#beforeFile").toggle();
		$("#afterFile").toggle();
	})
	
})

function updateContents() {
	
	//스마트 에디터에 작성된 내용을 #content에 반영한다
	oEditors.getById["notice_content"].exec("UPDATE_CONTENTS_FIELD", [])
	
}

</script>

</head>
<body>

<div class="container">

<header id="header" class="text-center">
</header>

<h1>공지사항 수정</h1>
<hr>

<form action="<%=request.getContextPath() %>/admin/mainnotice/update" method="post" enctype="multipart/form-data">

<input type="hidden" name="notice_no" value="<%=updateNotice.getNotice_no() %>">

<table class="table table-bordered">
<tr><td class="info">아이디</td><td><%=updateNotice.getAdmin_id() %></td></tr>
<tr><td class="info">제목</td><td><input type="text" name="title" style="width:100%;" value="<%=updateNotice.getTitle() %>"></td></tr>
<tr><td class="info" colspan="2">본문</td></tr>
<tr><td colspan="2"><textarea id="notice_content" name="notice_content" style="width: 100%;"><%=updateNotice.getNotice_content() %></textarea></td></tr>
</table>

<!-- 첨부파일 -->

<div>

<div id="beforeFile">
	<%	if( noticeFile != null ) { %>
	<a href="<%=request.getContextPath() %>/upload/<%=noticeFile.getStoredname() %>"
	 download="<%=noticeFile.getOriginname() %>">
		<%=noticeFile.getOriginname() %>
	</a>
	<span id="delFile" style="color: red; font-weight: bold; cursor: pointer;">X</span>
	<%	} %>
</div>

<div id="afterFile">
	새 첨부파일 <input type="file" name="file">
</div>

</div>

</form>

<div class="text-center">
	<button id="btnUpdate" class="btn btn-primary">수정</button>
	<button id="btnCancel" class="btn btn-danger">취소</button>
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

</div>

</body>
</html>




















