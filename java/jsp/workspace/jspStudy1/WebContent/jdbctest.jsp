<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="jdbctest" class="jspStudy1.Jdbctest" />
<jsp:setProperty property="*" name="jdbctest"/>
<html>
<head>
<meta charset="EUC-KR">
<title>DB ����â</title>
</head>
<body>
<%
	Class.forName("org.mariadb.jdbc.Driver"); //����̹� �ε� -java������ ClassNotFoundException �ڵ鸵 �ʿ� -> try-catch
	Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bigdb","scott","tiger");//DB ����
	Statement stmt= conn.createStatement();// ���� �غ�
	String all = null;
	String ans = "select ";
	ans += jdbctest.getCol();
	ans += " from ";
	ans += request.getParameter("tb");
	ans += ( jdbctest.getWh()!=null)?" where ":"";
	ans += (jdbctest.getWh()!=null)? jdbctest.getWh():"" ;
	ans +=( jdbctest.getGr()!=null)? " group by ":"";
	ans += (jdbctest.getGr()!=null)?jdbctest.getGr():"" ;
	ans += (jdbctest.getHa()!=null)? " having ":"";
	ans += (jdbctest.getHa()!=null)?jdbctest.getHa():"";
	ResultSet rs = stmt.executeQuery(ans);	// ������ �������� executeQuery: ���� ����
	String str = jdbctest.getCol();
	String[] strb = str.split(",");
	%>

<table border="1" style="border-collapse:collapse;">
<tr>
<% for(int i=0;i<strb.length;i++){ %>
	<%="<td>"+strb[i]+"</td>" %>
	 <% } %></tr>
<% while(rs.next()){ %>
<tr> 
	<% for(int i=0;i<strb.length;i++) { %>
 	   <%="<td>"+rs.getString(strb[i])+"</td>" %>
	 <%} } %></tr>
</table>
</body>
</html>



