<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���̺� ��ȸ�ϱ�</title>
<script type="text/javascript">
	function con(f){
		if(f.col.value.length==0){
			alert("��ȸ�÷����� �Է��ؾ��մϴ�.");
			f.col.focus();
			return false;
		}
	}
</script>
</head>
<body>
<form action="jdbctest.jsp" method="post" onsubmit="return con(this)" >
<table>
<tr><td colspan="2"> <!--  ���̺�� --> <%-- request.parameter�� name(tb)�� ���� value�� �޾ƿ´�. --%>
		<input type="radio" value="student" name="tb"> �л�
		<input type="radio" value="professor" name="tb"> ����
		<input type="radio" value="emp" name="tb"> ���
		<input type="radio" value="dept" name="tb"> �μ�
</td></tr>
<tr><td>��ȸ �÷�</td>
		<td><textarea name="col" cols="30" rows="3"></textarea></td></tr>
<tr><td>where</td>
		<td><textarea name="wh" cols="30" rows="3"></textarea></td></tr>
<tr><td>group by</td>
		<td><textarea name="gr" cols="30" rows="3"></textarea></td></tr>
<tr><td>having</td>
		<td><textarea name="ha" cols="30" rows="3"></textarea></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="���̺� ��ȸ�ϱ�"></td></tr>
</table>
</form>
</body>
</html>