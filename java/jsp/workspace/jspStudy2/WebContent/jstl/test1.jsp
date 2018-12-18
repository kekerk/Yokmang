<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:set var="name" value="${param.name }"/>
<c:set var="age" value="${param.age }" />
<c:set var="num" value="${param.num}" />
<%
		String gen = request.getParameter("gender").equals("1")? "��":"��" ;
		pageContext.setAttribute("gender", gen);
%>
<c:set var="gender" value="${gender}" />

�̸� : ${name}<br>
���� : ${gender}<br>
���� : ${age}<br>

<c:choose>
	<c:when test="${age < 10 }">
	10�� �̸� �Դϴ�<br>
	</c:when>
	<c:when test="${age >= 10 && age < 20 }">
	10�� �Դϴ�<br>
	</c:when>
	<c:when test="${age >= 20 && age < 30 }">
	20�� �Դϴ�<br>
	</c:when>
	<c:when test="${age >= 30 && age < 40 }">
	30�� �Դϴ�<br>
	</c:when>
	<c:when test="${age >= 40 && age < 50 }">
	40�� �Դϴ�<br>
	</c:when>
	<c:when test="${age >= 50 && age < 60 }">
	50�� �Դϴ�<br>
	</c:when>
	<c:otherwise>
	60�� �̻� �Դϴ�<br>
	</c:otherwise>
</c:choose>
<br>
${num}�� ���<br>
<c:forEach var="xnum" begin="1" end="9">
${num} * ${xnum} = ${num*xnum }<br>
</c:forEach>
</body>
</html>