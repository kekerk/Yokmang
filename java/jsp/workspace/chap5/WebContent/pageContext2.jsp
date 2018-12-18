<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>pageContext 객체 예제</title>
</head>
<body>
<h3><mark>pageContext2.jsp</mark>페이지입니다.<br>
pageContext1.jsp페이지에서 forward 되었습니다. <br>
내용은 pageContex2.jsp의 내용이 출력되지만 url은 pageContext1.jsp로 남아있습니다.
</h3>
name 파라미터 값 : <%=request.getParameter("name") %> <!-- 같은 request 영역이라서 url에서 name 값을 받아올 수 있다......? -->
</body>
</html>