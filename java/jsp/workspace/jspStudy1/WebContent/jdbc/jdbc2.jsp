<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSetMetaData"%>
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
<title>ResultSetmetaDate</title>
</head>
<body>
<%
	//Class.forName(" ") : �ش� ���ڿ��� ������ ã�Ƽ� Ŭ���� ������ �ε�
	Class.forName("org.mariadb.jdbc.Driver"); //Driver �ε�.
	// Connection(�������̽�) ��ü : db�� �������ִ� ��ü.
	Connection conn =
	DriverManager.getConnection("jdbc:mariadb://localhost:3306/bigdb","scott","tiger");
	//Statement(�������̽�) ��ü : sql ���� �����ϰ� �����ϴ� ����� ���� ��ü.
//	Statement stmt = conn.createStatement();
	//ResultSet(�������̽�) ��ü : dbms(db �Ŵ�����Ʈ �ý���)�κ��� ���޵� �����͸� �����ϴ� ��ü.
//	ResultSet rs = stmt.executeQuery("select * from professor");
	//ResultSetMetaData ��ü : ��ȸ�� ���ڵ� ����
	/*
		Statement �� ���� �������̽� PreparedStatement
		Statement ��ü ���� �� �̸� ���� ������ dbms�� �����ϴ� ���.
	
	*/
	PreparedStatement pstmt = conn.prepareStatement("select * from professor where position=?"); 
	pstmt.setString(1, "������");//insert ������ ���� ���δ�.
	ResultSet rs = pstmt.executeQuery();
	//ResultSetMetaData ��ü : ��ȸ�� ���ڵ� ����
	//MetaData�δ� 
	ResultSetMetaData rsmt=rs.getMetaData();
	PreparedStatement pstmt2 = conn.prepareStatement("select count(*) from professor where position=?");
	pstmt2.setString(1, "������");
	ResultSet rs2 = pstmt2.executeQuery();
	rs2.next();
//	rs.last();
//	int cnt =rs.getRow();
//	rs.beforeFirst();
%>
<h3>��ȸ�� �÷� �� : <%=rsmt.getColumnCount() %>
		 ��ȸ�� record �� : <%=rs2.getString(1)%></h3>

<table border="1" style="border-collapse:collapse;">
	<tr>
			<%for(int i=1;i<=rsmt.getColumnCount();i++) {%> <!--  db�� �ε��� 1���� ������. -->
			<th><%=rsmt.getColumnName(i) %></th>
			<% } %>
	</tr>
	<%while(rs.next()) {%>
	<tr>
     		<%for(int i=1;i<=rsmt.getColumnCount();i++) {%> 
			<td><%=rs.getString(i) %>
			<%} %>
	</tr>
	<%} %>
</table>
</body>
</html>