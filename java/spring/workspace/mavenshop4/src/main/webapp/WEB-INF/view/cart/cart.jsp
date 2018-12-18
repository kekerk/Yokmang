<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ٱ��� ���</title>
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
<h2>��ٱ��� ���</h2>
<table>
	<tr><td colspan="5"><font color="green">��ٱ��� ��ǰ ���</font></td></tr>
	<tr><td>��ǰ��</td><td>����</td><td>����</td><td>�հ�</td><td>���</td></tr>
	<c:set var="tot" value="${0}"/>
	<c:forEach items="${cart.itemSetList}" var="itemSet" varStatus="stat">
		<tr><td>${itemSet.item.name}</td><td>${itemSet.item.price}</td><td>${itemSet.quantity}</td><td>${itemSet.item.price * itemSet.quantity}</td>
		<td><a href="cancel.shop?index=${stat.index}">���</a></td></tr>
		<c:set var="tot" value="${tot+(itemSet.item.price*itemSet.quantity)}"/>
	</c:forEach>
	<tr><td colspan="5"><font color="green">�ѱ��� �ݾ� : ${tot}��</font></td></tr>
</table>
<br>${message}<br><a href="../item/list.shop">��ǰ���</a>&nbsp;&nbsp;<a href="checkout.shop">�ֹ��ϱ�</a>
</body>
</html>