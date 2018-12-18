<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>request Header 정보 보기</title>
</head>
<body>
<table border="1" style="border-collapse : collapse;">
	<tr><th>헤더이름</th><th>헤더값</th></tr>
	<%
		Enumeration e = request.getHeaderNames(); //헤더 이름들 조회
		while(e.hasMoreElements()){ //다른 요소들이 있는지 
			String hname = (String)e.nextElement(); %>
<tr><td><%=hname %>	</td>
		<td><%=request.getHeader(hname) %></td></tr>	
<%}%>
</table>
<table  border="1" style="border-collapse : collapse;">
<caption><h2>클라이언트 정보</h2></caption>
<tr><th>클라이언트 정보</th><th>클라이언트 내용</th></tr>
<tr><td>로컬주소</td><td><%=request.getLocalAddr() %></td></tr>
<tr><td>클라이언트주소</td><td><%=request.getRemoteAddr() %></td></tr>
<tr><td>클라이언트주소</td><td><%=request.getRemoteHost() %></td></tr>
<tr><td>요청method</td><td><mark><%=request.getMethod() %></mark></td></tr>
<tr><td>요청uri</td><td><b><%=request.getRequestURI() %></b></td></tr>
<tr><td>요청url</td><td><strong><%=request.getRequestURL() %></strong></td></tr>
<tr><td>웹 어플리케이션 경로</td><td><%=request.getContextPath() %></td></tr>
<tr><td>서버이름</td><td><%=request.getServerName() %></td></tr>
<tr><td>서버포트</td><td><%=request.getServerPort() %></td></tr>

</table>
</body>
</html>