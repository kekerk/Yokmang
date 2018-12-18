<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խù� ���</title>
<style type="text/css">
table {
	width: 90%;
	border-collapse: collapse;
}

th, td {
	border: 3px solid #bcbcbc;
	padding: 8px;
}

th {
	background-color: #4CAF50;
	color: white;

}

td {
	background-color: #f2f2f2;
}

td.title {
	background-color: #e2e2e2;
	color: blue;
}
</style>
</head>
<body>
<form:form action="reply.shop" method="post" name="f" modelAttribute="board">
	<input type="hidden" name="num" value="${board.num}">
	<input type="hidden" name="ref" value="${board.ref}">
	<input type="hidden" name="reflevel" value="${board.reflevel}">
	<input type="hidden" name="refstep" value="${board.refstep}">
	<table border="1" style="border-collapse: collapse; width:100%;">
		<tr>
			<td colspan="2" align="center">Spring �Խ��� ��� ����</td>
		</tr>
		<tr>
			<td>�۾���</td><td><input type="text" name="name">
			<font color="red"><form:errors path="name"/></font></td>
		</tr>
		<tr>
			<td>��й�ȣ</td><td><input type="password" name="pass">
			<font color="red"><form:errors path="pass"/></font></td>
		</tr>
		<tr>
			<td>����</td><td><input type="text" name="subject" value="RE:${board.subject}">
			<font color="red"><form:errors path="subject"/></font></td>
		</tr>
		<tr>
			<td>����</td><td><textarea rows="15" cols="80" name="content"></textarea>
			<font color="red"><form:errors path="content"/></font></td>
		</tr>
		<tr>
			<td colspan="2"><a href="javascript:document.f.submit()">[�亯���]</a>
			<a href="javascript:document.f.reset()">[�ʱ�ȭ]</a>
			<a href="javascript:document.history.go(-1)">[�ڷΰ���]</a>
			</td>
		</tr>
	</table> 

</form:form>
</body>
</html>