<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ��Ż�� ��й�ȣ �Է�</title>
</head>
<style>
	table {
		margin: 0 auto;
		width : 800px;
		border: 2px solid green;
		text-align: center;
	}
	caption {
	font-weight: bold;
	font-size: x-large;
	}
</style>
<body>
	<form action="delete.jsp" method="post" name="f">
	<input type="hidden" name="id" value="<%=request.getParameter("id") %>">
	<table border="1" style="border-collapse: collapse;">
	<caption>Ż�� Ȯ��â</caption>
	<tr><td>Ż�� ���� ��й�ȣ �Է�</td></tr>
	<tr><td><input type="password" name="pass"></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="Ż��"></td></tr>
	</table>
	</form>
</body>
</html>