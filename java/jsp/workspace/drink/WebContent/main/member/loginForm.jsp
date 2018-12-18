<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 화면</title>
</head>
<body>
<form action="login.me" method="post" onsubmit="return logincheck(this)">
 <table style="border-collapse: collapse;" class="w3-table-all w3-large">
 <caption>로그인</caption>
   <tr><td>아이디: <input type = "text" name = "id"></td>
    </tr>
   <tr><td>비밀번호: <input type = "password" name = "pass"></td>
   </tr>
    <tr><td colspan="2" align="center">
    <input type ="submit" value="로그인">
    <input type ="button" value="회원가입" onclick="location.href='joinForm.jsp'">
    </td></tr>
 </table>
</form>
</body>
</html>