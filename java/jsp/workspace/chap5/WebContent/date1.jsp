<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%-- 
   ���� ��¥�� yyyy-MM-dd hh:mm:ss a ���·� �����Ͽ� 
   session ��ü�� date��� �̸����� ����ϴ� ���α׷� 
   --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� date ���</title>
</head>
<body>
<% // SimpleDateFormat : ��¥ ������ �����Ѵ�.
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
	String s = sf.format(new Date()); // s�� "yyyy-MM-dd hh:mm:ss a"���°� ���ڿ��� ����ȴ�.
	session.setAttribute("date", s); // session ��ü�� s�� �Ӽ����� ����Ѵ�.(s->"date")
%>
��ϵ� ��¥ : <%=s %>
</body>
</html>