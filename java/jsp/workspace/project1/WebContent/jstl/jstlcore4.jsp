<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="EUC-KR">
<title>기타 core 태그</title>
</head>
<body>
<h3>header 정보 조회하기</h3>
<c:forEach var="h" items="${headerValues }">
	name:${h.key }<br>
	value:<c:forEach var="v" items="${h.value }"> 
		${v}<br>
	</c:forEach>
	<hr>
</c:forEach>
<h3>import tag</h3>
<c:import url="jstlcore1.jsp" var="url" />
${url} <%-- EL보다 JSTL을 쓰는게 더 좋다 : 보안성은 JSTL이 더 좋다--%>
<hr>
<c:out value="${url }"/>
</body>
</html>