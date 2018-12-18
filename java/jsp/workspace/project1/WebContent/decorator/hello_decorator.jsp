<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%-- webcontent/decorator/hello_decorator.jsp --%>
 <%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><decorator:title   /></title>
</head>
<body>
<div style="border: solid 1px;">
<table width="95%" border="1" style="border-collapse: collapse;" >
	<tr><td  colspan="3" align="right">site mesh 이해하기</td></tr>
	<tr>
	<td width="15%" align="center">
		<a href="${path}/model2/member/main.me">회원관리</a>
		<a href="${path}/model2/member/list.bo">게시판</a>
		<td colspan="2" align="left" valign="top"><decorator:body/>
	</td>
	</tr>
	<tr><td colspan="3" align="center">구디아카데미 Since 2016</td></tr>
</table>
</div>
</body>
</html>