<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>request Header ���� ����</title>
</head>
<body>
<table border="1" style="border-collapse : collapse;">
	<tr><th>����̸�</th><th>�����</th></tr>
	<%
		Enumeration e = request.getHeaderNames(); //��� �̸��� ��ȸ
		while(e.hasMoreElements()){ //�ٸ� ��ҵ��� �ִ��� 
			String hname = (String)e.nextElement(); %>
<tr><td><%=hname %>	</td>
		<td><%=request.getHeader(hname) %></td></tr>	
<%}%>
</table>
<table  border="1" style="border-collapse : collapse;">
<caption><h2>Ŭ���̾�Ʈ ����</h2></caption>
<tr><th>Ŭ���̾�Ʈ ����</th><th>Ŭ���̾�Ʈ ����</th></tr>
<tr><td>�����ּ�</td><td><%=request.getLocalAddr() %></td></tr>
<tr><td>Ŭ���̾�Ʈ�ּ�</td><td><%=request.getRemoteAddr() %></td></tr>
<tr><td>Ŭ���̾�Ʈ�ּ�</td><td><%=request.getRemoteHost() %></td></tr>
<tr><td>��ûmethod</td><td><mark><%=request.getMethod() %></mark></td></tr>
<tr><td>��ûuri</td><td><b><%=request.getRequestURI() %></b></td></tr>
<tr><td>��ûurl</td><td><strong><%=request.getRequestURL() %></strong></td></tr>
<tr><td>�� ���ø����̼� ���</td><td><%=request.getContextPath() %></td></tr>
<tr><td>�����̸�</td><td><%=request.getServerName() %></td></tr>
<tr><td>������Ʈ</td><td><%=request.getServerPort() %></td></tr>

</table>
</body>
</html>