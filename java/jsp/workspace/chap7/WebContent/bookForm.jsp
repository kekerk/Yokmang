<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �۾���</title>
</head>
<body>
<form action="book.jsp" method="post">
	<table border="1" style="border-collapse : collapse;">
	<caption>����</caption>
		<tr><td>�湮��</td>
				<td><input type="text" name="writer"></td>
		</tr>
		<tr><td>����</td>
				<td><input type="text" name="title1"></td>
		</tr>
		<tr><td>����</td>
				<td><textarea  rows="5" cols="60" name="content"></textarea></td>
		</tr>
		<tr>
		<td colspan="2" align="center"><input type="submit" value="���� ���"></td>
		</tr>
	</table>
</form>
</body>
</html>