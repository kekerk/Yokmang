<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- ���� ������ : exception ��ü�� ���޵�.--%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �߻� ������</title>
</head>
<body>
<h1> �Ķ���� name�� �Է����ּ���</h1>
<h1> ��� ������ �߻��ϸ� ����η� ���� �ٶ��ϴ�.</h1>
<h1> ����� : 1234 ���</h1>
<h1> exception ��ü�� error ������������ �����˴ϴ�.</h1>
<%=exception.getMessage() %> <!-- null ���� -->

</body>
</html>