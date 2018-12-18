<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 삭제</title>
</head>
<body>
<form action="delete.bo"name="f" method="post"> 
  <input type="hidden" name="code" value="${param.code}">
  <input type="hidden" name="num" value="${param.num }">
  <table border ="1" style="border-collapse: collapse;" class="w3-table-all w3-large">
  <caption>글을 삭제하려면 비밀번호를 입력하세요</caption>
  <tr><td>비밀번호</td>
  <td><input type="password" name="pass"></td></tr>
  <tr><td colspan="2" align="center">
  <input type="submit" value = "글 삭제">&nbsp;<input type="button" value ="목록" onclick="location.href='list.bo?code=${param.code}'"></td></tr>
  </table>
</form>
</body>
</html>