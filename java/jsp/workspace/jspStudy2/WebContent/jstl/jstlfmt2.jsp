<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="EUC-KR">
<title>fmt �±� ����</title>
</head>
<body>
<fmt:requestEncoding value="euc-kr"/>
<form method="post" name="f">
�̸� : <input type="text" name="name" value="${param.name }"><br>
�Ի��� : <input type="text" name="hiredate" value="${param.hiredate }"> yyyy-MM-dd�� �Է�<br>
�޿� : <input type="text" name="salary" value="${param.salary }"><br>
<script type="text/javascript">
	document.f.salary.value='<fmt:formatNumber value="${param.salary }" pattern="#,###,###" />';
</script>
<input type="submit" value="����">
</form>
<hr>
�̸� : ${param.name}<br>
�Ի��� : ${param.hiredate}<br>
�޿� : ${param.salary}<br>
<hr>
<h3>���� : �Ի����� yyyy�� dd�� E���Ϸ� ���<br> �޿��� ���ڸ����� , ����ϰ� ���ھտ� ��ȭǥ���ϱ�.<br>�޿�*12�� ������ ����ϰ�, ���ڸ����� ,��� �� ��ȭ ǥ���ϱ�</h3>
<%-- ������ ������ parameter���� date �������� �ѹ� �ٲ��ְ�(fmt:parseDate) ���ϴ� �������� �ٽ� ����ϱ� ���� fmt:formatDate�� �Ἥ ���--%>
<fmt:parseDate value="${param.hiredate }" pattern="yyyy-MM-dd" var="date"/>
�̸� : ${param.name}<br>
�Ի��� :<fmt:formatDate value="${date}" pattern="yyyy�� MM�� dd�� E����" /><br>
�޿� : <fmt:formatNumber value="${param.salary }" type="currency" /><br>
����:  <fmt:formatNumber value="${param.salary*12 }" type="currency"/><br>
</body>
</html>