<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- Calendar Ŭ������ �̿��Ͽ� 2018�� 9�� 20���� ���� ���Ͽ� ȭ�鿡 ����ϱ�.--%>
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
		a="��";
		break;
	case 2 :
		a="��";
		break;
	case 3 :
		a="ȭ";
		break;
	case 4 :
		a="��";
		break;
	case 5 :
		a="��";
		break;
	case 6 :
		a="��";
		break;
	case 7 :
		a="��";
		break;
	}
%>
2018�� 9�� 20���� <mark><%=a %>����</mark>�Դϴ�.
</body>
</html>