<%@ page language="java" contentType="text/html; charset=EUC-KR" 
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����� ��� ��� ȭ��</title>
</head>
<body>
	<h2>����� ��� ��� ȭ��</h2>
	<table border="1" cellspacing="0" cellpadding="0">
		<tr>
			<td>���̵�</td>
			<td>${user.userId}</td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td>${user.userName}</td>
		</tr>
		<tr>
			<td>�����ȣ</td>
			<td>${user.postcode}</td>
		</tr>
		<tr>
			<td>�ּ�</td>
			<td>${user.address}</td>
		</tr>
		<tr>
			<td>��ȭ��ȣ</td>
			<td>${user.phoneNo}</td>
		</tr>
		<tr>
			<td>�̸���</td>
			<td>${user.email}</td>
		</tr>
		<tr>
			<td>�������</td>
			<td><fmt:formatDate value="${user.birthDay}" pattern="yyyy�� MM�� dd��" /></td>
		</tr>
	</table>
</body>
</html>