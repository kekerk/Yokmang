<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��Ű ���� �ϱ�</title>
</head>
<body>
<% 
	Cookie cookie = new Cookie("name", "");
	cookie.setMaxAge(0); //��ȿ�Ⱓ 0 : ������ ����������.
	response.addCookie(cookie);
%>
	<h2>��Ű�� �����Ǿ����ϴ�.</h2>
	<a href="cookie2.jsp"> ��Ű ��ȸ�ϱ�</a>
</body>
</html>