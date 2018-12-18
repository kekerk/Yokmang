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
	caption {
	font-weight: bold;
	font-size: large;
	}
</style> 
</head>
<body>
<div style="border:2px solid silver; margin-top:200px; padding:50px;" align="center">
<form>

	<table border="1" style="border-collapse: collapse;">
		<caption>my page</caption>
		<tr>
		<td rowspan="6"><img src="img/${mem.picture}" width="100" height="120"></td>
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
		<%-- 
					id에 해당하는 회원정보 수정 전 화면
					1. 로그인여부, 자기정보 여부 검증
					2. 
		 --%>
			<a href="updateform.me?id=${mem.id}">[수정]</a>
			<a href="repassform.me?id=${mem.id}">[비밀번호 변경]</a>
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

