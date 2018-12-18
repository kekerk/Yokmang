<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<%-- info.jsp에 비밀번호변경 넣기. --%>

<head>
<meta charset="EUC-KR">
<title>model2 비밀번호 재설정</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<style type="text/css">
body {
	background-image: url("img/Bgimg.jpg");
	background-size: contain;
	font-family: "Raleway", Arial, sans-serif
}

caption {
	font: bold;
	font-size: x-large;
}
</style>
</head>
<body>
	<div style="margin: 50px; padding: 25px;" align="center">
		<form action="repass.me" name="f" method="post">
			<input type="hidden" name="id" value="${param.id }">
			<table border="1" style="border-collapse: collapse;"
				class="w3-centered">
				<caption>비밀번호 수정</caption>
				<tr>
					<td>현재 비밀번호</td>
					<td><input type="password" name="pass1"></td>
				</tr>
				<tr>
					<td>수정할 비밀번호</td>
					<td><input type="password" name="pass2"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="비밀번호 변경"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>