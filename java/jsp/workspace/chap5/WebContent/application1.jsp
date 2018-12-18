<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>application 객체</title>
</head>
<body>
<h3>application 객체는 웹 어플리케이션 당 한개의 객체가 할당된다.<br>
즉 현재 chap5 프로젝트의 모든 jsp는 하나의 application 객체를 공유한다.
</h3>
<table border="1" style="border-collapse : collapse; ">
	<tr><td> jsp 버전</td>
			<td> <%= application.getMajorVersion() %>.<%=application.getMajorVersion() %></td></tr>
	<tr><td> 컨테이너정보</td>
			<td> <%= application.getServerInfo() %></td></tr>
	<tr><td> Web 어플리케이션 실제 파일 경로</td>
			<td> <%= application.getRealPath("/") %></td></tr>
</table>
<%application.setAttribute("test","application 객체에 설정된 속성");
	 session.invalidate();
%>

</body>
</html>