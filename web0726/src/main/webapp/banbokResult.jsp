<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 request.setCharacterEncoding("UTF-8");
 String msg = request.getParameter("msg");
 int number = Integer.parseInt(request.getParameter("num"));
 for (int i = 0; i < number; i++){
%>
	<p><%=msg %></p>
<%
 }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>