<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String title = request.getParameter("title");
String content = request.getParameter("content");

String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");
String userName = (String) session.getAttribute("userName");
String sql = "insert into reboard(userName,title,content, regtime, hits) values (?,?,?,now(),0)";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, userName);
pstmt.setString(2, title);
pstmt.setString(3, content);
pstmt.executeUpdate();
response.sendRedirect("board.jsp"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 완료</title>
</head>
<body>

</body>
</html>