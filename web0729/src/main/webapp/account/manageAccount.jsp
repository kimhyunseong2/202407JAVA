<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//데이터베이스 접속
String sql = "";
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");

String idTmp = "";
String nameTmp = "";
String ssnTmp = "";
String telTmp = "";
int balanceTmp = 0;
String sqlTmp = "";

request.setCharacterEncoding("UTF-8"); 		// 한글처리
String find =request.getParameter("find");	// update하기 전 학번을 클릭하면 넘어오는 매개변수값
String id = request.getParameter("id");	// null이면 insert나 update를 하지 말아야 한다
String name = request.getParameter("name");
String ssn = request.getParameter("ssn");
String tel = request.getParameter("tel");
String balance = request.getParameter("balance"); 

String delete = request.getParameter("delete");


if (delete != null){
	sqlTmp = "delete from account where id = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, delete);
	int ret = pstmt.executeUpdate();
}

if (find != null) {
	sqlTmp = "select * from account where id = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, find);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		idTmp = rs.getString("id");
		nameTmp = rs.getString("name");
		ssnTmp = rs.getString("ssn");
		telTmp = rs.getString("tel");
		balanceTmp = rs.getInt("balance");
	}
}

if (id != null) {
	out.println("id는 null이 아닙니다.");
	sqlTmp = "select count(*) from account where id = ?"; 
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, id);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	int cnt = rs.getInt(1); // 0: insert, 1: update
	if (!name.equals("") && !ssn.equals("") && !tel.equals("") && !balance.equals("")) {
	if (cnt == 1) { // 정보 수정
		sqlTmp = "update account set name = ?, ssn = ?, tel = ?, balance = ? where id = ?";
		pstmt = conn.prepareStatement(sqlTmp);
		pstmt.setString(1, name);
		pstmt.setString(2, ssn);
		pstmt.setString(3, tel);
		pstmt.setString(4, balance);
		pstmt.setString(5, id);
		int ret = pstmt.executeUpdate();
	} else { //정보 입력
		sqlTmp = "insert into account(name, ssn, tel, balance) values (?,?,?,?)";
		pstmt = conn.prepareStatement(sqlTmp);
		pstmt.setString(1, name);
		pstmt.setString(2, ssn);
		pstmt.setString(3, tel);
		pstmt.setString(4, balance);
		int ret = pstmt.executeUpdate();
		}
	}else{
		out.println("입력 또는 수정을 할 수 없습니다.");
	}
}else {
	out.println("id는 null입니다.");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
        table { width: 690px; text-align: left; }
        th    { width: 100px; background-color: cyan; }
    </style>
<title>회원 관리 프로그램</title>
</head>
<body>
<form>
	번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="id" value="<%=idTmp %>"><br>
	이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="name" value="<%=nameTmp %>"><br>
    주민번호: <input type="text" name="ssn" value="<%=ssnTmp %>"><br>
    전화번호:<input type="text" name="tel" value="<%=telTmp %>"><br>
    잔액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="balance" value="<%=balanceTmp %>"><br>
    <input type="submit" value="입력/수정">
</form>
<table>
<tr>
        <th>번호</th><th>이름</th>
        <th>주민번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 앞6자리</th><th>전화번호</th><th>잔액</th><th>삭제</th>
</tr>
<%
sqlTmp = "select * from account";
pstmt = conn.prepareStatement(sqlTmp);
ResultSet rs = pstmt.executeQuery();

while(rs.next()) {
	idTmp = rs.getString("id");
	nameTmp = rs.getString("name");
	ssnTmp = rs.getString("ssn");
	telTmp = rs.getString("tel");
	balanceTmp =rs.getInt("balance");
	
%>
	<tr>
	<td><a href="?find=<%=idTmp %>"><%=idTmp %></a></td><td><%=nameTmp %></td><td><%=ssnTmp %></td><td><%=telTmp %></td>
	<td><%=balanceTmp %></td><td><button onclick="location.href='?delete=<%=idTmp %>'">삭제</button>
	</tr>
<%
}
%>
</body>
</html>