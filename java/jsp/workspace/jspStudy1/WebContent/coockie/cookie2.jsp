<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��Ű ���� ��ȸ�ϱ�</title>
</head>
<body>
<%
	//request.getCookies() : �������� ����� ��Ű�� ������ ����. ��Ű��� ����.
	Cookie[] cookies = request.getCookies();
	String name = null;
	String value = null;
	for(Cookie c : cookies){
		if(c.getName().equals("name")){
			name = c.getName();
			value = c.getValue();
		}
	}
%>
<h2>��Ű�̸� : <%=name %></h2>
<h2>��Ű�� : <%=value %></h2>
<%-- ��� ��Ű�� �̸��� ���� ����ϱ� : �赿�� --%>
<%--  --%>
<hr>
<h2>��� ��Ű�� �̸��� �� ���</h2>
<%  for(Cookie c : cookies) { %>
<h2>Cookie c: <%=c %></h2><br>
<h2>��Ű�̸� : <%=c.getName() %></h2><br>
<h2>��Ű�� : <%=c.getValue() %></h2><br> 
<br>
<%} %>
<%-- --------------------------------------- --%>
<br>
<a href="cookie3.jsp">��Ű �����ϱ�</a>
</body>
</html>