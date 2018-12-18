<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%-- /WebContent/model2/member/loginform.jsp --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>model2 로그인화면</title>
<!-- 
<style>
	table {
		margin: auto;
		width : 400px;
		border: 1px solid gray;
		text-align: center;
	}
	caption {
	font-weight: bold;
	font-size: x-large;
	}
</style> -->
<script type="text/javascript">
	function  logincheck(f){
		if(f.id.value.length==0){
			alert("아이디를 입력하세요");
			f.id.focus();
			return false;
		}
		if(f.pass.value.length==0){
			alert("비밀번호를 입력하세요");
			f.pass.focus();
			return false;
		}
	}
</script>
</head>
<body>
<div style="border: 2px solid silver; margin-top: 300px; padding:50px;" align="center">
<form action="login.me" method="post" onsubmit="return logincheck(this)">
	<table border="1" style="border-collapse: collapse;">
		<caption>model1 로그인</caption>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id"></td>
	</tr> 
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pass"></td>
	</tr> 
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onclick="location.href='joinform.jsp'">
		 </td>
	</tr> 
	</table>
</form>
</div>
</body>
</html>