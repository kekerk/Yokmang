<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ ȭ��</title>
</head>
<script type="text/javascript">
		function confirm(f){
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
</script>
<%-- ���� : ���̵� ��й�ȣ, �̸��� �ݵ�� �Է��ϵ��� join.jsp ���������� useBean �׼��±׸� ����Ͽ�  --%>
<body>
<form action="join.jsp" method="post" name="f" onsubmit="return confirm(this)">
	<table border="1" style="border-collapse : collapse;">
		<tr>
		<td>���̵�</td><td><input type="text" name="id"></td></tr>
		<tr><td>��й�ȣ</td><td><input type="password" name="pass"></td></tr>
		<tr><td>�̸�</td><td><input type="text" name="name"></td></tr>
		<tr><td>����</td>
		<td><input type="radio" name="gender" value="1">��
		        <input type="radio" name="gender" value="2">��
		</td></tr>
		<tr><td>�̸���</td><td><input type="text" name="email"></td></tr>
		<tr><td>����</td><td><input type="text" name="birth"></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="ȸ�����"></td></tr>
	</table>
</form>
</body>
</html>