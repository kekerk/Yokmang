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
<title>회원 탈퇴 비밀번호 입력</title>
</head>
<body>
<form action="delete.me"name="f" method="post"> 
  <input type="hidden" name="id" value="${param.id}">
  <table border ="1" style="border-collapse: collapse;" class="w3-table-all w3-large">
  <caption>회원 탈퇴를 위한 비밀번호 입력</caption>
  <tr><td>비밀번호</td>
  <td><input type="password" name="pass"></td></tr>
  <tr><td colspan="2" align="center">
  <input type="submit" value = "탈퇴하기"></td></tr>
  </table>
</form>
</body>
</html>