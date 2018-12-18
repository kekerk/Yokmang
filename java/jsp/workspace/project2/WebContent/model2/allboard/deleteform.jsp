<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Delete</title>
<style type="text/css">
caption {
	font :bold;
	font-size: x-large;
}
</style>
</head>
<body>
<div style="margin: 50px; padding: 25px;" align="center">
<form action="delete.all" method="post" name="f" >
	<input type="hidden" name="dormi" value="${param.dormi}">
	<input type="hidden" name="boardtype" value="${param.boardtype}">
	<input type="hidden" name="no" value="${param.no}">
	<table border="1" style="border-collapse: collapse;"  class="w3-table-all w3-centered">
	<caption>Confirm for deletion a post</caption>
	<tr><td>Input Password</td></tr>
	<tr><td><input type="password" name="password"></td></tr>
	<tr><td colspan="2" align="center"><a href="javascript:document.f.submit()" class="w3-button w3-black">delete</a></td></tr>
	</table>
	</form>
</div>
</body>
</html>