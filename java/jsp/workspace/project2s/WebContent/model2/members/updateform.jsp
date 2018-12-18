<%@page import="model.MembersDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Member Info Edit</title>
<style>
caption {
	font :bold;
	font-size: x-large;
}
</style> 
<script >
function passchg_winopen() {
	var op = "width=650, height=300, left=50, top=150";
	open("repassform.jsp?id=${mem.id}","",op);
	
}
</script>
</head>
<body>
<div style="margin: 50px; padding: 25px;" align="center" >
<form action = "update.me" name="f" method="post">
	<table border="1" style="border-collapse : collapse; border-color: silver;" class="w3-table-all w3-centered">
	<caption>${mem.id} Info Edit</caption>
	<tr>
		<td>Id</td>
		<td><input type="text" name="id" value="${mem.id}" readonly></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password" value="${mem.password}" ></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><input type="text" name="name" value="${mem.name}" readonly></td>
	</tr>	
	<tr>
		<td>Nickname</td>
		<td><input type="text" name="nickname" value="${mem.nickname}"></td>
	</tr>		
	<tr>
		<td>gender</td>
		<td><input type="radio" name="gender" value="1" <c:if test='${mem.gender==1}'>checked</c:if> readonly>male
			<input type="radio" name="gender" value="2"<c:if test='${mem.gender==2}'>checked</c:if> readonly>female</td>
	</tr>

	<tr>
		<td>Telephone</td>
		<td colspan="2"><input type="text" name="tel" value="${mem.tel}" ></td>
	</tr>
	<tr>
		<td>E-mail</td>
		<td colspan="2"><input type="text" name="email" value="${mem.email}" ></td>
	</tr>
	<tr>
		<td colspan="3" align="center">
		<input type="button" value="Change Password" onclick="passchg_winopen()" class="w3-button w3-black">
		<input type="submit"  value="Edit" class="w3-button w3-black" >
		</td>
	</tr>	
</table>
</form>
</div>
</body>
</html>
