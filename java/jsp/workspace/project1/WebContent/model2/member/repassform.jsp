<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<%-- info.jsp�� ��й�ȣ���� �ֱ�. --%>

<head>
<meta charset="EUC-KR">
<title>model2 ��й�ȣ �缳��</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<style type="text/css">
body {
	background-image: url("img/Bgimg.jpg");
	background-size: contain;
	font-family: "Raleway", Arial, sans-serif
}

caption {
	font: bold;
	font-size: x-large;
}
</style>
</head>
<body>
	<div style="margin: 50px; padding: 25px;" align="center">
		<form action="repass.me" name="f" method="post">
			<input type="hidden" name="id" value="${param.id }">
			<table border="1" style="border-collapse: collapse;"
				class="w3-centered">
				<caption>��й�ȣ ����</caption>
				<tr>
					<td>���� ��й�ȣ</td>
					<td><input type="password" name="pass1"></td>
				</tr>
				<tr>
					<td>������ ��й�ȣ</td>
					<td><input type="password" name="pass2"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="��й�ȣ ����"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>