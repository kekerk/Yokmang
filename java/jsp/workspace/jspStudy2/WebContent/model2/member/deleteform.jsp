<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>model2 ȸ��Ż�� ��й�ȣ �Է�</title>

<!-- <style>
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
</style> -->
</head>
<body>
<div style="border:2px solid silver; margin-top:200px;" align="center">
	<form action="delete.me" method="post" name="f">
	<input type="hidden" name="id" value="${param.id}">
	<table border="1" style="border-collapse: collapse;">
	<caption>Ż�� Ȯ��â</caption>
	<tr><td>Ż�� ���� ��й�ȣ �Է�</td></tr>
	<tr><td><input type="password" name="pass"></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="Ż��"></td></tr>
	</table>
	</form>
	</div>
</body>
</html>