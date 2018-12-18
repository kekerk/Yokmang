<%@page import="java.util.List"%>
<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��2 �Խù� ��� ����</title>
<style type="text/css">
body {font-family: "Raleway", Arial, sans-serif }
caption {
	font :bold;
	font-size: x-large;
}
</style>
</head>
<body>
<div style="margin: 50px; padding: 25px;" align="center">
<form>
<input type="hidden" name="sel" value="${param.sel}">
<table border="1" style="border-collapse: collapse;" class="w3-table-all w3-hoverable">
	<caption>model2 ���� �Խù� �˻�</caption>
	<c:if test="${searchboardcount==0 }">
	<tr><td colspan="5" align="center">��ϵ� �Խñ��� �����ϴ�.</td></tr>
	</c:if>
	<c:if test="${searchboardcount>0 }">
	<tr><td colspan="5" align="right">�۰���:${searchboardcount} </td></tr>
	<tr align="center" valign="middle">
	<th width="8%">��ȣ</th>
	<th width="50%">����</th>
	<th width="14%">�ۼ���</th>
	<th width="17%">��¥</th>
	<th width="11%">��ȸ��</th>
	</tr>
		<c:forEach var="b" items="${list}">
	<tr align="center" valign="middle">
	<td>${boardnum}</td><%-- �Խ� ��ȣ --%>
	<c:set var="boardnum" value="${boardnum-1 }"/>
	<%-- ÷�������� �ִ� ��� @ �ٿ��� ��� --%>
	<%-- ����� ���  ������ �鿩���� --%>
	<td align="left">
	<c:if test="${!empty b.file1}">
	<a href="file/${b.file1}" style="text-decoration:none;">@</a>
	</c:if>
	<c:if test="${empty b.file1}"> &nbsp;&nbsp;&nbsp;</c:if>
	<c:if test="${b.reflevel >0 }">
	<c:forEach var="i" begin="1" end="${ b.reflevel}">&nbsp;&nbsp;&nbsp;</c:forEach>��
	</c:if>
	<a href="info.bo?num=${b.num}">${b.title}</a></td>
	<td>${b.name}</td>
	<%-- --------------------------------�ð� ���------------------------------------------ --%>
	<jsp:useBean id="today" class="java.util.Date" />
	<fmt:formatDate value="${today}" pattern="yyyyMMdd" var="Today" />
	<fmt:formatDate value="${b.regdate}" pattern="yyyyMMdd" var="regday" />
	<c:choose>
	<c:when test="${regday != Today}">
	<td><fmt:formatDate value="${b.regdate}" pattern="yy/MM/dd hh:mm:ss" /></td>
	</c:when>
	<c:otherwise>
	<td><fmt:formatDate value="${b.regdate}" pattern="hh:mm:ss" /></td>
	</c:otherwise>
	</c:choose>
	<%-- ------------------------------------------------------------------------------------ --%>
	<td>${b.readcnt}</td>
	</tr>
	</c:forEach>	<%-- ������ �κ� ��� --%>
	<tr align="center">
	<td colspan="5">
	<%-- pageNum �Ķ���� ���� �κ� --%>
	<c:if test="${pageNum<=1 }">[����]</c:if>
	<c:if test="${pageNum >1 }"><a href="searchList.bo?pageNum=${pageNum-1}&sel=${sel}&searchword=${searchword}">[����]</a></c:if>
	<c:forEach var="a" begin="${startpage}" end="${endpage}" >
		<c:if test="${a==pageNum}">[${a}]</c:if>
		<c:if test="${a!=pageNum }"><a href="searchList.bo?pageNum=${a}&sel=${sel}&searchword=${searchword}">[${a}]</a></c:if>
	</c:forEach>
	<c:if test="${pageNum >= maxpage }">[����]&nbsp;</c:if>
	<c:if test="${pageNum < maxpage }"><a href="searchList.bo?pageNum=${pageNum+1}&sel=${sel}&searchword=${searchword}">[����]</a></c:if>
	</td>
	</tr>
	</c:if>
	<tr><td colspan="5" align="right"><a href= "writeForm.bo">�۾���</a></td></tr>
	<tr><td colspan="5" align="right"><a href="javascript:location.href='list.bo'">[��ü �Խù� ���]</a></td></tr>
</table>
</form>
</div>
</body>
</html>