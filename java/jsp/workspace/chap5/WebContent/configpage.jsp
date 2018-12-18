<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>config 객체</title>
</head>
<body>
<h2> config : 서블릿의 파라미터 전달에 사용되는 객체. jsp 페이지에서는 잘 사용안함.</h2>
<table border="1">
	<tr><td>파라미터이름</td><td>파라미터값</td></tr>
	<% Enumeration e = config.getInitParameterNames();
		   while(e.hasMoreElements()) { 
				String name = (String) e.nextElement();%>
			   <tr>
			   <td><%=name %></td>
			   <td><%=config.getInitParameter(name) %></td>
			   </tr>		  
		   <%}%>
</table>
<h2>page 기본 객체 : jsp 페이지 자체를 의미한다. this 객체와 같다.</h2>
페이지의 클래스 이름 : <%=page.getClass().getName() %>
페이지의 클래스 이름 : <%=this.getClass().getName() %>
</body>
</html>