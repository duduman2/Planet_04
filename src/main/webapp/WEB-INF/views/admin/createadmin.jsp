<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 관리</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
window.onload = function() {
	let inputuserid = document.querySelector("#userid")
	let hideuserid = document.querySelector(".hideuserid")
	let inputuserpw = document.querySelector("#userpw")
	let hideuserpw = document.querySelector(".hideuserpw")
	
	inputuserid.onkeyup = function() {
		if(inputuserid.value.length <= 20) {
			hideuserid.innerHTML = ""
		} else {
			hideuserid.innerHTML = "아이디는 20자를 넘을 수 없습니다"
		}
	}
	
	inputuserpw.onkeyup = function() {
		if(inputuserpw.value.length <= 20) {
			hideuserpw.innerHTML = ""
		} else {
			hideuserpw.innerHTML = "비밀번호는 20자를 넘을 수 없습니다"
		}
	}
}

$(document).ready(function() {
	$("#id_overlap_button").click(function() {
		
		$.ajax({
			type: "post"					// 요청 메소드
			, url: "<%=request.getContextPath() %>/admin/checkadmin"		// 요청 URL
			, data: {						// 요청 파라미터
				n1 : $("#userid").val()		// 이게 효자네
			}
			, dataType: "html"				// 응답 데이터를 처리할 형식(**요청 파라미터의 형식이 아님!!)
			// 서블릿으로 바로 주고 받으려면 json으로 사용하기
			, success: function( res ) {
//				console.log( res.result )
 				$(".checkuserid").html( res )
			}
			, error: function() {
			}
		})
		
	})
})
</script>
</head>
<body>

<form action="<%=request.getContextPath() %>/admin/addadmin" method="post">
	<div style="color: #029EE4; font-size: 1.2em">관리자 생성</div><br>
	<input type="text" id="userid" name="userid" placeholder="아이디">
	<button type="button" id="id_overlap_button">중복검사</button>
	<span class="checkuserid" style="font-size: 0.6em;"></span>
	<div class="hideuserid" style="font-size: 0.6em; color: red; height: 22px;"></div>
	<input type="password" id="userpw" name="userpw" placeholder="비밀번호">
	<div class="hideuserpw" style="font-size: 0.6em; color: red; height: 22px;"></div>
	<button>생성</button>
</form>

</body>
</html>