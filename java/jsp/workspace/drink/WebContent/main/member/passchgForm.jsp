<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>비밀번호 수정</title>
</head>
<body>
<form name="f" action="passchg.me?id=${param.id}" method="post">
 <table border="1" style="border-collapse:collapse;">
  <caption>비밀번호 변경 화면</caption>
  <tr><td>현재 비밀번호</td>
  <td><input type="password" name="pass"></td></tr>
  <tr><td>변경할 비밀번호</td>
  <td><input type="password" name="chgpass"></td></tr>
  <tr><td colspan="2" align="center">
  <input type="submit" value="비밀번호 변경"></td></tr>
 </table>
</form> 
</body>
</html>