<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사진 등록</title>
</head>
<body>
<h3>업로드위치 : model2/member/img</h3>
<div style="border:2px solid silver; margin-top:50px;">
<form action="memberimg.me" method="post" enctype="multipart/form-data">
<input type="file" name="picture">
<input type="submit" value="사진등록">
</form>
</div>
</body>
</html>