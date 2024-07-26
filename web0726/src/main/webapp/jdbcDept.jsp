<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String loc1 = request.getParameter("loc");
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
//out.println("드라이버 로딩!!");
conn = DriverManager.getConnection(URL, "root" , "mysql");
//out.println("mysql 접속!!");
String sql = "select * from dept where loc like ?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, loc1);
ResultSet rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<input type="text" name="loc">
<input type="submit">
</form>
<p>

<table border="1">

<%

while(rs.next()){
	String deptno = rs.getString("deptno");
	String dname = rs.getString("dname");
	String loc = rs.getString("loc");
	//out.println(deptno);
%>
<tr>
<td><%=deptno %></td><td><%=dname %></td><td><%=loc %></td>
</tr>
<%
}
%>
</table>
</body>
</html>