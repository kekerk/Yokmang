<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ǰ ��� ����</title>
</head>
<body>
	<h2>��ǰ ���</h2>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th width="10%">��ǰID</th>
			<th width="50%">��ǰ��</th>
			<th width="20%">����</th>
			<th width="20%">����</th>
		</tr>
		<c:forEach items="${itemList}" var="item">
		<tr>
			<td>${item.id}</td>
			<td><a href="detail.shop?id=${item.id}">${item.name}</a></td>
			<td>${item.price}</td>
			<td><img src="img/${item.pictureUrl}" width="50"></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>