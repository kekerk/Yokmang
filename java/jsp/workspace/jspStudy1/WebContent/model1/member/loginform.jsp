<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α���ȭ��</title>
</head>
<style>
	table {
		margin: auto;
		width : 400px;
		border: 1px solid gray;
		text-align: center;
	}
	caption {
	font-weight: bold;
	font-size: x-large;
	}
</style>
<script type="text/javascript">
	function  logincheck(f){
		if(f.id.value.length==0){
			alert("���̵� �Է��ϼ���");
			f.id.focus();
			return false;
		}
		if(f.pass.value.length==0){
			alert("��й�ȣ�� �Է��ϼ���");
			f.pass.focus();
			return false;
		}
	}
</script>
<body>
<form action="login.jsp" method="post" onsubmit="return logincheck(this)">
	<table border="1" style="border-collapse: collapse;">
		<caption>model1 �α���</caption>
	<tr>
		<td>���̵�</td>
		<td><input type="text" name="id"></td>
	</tr> 
	<tr>
		<td>��й�ȣ</td>
		<td><input type="password" name="pass"></td>
	</tr> 
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="�α���">
			<input type="button" value="ȸ������" onclick="location.href='joinform.jsp' ">
		 </td>
	</tr> 
	</table>
</form>
</body>
</html>