<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����� ���</title>
<style type="text/css">
table {
	width: 90%;
	border-collapse: collapse;
}

th, td {
	border: 3px solid #bcbcbc;
	padding: 8px;
}

th {
	background-color: #4CAF50;
	color: white;
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
<h2>����� ���</h2>
<div align="center">
<form:form modelAttribute="user" method="post" action="userEntry.shop">
		<spring:hasBindErrors name="user">
			<font color="red">
				<c:forEach items="${errors.globalErrors}" var="error">
					<spring:message code ="${error.code}" />
				</c:forEach>
			</font>
		</spring:hasBindErrors>	
		<table>
			<tr height="40px">
				<td>���̵�</td>
				<td>
				<form:input path="userId" />
				<font color="red"><form:errors path="userId" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>��й�ȣ</td>
				<td>
					<form:input path="password" /></td></tr><tr><td>
					<font color="red"><form:errors path="password" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>�̸�</td>
				<td>
				<form:input path="userName" /></td></tr><tr><td>
				<font color="red"><form:errors path="userName" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>��ȭ��ȣ</td>
				<td>
					<form:input path="phoneNo" />
					<font color="red"><form:errors path="phoneNo" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>�����ȣ</td>
				<td>
					<form:input path="postcode" />
					<font color="red"><form:errors path="postcode" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>�ּ�</td>
				<td>
					<form:input path="address" />
					<font color="red"><form:errors path="address" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>�̸���</td>
				<td>
					<form:input path="email" />
					<font color="red"><form:errors path="email" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>�������</td>
				<td>
					<form:input path="birthDay" /></td></tr><tr><td>
					<font color="red"><form:errors path="birthDay" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td colspan="2" align="center">
					<input type="submit" value="���">
					<input type="reset" value="�ʱ�ȭ">
				</td>
			</tr>
		</table>
	</form:form>
</div>
</body>
</html>