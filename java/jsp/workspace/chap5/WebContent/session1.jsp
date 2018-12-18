<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session 객체 예제</title>
</head>
<body>
<h2>session 객체 : 브라우저의 상태 정보를 저장하는 객체</h2>
<h3>session 테스트</h3>
<% session.setMaxInactiveInterval(10);  //session 유지 시간 : 10초(은행 사이트에 사용)%>
isNew() : <%=session.isNew() %><br>
생성시간 : <%=session.getCreationTime() %><br> <!--  1970년 1월 1일부터 현재까지의 시간을 밀리초단위로 출력 -->
최종접속시간 : <%=session.getLastAccessedTime() %><br> 
세션ID: <%=session.getId() %><br><!--  브라우저당 1개씩 세션 객체를 가지게 된다. --> <!-- sendRedirect를 하더라도 같은 세션 영역이다. -->
<!--  Cookies(보안성에 취약함)와 session은 비슷한 역할을 한다. -->
<% session.invalidate(); %>
</body>
</html>