<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
 <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
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
       
       input[type="submit"] {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            margin-top: 10px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        input[type="button"] {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            margin-top: 10px;
        }
        input[type="button"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%
    if ((String)session.getAttribute("userId") != null) {          
        // 로그인 상태일 때의 출력 
%>
        <form action="logout.jsp" method="post">  
            <%=(String)session.getAttribute("userName")%>님 환영합니다<p>
            <input type="submit" value="로그아웃">
            <input type="button" value="회원정보 수정" 
                   onclick="location.href= 'register_update_form.jsp'" >
            <input type="button" value="회원탈퇴" onclick="location.href='register_delete_form.jsp'"> 
            <input type="button" value="게시판" onclick="location.href='board.jsp'">
        </form>
<%  
    } else {                       
        // 로그인되지 않은 상태일 때의 출력
%>		<form action="login.jsp" method="post">
            아이디&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"     name="id"><p>
            비밀번호 <input type="password" name="pw">
            <p>
            <input type="submit" value="로그인">
            <input type="button" value="뒤로가기" onclick="location.href='main.jsp'">
        </form>
<%
    }
%>
</body>
</html>