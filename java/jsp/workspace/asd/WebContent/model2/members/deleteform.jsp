<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>withdraw</title>
<style type="text/css">
caption {
	font :bold;
	font-size: x-large;
}
</style>
</head>
<body>
<div style="margin: 50px; padding: 25px;" align="center">
	<form action="delete.me" method="post" name="f">
	<input type="hidden" name="id" value="${param.id}">
	<table border="1" style="border-collapse: collapse;">
	<caption>Confirm for withdraw</caption>
	<tr><td>Input Password</td></tr>
	<tr><td><input type="password" name="password"></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="withdraw" class="w3-button w3-black"></td></tr>
	</table>
	</form>
	</div>
</body>
</html>