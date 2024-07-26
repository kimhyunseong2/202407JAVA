<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

int number = Integer.parseInt(request.getParameter("n"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=number  %>단</title>
</head>
<body>
<table border="1">
<tr><th><%=number %>단</th></tr>
<%
for(int i = 1; i<10; i++){
%>	
	<tr><td><%=number %>X<%=i %>=<%=i*number %></td></tr>	
<%	
}
%>
</table>


</body>
</html>