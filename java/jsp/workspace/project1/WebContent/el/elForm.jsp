<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- jspStudy2/WebContent/el/elForm.jsp --%>
<html>
<head>
<meta charset="EUC-KR">
<title>EL(표현언어) 예제</title>
</head>
<body>
<%
	session.setAttribute("test","session test 속성 값");
	session.setAttribute("today",new Date());
%>
<form action="el1.jsp" method="post"> 
<%--
	 el1.jsp와 elForm.jsp는 다른 request영역,  같은 session영역
 --%>
	<table border="1" style="border-collapse : collapse;">
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" value="홍길동"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="전송"></td>
	</tr>
	</table>
</form>
</body>
</html>