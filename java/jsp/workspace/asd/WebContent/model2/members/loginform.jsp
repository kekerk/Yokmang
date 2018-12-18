<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%-- /WebContent/model2/member/loginform.jsp --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login</title>
<style type="text/css">
caption {
	font :bold;
	font-size: x-large;
}
</style>
<script type="text/javascript">
	function  logincheck(f){
		if(f.id.value.length==0){
			alert("Input Id");
			f.id.focus();
			return false;
		}
		if(f.password.value.length==0){
			alert("Input Password");
			f.password.focus();
			return false;
		}
	}
</script>
</head>
<body>
<div style="margin: 50px; padding: 25px;" align="center">
<form action="login.me" method="post" onsubmit="return logincheck(this)">
	<table border="1" style="border-collapse: collapse;" class="w3-table-all w3-centered">
		<caption>Login</caption>
	<tr>
		<td>id</td>
		<td><input type="text" name="id"></td>
	</tr> 
	<tr>
		<td>password</td>
		<td><input type="password" name="password"></td>
	</tr> 
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="Login" class="w3-button w3-black">
			<input type="button" value="Join" onclick="location.href='joinform.jsp'" class="w3-button w3-black">
		 </td>
	</tr> 
	</table>
</form>
</div>
</body>
</html>