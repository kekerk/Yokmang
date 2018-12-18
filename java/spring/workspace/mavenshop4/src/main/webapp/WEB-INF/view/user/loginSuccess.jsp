<%@ page language="java" contentType="text/html; charset=EUC-KR" 
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인 성공</title>
<style type="text/css">
table {
	width: 90%;
	border-collapse: collapse;
}

th, td {
	border: 3px solid #bcbcbc;
	text-align: center;
	padding: 8px;
}

th {
	background-color: #4CAF50;
	color: white;
	text-align: center;
}

td {
	background-color: #f2f2f2;
}

td.title {
	background-color: #e2e2e2;
	color: blue;
}
</style>
</head>
<body>
	<h2>환영합니다. ${sessionScope.loginUser.userName}님이 로그인 하셨습니다.</h2>
	<table border="1" cellspacing="0" cellpadding="0">
		<tr>
			<td>아이디</td>
			<td>${loginUser.userId}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${loginUser.userName}</td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td>${loginUser.postcode}</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${loginUser.address}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${loginUser.phoneNo}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${loginUser.email}</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><fmt:formatDate value="${loginUser.birthDay}" pattern="yyyy년 MM월 dd일" /></td>
		</tr>
	</table>
	<hr>
	<h3><a href="mypage.shop?id=${loginUser.userId}">My Page</a></h3>
	<h3><a href="logout.shop">logout</a></h3>
	<h3><a href="../item/list.shop">상품 리스트</a></h3>
</body>
</html>