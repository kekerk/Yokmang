<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ����</title>
</head>
<body>
<form action="delete.bo"name="f" method="post"> 
  <input type="hidden" name="code" value="${param.code}">
  <input type="hidden" name="num" value="${param.num }">
  <table border ="1" style="border-collapse: collapse;" class="w3-table-all w3-large">
  <caption>���� �����Ϸ��� ��й�ȣ�� �Է��ϼ���</caption>
  <tr><td>��й�ȣ</td>
  <td><input type="password" name="pass"></td></tr>
  <tr><td colspan="2" align="center">
  <input type="submit" value = "�� ����">&nbsp;<input type="button" value ="���" onclick="location.href='list.bo?code=${param.code}'"></td></tr>
  </table>
</form>
</body>
</html>