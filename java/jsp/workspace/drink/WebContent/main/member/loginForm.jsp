<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ȭ��</title>
</head>
<body>
<form action="login.me" method="post" onsubmit="return logincheck(this)">
 <table style="border-collapse: collapse;" class="w3-table-all w3-large">
 <caption>�α���</caption>
   <tr><td>���̵�: <input type = "text" name = "id"></td>
    </tr>
   <tr><td>��й�ȣ: <input type = "password" name = "pass"></td>
   </tr>
    <tr><td colspan="2" align="center">
    <input type ="submit" value="�α���">
    <input type ="button" value="ȸ������" onclick="location.href='joinForm.jsp'">
    </td></tr>
 </table>
</form>
</body>
</html>