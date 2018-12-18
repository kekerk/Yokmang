<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- jspStudy2/WebContent/el/el1.jsp --%>
<html>
<head>
<meta charset="EUC-KR">
<title>EL 예제 결과</title>
</head>
<body>
<% 
	request.setCharacterEncoding("euc-kr");
	pageContext.setAttribute("test", "pageContext 객체의 test 속성");
String tel = "02-1234-5678";
%>
<h3>jsp의 스크립트를 이용한 결과 출력</h3>
test 속성값 : <%=session.getAttribute("test") %><br>
today 속성값 : <%=session.getAttribute("today") %><br>
name 파라미터값 : <%=request.getParameter("name") %><br>
없는 파라미터값 : <%=request.getParameter("noparam") %><br>
tel 변수 출력 : <%=tel %>

<%--
		${test} : 영역 담당 객체에 등록된 test 속성의 값을 출력
		1. pageContext 객체의 속성 중 test 속성 검색. 존재하면 출력.
			존재하지 않으면 request 객체 검색
		2.  request 객체의 속성 중 test 속성 검색. 존재하면 출력.
			존재하지 않으면 session 객체 검색
		3.  session 객체의 속성 중 test 속성 검색. 존재하면 출력.
			존재하지 않으면 application 객체 검색
		4.  application 객체의 속성 중 test 속성 검색. 존재하면 출력.
			존재하지 않으면 공백 출력. 출력 없음. null도 아님.
	
		${sessionScope.test} : session 영역에 등록된 속성 중 test 속성의 값을 출력.
			존재하지 않으면 공백 출력. 출력 없음. null도 아님.
  --%>
<h3>EL(표현언어)을 이용한 결과 출력</h3>
test 속성값 : ${test}<br>
session test 속성값 : ${sessionScope.test}<br>
today 속성값 : ${today }<br>
name 파라미터값 : ${param.name }<br>
없는 파라미터값 : ${param.noparam } <br>
tel 변수 출력 : ${'EL로 표현 안됨. EL은 속성값만 출력가능'}
</body>
</html>