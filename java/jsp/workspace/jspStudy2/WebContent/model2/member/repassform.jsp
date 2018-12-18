<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html><%-- info.jsp에 비밀번호변경 넣기. --%>
<%-- 
		비밀번호 변경 버튼 클릭 시 
		db에 파라미터 정보를 이용하여 비밀번호 수정하고,
		수정 성공 : alert("비밀번호 수정이 완료되었습니다")  메세지 출력하고 윈도우 닫기.
		수정 실패 : alert("비밀번호 수정 실패") 메세지 출력하고 가만히 있기.
 --%>
<head>
<meta charset="EUC-KR">
<title>model2 비밀번호 재설정</title>
<!-- <style>
	table {
		margin: 0 auto;
		width : 400px;
		border: 2px solid green;
		text-align: center;
	}
	caption {
	font-weight: bold;
	font-size: x-large;
	} 
</style>-->
</head>
<body>
<div style="border:2px solid silver; margin-top:200px;" align="center">
	<form action="repass.me" name="f" method="post">
	<input type="hidden" name="id" value="${param.id }">
	<table border="1" style="border-collapse : collapse;">
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
			<td colspan="2" align="center">
			<input type="submit" value="비밀번호 변경">
			</td>
		</tr>	
	</table>
	</form>
</div>
</body>
</html>