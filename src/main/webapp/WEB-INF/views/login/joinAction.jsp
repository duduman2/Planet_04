<%@page import="login.dao.face.LoginDao"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 뷰포트 -->
<meta name="viewport" content="width=device-width" initial-scale="1">

<title>Insert title here</title>
</head>
<body>

 <%--
        String u_id = null; //로그인이 된 유저는 로그인, 회원가입 페이지에 못들어오게 해야함
    if (session.getAttribute("u_id") != null) {
        u_id = (String) session.getAttribute("u_id"); //해당 세션값 넣어줌 
    }
    if (u_id != null) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('이미 로그인이 되어 있습니다.')");
        script.println("location.href='main.jsp'"); //이미 로그인이 되면 또 로그인 못하게 해줌
        script.println("</script>");
    }
    if (userinfo.getU_id == null || userinfo.getU_pw() == null || userinfo.getU_name() == null
            || userinfo.getU_gender() == null || userinfo.getU_email() == null) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('입력이 되지 않은 사항이 있습니다.')");
        script.println("history.back()"); //이전 페이지 즉 로그인페이지로 돌아가게 만듬
        script.println("</script>");
    } else {
        LoginDao loginDao = new LoginDao();
        int result = loginDao.join(userinfo); 
        if (result == -1) {
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('이미 존재하는 아이디입니다.')");
            script.println("history.back()"); //이전 페이지 즉 로그인페이지로 돌아가게 만듬
            script.println("</script>");
        } else {
            session.setAttribute("u_id", userinfo.getU_id());
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("location.href='main.jsp'");
            script.println("</script>");
        }
    }
    --%>




</body>
</html>