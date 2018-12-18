<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사진등록</title>
</head>
<body>
<h3>업로드 위치:main/member/img</h3>
<form action="memberimg.me" method="post" enctype="multipart/form-data" class="w3-table-black">
 <input type="file" name="picture">
 <input type="submit" value="사진등록">
</form>
</body>
</html>