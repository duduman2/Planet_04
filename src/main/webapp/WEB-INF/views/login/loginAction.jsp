<%@page import="login.service.impl.LoginServiceImpl"%>
<%@page import="dto.UserInfo"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% int result = (int) request.getAttribute("result"); %>    

<!DOCTYPE html>
<html>
<head>


<title>Insert title here</title>
</head>
<body>

<script>
<%	if (result ==1){ %>
	location.href = '/main'
	
<%	} else if (result == 0){ %>
	alert('비밀번호가 틀립니다.')
	history.back()    // 이전 페이지로 사용자를 보냄
	
 <%	}   else if (result == -1){%>
	alert('존재하지 않는 아이디입니다.')
	history.back()    // 이전 페이지로 사용자를 보냄
	
<%	}%>
</script>



</body>
</html>