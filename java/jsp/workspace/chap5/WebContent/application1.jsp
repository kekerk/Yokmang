<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>application ��ü</title>
</head>
<body>
<h3>application ��ü�� �� ���ø����̼� �� �Ѱ��� ��ü�� �Ҵ�ȴ�.<br>
�� ���� chap5 ������Ʈ�� ��� jsp�� �ϳ��� application ��ü�� �����Ѵ�.
</h3>
<table border="1" style="border-collapse : collapse; ">
	<tr><td> jsp ����</td>
			<td> <%= application.getMajorVersion() %>.<%=application.getMajorVersion() %></td></tr>
	<tr><td> �����̳�����</td>
			<td> <%= application.getServerInfo() %></td></tr>
	<tr><td> Web ���ø����̼� ���� ���� ���</td>
			<td> <%= application.getRealPath("/") %></td></tr>
</table>
<%application.setAttribute("test","application ��ü�� ������ �Ӽ�");
	 session.invalidate();
%>

</body>
</html>