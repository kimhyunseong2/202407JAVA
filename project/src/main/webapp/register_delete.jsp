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
    
    String id = request.getParameter("id");
    String sql = "delete from register where id= ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, id);
    pstmt.executeUpdate();
    session.invalidate();
    

   
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
        .message {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        a {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            margin: 10px;
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            border-radius: 5px;
            border: none;
            cursor: pointer;
            text-align: center;
        }
        a:hover {
            background-color: #0056b3;
        }
</head>
</style>
<body>
<script>
    alert('회원 탈퇴되었습니다.');
    window.location.href="main.jsp";
</script>

</body>
</html>