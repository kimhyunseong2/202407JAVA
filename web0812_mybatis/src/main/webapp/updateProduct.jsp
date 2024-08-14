<%@page import="shop.Product"%>
<%@page import="shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String name = request.getParameter("name");
String description = request.getParameter("description");
String price = request.getParameter("price");
String stok = request.getParameter("stok");
ProductDAO dao = new ProductDAO();
Product product = new Product(Integer.parseInt(id), name, description, Double.parseDouble(price), stok );
dao.updateProduct(product);
%>
<jsp:forward page="productList.jsp"/>
