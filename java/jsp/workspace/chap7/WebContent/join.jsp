<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<jsp:useBean id="join" class="chap7.Join1"/>
<jsp:setProperty property="*" name="join"/> <%--  jsp:setProperty�� ���Ͽ� int���� String ������ �ڵ� ����ȯ--%>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ ��ȸ</title>
</head>
<body>
<table border="1" style="border-collapse : collapse;">
<caption> ȸ�� ���� Ȯ��</caption>
<tr><td>���̵�</td><td><jsp:getProperty property="id" name="join"/></td></tr>
<tr><td>��й�ȣ</td><td><jsp:getProperty property="pass" name="join"/></td></tr>
<tr><td>�̸�</td><td><jsp:getProperty property="name" name="join"/></td></tr>
<tr><td>����</td><td><jsp:getProperty property="gender" name="join"/></td></tr>
<tr><td>�̸���</td><td><jsp:getProperty property="email" name="join"/></td></tr>
<tr><td>����</td><td><jsp:getProperty property="birth" name="join"/></td></tr>
</table>
</body>
</html>