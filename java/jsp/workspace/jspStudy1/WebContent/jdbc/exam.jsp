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
<title>간단하지 않은 sql 구문 조회</title>
</head>
<% 
request.setCharacterEncoding("euc-kr"); 
String sql = request.getParameter("sql");
%>
<body>
<form name="f" method="post" > <!--  action을 집어넣지 않으면 내가 나를 호출 -->
	<textarea name="sql" cols="30" rows="5"><%= sql==null? "" : sql %></textarea>
	<input type="submit" value="테이블 조회">
</form>
<%  if(sql!=null && !sql.trim().equals("")){
	Class.forName("org.mariadb.jdbc.Driver");   //db를 끌어와야할 때마다 계속 코딩하는 중.
	Connection conn =DriverManager.getConnection("jdbc:mariadb://localhost:3306/bigdb","scott","tiger"); //db연결
	PreparedStatement pstmt = conn.prepareStatement(sql); //쿼리 준비
	ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행해서 데이터 가져오기
	ResultSetMetaData rsmt = rs.getMetaData();
	/*  조회건수 가져오기 */
	PreparedStatement pstmt2 = conn.prepareStatement("select count(*) from (" + sql + " ) a"); //inline-view 를 통하여 건수 가져오기.
	ResultSet rs2 = pstmt2.executeQuery();
	rs2.next();
	/* -----------------  */
%>
<h3>조회된 column 수 : <%=rsmt.getColumnCount() %></h3><br>
<h3>조회된 record 수  :   <%=rs2.getInt(1) %></h3><br>
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