<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="delete.bo" method="post" name="f" >
	<input type="hidden" name="num" value="${param.num}">
	<table border="1" style="border-collapse: collapse;"  class="w3-table-all">
	<caption>�Խù� ���� Ȯ��â</caption>
	<tr><td>�Խù� ������ ���� ��й�ȣ �Է�</td></tr>
	<tr><td><input type="password" name="pass"></td></tr>
	<tr><td colspan="2" align="center"><a href="javascript:document.f.submit()">[����]</a></td></tr>
	</table>
	</form>
</body>
</html>