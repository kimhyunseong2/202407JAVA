<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>   

<%
   
String id = request.getParameter("id");
String pw = request.getParameter("pw");
MemberDAO dao = new MemberDAO();
MemberDTO dto = dao.getSelect(id,pw,"");
      
            response.sendRedirect("login_main.jsp");   
            return;
      
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>
 
</body>
</html>
