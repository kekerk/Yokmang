<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>forward �׼� �±� ����</title>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR"); %>
<h1>forward1.jsp ������ �Դϴ�. forward2.jsp�� forward �ǹǷ� �� ������ ȭ�鿡 ǥ�õ��� �ʽ��ϴ�.</h1>
<jsp:forward page="forward2.jsp"> <!--  jsp:forward page=" "  : �׼� �±� : ������ URL�� ��� �ִ´�.-->
	<jsp:param value="forward1.jsp���� �߰��� �Ķ����" name="test"/>
		<jsp:param value="Unknown" name="id"/>
</jsp:forward>
</body>
</html>