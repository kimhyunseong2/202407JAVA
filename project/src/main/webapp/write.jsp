<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 작성</title>
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
        table {
            width: 100%;
            max-width: 600px;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 20px 0;
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="text"], input[type="submit"], input[type="button"] {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            margin-top: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        input[type="text"] {
            width: 100%;
            box-sizing: border-box;
        }
        input[type="submit"], input[type="button"] {
            color: #fff;
            background-color: #007bff;
            border: none;
            cursor: pointer;
            text-align: center;
        }
        input[type="submit"]:hover, input[type="button"]:hover {
            background-color: #0056b3;
        }
        input[type="button"] {
            background-color: #6c757d;
        }
        input[type="button"]:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
<%
    // 세션에서 사용자 이름을 가져옵니다.
    String userName = (String) session.getAttribute("userName");
%>
<form method="post" action="insert.jsp">

    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"  maxlength="80"
                       value="">
            </td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" maxlength="20"
                       value="<%=userName%>">
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10"></textarea>
            </td>
        </tr>
    </table>

    <br>
    <input type="submit" value="저장">
    <input type="button" value="취소" onclick="history.back()">
</form>
</body>
</html>