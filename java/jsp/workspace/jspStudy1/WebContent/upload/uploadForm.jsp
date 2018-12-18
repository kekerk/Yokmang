<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>파일 업로드 화면</title>
</head>
<body>
<form action="upload.jsp" method="post" enctype="multipart/form-data">
 <%--
  			파일 업로드시  반드시 enctype="multipart/form-data" 설정이 필요함.
 
 			******enctype="multipart/form-data" : file1의 내용까지 보내는 기능. 
  
  			1. 파라미터값과 파일의 내용까지 서버로 전송하도록 설정
  			2. 반드시 method="post" 설정해야함
  			
  			upload.jsp 페이지에서는 request 객체를 직접 사용할 수 없다.
  			=> cos.jar 필요함.
  			
  --%>
<table border="1" style="border-collapse: collapse;">
	<tr><td>올린사람</td><td><input type="text" name="name"></td></tr>
	<tr><td>제목</td><td><input type="text" name="title"></td></tr>
	<tr><td>파일</td><td><input type="file" name="file1"></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="전송"></td></tr>
</table>
</form>
</body>
</html>