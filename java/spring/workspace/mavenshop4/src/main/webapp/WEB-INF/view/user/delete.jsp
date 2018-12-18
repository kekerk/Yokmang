<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� Ż�� Ȯ��</title>
<style type="text/css">
table {
	width: 90%;
	border-collapse: collapse;
}

th, td {
	border: 3px solid #bcbcbc;
	text-align: center;
	padding: 8px;
}

th {
	background-color: #4CAF50;
	color: white;
	text-align: center;
}

td {
	background-color: #f2f2f2;
}

td.title {
	background-color: #e2e2e2;
	color: blue;
}
</style>
</head>
<body>
<table border="1" style="border-collapse: collapse;">
	<tr><td>���̵�</td><td>${user.userId}</td></tr>
	<tr><td>�̸�</td><td>${user.userName}</td></tr>
	<tr><td>�������</td><td><fmt:formatDate value="${user.birthDay}" pattern="yyyy-MM-dd"/></td></tr>
</table>
<form action="delete.shop" method="post" name="deleteform">
	<input type="hidden" name="id" value="${param.id}">
	��й�ȣ<input type="password" name="password" size="12">
	<a href="javascript:document.deleteform.submit()">[ȸ��Ż��]</a>
</form>
</body>
</html>