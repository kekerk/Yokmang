<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ������</title>
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
<script type="text/javascript">
	function allchkbox(chk) {
		var chks = document.getElementsByName("idchks"); 
		for(var i=0; i<chks.length; i++) {
			chks[i].checked = chk.checked;
		}
	}
</script>
<%--���̹� ������ �̿��ؼ� ������ --%>
<script type="text/javascript" src="http://cdn.ckeditor.com/4.5.7/full/ckeditor.js"></script>
<script type="text/javascript">
	function naveridchk(f){
		if(f.naverid.value == ""){
			alert("���̹� ���̵� �Է��ϼ���");
			f.naverid.focus();
			return false;
		}
		if(f.naverpw.value == ""){
			alert("���̹� ��й�ȣ�� �Է��ϼ���");
			f.naverpw.focus();
			return false;
		}
	}
</script>
</head>
<body>
<form name="mailform" method="post" action="mail.shop" enctype="multipart/form-data" onsubmit="return naveridchk(this)">
	���̹� ���� �ּ� : <input type="text" name="naverid" >
	���̹� ���� ��й�ȣ : <input type="password" name="naverpw" >
	<hr>
	<table border="1" style="border-collapse: collapse; width:100%">
		<tr><td>�����»��</td><td>${loginUser.email}</td></tr>
		<tr><td>�޴»��</td>
		<td>
		<input type="text" name="recipient" size="100" value='<c:forEach items="${userList}" var="user"> ${user.userName}&lt;${user.email}&gt;,</c:forEach>'>
		</td></tr>
		<tr>
			<td>����</td>
			<td><input type="text" name="title" size="100"></td>
		</tr>
		<tr>
			<td>�޼�������</td>
			<td><select name="mtype"> <%-- �Ľ� ���� (MIME)--%>
			<option value="text/html; charset=euc-kr">HTML</option> <%-- �޴� ����� �� �� �±װ� �ν��� �Ǿ� �������� --%>
			<option value="text/plain; charset=euc-kr">TEXT</option> <%-- �޴� ����� �� �� �±װ� �νĵ��� ���� ä�� �������� --%>
			</select>
			</td>
		</tr>
		<tr>
			<td>÷������1</td>
			<td><input type="file" name="file1"></td>
		</tr>
		<tr>
			<td>÷������2</td>
			<td><input type="file" name="file1"></td>
		</tr>
		<tr>
			<td colspan="2">
			<textarea name="contents" cols="120" rows="10"></textarea>
			<script type="text/javascript">CKEDITOR.replace('contents')</script> 
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="���Ϻ�����">
			</td>
	</table>
</form>
</body>
</html>