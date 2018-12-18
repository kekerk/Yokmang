<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���</title>
<style type="text/css">
table {
	width: 90%;
	border-collapse: collapse;
}

th, td {
	border: 3px solid #bcbcbc;
	text-align: center;
	padding: 8px;
}

th {
	background-color: #4CAF50;
	color: white;
	text-align: center;
}

td {
	background-color: #f2f2f2;
}

td.title {
	background-color: #e2e2e2;
	color: blue;
}
</style>
<script type="text/javascript">
	function allchkbox(chk) {
		var chks = document.getElementsByName("idchks"); 
		for(var i=0; i<chks.length; i++) {
			chks[i].checked = chk.checked;
		}
	}
</script>
</head>
<body>
	<form action="mailForm.shop" method="post">
		<table border="1" style="border-collapse: collapse; width: 100%">
			<tr>
				<td colspan="7">ȸ�� ���</td>
			</tr>
			<tr>
				<td>���̵�</td>
				<td>�̸�</td>
				<td>��ȭ��ȣ</td>
				<td>����</td>
				<td>�̸���</td>
				<td>&nbsp;</td>
				<td><input type="checkbox" name="allchk" onchange="allchkbox(this)"></td>
			</tr>
			<c:forEach items="${userlist}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.phoneNo}</td>
					<td><fmt:formatDate value="${user.birthDay}" pattern="yyyy-MM-dd"/></td>
					<td>${user.email}</td>
					<td>
						<a href="../user/updateForm.shop?id=${user.userId}">����</a>
						<a href="../user/delete.shop?id=${user.userId}">����Ż��</a>
						<a href="../user/mypage.shop?id=${user.userId}">ȸ������</a>
					</td>
					<td><input type="checkbox" name="idchks" value="${user.userId}"></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7" align="center">
					<input type="submit" value="���Ϻ�����">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>