<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>model2 회원탈퇴 비밀번호 입력</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<style type="text/css">
body {font-family: "Raleway", Arial, sans-serif }
caption {
	font :bold;
	font-size: x-large;
}
</style>
</head>
<body>
<div style="margin: 50px; padding: 25px;" align="center" >
	<form action="delete.me" method="post" name="f" >
	<input type="hidden" name="id" value="${param.id}">
	<table border="1" style="border-collapse: collapse;" class="w3-table-all w3-centered">
	<caption>탈퇴 확인창</caption>
	<tr><td>탈퇴를 위한 비밀번호 입력</td></tr>
	<tr><td><input type="password" name="pass"></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="탈퇴"></td></tr>
	</table>
	</form>
	</div>
</body>
</html>