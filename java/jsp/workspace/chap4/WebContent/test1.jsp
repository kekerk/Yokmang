<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- Calendar 클래스를 이용하여 2018년 9월 20일의 요일 구하여 화면에 출력하기.--%>
<html>
<head>
<meta charset="EUC-KR">
<title>test1</title>
</head>
<body>
<%
	Calendar cal = Calendar.getInstance();
	cal.set(2018, 8, 20);
	int day = cal.get(Calendar.DAY_OF_WEEK);
	String a = "";
	switch(day){
	case 1 :
		a="일";
		break;
	case 2 :
		a="월";
		break;
	case 3 :
		a="화";
		break;
	case 4 :
		a="수";
		break;
	case 5 :
		a="목";
		break;
	case 6 :
		a="금";
		break;
	case 7 :
		a="토";
		break;
	}
%>
2018년 9월 20일은 <mark><%=a %>요일</mark>입니다.
</body>
</html>