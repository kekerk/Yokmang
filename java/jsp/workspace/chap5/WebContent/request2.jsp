<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��û �Ķ���� ���� ���</title>
</head>
<body>
<%
    // �Ķ������ �⺻ ���ڵ� : 8859_1 : �����ξ�
	request.setCharacterEncoding("EUC-KR"); //�ѱ� ���ڵ�. post ������. 1������ �Է�.
	String name = request.getParameter("name"); //request�� getParameter�Ҷ� �Ӽ� Ÿ���� name�̾���Ѵ�.(id X)
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String hobby = request.getParameter("hobby");
	String year = request.getParameter("year");
%>
<h2>��û �Ķ���� �Ѱ� ��� �ϱ�</h2>
�̸� : <%=name %><br>
���� : <%=age %><br>
���� : <%=(gender.equals("1")? "��":"��") %><br>
��� : <%=hobby %><br>
����⵵ : <%=year %><br>
<hr>
<h2>�ϳ��� ��û �Ķ���Ϳ� �������� ���� ����ϱ�.</h2>
<%
	String[] hobbies = request.getParameterValues("hobby");
	for(String h : hobbies){ %>
	<%=h %> &nbsp;&nbsp;&nbsp;
<%}%>
<hr>
<h2>�Ķ���� �̸��� ��ȸ�Ͽ� �������� ���� ����ϱ� </h2>
<table border="2 solid thick"><tr><th>�Ķ�����̸�</th><th>�Ķ���Ͱ�</th></tr>
<%
// getParameterNames() : �Ķ���� �̸��� ��ȸ
// Enumeration : Iterator�� ������. �ݺ���.
	Enumeration e = request.getParameterNames(); // �Ķ���� �̸��� �� ��. 
 
	while(e.hasMoreElements()){
	String pname = (String)e.nextElement();
	String[] pvalue = request.getParameterValues(pname); %>

<tr><td><%=pname %></td>
		<td><% for(String v : pvalue) { %>
				  <%=v %> &nbsp;&nbsp;&nbsp;
	        	  <%}%></td>
</tr>
<%}%>
</table>
</body>
</html>

<!--  
	request ��ü : ��û ��ü. ��û ������ �����ϰ� �ִ� ��ü.
						   �Ķ���� ����. �Էµ� ��
						    String value = request.getParameter("�Ķ�����̸�");
						    String[] values = request.getParameterValues("�Ķ�����̸�");
						    Enumeration e = request.getParameterNames(); �Ķ���� �̸��� ����.
 -->