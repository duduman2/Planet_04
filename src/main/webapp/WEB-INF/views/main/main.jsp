<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<style type="text/css">
#tknow-how {
clear: both;
	height: 100px;
	background-color: yellowgreen;
}

#hitRank {
	height: 500px;
	background-color: yellow;
}

#knowhowRank {
	float: left;
	width: 50%;
	height: 300px;
	background-color: tomato;
}

#qnaRank {
	float: left;
	width: 50%;
	height: 300px;
	background-color: blue;
}

</style>

<div id="tknow-how">
<p>테마별 노하우</p>
</div>

<%@ include file="../main/hitRank.jsp"%>

<p>인기 추천글</p>
<div id="knowhowRank">
<p>노하우 추천순</p>

</div>

<div id="qnaRank">
<p>질문답변 추천순</p>

</div>

<%@ include file="../layout/footer.jsp"%>