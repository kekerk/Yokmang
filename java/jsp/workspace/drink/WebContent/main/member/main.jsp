<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���� ���α׷�</title>
</head>
<body class="body">
<%-- logout.me : session�� ����. loginForm.jsp�� ������ �̵�--%>
<h3>${sessionScope.login} ����~</h3>
<h3><a href = "logout.me">�α׾ƿ�</a></h3>
<h3><a href="info.me?id=${sessionScope.login}">ȸ����������</a></h3>
<c:if test="${sessionScope.login == 'admin'}">
 <h3><a href="list.me">ȸ�� ��� ����</a></h3>
</c:if>
</body>
</html>