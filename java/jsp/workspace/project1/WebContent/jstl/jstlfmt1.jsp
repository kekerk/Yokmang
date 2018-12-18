<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="EUC-KR">
<title>format tag example</title>
</head>
<body>
<h3>���� ���� ���� �����ϱ�</h3>
<%-- type="currency" �ش� ������ ȭ������� ǥ��  --%>
<fmt:formatNumber value="500000" type="currency"/><br>
<fmt:setLocale value="en_US"/> <%-- ���� �����ϱ� --%>
<fmt:formatNumber value="500000" type="currency"/><br>
<fmt:setLocale value="ko_KR"/>
<fmt:formatNumber value="0.15" type="percent" /><br>
<fmt:formatNumber value="1234567890.5555" pattern="###,###.00" /><br><%-- ���� ���� ���� ��� --%>
<h3>��¥ ���� ���� �����ϱ�</h3>
<jsp:useBean id="today" class="java.util.Date"/> <%-- class="java.util.Date" : ���� ��¥ �� �ð��� ������ �� �ִ�.--%>
����� : <fmt:formatDate value="${today}" type="date"/><br>
�ú��� : <fmt:formatDate value="${today}" type="time"/><br>
����� �ú��� : <fmt:formatDate value="${today}" type="both"/><br>
���� ���� : <fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss a"/><br>
<br>
����� �ú��� : <fmt:formatDate value="${today}" type="both" timeStyle="short" dateStyle="short"/><br>
����� �ú��� : <fmt:formatDate value="${today}" type="both" timeStyle="long" dateStyle="long"/><br>
����� �ú��� : <fmt:formatDate value="${today}" type="both" timeStyle="full" dateStyle="full"/><br>
<br>
<h3>���˵� ���ڸ� �Ϲ� ���ڷ� �ٲٱ�</h3>
<fmt:parseNumber value="20,000" var="num1" pattern="##,###" /> 
<fmt:parseNumber value="10,000" var="num2" pattern="##,###" />

�� : ${num1+num2}<br>
�� : <fmt:formatNumber value="${num1+num2 }" pattern="###,###" />

<h3>���˵� ��¥�� �Ϲ� ��¥�� �ٲٱ�</h3>
<fmt:parseDate value="2018-10-04 10:30:30" pattern="yyyy-MM-dd HH:mm:ss" var="day" />
${day}<br>
<%-- day��¥ ���� ����ϱ� --%>
<fmt:parseDate value="${day }" pattern="yyyy�� MM�� dd�� E����" /><br>
<fmt:parseDate value="${day }" type="date" dateStyle="full" />
</body>
</html>