<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");

String userName = request.getParameter("userName");
String sql = "select * from reboard where userName = ?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, userName);
ResultSet rs = pstmt.executeQuery();


String title = "";
String content = "";
String regtime = "";
int hits = 0;

if(rs.next()) {
	
	title = rs.getString("title");
	content = rs.getString("content");
	regtime = rs.getString("regtime");
	hits = rs.getInt("hits");
	
	
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #f0f0f0;
        font-family: Arial, sans-serif;
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
    table {
        width: 100%;
        max-width: 600px;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin: 20px auto;
        padding: 10px;
        border-radius: 8px;
    }
    th, td {
        padding: 12px 15px;
        border: 1px solid #ddd;
        text-align: left;
    }
    th {
        background-color: #007bff;
        color: #fff;
    }
    textarea {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-sizing: border-box;
    }
    input[type="text"], textarea {
        width: calc(100% - 30px); /* Adjust width for padding */
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-sizing: border-box;
    }
    input[type="submit"], input[type="button"] {
        padding: 10px 20px;
        font-size: 16px;
        margin: 10px;
        text-decoration: none;
        color: #fff;
        background-color: #007bff;
        border-radius: 5px;
        border: none;
        cursor: pointer;
    }
    input[type="submit"]:hover, input[type="button"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<form method="post" action="update.jsp">
<input type="hidden" name="userName" value="<%=userName %>">
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"  maxlength="80"
                       value="<%=title%>">
            </td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" maxlength="20"
                       value="<%=userName%>">
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10"><%=content%></textarea>
            </td>
        </tr>
    </table>

    <br>
    <input type="submit" value="저장">
    <input type="button" value="취소" onclick="history.back()">
</form>
</body>
</html>