<%@page import="model.MembersDao"%>
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
<title>My page</title>
 <style>
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
		<td>Id</td>
		<td>${mem.id }</td>
		<td>Password</td>
		<td>${mem.password}</td>
		</tr>
		<tr>
		<td>Name</td>
		<td>${mem.name}</td>
		<td>Nickname</td>
		<td>${mem.nickname}</td>
		</tr>
		<tr>
		<td>dormitory</td>
		<td>${mem.dormi}</td>
		<td>grade</td>
		<td>${mem.grade}</td>
		</tr>
		<tr>
		<td colspan="2">[caution]</td>
		<td colspan="2">
			${mem.gender==1?"여자 기숙사 출입 금지":"남자 기숙사 출입 금지"}
		</td>
		</tr>
		<tr>
		<td colspan="2">Telephone</td>
		<td colspan="2">${mem.tel}</td>
		</tr>
		<tr>
		<td colspan="2">E-mail</td>
		<td colspan="2">${mem.email}</td>
		</tr>
		<tr><td colspan="4">
			<c:if test="${sessionScope.login == mem.id}">
			<a href="updateform.me?id=${mem.id}" class="w3-button w3-black">edit</a>
			</c:if>
			<c:if test="${mem.id != 'admin'}">
			<a href="delete.me?id=${mem.id}" class="w3-button w3-black">withdraw</a>
			</c:if>
			<a href="main.me?id=${mem.id}" class="w3-button w3-black">main</a>
		</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>

