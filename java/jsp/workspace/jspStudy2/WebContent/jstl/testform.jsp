<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL 연습</title>
</head>
<body>
<h4>문제 :아래의 파라미터 출력</h4>
<h4>입력된 숫자에 해당하는 구구단을 출력하기</h4>
<h4>나이가 10살 미만인 경우 : 10살 미만,
		 나이가 10대인 경우 : 10대,
		 나이가 60 이상인 경우 : 60대 이상</h4>
<form action="test1.jsp" method="post" name="f">
이름 : <input type="text" name="name"><br>
나이 : <input type="text" name="age"><br>
성별 : <input type="radio" name="gender" value="1">남&nbsp;&nbsp;
		 <input type="radio" name="gender" value="2">여&nbsp;&nbsp;<br>
구구단 : <input type="text" name="num"><br>
			<input type="submit" value="전송">
</form>
</body>
</html>