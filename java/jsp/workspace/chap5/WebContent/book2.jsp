<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�湮�� ���â</title>
</head>
<body>
<%request.setCharacterEncoding("EUC-KR"); %> <!--  ������ ���ڵ� --> 
<% 
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		String s = sf.format(new Date());
%>
<table border="1">
<caption>����</caption>
<tr><td>�湮��</td><td><%=request.getParameter("writer") %></td></tr>
<tr><td>����</td><td><%=request.getParameter("title") %></td></tr>
<tr><td>����</td><td><%=request.getParameter("content") %></td></tr>
<tr><td>�����</td><td><%=s %></td></tr>
</table>
</body>
</html>
<%-- jsp ���� ��ü (8+1)
		request
		application
		response
		session
		pageContext
		out, page, ...
	
--%>