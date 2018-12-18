<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL core �±� ����</title>
</head>
<body>

<h3>&lt;c:set .. /%gt; : page ������ �Ӽ����� ���. �ٸ� ������ ��Ͻ� scope �Ӽ��� �߰��� : scope="request"</h3>
<c:set var="test" value="${'Hello JSTL'}" scope="request"/>

<h3>&lt;c:out .. /%gt; : ��ϵ� �Ӽ� �� ��ȸ. elǥ���� �����</h3>
<c:out value="${test}" />

<h3>&lt;c:remove .. /%gt; : ��ϵ� �Ӽ� �� ����</h3>
<c:remove var="test"/>
test�Ӽ��� : ${test}

<h3>if ���� �±� </h3>
<c:if test="${5 < 10}">
	<h4>5�� 10���� �۴�.</h4>
</c:if>
<c:if test="${5 > 10}"> <%-- ��� �ȵ� --%>
	<h4>5�� 10���� ũ��.</h4>
</c:if>

<h3>choose ���� �±� </h3>
<c:choose>
	<c:when test="${5+10 == 40 }"> <%-- ��� �ȵ� --%>
		<h4>5�� 10�� ���� 40�̴�.</h4>
	</c:when>
		<c:when test="${5+10 == 15 }">
		<h4>5�� 10�� ���� 15�̴�.</h4>
	</c:when>
	<c:otherwise>
	<h4>5�� 10�� ���� �𸥴�.</h4>
	</c:otherwise>
</c:choose>
</body>
</html>