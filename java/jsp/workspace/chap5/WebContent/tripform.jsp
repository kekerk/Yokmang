<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>trip information</title>
</head>
<body> <!--  forward시키기. -->
<form action = "info.jsp" name="f" method="post">
<select name="loc">
		<option value="seoul">서울 정보</option>
		<option value="busan">부산 정보</option>
		<option value="daegu">대구 정보</option>
		<option value="kwangju">광주 정보</option>
		<option value="jeju">제주 정보</option>
</select>
	<input type = "submit" value="도시 정보 조회">
</form>
</body>
</html>