<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%-- 
   현재 날짜를 yyyy-MM-dd hh:mm:ss a 형태로 변경하여 
   session 객체에 date라는 이름으로 등록하는 프로그램 
   --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>최종 date 출력</title>
</head>
<body>
<% // SimpleDateFormat : 날짜 형식을 지정한다.
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
	String s = sf.format(new Date()); // s는 "yyyy-MM-dd hh:mm:ss a"형태가 문자열로 저장된다.
	session.setAttribute("date", s); // session 객체에 s를 속성으로 등록한다.(s->"date")
%>
등록된 날짜 : <%=s %>
</body>
</html>