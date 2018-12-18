<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입 화면</title>
</head>
<script type="text/javascript">
		function confirm(f){
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
</script>
<%-- 문제 : 아이디 비밀번호, 이름은 반드시 입력하도록 join.jsp 페이지에서 useBean 액션태그를 사용하여  --%>
<body>
<form action="join.jsp" method="post" name="f" onsubmit="return confirm(this)">
	<table border="1" style="border-collapse : collapse;">
		<tr>
		<td>아이디</td><td><input type="text" name="id"></td></tr>
		<tr><td>비밀번호</td><td><input type="password" name="pass"></td></tr>
		<tr><td>이름</td><td><input type="text" name="name"></td></tr>
		<tr><td>성별</td>
		<td><input type="radio" name="gender" value="1">남
		        <input type="radio" name="gender" value="2">여
		</td></tr>
		<tr><td>이메일</td><td><input type="text" name="email"></td></tr>
		<tr><td>생일</td><td><input type="text" name="birth"></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="회원등록"></td></tr>
	</table>
</form>
</body>
</html>