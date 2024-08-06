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
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
 <style>
    body {
        display: flex;
        flex-direction: column;
        height: 100vh;
        margin: 0;
        background-color: #f0f0f0;
        font-family: Arial, sans-serif;
    }
    table {
        width: 80%;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin: 20px auto;
    }
    th, td {
        padding: 12px 15px;
        border: 1px solid #ddd;
        text-align: center;
    }
    th {
        background-color: #007bff;
        color: #fff;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    a {
        color: #007bff;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
    .button-container {
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: auto;
        padding: 20px;
    }
    input[type="button"] {
        display: inline-block;
        padding: 10px 20px;
        font-size: 16px;
        text-decoration: none;
        color: #fff;
        background-color: #007bff;
        border-radius: 5px;
        border: none;
        cursor: pointer;
        margin: 10px 10px; 
    }
    input[type="button"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<table>
    <tr>
        <th class="num"    >번호    </th>
        <th class="title"  >제목    </th>
        <th class="userName" >작성자  </th>
        <th class="regtime">작성일시</th>
        <th class="hits" >조회수  </th>
    </tr>
<%
String sql = "select * from reboard ";
pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();

while(rs.next()) {
	int num = rs.getInt("num");
	String userName = rs.getString("userName");
	String title = rs.getString("title");
	String content = rs.getString("content");
	String regtime = rs.getString("regtime");
	int hits = rs.getInt("hits");
%>   
    <tr>
        <td><%=num %></td>
        <td >
            <%=title %>
        </td>
        <td style="text-align:left;"><a href="view.jsp?userName=<%=userName%>"><%=userName %></a></td>
        <td><%=regtime %></td>
        <td><%=hits %></td>
    </tr>

<%	
}
%>
</table>
<br>
<input type="button" value="글쓰기" onclick="location.href='write.jsp'">
<input type="button" value="홈으로" onclick="location.href='main.jsp'">
</body>
</html>