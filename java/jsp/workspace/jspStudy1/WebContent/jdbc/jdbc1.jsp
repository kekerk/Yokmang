<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jdbc ���� 1</title>
</head>
<body>
<%
	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bigdb","scott","tiger"); 
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from student order by grade"); //�ش� �������� �����϶�.
%>

<table border="1" style="border-collapse:collapse;">
	<tr>
		<td>�й�</td>
		<td>�̸�</td>
		<td>�г�</td>
		<td>Ű</td>
		<td>������</td>
	</tr>
	<% while(rs.next()){ %> <%-- ���� ������ �ִ°�. rs.next()--%>
	 <tr>
	 	<td><%=rs.getString("studno") %></td>
	 	<td><%=rs.getString("name") %></td>
	 	<td><%=rs.getString("grade") %></td>
	 	<td><%=rs.getString("height") %></td>
	 	<td><%=rs.getString("weight") %></td>
	 </tr>
	 <%} %>
	 <%-- student ���̺��� ��ȸ�� �Ǽ� ����ϱ�. 
	 		select count(*) from student
	 		rs.getInt(1)
	 		��ü �л� �ο� ��
	 --%>
<%
	rs = stmt.executeQuery("select count(*) from student");
%>
</table>
<hr>
<table border="2"  style="border-collapse:collapse;">
	<tr><td>�л���</td></tr>
	<% while(rs.next()){ %> <%-- ���� ������ �ִ°�. rs.next()--%>
	<tr>
	 <td><%=rs.getInt(1) %></td>
	</tr>
	 <% } %>
</table>
</body>
</html>