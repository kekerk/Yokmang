<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ֹ� �� ��ǰ ��� ����</title>
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
	<h2>����� ����</h2>
	<table>
		<tr>
			<td width="30%" class="title">������ ID</td>
			<td width="70%">${sessionScope.loginUser.userId}</td>
		</tr>
		<tr>
			<td width="30%" class="title">�̸�</td>
			<td width="70%">${sessionScope.loginUser.userName}</td>
		</tr>
		<tr>
			<td width="30%" class="title">�����ȣ</td>
			<td width="70%">${sessionScope.loginUser.postcode}</td>
		</tr>
		<tr>
			<td width="30%" class="title">�ּ�</td>
			<td width="70%">${sessionScope.loginUser.address}</td>
		</tr>
		<tr>
			<td width="30%" class="title">��ȭ��ȣ</td>
			<td width="90%">${sessionScope.loginUser.phoneNo}</td>
		</tr>
		<tr>
			<td width="30%" class="title">�̸���</td>
			<td width="90%">${sessionScope.loginUser.email}</td>
		</tr>
	</table>
	<br>
	<br>
	<h2>������ ��ǰ ���</h2>
	<table>
		<tr>
			<td>��ǰ��</td>
			<td>��ǰ����</td>
			<td>����</td>
			<td>�Ѿ�</td>
		</tr>
		<c:forEach items="${sessionScope.CART.itemSetList}" var="itemSet">
			<tr>
				<td>${itemSet.item.name}</td>
				<td>${itemSet.item.price}��</td>
				<td>${itemSet.quantity}</td>
				<td>${itemSet.item.price * itemSet.quantity}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" style="text-align: right;">�ѱݾ� : 
			<%-- ${CART.totalAmount} : Cart ��ü�� getTotalAmount() �޼��� ȣ��� --%>
			<fmt:formatNumber value="${CART.totalAmount}" pattern="#,###"/>��
			</td>
		</tr>
		<tr>
			<td colspan="4" >
				<a href="end.shop">�ֹ�Ȯ��</a>&nbsp;
				<a href="../item/list.shop">��ǰ���</a>
			</td>
		</tr>
	</table>
</body>
</html>