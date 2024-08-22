<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">  
<title>BM</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">BM</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/main">Home</a>
              </li>
              <li class="nav-item">
              <c:if test="${userLoggedIn}">
            		<li><a class="nav-link" href="${pageContext.request.contextPath}/logout">${customInfo.name}님, Logout</a>
            		<li class="nav-item">
                <a class="nav-link " href="${pageContext.request.contextPath}/list">게시판</a>
              </li>
            	</c:if>
            	<c:if test="${!userLoggedIn}">
            		<li><a class="nav-link" href="${pageContext.request.contextPath}/loginForm">로그인</a></li>
            		<li class="nav-item">
                <a class="nav-link " href="${pageContext.request.contextPath}/registerForm">회원가입</a>
              </li>
            	</c:if>
              </li>
              
              
            </ul>
            <form class="d-flex" role="search">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
        </div>
      </nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<div class="container" style="padding-top: 50px;">
<div class="container mt-5">
 <h1 class="text-center mb-4">BM사이트에 오신 것을 환영합니다</h1>
  <p class="text-center">로그인 후 게시판을 확인할 수 있습니다. 많은 관심 부탁드립니다!</p>
  </div>
</body>
</html>