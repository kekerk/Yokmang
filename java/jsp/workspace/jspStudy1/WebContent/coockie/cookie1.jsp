<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��Ű �����ϱ�</title>
</head>
<body>
<% Cookie cookie = new Cookie("name","hongkildong");
		cookie.setMaxAge(10*60); //��ȿ �ð��� ������. 600��
		response.addCookie(cookie); // ��Ű�� ���䰴ü�� ��������. �������� ��Ű�� �����Ѵٴ� �ǹ�.
%>
<h2>��Ű�̸�:<%=cookie.getName() %></h2> 
<h2>��Ű��:<%=cookie.getValue() %></h2>
<h2>��Ű��ȿ�ð�:<%=cookie.getMaxAge() %></h2>
<a href="cookie2.jsp">��Ű�� �ҷ�����</a>
</body>
</html>