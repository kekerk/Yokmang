<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- jspStudy2/WebContent/el/elForm.jsp --%>
<html>
<head>
<meta charset="EUC-KR">
<title>EL(ǥ�����) ����</title>
</head>
<body>
<%
	session.setAttribute("test","session test �Ӽ� ��");
	session.setAttribute("today",new Date());
%>
<form action="el1.jsp" method="post"> 
<%--
	 el1.jsp�� elForm.jsp�� �ٸ� request����,  ���� session����
 --%>
	<table border="1" style="border-collapse : collapse;">
	<tr>
		<td>�̸�</td>
		<td><input type="text" name="name" value="ȫ�浿"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="����"></td>
	</tr>
	</table>
</form>
</body>
</html>