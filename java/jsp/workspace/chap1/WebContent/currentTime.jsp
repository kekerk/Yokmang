<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.Calendar" %>
    <!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �ð�</title>
</head>
<body>
<%  // �ڹ��� ����. �ڹ� ������ ����.
	Calendar  c = Calendar.getInstance();
	int hour = c.get(Calendar.HOUR_OF_DAY);
	int min = c.get(Calendar.MINUTE);
	int second = c.get(Calendar.SECOND);
%>
<h1> ���� �ð��� <%=hour %> ��<%=min %> �� <%=second %>�� �Դϴ�. </h1>
</body>
</html>