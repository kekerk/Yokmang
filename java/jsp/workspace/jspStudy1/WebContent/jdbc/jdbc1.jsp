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
<title>jdbc 예제 1</title>
</head>
<body>
<%
	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bigdb","scott","tiger"); 
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from student order by grade"); //해당 쿼리문을 실행하라.
%>

<table border="1" style="border-collapse:collapse;">
	<tr>
		<td>학번</td>
		<td>이름</td>
		<td>학년</td>
		<td>키</td>
		<td>몸무게</td>
	</tr>
	<% while(rs.next()){ %> <%-- 읽을 내용이 있는가. rs.next()--%>
	 <tr>
	 	<td><%=rs.getString("studno") %></td>
	 	<td><%=rs.getString("name") %></td>
	 	<td><%=rs.getString("grade") %></td>
	 	<td><%=rs.getString("height") %></td>
	 	<td><%=rs.getString("weight") %></td>
	 </tr>
	 <%} %>
	 <%-- student 테이블의 조회된 건수 출력하기. 
	 		select count(*) from student
	 		rs.getInt(1)
	 		전체 학생 인원 수
	 --%>
<%
	rs = stmt.executeQuery("select count(*) from student");
%>
</table>
<hr>
<table border="2"  style="border-collapse:collapse;">
	<tr><td>학생수</td></tr>
	<% while(rs.next()){ %> <%-- 읽을 내용이 있는가. rs.next()--%>
	<tr>
	 <td><%=rs.getInt(1) %></td>
	</tr>
	 <% } %>
</table>
</body>
</html>