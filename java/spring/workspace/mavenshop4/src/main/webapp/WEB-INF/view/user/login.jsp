<%@ page language="java" contentType="text/html; charset=EUC-KR" 
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α��� ȭ��</title>
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
<h3>�α��� ȭ��</h3>
<%-- /mavenshop3/user/loginForm.shop ��û �� login.jsp�� ȭ�� ��� --%>
	<form:form modelAttribute="user" method="post" action="login.shop">
	<input type="hidden" name="userName" value="�Ѿ">
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
				<form:input path="userId"/>
				<font color="red"><form:errors path="userId" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>��й�ȣ</td>
				<td>
					<form:password path="password" />
					<font color="red"><form:errors path="password" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td colspan="2" align="center">
					<input type="submit" value="�α���">
					<input type="button" value="ȸ������" onclick="location.href='userForm.shop'">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>