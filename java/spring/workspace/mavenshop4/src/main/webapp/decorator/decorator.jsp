<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><decorator:title/></title>
<decorator:head/>
</head>
<body>
<table border="1" style="border-collapse: collapse; width:95%;">
	<tr>
		<td colspan="3" align="right">
			<c:if test="${empty sessionScope.loginUser}">
			<a href="${path}/user/loginForm.shop">�α���</a>
			</c:if>
			<c:if test="${!empty sessionScope.loginUser}">
			${sessionScope.loginUser.userName}��
			<a href="${path}/user/logout.shop">�α׾ƿ�</a>
			</c:if>
		</td>
	</tr>
	<tr>
		<td align="center" width="15%" valign="top">
			<a href="${path}/user/mypage.shop?id=${sessionScope.loginUser.userId}">ȸ������</a>
			<a href="${path}/item/list.shop">��ǰ���</a>
			<a href="${path}/board/list.shop">�Խ���</a>
			<a href="${path}/chat/chat.shop">ä��</a>
		</td>
		<td colspan="2" align="left" valign="top">
			<decorator:body/>
		</td>
	</tr>
	<tr>
		<td colspan="3" align="center">
		�����ī���� Since 2016
		</td>
	</tr>
</table>
</body>
</html>