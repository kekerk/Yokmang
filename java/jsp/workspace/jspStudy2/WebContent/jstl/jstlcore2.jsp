<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%-- ���þ� --%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%-- ���þ� --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl ���ǹ� ����</title>
</head>
<body>
<form method="post">
	x : <input type="text" name="x" value="${param.x }"><br> <%-- param.x , param.y�� ���� ������ null�� �ƴ϶� �������� ���� --%>
	y : <input type="text" name="y" value="${param.y }"><br>
	<input type="submit" value="���ϱ�">
</form><p>
�հ� : <c:out value="${param.x + param.y }" /><br> 
<br>
<c:choose>
	<c:when test="${param.x + param.y > 0 }">
		<h4>�� ���� ���� ����Դϴ�.</h4>
	</c:when>
	<c:otherwise>
		<h4>�� ���� ���� �����Դϴ�.</h4>
	</c:otherwise>
</c:choose>
<c:set var="sum" value="${param.x + param.y }" />
<c:if test="${sum > 0 }">
	<h4>�� ���� ���� ����Դϴ�.</h4>
</c:if>
<c:if test="${sum < 0 }">
	<h4>�� ���� ���� �����Դϴ�.</h4>
</c:if>
</body>
</html>