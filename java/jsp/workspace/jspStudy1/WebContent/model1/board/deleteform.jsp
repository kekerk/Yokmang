<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="delete.jsp" method="post" name="f">
	<input type="hidden" name="num" value="<%=request.getParameter("num") %>">
	<table border="1" style="border-collapse: collapse;">
	<caption>�Խù� ���� Ȯ��â</caption>
	<tr><td>�Խù� ������ ���� ��й�ȣ �Է�</td></tr>
	<tr><td><input type="password" name="pass"></td></tr>
	<tr><td colspan="2" align="center"><a href="javascript:document.f.submit()">[����]</a></td></tr>
	</table>
	</form>
</body>
</html>