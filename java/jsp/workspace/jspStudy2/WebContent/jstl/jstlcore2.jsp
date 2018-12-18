<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%-- 지시어 --%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%-- 지시어 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl 조건문 연습</title>
</head>
<body>
<form method="post">
	x : <input type="text" name="x" value="${param.x }"><br> <%-- param.x , param.y의 값이 없으면 null이 아니라 공백으로 들어간다 --%>
	y : <input type="text" name="y" value="${param.y }"><br>
	<input type="submit" value="더하기">
</form><p>
합계 : <c:out value="${param.x + param.y }" /><br> 
<br>
<c:choose>
	<c:when test="${param.x + param.y > 0 }">
		<h4>두 수의 합은 양수입니다.</h4>
	</c:when>
	<c:otherwise>
		<h4>두 수의 합은 음수입니다.</h4>
	</c:otherwise>
</c:choose>
<c:set var="sum" value="${param.x + param.y }" />
<c:if test="${sum > 0 }">
	<h4>두 수의 합은 양수입니다.</h4>
</c:if>
<c:if test="${sum < 0 }">
	<h4>두 수의 합은 음수입니다.</h4>
</c:if>
</body>
</html>