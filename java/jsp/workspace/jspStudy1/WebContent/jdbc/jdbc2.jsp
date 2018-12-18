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
	//Class.forName(" ") : 해당 문자열의 정보를 찾아서 클래스 정보를 로드
	Class.forName("org.mariadb.jdbc.Driver"); //Driver 로드.
	// Connection(인터페이스) 객체 : db와 연결해주는 객체.
	Connection conn =
	DriverManager.getConnection("jdbc:mariadb://localhost:3306/bigdb","scott","tiger");
	//Statement(인터페이스) 객체 : sql 구문 전달하고 실행하는 기능을 가진 객체.
//	Statement stmt = conn.createStatement();
	//ResultSet(인터페이스) 객체 : dbms(db 매니지먼트 시스템)로부터 전달된 데이터를 저장하는 객체.
//	ResultSet rs = stmt.executeQuery("select * from professor");
	//ResultSetMetaData 객체 : 조회된 레코드 정보
	/*
		Statement 의 하위 인터페이스 PreparedStatement
		Statement 객체 생성 시 미리 실행 문장을 dbms에 전달하는 기능.
	
	*/
	PreparedStatement pstmt = conn.prepareStatement("select * from professor where position=?"); 
	pstmt.setString(1, "정교수");//insert 구문에 많이 쓰인다.
	ResultSet rs = pstmt.executeQuery();
	//ResultSetMetaData 객체 : 조회된 레코드 정보
	//MetaData로는 
	ResultSetMetaData rsmt=rs.getMetaData();
	PreparedStatement pstmt2 = conn.prepareStatement("select count(*) from professor where position=?");
	pstmt2.setString(1, "정교수");
	ResultSet rs2 = pstmt2.executeQuery();
	rs2.next();
//	rs.last();
//	int cnt =rs.getRow();
//	rs.beforeFirst();
%>
<h3>조회된 컬럼 수 : <%=rsmt.getColumnCount() %>
		 조회된 record 수 : <%=rs2.getString(1)%></h3>

<table border="1" style="border-collapse:collapse;">
	<tr>
			<%for(int i=1;i<=rsmt.getColumnCount();i++) {%> <!--  db는 인덱스 1부터 시작함. -->
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