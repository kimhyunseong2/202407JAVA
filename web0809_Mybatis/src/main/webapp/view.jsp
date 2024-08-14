<%@page import="shop.ProductDAO"%>
<%@page import="shop.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
ProductDAO productDAO = new ProductDAO();
Product product = productDAO.getProductById(Integer.parseInt(id));
request.setAttribute("product", product);
%>
<jsp:forward page="productView.jsp"/>