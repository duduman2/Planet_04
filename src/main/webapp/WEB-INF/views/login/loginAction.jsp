<%@page import="login.service.impl.LoginServiceImpl"%>
<%@page import="dto.UserInfo"%>
<%@page import="java.io.PrintWriter"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="userinfo" class="dto.UserInfo" scope="page" />
<jsp:setProperty name="userinfo" property="u_id"/>
<jsp:setProperty name="userinfo" property="u_pw"/>

    
<!DOCTYPE html>
<html>
<head>


<title>Insert title here</title>
</head>
<body>

 <%
        LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
        int result = loginServiceImpl.login(userinfo.getU_id(), userinfo.getU_pw());
        if (result ==1){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("location.href = 'main.jsp'");
            script.println("</script>");
        }
        else if (result == 0){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('비밀번호가 틀립니다.')");
            script.println("history.back()");    // 이전 페이지로 사용자를 보냄
            script.println("</script>");
        }
        else if (result == -1){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('존재하지 않는 아이디입니다.')");
            script.println("history.back()");    // 이전 페이지로 사용자를 보냄
            script.println("</script>");
        }
    %>


</body>
</html>