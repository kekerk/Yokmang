<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- WebContent/model1/member/main.jsp
		 1. �α��� ������ ������.
		 	 �α��� ���¸� ȭ�鿡 ���.
		 	 �α׾ƿ� ���¸� loginform.jsp�� ������ �̵�. (�α׾ƿ� submit)
		 2. �����ڷ� �α��� �ϴ� ��� ȸ�� ��� ����(list.jsp) ��ũ �߰��ϱ�.
 --%>
	<html>
	<head><title>ȸ�� ���� ���α׷�</title>
	<style type="text/css">
	body {font-family: "Raleway", Arial, sans-serif }
	</style>
	</head>
	<body>
	<div style="margin: 50px; padding: 25px; border:1px solid silver; " align="center">
	<h3>${sessionScope.login} ȸ���� �ݰ����ϴ�.</h3>
	<%-- logout.me : session ����. loginform.jsp �������� �̵�. --%>
	<h3><a href="logout.me">logout</a></h3> <%-- ���ǿ� �ִ� ���� ���� ����������. --%>
	<h3><a href="info.me?id=${sessionScope.login}">my page</a></h3>  
	<c:if test="${sessionScope.login=='admin' }">
	<h3><a href="list.me">ȸ�� ��� ����</a></h3>   
	</c:if>
	</div>
	<%-- ?id=<%=login%> : get ��� --%>
	</body>
</html>	
