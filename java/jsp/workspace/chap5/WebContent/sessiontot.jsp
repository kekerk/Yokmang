<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ٱ��� ��ǰ ����</title>
</head>
<body>
<h2>��ٱ��� ���</h2>
<%
ArrayList<String> list = (ArrayList<String>)session.getAttribute("list"); 
	if(list== null || list.size()==0){
%>
	<h3>��ٱ��Ͽ� ������ ��ǰ�� �����ϴ�.</h3>
<%	} else {
		for(String p : list) { %>	
		<h4><%=p %></h4>
<%	}%>

<hr>
<h3> ��ٱ��Ͽ� ��ϵ� ��ǰ ���� : <%=list.size() %></h3>
<%	} 
	session.removeAttribute("list"); //list �Ӽ��� ����.
	session.invalidate(); //session ��ü�� ���� ����.
%>
<!--  session ��ü�� �����ϴ� ���������� ���� session �����̶� �Ѵ�.
		 session2.jsp, sessionadd.jsp, sessiontot.jsp�� ���� session ������.
 -->
</body>
</html>