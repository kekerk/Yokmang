<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��1 �Խ��� �۾���</title>

<script type="text/javascript">
function board_submit(){
	<%-- ���� �Է� ���ϸ� ���Ѿ�� --%>
	if(document.f.name.value.length==0){
		alert("�۾��̸� �Է��ϼ���");
		document.f.name.focus();
		return;
	}
	if(document.f.pass.value.length==0){
		alert("��й�ȣ�� �Է��ϼ���");
		document.f.pass.focus();
		return;
	}
	if(document.f.title.value.length==0){
		alert("������ �Է��ϼ���");
		document.f.title.focus();
		return;
	}
	if(document.f.content.value.length==0){
		alert("������ �Է��ϼ���");
		document.f.content.focus();
		return;
	}
	document.f.submit();
}
</script>
</head>
<body>
<form action="write.jsp" name="f" method="post" enctype="multipart/form-data">
	<table border="1" style="border-collapse: collapse;">
	<caption>��1 �Խ��� �۾���</caption>
	<tr>
	<td align="center">�۾���</td>
	<td><input type="text" name="name"></td>
	</tr>	
	<tr>
	<td align="center">��й�ȣ</td>
	<td><input type="password" name="pass"></td>
	</tr>
	<tr>
	<td align="center">����</td>
	<td><input type="text" name="title"></td>
	</tr>		
	<tr>
	<td align="center">����</td>
	<td><textarea rows="15" cols="80" name="content">������ �Է��ϼ���</textarea></td>
	</tr>	
	<tr>
	<td align="center">÷������</td>
	<td><input type="file" name="file1"></td>
	</tr>	
	<tr>
	<td colspan="2" align="center">
	<a href="javascript:board_submit()">[�Խù� ���]</a></td>
	</tr>	
	</table>
</form>
</body>
</html>