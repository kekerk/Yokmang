<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>trip information</title>
</head>
<body> <!--  forward��Ű��. -->
<form action = "info.jsp" name="f" method="post">
<select name="loc">
		<option value="seoul">���� ����</option>
		<option value="busan">�λ� ����</option>
		<option value="daegu">�뱸 ����</option>
		<option value="kwangju">���� ����</option>
		<option value="jeju">���� ����</option>
</select>
	<input type = "submit" value="���� ���� ��ȸ">
</form>
</body>
</html>