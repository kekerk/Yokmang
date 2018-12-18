<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Join</title>
<style type="text/css">
caption {
	font :bold;
	font-size: x-large;
}
</style>
<script type="text/javascript">
function joincheck(f){
	if(f.id.value.length==0){
		alert("Input Id");
		f.id.focus();
		return false;
	}
	if(f.password.value.length==0){
		alert("Input Password");
		f.pass.focus();
		return false;
	}
	if(f.name.value.length==0){
		alert("Input Name");
		f.name.focus();
		return false;
	}
	if(f.nickname.value.length==0){
		alert("Input NickName");
		f.nickname.focus();
		return false;
	}
	if(f.gender.value.length==0){
		alert("Select Gender");
		f.name.focus();
		return false;
	}
}

</script>
</head>
<body>
<div style="margin: 50px; padding: 25px;" align="center">
<form action="join.me" name="f" method="post" onsubmit="return joincheck(this)">
	<input type="hidden" name="grade" value="1"> 		<%-- value=""에서 ""자리에 업로드된 이미지 파일의 경로 및 파일 명이 들어가게 된다. --%>
	<table border="1" style="border-collapse: collapse;" class="w3-table-all w3-centered">
		<caption>Member join</caption>
		<tr>
		<td>Id</td>
		<td><input type="text" name="id"></td></tr>
		<tr>
		<td>Password</td>
		<td><input type="password" name="password"></td>
		</tr>
		<tr>
		<td>Name</td>
		<td><input type="text" name="name"></td>
		</tr>
		<tr>
		<td>Nickname</td>
		<td><input type="text" name="nickname"></td>
		</tr>
		<tr>
		<td>Gender</td>
		<td>
		<input type="radio" name="gender" value="1">male
		<input type="radio" name="gender" value="2">female
		</td>
		</tr>
		<tr>
		<td>TelePhone</td>
		<td colspan="2"><input type="text" name="tel"></td>
		</tr>
		<tr>
		<td>E-mail</td>
		<td colspan="2"><input type="text" name="email"></td>
		</tr>
		<tr><td colspan="3" align="center">
		<select name="dormi">
			<option value="1">Gryffindor</option>
			<option value="2">Slytherin</option>
			<option value="3">Hufflepuff</option>
			<option value="4">Ravenclaw</option>
			<option value="5" disabled="disabled">X</option>
		</select> 
		<input type="submit" value="Join" class="w3-button w3-black">
		</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>















