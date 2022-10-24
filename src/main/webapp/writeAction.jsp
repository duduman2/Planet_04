<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.face.BoardDao" %>
<%@ page import="java.io.PrintWriter" %>

<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="bbs" class="board.dao.face.BoardDao" scope="page" />
<jsp:setProperty name="bbs" property="bbsTitle" />
<jsp:setProperty name="bbs" property="bbsContent" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Planet</title>
</head>
<body>

<%-- 	<% --%>
// 		String userID = null;
// 		if (session.getAttribute("userID") != null) {
// 			userID = (String) session.getAttribute("userID");
// 		}
		
		
// 		if(userID == null) {
// 			PrintWriter script = response.getWriter();
// 			script.println("<script>");
// 			script.println("alert('로그인을 하세요.')");
// 			script.println("location.href = 'login.jsp'");
// 			script.println("</script>");
			
			
// 		} else {
			
// 			if (b.getBoardTitle() == null || b.getBoardContent() == null) {
				
// 					PrintWriter script = response.getWriter();
// 					script.println("<script>");
// 					script.println("alert('입력하지 않은 사항이 있습니다.')");
// 					script.println("history.back()");
// 					script.println("</script");
					
// 				} else {
					
// 					BoardDao b = new BoardDao();
					
// 					int result = b.write(board.getBoardTitle(), userID, board.getBoardContent());
					
// 					if (result == -1) {
						
// 						PrintWriter script = response.getWriter();
// 						script.println("<script>");
// 						script.println("alert('글쓰기에 실패했습니다.')");
// 						script.println("history.back()");
// 						script.println("</script>");
					
// 					}
					
// 					else {
						
// 						PrintWriter script = response.getWriter();
// 						script.println("<script>");
// 						script.println("location.href = 'bbs.jsp'");
// 						script.println("</script>");
						
// 					}
					
// 				}
			
// 		}
<%-- 	%> --%>
	
	
</body>
</html>




































