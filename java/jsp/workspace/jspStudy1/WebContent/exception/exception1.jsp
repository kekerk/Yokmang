<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- 
		error ������ �����ϱ�
	<%@ page errorPage="error.jsp" %> : ������ �߻��ϸ� error.jsp �������� ���.		
 --%>
<%-- <%@ page errorPage="error.jsp" %>  : error.jsp�� error500.jsp���� �켱������ ����.--%> 
<html>
<head>
<meta charset="EUC-KR">
<title>���� �߻� ������</title>
</head>
<body>
<%=request.getParameter("name").trim() %>
</body>
</html>