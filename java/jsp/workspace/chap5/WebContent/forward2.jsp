<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>forward action tag exercise</title>
</head>
<body>
<h2>forward2.jsp ������ : forward1.jsp ���������� forward�� ������ �Դϴ�.</h2>
<h3>��û �Ķ���� ����</h3>
Name : <%=request.getParameter("name") %><br>
Id : <%=request.getParameter("id") %><br>
Tel : <%=request.getParameter("tel") %><br>
Test : <%=request.getParameter("test") %>

</body>
</html>