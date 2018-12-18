<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품 등록 화면</title>
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
<form:form modelAttribute="item" action="register.shop" enctype="multipart/form-data"> <%-- 파일 업로드 --%>
<h2>상품 등록 화면</h2>
<table>
	<tr>
		<td>상품명</td>
		<td><form:input path="name" maxlength="20" /></td>
		<td><font color="red"><form:errors path="name"/></font></td> <%-- form:errors : 유효성 검증 --%>
	</tr>
	<tr>
		<td>가격</td>
		<td><form:input path="price" maxlength="6" /></td>
		<td><font color="red"><form:errors path="price"/></font></td>
	</tr>
	<tr>
		<td>상품이미지</td>
		<td colspan="2"><input type="file" name="picture"></td>
	</tr>
	<tr>
		<td>상품설명</td>
		<td><form:textarea path="description" cols="20" rows="5"/></td>
		<td><font color="red"><form:errors path="description"/></font></td>
	</tr>
	<tr>
		<td colspan="3"><input type="submit" value="등록">&nbsp;
		<input type="button" value="상품목록" onclick="location.href='list.shop'"></td>
	</tr>
</table>
</form:form>
</body>
</html>