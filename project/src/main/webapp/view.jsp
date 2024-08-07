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

String num = request.getParameter("num");
String sql = "select * from reboard where num= ?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, num);
ResultSet rs = pstmt.executeQuery();

String title = "";
String userName="";
String content = "";
String regtime = "";
int hits = 0;

if(rs.next()) {
	title = rs.getString("title");
	content = rs.getString("content");
	regtime = rs.getString("regtime");
	hits = rs.getInt("hits");
	userName = rs.getString("userName");
	
	sql = "update reboard set hits = hits + 1 where num =?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, num);
	pstmt.executeUpdate();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    body {
        display: flex;
        flex-direction: column;
        height: 100vh;
        margin: 0;
        background-color: #f0f0f0;
        font-family: Arial, sans-serif;
        justify-content: space-between;
        align-items: center; /* Center horizontally */
    }
    header {
        text-align: center;
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        max-width: 600px;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin: 20px auto;
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
    .button-container {
        display: flex;
        justify-content: center; /* Center horizontally */
        align-items: center; /* Center vertically */
        margin-bottom: 10px; /* Space from the bottom */
    }
    input[type="button"] {
        width: 120px; /* Adjusted width */
        height: 40px; /* Adjusted height */
        font-size: 14px; /* Font size for readability */
        text-align: center; /* Center text horizontally */
        line-height: 1.5; /* Adjust line-height to center text vertically */
        padding: 0; /* Remove padding */
        margin: 5px; /* Margin around buttons */
        text-decoration: none;
        color: #fff;
        background-color: #007bff;
        border-radius: 5px;
        border: none;
        cursor: pointer;
    }
    input[type="button"]:hover {
        background-color: #0056b3;
    }
</style>
<title><%=userName %>게시판 목록</title>
</head>
<body>
<header>
    <h1><%=userName %> 게시판 목록</h1>
</header>

<table>
 <tr>
        <th>제목</th>
        <td><%=title %></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=userName %></td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td><%=regtime %></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%=hits %></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%=content %></td>
    </tr>   

</table>
<br>
<input type="button" value="목록보기" onclick="location.href='board.jsp'">
<%
    // 현재 글의 작성자와 로그인한 사용자가 일치하는지 확인
    if (userName.equals(session.getAttribute("userName"))) {
%>
<input type="button" value="수정"
       onclick="location.href='write2.jsp?num=<%=num%>'">
<input type="button" value="삭제"
       onclick="location.href='delete.jsp?num=<%=num%>'">
<%
    }
%>
</body>
</html>