<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<head>
<script>
 img = opener.document.getElementById("pic");
 img.src="img/${filename}";
 opener.document.f.picture.value="${filename}";
 self.close();
</script>
</head>