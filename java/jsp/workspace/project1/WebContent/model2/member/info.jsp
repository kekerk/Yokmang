<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="model.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
 <html>
<head>
<meta charset="EUC-KR">
<title>my page</title>
 <style>
 body {font-family: "Raleway", Arial, sans-serif }
	caption {
	font-weight: bold;
	font-size: x-large;
	}
</style> 
</head>
<body>
<div style="margin: 50px; padding: 25px;" align="center">
<form>
	<table border="1" style="border-collapse: collapse; " class="w3-table-all w3-centered">
		<caption>my page</caption>
		<tr>
		<td rowspan="6"><img src="img/${mem.picture}" width="200" height="220"></td>
		<td>아이디</td>
		<td>${mem.id }</td></tr>
		<tr>
		<td>비밀번호</td>
		<td>${mem.pass}</td>
		</tr>
		<tr>
		<td>이름</td>
		<td>${mem.name}</td>
		</tr>
		<tr>
		<td>성별</td>
		<td>
			${mem.gender==1?"남자":"여자"}
		</td>
		</tr>
		<tr>
		<td>전화번호</td>
		<td>${mem.tel}</td>
		</tr>
		<tr>
		<td>이메일</td>
		<td>${mem.email}</td>
		</tr>
		<tr><td colspan="3">
			<a href="updateform.me?id=${mem.id}">[수정]</a>
			<c:if test="${mem.id != 'admin' }">
			<a href="deleteform.me?id=${mem.id}">[탈퇴]</a>
			</c:if>
		</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>

