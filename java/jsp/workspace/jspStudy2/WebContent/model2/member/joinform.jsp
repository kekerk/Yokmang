<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>model2 ȸ�� ���� ȭ��</title>
<!-- <style>
	table {
		margin: 0 auto;
		width : 400px;
		border: 2px solid green;
		text-align: center;
	}
	caption {
	font-weight: bold;
	font-size: x-large;
	}
</style> -->
<script type="text/javascript">
function joincheck(f){
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
	if(f.name.value.length==0){
		alert("�̸��� �Է��ϼ���");
		f.name.focus();
		return false;
	}
}

function win_open() {
	var op = "width=500, height=150, left=50, top=150";
	open("memberimgForm.jsp","",op);
	
}
</script>
</head>
<body>
<div style="border:2px solid silver; margin-top:200px;" align="center">
<form action="join.me" name="f" method="post" onsubmit="return joincheck(this)">
	<input type="hidden" name="picture" value=""> 		<%-- value=""���� ""�ڸ��� ���ε�� �̹��� ������ ��� �� ���� ���� ���� �ȴ�. --%>
	<table border="1" style="border-collapse: collapse;">
		<caption>Model2���� ������ ȸ�� ����</caption>
		<tr>
		<td rowspan="4" align="center" valign="bottom"><img src="" width="100" height="120" id="pic"><br>
		<font size="1"><a href="javascript:win_open()">�������</a></font></td>
		<td>���̵�</td>
		<td><input type="text" name="id"></td></tr>
		<tr>
		<td>��й�ȣ</td>
		<td><input type="password" name="pass"></td>
		</tr>
		<tr>
		<td>�̸�</td>
		<td><input type="text" name="name"></td>
		</tr>
		<tr>
		<td>����</td>
		<td>
		<input type="radio" name="gender" value="1" checked>��
		<input type="radio" name="gender" value="2">��
		</td>
		</tr>
		<tr>
		<td>��ȭ��ȣ</td>
		<td colspan="2"><input type="text" name="tel"></td>
		</tr>
		<tr>
		<td>�̸���</td>
		<td colspan="2"><input type="text" name="email"></td>
		</tr>
		<tr><td colspan="3" align="center">
		<input type="submit" value="ȸ������">
		<input type="reset" value="���ۼ�">
		</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>















