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
ResultSet rs = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");

String userId = (String)session.getAttribute("userId");
String sql = "select * from register where id= ?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, userId);
rs = pstmt.executeQuery();

if (rs.next()) {
    String userName = rs.getString("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
        }
        header {
            position: absolute;
            top: 20px;
            width: 100%;
            text-align: center;
        }
        header h1 {
            margin: 0;
            font-size: 36px;
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            text-align: center;
        }
        table {
            margin: 0 auto;
        }
        td {
            padding: 8px;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin: 4px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            margin: 10px;
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<form action="register_delete.jsp" method="post">
<table>
<tr>
<td>아이디</td>
<td><input type="text" name="id" readonly value="<%=userId %>"></td>
</tr>
 <tr>
<td>이름</td>
<td><input type="text" name="name" readonly value="<%= userName %>"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="탈퇴" ></td>
</tr>
</table>
</form>
</body>
</html>
<%
    }
%>