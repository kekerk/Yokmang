<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- /WebContent/pageContext3.jsp --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>pageContext ��ü : include ����</title>
</head>
<body>
<h3>pageContext3.jsp ������ �Դϴ�.</h3><br>
<% 
String msg="pageContext3.jsp�� msg ����"; 
/*������ ���� ������ �ƴϱ� ������ ������ �� ����.
������ ���� request�����̹Ƿ� request.setAttribute("msg",msg);[pageContext3.jsp]�� request.getAttribute("msg");[pageContext4.jsp]�� �̿��Ͽ� ������ �Ѱ��ش�.   */
request.setAttribute("msg",msg);
pageContext.setAttribute("msg",msg);
request.setAttribute("today",new Date());

pageContext.include("pageContext4.jsp");  %>
<h3>pageContext3.jsp ������ �Դϴ�.</h3> 
<!-- pageContext3.jsp�� pageContext4.jsp�� ���� ������ �ƴ϶� ������ ������ �� ����.  -->
</body>
</html>