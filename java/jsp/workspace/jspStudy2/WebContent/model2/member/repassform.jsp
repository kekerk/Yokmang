<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html><%-- info.jsp�� ��й�ȣ���� �ֱ�. --%>
<%-- 
		��й�ȣ ���� ��ư Ŭ�� �� 
		db�� �Ķ���� ������ �̿��Ͽ� ��й�ȣ �����ϰ�,
		���� ���� : alert("��й�ȣ ������ �Ϸ�Ǿ����ϴ�")  �޼��� ����ϰ� ������ �ݱ�.
		���� ���� : alert("��й�ȣ ���� ����") �޼��� ����ϰ� ������ �ֱ�.
 --%>
<head>
<meta charset="EUC-KR">
<title>model2 ��й�ȣ �缳��</title>
<!-- <style>
	table {
		margin: 0 auto;
		width : 400px;
		border: 2px solid green;
		text-align: center;
	}
	caption {
	font-weight: bold;
	font-size: x-large;
	} 
</style>-->
</head>
<body>
<div style="border:2px solid silver; margin-top:200px;" align="center">
	<form action="repass.me" name="f" method="post">
	<input type="hidden" name="id" value="${param.id }">
	<table border="1" style="border-collapse : collapse;">
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
			<td colspan="2" align="center">
			<input type="submit" value="��й�ȣ ����">
			</td>
		</tr>	
	</table>
	</form>
</div>
</body>
</html>