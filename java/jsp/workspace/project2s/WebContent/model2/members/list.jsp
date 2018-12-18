<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Member list</title>
<style>
caption {
	font: bold;
	font-size: x-large;
}
</style>
</head>
<body>
	<div style="margin: 50px; padding: 25px;" align="center">
		<table border="1" style="border-collapse: collapse;"
			class="w3-table-all w3-hoverable w3-centered">
			<caption>Member list</caption>
			<tr>
				<th>Id</th>
				<th>Nickname</th>
				<th>domi & grade</th>
				<th>Gender</th>
				<th>boards</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach var="list" items="${list}">
				<tr class="w3-hover-blue-grey">
					<td>${list.id}</td>
					<td>${list.name}</td>
					<td>${list.dormi}${list.grade}학년</td>
					<td>${list.gender==1?'남자':'여자'}</td>
					<td>${list.boardcnt}</td>
					<td><a href="info.me?id=${list.id}"
						style="text-decoration: none;" class="w3-button w3-black">info</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
