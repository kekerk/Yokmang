<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���ε� ȭ��</title>
</head>
<body>
<form action="upload.jsp" method="post" enctype="multipart/form-data">
 <%--
  			���� ���ε��  �ݵ�� enctype="multipart/form-data" ������ �ʿ���.
 
 			******enctype="multipart/form-data" : file1�� ������� ������ ���. 
  
  			1. �Ķ���Ͱ��� ������ ������� ������ �����ϵ��� ����
  			2. �ݵ�� method="post" �����ؾ���
  			
  			upload.jsp ������������ request ��ü�� ���� ����� �� ����.
  			=> cos.jar �ʿ���.
  			
  --%>
<table border="1" style="border-collapse: collapse;">
	<tr><td>�ø����</td><td><input type="text" name="name"></td></tr>
	<tr><td>����</td><td><input type="text" name="title"></td></tr>
	<tr><td>����</td><td><input type="file" name="file1"></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="����"></td></tr>
</table>
</form>
</body>
</html>