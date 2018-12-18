<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="passchg.jsp" name="f" method="post">

	<table border="1" style="border-collapse : collapse;">
		<caption>비밀번호 수정</caption>
		<tr>
			<td>현재 비밀번호</td>
			<td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td>수정할 비밀번호</td>
			<td><input type="password" name="chgpass"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="비밀번호 변경">
			</td>
		</tr>	
	</table>
	</form>
</body>
</html>