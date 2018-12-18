<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>include action tag</title>
</head>
<body>
<% request.setCharacterEncoding("euc-kr"); %>
<h1>this page is include1.jsp page. </h1>
Name : <%=request.getParameter("name") %><br>
Id : <%=request.getParameter("id") %><br>
Tel : <%=request.getParameter("tel") %><br>
	<% String jsp="include2.jsp"; %>
<jsp:include page="<%=jsp %>">
	<jsp:param value="a parameter from  include1.jsp" name="test"/>
	<jsp:param value="Unknown" name="id"/>
</jsp:include>
<h1>include1.jsp page</h1>
</body>
</html>