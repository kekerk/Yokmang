<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>이미지 올리기</title>
</head>
<body>
<form action="thumbnail.jsp" method="post" enctype="multipart/form-data">
원본이미지 : <input type="file" name="image">
<input type="submit" value="thumbnail 이미지 생성">
</form>
</body>
</html>