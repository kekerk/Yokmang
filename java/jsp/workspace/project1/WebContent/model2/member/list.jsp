<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	AdminUserAction �߻� Ŭ����
	1. �α׾ƿ� ����
		-> �α����ϼ��� �޼��� ���. loginForm.jsp �̵�
	2. admin�� �ƴ� ���
		-> �����ڸ� ��ȸ �����մϴ�. �޼��� ���. main.jsp
	ListAction Ŭ����
	3.admin�� ���
		-> MemberDao Ŭ������ list �޼��� �߰��ϱ�.
		List<Member> list() ���
--%>
<!DOCTYPE html>
 <html>
 <head>
<meta charset="EUC-KR">
<title>model2 ȸ����Ϻ���</title>
 <style>
 body {font-family: "Raleway", Arial, sans-serif }
caption {
	font :bold;
	font-size: x-large;
}
</style> 
</head>
<body>
<div style="margin: 50px; padding: 25px;" align="center">
<table border="1" style="border-collapse: collapse;" class="w3-table-all  w3-hoverable">
	<caption>model2 ȸ�� ��� ��ȸ</caption>
	<tr><th>����</th><th>���̵�</th><th>�̸�</th><th>����</th><th>��ȭ</th><th>�̸���</th><th>&nbsp;</th></tr>
<c:forEach var="list" items="${list}" > <%-- ������� ����� record�� ��� --%>
<tr class="w3-hover-gray">
	<td><img src="img/sm_${list.picture}" width="50" height="50"></td> <%-- ���� �̹��� ������ ���� : ����� �̹��� --%>
	<td><a href="info.me?id=${list.id} ">${list.id }</a></td>	
	<td>${list.name }</td>	
	<td>${list.gender==1?'����':'����'}</td>	
	<td>${list.tel}</td>	
	<td>${list.email}</td>	
	<td>
		<a href="updateform.me?id=${list.id}">[����]</a>	
		<a href="delete.me?id=${list.id}">[����Ż��]</a>
	</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>
