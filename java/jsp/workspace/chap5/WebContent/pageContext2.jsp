<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>pageContext ��ü ����</title>
</head>
<body>
<h3><mark>pageContext2.jsp</mark>�������Դϴ�.<br>
pageContext1.jsp���������� forward �Ǿ����ϴ�. <br>
������ pageContex2.jsp�� ������ ��µ����� url�� pageContext1.jsp�� �����ֽ��ϴ�.
</h3>
name �Ķ���� �� : <%=request.getParameter("name") %> <!-- ���� request �����̶� url���� name ���� �޾ƿ� �� �ִ�......? -->
</body>
</html>