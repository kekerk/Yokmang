<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>파일 업로드 결과</title>
</head>
<body>
<%
	
	String uploadPath = application.getRealPath("/") + "upload/";//실제 업로드 폴더 설정
	int size = 10 * 1024 * 1024;//최대 업로드 크기 지정. 10M 이상 업로드 불가.
	MultipartRequest multi = new MultipartRequest(request,uploadPath,size,"euc-kr"); // 파일 업로드 완료 
	/*
		MultipartRequest
		1. request : 요청 정보객체. 파라미터정보, 파일정보, 파일의 내용 정보까지 저장한 객체
		2. uploadPath : 실제 업로드할 폴더 설정
		3. size : 최대 업로드 크기 지정.
		4. "euc-kr" : 파라미터 인코딩
	*/
	String name = multi.getParameter("name");
	String title = multi.getParameter("title");
	String fileName = multi.getFilesystemName("file1");
%>

<table border="1" style="border-collapse: collapse;">
<tr><td>올린사람</td><td><%=name %></td></tr>
<tr><td>제목</td><td><%=title %></td></tr>
<tr><td>업로드 경로</td><td><%=uploadPath %></td></tr>
<tr><td>파일</td><td><a href="<%=fileName %>"><%=fileName %></a></td></tr>
</table>
</body>
</html>
















