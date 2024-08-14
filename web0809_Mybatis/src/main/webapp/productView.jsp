<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
<table border="1">
    <tr>
        <th>ID</th>
         <td>${product.id}</td>
    </tr>
    <tr>
        <th>Name</th>
        <td>${product.name}</td>
    </tr>
    <tr>
        <th>Description</th>
        <td>${product.description}</td>
    </tr>
    <tr>
        <th>Price</th>
        <td>${product.price}</td>
    </tr>
    <tr>
        <th>Stock</th>
        <td>${product.stock}</td>
    </tr>
</table>

</body>
</html>