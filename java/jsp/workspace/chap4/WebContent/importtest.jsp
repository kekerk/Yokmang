<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<%--
	/WebContent/importtest.jsp
	page Directive(지시자) 예제
	page Directive란 현재 jsp 페이지의 특징을 속성을 이용하여 설정함.
  
      	 language="java" : 기본값 java. 사용할 언어 java 설정. 설정안해도 됨.
	     contentType : 작성할 페이지의 문서의 종류와 인코딩 방식 설정.
	     			문서의 종류 : MIME타입 설정함.  (text/html). image/gif ...
		  pageEncoding : 인코딩 설정.    
		  import : 사용되는 클래스의 패키지 설정. 여러번 사용 가능한 속성임.
 --%>
<html>
<head>
<meta charset="EUC-KR">
<title>page Directive 예제</title>
</head>
<body>
<%
	Date today = new Date(); 
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>

	오늘 날짜 : <%=sf.format(today) %>
</body>
</html>