<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>model2 ȸ�� ���� ����</title>
<!-- <style>
	table {
		margin: 0 auto;
		width : 800px;
		border: 2px solid green;
		text-align: center;
	}
	caption {
	font-weight: bold;
	font-size: x-large;
	}
</style> -->
<script >
function win_open() {
	var op = "width=500, height=150, left=50, top=150";
	open("memberimgForm.jsp","",op);
	
}
function passchg_winopen() {
	var op = "width=500, height=300, left=50, top=150";
	open("passchgform.jsp","",op);
	
}
</script>
</head>
<body>
<div style="border:2px solid silver; margin-top:250px; padding:25px;" align="center" >
<form action = "update.me" name="f" method="post">
	<input type="hidden" name="picture" value="${mem.picture}">
	<table border="1" style="border-collapse : collapse; border-color: silver;">
	<caption>��2���� ������ ȸ�� ���� ȭ��</caption>
	<tr>
		<td rowspan="4" align="center" valign="bottom">
		<img src=" img/${mem.picture}" width="100" height="120" id="pic"><br>
		<font size="1"><a href="javascript:win_open()">��������</a></font></td>
		<td>���̵�</td>
		<td><input type="text" name="id" value="${mem.id}" readonly></td>
	</tr>
	<tr>
		<td>��й�ȣ</td>
		<td><input type="password" name="pass" value="${mem.pass}" ></td>
	</tr>
	<tr>
		<td>�̸�</td>
		<td><input type="text" name="name" value="${mem.name }" ></td>
	</tr>		
	<tr>
		<td>����</td>
		<td><input type="radio" name="gender" value="1" <c:if test='${mem.gender==1}'>checked</c:if>>����
				<input type="radio" name="gender" value="2"<c:if test='${mem.gender==2}'>checked</c:if>>����</td>
	</tr>

	<tr>
		<td>��ȭ��ȣ</td>
		<td colspan="2"><input type="text" name="tel" value="${mem.tel }" ></td>
	</tr>
	<tr>
		<td>�̸���</td>
		<td colspan="2"><input type="text" name="email" value="${mem.email }" ></td>
	</tr>
	<tr>
		<td colspan="3" align="center"><input type="submit"  value="ȸ�� ����" >
		<input type="button" value="��й�ȣ����" onclick="passchg_winopen()">
		</td>
	</tr>	
</table>
</form>
</div>
</body>
</html>
