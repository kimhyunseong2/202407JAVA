<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept 테이블 업데이트</title>
</head>
<body>
<h1>dept 테이블 업데이트</h1>
<form action = "/web0724/update.do">
부서번호: <input type="text" name="deptno"><br>
부서이름: <input type="text" name="dname"><br>
부서지역: <input type="text" name="loc"><br>
<input type="submit">
</form>
</body>
</html>