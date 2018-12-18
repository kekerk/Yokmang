<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- jspStudy2/WebContent/el/el1.jsp --%>
<html>
<head>
<meta charset="EUC-KR">
<title>EL ���� ���</title>
</head>
<body>
<% 
	request.setCharacterEncoding("euc-kr");
	pageContext.setAttribute("test", "pageContext ��ü�� test �Ӽ�");
String tel = "02-1234-5678";
%>
<h3>jsp�� ��ũ��Ʈ�� �̿��� ��� ���</h3>
test �Ӽ��� : <%=session.getAttribute("test") %><br>
today �Ӽ��� : <%=session.getAttribute("today") %><br>
name �Ķ���Ͱ� : <%=request.getParameter("name") %><br>
���� �Ķ���Ͱ� : <%=request.getParameter("noparam") %><br>
tel ���� ��� : <%=tel %>

<%--
		${test} : ���� ��� ��ü�� ��ϵ� test �Ӽ��� ���� ���
		1. pageContext ��ü�� �Ӽ� �� test �Ӽ� �˻�. �����ϸ� ���.
			�������� ������ request ��ü �˻�
		2.  request ��ü�� �Ӽ� �� test �Ӽ� �˻�. �����ϸ� ���.
			�������� ������ session ��ü �˻�
		3.  session ��ü�� �Ӽ� �� test �Ӽ� �˻�. �����ϸ� ���.
			�������� ������ application ��ü �˻�
		4.  application ��ü�� �Ӽ� �� test �Ӽ� �˻�. �����ϸ� ���.
			�������� ������ ���� ���. ��� ����. null�� �ƴ�.
	
		${sessionScope.test} : session ������ ��ϵ� �Ӽ� �� test �Ӽ��� ���� ���.
			�������� ������ ���� ���. ��� ����. null�� �ƴ�.
  --%>
<h3>EL(ǥ�����)�� �̿��� ��� ���</h3>
test �Ӽ��� : ${test}<br>
session test �Ӽ��� : ${sessionScope.test}<br>
today �Ӽ��� : ${today }<br>
name �Ķ���Ͱ� : ${param.name }<br>
���� �Ķ���Ͱ� : ${param.noparam } <br>
tel ���� ��� : ${'EL�� ǥ�� �ȵ�. EL�� �Ӽ����� ��°���'}
</body>
</html>