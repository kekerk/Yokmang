<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ ��ȸ</title>
</head>
<body>
<div align="center" class="body">
	<h2>��ǰ���</h2>
	<a href="create.shop">��ǰ ���</a>
	<table border="1">
		<tr class="header">
			<th align="center" width="80">��ǰ ID</th>
			<th align="center" width="320">��ǰ��</th>
			<th align="center" width="100">����</th>
		</tr>
		<c:forEach items="${itemList}" var="item">
			<tr class="record">
				<td align="center">${item.id}</td>
				<td align="left"><a href="detail.shop?id=${item.id}" style="text-decoration: none;">${item.name}</a></td>
				<td align="right"><fmt:formatNumber type="CURRENCY" currencySymbol="" value="${item.price}" minFractionDigits="0"/>��</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="../j_spring_security_logout" style="text-decoration: none;">�� �α׾ƿ��ϱ�</a>
</div>
</body>
</html>