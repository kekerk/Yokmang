<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="passchg.jsp" name="f" method="post">

	<table border="1" style="border-collapse : collapse;">
		<caption>��й�ȣ ����</caption>
		<tr>
			<td>���� ��й�ȣ</td>
			<td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td>������ ��й�ȣ</td>
			<td><input type="password" name="chgpass"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="��й�ȣ ����">
			</td>
		</tr>	
	</table>
	</form>
</body>
</html>