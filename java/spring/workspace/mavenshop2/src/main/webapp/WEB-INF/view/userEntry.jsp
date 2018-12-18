<%@ page language="java" contentType="text/html; charset=EUC-KR" 
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사용자 등록</title>
</head>
<body>
	<h2>사용자 등록</h2>
	<!-- 
		modelAttribute="user" : 현재 페이지가 호출될때 user 객체가 있어야한다.
								데이터가 없으면 @modelAttribute 어노테이션을 찾아서 자동 주입한다.
	 -->
	<form:form modelAttribute="user" method="post" action="userEntry.shop">
		<!-- <form id="user" action="userEntry.shop" method="post">와 동일 -->
		<spring:hasBindErrors name="user">
			<font color="red">
				<c:forEach items="${errors.globalErrors}" var="error">
					<spring:message code ="${error.code}" />
				</c:forEach>
			</font>
		</spring:hasBindErrors>	
		<table>
			<tr height="40px">
				<td>아이디</td>
				<td>
				<form:input path="userId" />
				<font color="red"><form:errors path="userId" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>비밀번호</td>
				<td>
					<form:input path="password" />
					<font color="red"><form:errors path="password" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>이름</td>
				<td>
				<form:input path="userName" />
				<font color="red"><form:errors path="userName" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>전화번호</td>
				<td>
					<form:input path="phoneNo" />
					<font color="red"><form:errors path="phoneNo" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>우편번호</td>
				<td>
					<form:input path="postcode" />
					<font color="red"><form:errors path="postcode" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>주소</td>
				<td>
					<form:input path="address" />
					<font color="red"><form:errors path="address" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>이메일</td>
				<td>
					<form:input path="email" />
					<font color="red"><form:errors path="email" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td>생년월일</td>
				<td>
					<form:input path="birthDay" />
					<font color="red"><form:errors path="birthDay" /></font>
				</td>
			</tr>
			<tr height="40px">
				<td colspan="2" align="center">
					<input type="submit" value="등록">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>