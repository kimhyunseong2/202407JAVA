<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@page import="dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="dept.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
p

BoardDAO dao = new BoardDAO();
List<BoardDTO> list = dao.listBoard();
for (BoardDTO dto : list){
		out.println(dto+"<br>");
}
%>
</body>
</html>