<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�������� ���� sql ���� ��ȸ</title>
</head>
<% 
request.setCharacterEncoding("euc-kr"); 
String sql = request.getParameter("sql");
%>
<body>
<form name="f" method="post" > <!--  action�� ������� ������ ���� ���� ȣ�� -->
	<textarea name="sql" cols="30" rows="5"><%= sql==null? "" : sql %></textarea>
	<input type="submit" value="���̺� ��ȸ">
</form>
<%  if(sql!=null && !sql.trim().equals("")){
	Class.forName("org.mariadb.jdbc.Driver");   //db�� ����;��� ������ ��� �ڵ��ϴ� ��.
	Connection conn =DriverManager.getConnection("jdbc:mariadb://localhost:3306/bigdb","scott","tiger"); //db����
	PreparedStatement pstmt = conn.prepareStatement(sql); //���� �غ�
	ResultSet rs = pstmt.executeQuery(); // ������ �����ؼ� ������ ��������
	ResultSetMetaData rsmt = rs.getMetaData();
	/*  ��ȸ�Ǽ� �������� */
	PreparedStatement pstmt2 = conn.prepareStatement("select count(*) from (" + sql + " ) a"); //inline-view �� ���Ͽ� �Ǽ� ��������.
	ResultSet rs2 = pstmt2.executeQuery();
	rs2.next();
	/* -----------------  */
%>
<h3>��ȸ�� column �� : <%=rsmt.getColumnCount() %></h3><br>
<h3>��ȸ�� record ��  :   <%=rs2.getInt(1) %></h3><br>
<table border="1" style="border-collapse: collapse;">
	<tr>
		<% for(int i=1;i<=rsmt.getColumnCount();i++) { %>
		<th><%=rsmt.getColumnName(i) %> </th>
	<% } %>
	</tr>
	<% while(rs.next()) {%>
	<tr>
	<% for(int i=1;i<=rsmt.getColumnCount();i++) {%>
		<td><%=rs.getString(i) %></td>
		    <%} %>
		</tr>
		<%} %>
</table>
<%}%>
</body>
</html>