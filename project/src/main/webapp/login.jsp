<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
request.setCharacterEncoding("utf-8");
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");   
String id =request.getParameter("id");
String pw = request.getParameter("pw");
String sql = "select * from register where id=? and pw=?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, id);
pstmt.setString(2, pw);
ResultSet rs = pstmt.executeQuery();
    // 그런 레코드가 있으면, 세션 속성을 등록하고, 메인 화면으로 돌아감
    if (rs.next()) {
        session.setAttribute("userId",   rs.getString("id" ));
        session.setAttribute("userName", rs.getString("name"));    
        response.sendRedirect("login_main.jsp");   
        return;
    }
    

%>
<!DOCTYPE html>
<html>
<head>
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
       
        input[type="submit"] {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            margin-top: 10px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .error-message {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
            border-radius: 5px;
            padding: 15px;
            margin: 20px;
            text-align: center;
        }
    </style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>
</body>
</html>