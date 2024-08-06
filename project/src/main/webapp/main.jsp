<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BM</title>
 <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
        }
         header {
            position: absolute;
            top: 20px;
            width: 100%;
            text-align: center;
        }
        header h1 {
            margin: 0;
            font-size: 36px;
            color: #333;
        }
        a.button {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            margin: 10px;
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            border-radius: 5px;
            border: none;
            cursor: pointer;
            text-align: center;
        }
        a.button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<header>
        <h1>BM 홈페이지</h1>
    </header>

 	<a href="login_main.jsp" class="button">로그인</a>
    <a href="register.jsp" class="button">회원가입</a>
</body>
</html>