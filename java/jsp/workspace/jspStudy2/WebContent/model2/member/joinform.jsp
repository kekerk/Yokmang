<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>model2 회원 가입 화면</title>
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
</style> -->
<script type="text/javascript">
function joincheck(f){
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
	if(f.name.value.length==0){
		alert("이름을 입력하세요");
		f.name.focus();
		return false;
	}
}

function win_open() {
	var op = "width=500, height=150, left=50, top=150";
	open("memberimgForm.jsp","",op);
	
}
</script>
</head>
<body>
<div style="border:2px solid silver; margin-top:200px;" align="center">
<form action="join.me" name="f" method="post" onsubmit="return joincheck(this)">
	<input type="hidden" name="picture" value=""> 		<%-- value=""에서 ""자리에 업로드된 이미지 파일의 경로 및 파일 명이 들어가게 된다. --%>
	<table border="1" style="border-collapse: collapse;">
		<caption>Model2으로 구현한 회원 가입</caption>
		<tr>
		<td rowspan="4" align="center" valign="bottom"><img src="" width="100" height="120" id="pic"><br>
		<font size="1"><a href="javascript:win_open()">사진등록</a></font></td>
		<td>아이디</td>
		<td><input type="text" name="id"></td></tr>
		<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pass"></td>
		</tr>
		<tr>
		<td>이름</td>
		<td><input type="text" name="name"></td>
		</tr>
		<tr>
		<td>성별</td>
		<td>
		<input type="radio" name="gender" value="1" checked>남
		<input type="radio" name="gender" value="2">여
		</td>
		</tr>
		<tr>
		<td>전화번호</td>
		<td colspan="2"><input type="text" name="tel"></td>
		</tr>
		<tr>
		<td>이메일</td>
		<td colspan="2"><input type="text" name="email"></td>
		</tr>
		<tr><td colspan="3" align="center">
		<input type="submit" value="회원가입">
		<input type="reset" value="재작성">
		</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>















