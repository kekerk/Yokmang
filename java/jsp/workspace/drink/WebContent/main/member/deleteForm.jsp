<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
  caption{
     font-weight: bold;
     font-size: :20pt;
  }
</style>
<title>ȸ�� Ż�� ��й�ȣ �Է�</title>
</head>
<body>
<form action="delete.me"name="f" method="post"> 
  <input type="hidden" name="id" value="${param.id}">
  <table border ="1" style="border-collapse: collapse;" class="w3-table-all w3-large">
  <caption>ȸ�� Ż�� ���� ��й�ȣ �Է�</caption>
  <tr><td>��й�ȣ</td>
  <td><input type="password" name="pass"></td></tr>
  <tr><td colspan="2" align="center">
  <input type="submit" value = "Ż���ϱ�"></td></tr>
  </table>
</form>
</body>
</html>