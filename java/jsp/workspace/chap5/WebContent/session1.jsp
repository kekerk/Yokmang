<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session ��ü ����</title>
</head>
<body>
<h2>session ��ü : �������� ���� ������ �����ϴ� ��ü</h2>
<h3>session �׽�Ʈ</h3>
<% session.setMaxInactiveInterval(10);  //session ���� �ð� : 10��(���� ����Ʈ�� ���)%>
isNew() : <%=session.isNew() %><br>
�����ð� : <%=session.getCreationTime() %><br> <!--  1970�� 1�� 1�Ϻ��� ��������� �ð��� �и��ʴ����� ��� -->
�������ӽð� : <%=session.getLastAccessedTime() %><br> 
����ID: <%=session.getId() %><br><!--  �������� 1���� ���� ��ü�� ������ �ȴ�. --> <!-- sendRedirect�� �ϴ��� ���� ���� �����̴�. -->
<!--  Cookies(���ȼ��� �����)�� session�� ����� ������ �Ѵ�. -->
<% session.invalidate(); %>
</body>
</html>