<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ ���� ȭ��</title>
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
<form:form modelAttribute="item" action="update.shop" enctype="multipart/form-data"> <%-- ���� ���ε� --%>
<form:hidden path="id"/>
<form:hidden path="pictureUrl"/>
<h2>��ǰ ���� ȭ��</h2>
<table>
	<tr>
		<td>��ǰ��</td>
		<%-- <input type="text" id="name" name="name" value="${item.name}"> --%>
		<td><form:input path="name" maxlength="20" /></td>
		<td><font color="red"><form:errors path="name"/></font></td> <%-- form:errors : ��ȿ�� ���� --%>
	</tr>
	<tr>
		<td>����</td>
		<td><form:input path="price" maxlength="6" /></td>
		<td><font color="red"><form:errors path="price"/></font></td>
	</tr>
	<tr>
		<td>��ǰ�̹���</td>
		<td><input type="file" name="picture"></td>
		<td>${item.pictureUrl}&nbsp;</td>
	</tr>
	<tr>
		<td>��ǰ����</td>
		<td><form:textarea path="description" cols="20" rows="5"/></td>
		<td><font color="red"><form:errors path="description"/></font></td>
	</tr>
	<tr>
		<td colspan="3"><input type="submit" value="����">&nbsp;
		<input type="button" value="��ǰ���" onclick="location.href='list.shop'"></td>
	</tr>
</table>
</form:form>
</body>
</html>