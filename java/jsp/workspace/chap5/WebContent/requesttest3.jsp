<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>요청된 연산 결과</title>
</head>
<body>

<%
    request.setCharacterEncoding("EUC-KR");
	int num1 = Integer.parseInt(request.getParameter("num1"));
	String op = request.getParameter("op");
	int num2 = Integer.parseInt(request.getParameter("num2"));
	double sum = 0;
	switch(op) {
	case  "+" :
		sum = num1 + num2;
		break;
	case  "-" :
		sum = num1 - num2;
		break;
	case  "*" :
		sum = num1 * num2;
		break;
	case  "/" :
		sum = (double)num1/ num2;
		break;
	}
%>
연산된 결과값 : <%=sum %>
</body>
</html>