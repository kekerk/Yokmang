<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���ε� ���</title>
</head>
<body>
<%
	
	String uploadPath = application.getRealPath("/") + "upload/";//���� ���ε� ���� ����
	int size = 10 * 1024 * 1024;//�ִ� ���ε� ũ�� ����. 10M �̻� ���ε� �Ұ�.
	MultipartRequest multi = new MultipartRequest(request,uploadPath,size,"euc-kr"); // ���� ���ε� �Ϸ� 
	/*
		MultipartRequest
		1. request : ��û ������ü. �Ķ��������, ��������, ������ ���� �������� ������ ��ü
		2. uploadPath : ���� ���ε��� ���� ����
		3. size : �ִ� ���ε� ũ�� ����.
		4. "euc-kr" : �Ķ���� ���ڵ�
	*/
	String name = multi.getParameter("name");
	String title = multi.getParameter("title");
	String fileName = multi.getFilesystemName("file1");
%>

<table border="1" style="border-collapse: collapse;">
<tr><td>�ø����</td><td><%=name %></td></tr>
<tr><td>����</td><td><%=title %></td></tr>
<tr><td>���ε� ���</td><td><%=uploadPath %></td></tr>
<tr><td>����</td><td><a href="<%=fileName %>"><%=fileName %></a></td></tr>
</table>
</body>
</html>
















