<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!--  /WebContent/response1.jsp : ���䰴ü ���� -->
<html>
<head>
<meta charset="EUC-KR">
<title>���� ��ü : sendRedirect ����</title>
</head>
<body>
<h2>response ��ü�� ���� ��ü�� �������� �������� ������ �����ϴ� ����� ���� ��ü�Դϴ�. <br>
�� ������ <mark>response1.jsp</mark>���������� �ۼ��� ���������� ȭ�鿡 ��µ����� �ʽ��ϴ�.</h2>
<%response.sendRedirect("response2.jsp"); %>
</body>
</html>