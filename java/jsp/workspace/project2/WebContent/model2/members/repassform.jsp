<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Password Change</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<style type="text/css">
caption {
	font :bold;
	font-size: x-large;
}
</style>
<script type="text/javascript">
function chgpass(){
	opener.location.href="repass.me?id="+document.f.id.value+"&password1="+document.f.password1.value+"&password2="+document.f.password2.value;
	self.close();
}
</script>
</head>
<body>
<div style="margin: 50px; padding: 25px;" align="center">
	<form action="javascript:chgpass()" name="f" method="post">
	<input type="hidden" name="id" value="${param.id}">
	<table border="1" style="border-collapse : collapse;" class="w3-table-all w3-centered">
		<caption>Password Change</caption>
		<tr>
			<td>Current Password</td>
			<td><input type="password" name="password1"></td>
		</tr>
		<tr>
			<td>Change password</td>
			<td><input type="password" name="password2"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" value="Change" class="w3-button w3-black" onclick="javascript:chgpass()">
			</td>
		</tr>	
	</table>
	</form>
</div>
</body>
</html>