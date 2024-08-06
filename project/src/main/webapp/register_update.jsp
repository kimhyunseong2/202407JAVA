<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");

String pw = request.getParameter("pw");
String name = request.getParameter("name");
String id =   request.getParameter("id");
String sql ="update register set pw=?, name=? where id=?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, pw);
pstmt.setString(2, name);
pstmt.setString(3, id);
pstmt.executeUpdate();
session.setAttribute("userName", name );

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
    alert('수정이 완료되었습니다.');
    window.location.href="main.jsp";
</script>
</body>
</html>