<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%-- /WebContent/model2/member/loginform.jsp --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>model2 �α���ȭ��</title>
<style type="text/css">
body {font-family: "Raleway", Arial, sans-serif }
caption {
	font :bold;
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
</head>
<body>
<div style="margin: 50px; padding: 25px;" align="center">
<form action="login.me" method="post" onsubmit="return logincheck(this)">
	<table border="1" style="border-collapse: collapse;" class="w3-table-all w3-centered">
		<caption>model2 �α���</caption>
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
			<input type="button" value="ȸ������" onclick="location.href='joinform.jsp'"> 
		 </td>
	</tr> 
	</table>
</form>
</div>
</body>
</html>