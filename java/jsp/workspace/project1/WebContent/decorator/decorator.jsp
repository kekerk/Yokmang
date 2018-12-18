<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%-- /WebContent/decorator/decorator.jsp --%>
  <%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><decorator:title/></title>
</head>
<decorator:head />
<body>
<table width="95%" border="1" style="border-collapse: collapse;" >
	<tr><td  colspan="3" align="right">
	<c:if test="${empty sessionScope.login }">
		<a href="${path}/model2/member/loginform.me">�α���</a>
	</c:if>
	<c:if test="${!empty sessionScope.login }">
		${sessionScope.login }��
		<a href="${path}/model2/member/logout.me">�α׾ƿ�</a>
	</c:if>
	</td></tr>
	<tr>
	<td width="15%" align="center">
		<a href="${path}/model2/member/main.me">ȸ������</a>
		<a href="${path}/model2/board/list.bo">�Խ���</a>
		<td colspan="2" align="left" valign="top"><decorator:body/>
	</td>
	</tr>
	<tr><td colspan="2" align="center" valign="top">�����ī���� Since 2016</td></tr>
</table>
</body>
</html>