<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="EUC-KR">
<title>��Ÿ core �±�</title>
</head>
<body>
<h3>header ���� ��ȸ�ϱ�</h3>
<c:forEach var="h" items="${headerValues }">
	name:${h.key }<br>
	value:<c:forEach var="v" items="${h.value }"> 
		${v}<br>
	</c:forEach>
	<hr>
</c:forEach>
<h3>import tag</h3>
<c:import url="jstlcore1.jsp" var="url" />
${url} <%-- EL���� JSTL�� ���°� �� ���� : ���ȼ��� JSTL�� �� ����--%>
<hr>
<c:out value="${url }"/>
</body>
</html>