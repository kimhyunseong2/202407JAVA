<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setAttribute("name", "홍길동");
request.setAttribute("money", 5000);
request.setAttribute("dataList", new String[] {"a", "b", "c"});
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${name == '홍길동'}">
	이름은 홍길동입니다.<br>
</c:if>
<c:choose>
	<c:when test="${money >= 10000 }">
		돈 많아요.
	</c:when>
	<c:when test="${money > 0 }">
		돈 조금 있어요.
	</c:when>
	<c:otherwise>
		돈 하나도 없어요.
	</c:otherwise>
</c:choose>
<br>
<c:forEach var="count" begin="0" end="30" step="3">
	${count}
</c:forEach>
<br>
<!-- 1부터 10까지의 합을 출력 JSTL forEach -->
${sum = 0; ''}
<c:forEach var="i" begin="1" end="10">
${sum = sum + i; ''}
</c:forEach>
1부터 10까지의 합: ${sum}

<!--구구단 4단을 출력 JSTL forEach -->
<ul>
<c:forEach var="i" begin="1" end="9">
<li>4 X ${i} = ${4*i}</li>
</c:forEach>
</ul>

<!-- 배열 또는 리스트를 순회하는 반복문 JSTL forEach -->
<c:forEach var="data" items="${dataList}">
	${data}
</c:forEach>
</body>
</html>