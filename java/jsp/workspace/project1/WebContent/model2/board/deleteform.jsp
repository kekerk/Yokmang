<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
body {font-family: "Raleway", Arial, sans-serif }
caption {
	font :bold;
	font-size: x-large;
}
</style>
</head>
<body>
<div style="margin: 50px; padding: 25px;" align="center">
<form action="delete.bo" method="post" name="f" >
	<input type="hidden" name="num" value="${param.num}">
	<table border="1" style="border-collapse: collapse;"  class="w3-table-all">
	<caption>게시물 삭제 확인창</caption>
	<tr><td>게시물 삭제를 위한 비밀번호 입력</td></tr>
	<tr><td><input type="password" name="pass"></td></tr>
	<tr><td colspan="2" align="center"><a href="javascript:document.f.submit()">[삭제]</a></td></tr>
	</table>
	</form>
</div>
</body>
</html>