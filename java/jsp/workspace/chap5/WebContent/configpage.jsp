<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>config ��ü</title>
</head>
<body>
<h2> config : ������ �Ķ���� ���޿� ���Ǵ� ��ü. jsp ������������ �� ������.</h2>
<table border="1">
	<tr><td>�Ķ�����̸�</td><td>�Ķ���Ͱ�</td></tr>
	<% Enumeration e = config.getInitParameterNames();
		   while(e.hasMoreElements()) { 
				String name = (String) e.nextElement();%>
			   <tr>
			   <td><%=name %></td>
			   <td><%=config.getInitParameter(name) %></td>
			   </tr>		  
		   <%}%>
</table>
<h2>page �⺻ ��ü : jsp ������ ��ü�� �ǹ��Ѵ�. this ��ü�� ����.</h2>
�������� Ŭ���� �̸� : <%=page.getClass().getName() %>
�������� Ŭ���� �̸� : <%=this.getClass().getName() %>
</body>
</html>