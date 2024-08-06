<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
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
    String pw =  request.getParameter("pw");
    String name = request.getParameter("name");
    String sql = "select * from register where id= ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, id);
    ResultSet rs = pstmt.executeQuery();
  
        
        if (rs.next()) {   
%>
            <script>
                alert('이미 등록된 아이디입니다.');
                history.back()
            </script>
            
<%          
        } else {           
            
        // 새로운 회원정보를 DB에 추가하는 쿼리
          
            sql = "insert into register values(?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            pstmt.setString(3, name);
            pstmt.executeUpdate();       
           
%>
            <script>
                alert('가입이 완료되었습니다.');
                window.location.href="main.jsp";
               
            </script>
<%          
        }
       
        
%>

