<%@page import="model.Board"%>
<%@page import="java.util.List"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

  <% request.setCharacterEncoding("euc-kr"); %>
 <%-- 
 	WebContent/model2/board/list.jsp
 	1.pageNum �Ķ���� ����. pageNum �Ķ���Ͱ� ������ 1�� ����.        pageNum-> ������ �з�
 	2.������ ���� 10�Ǿ� ����ϴ� �˰���.
 		-> db���� �ش� �������� ��µǴ� �Խù��� ��ȸ. ���� ����.
 	3.�Խù��� ȭ�鿡 ���.
  --%>
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
<script type="text/javascript">
function listcall(page){
	document.sf.pageNum.value=page;
	document.sf.submit();
}
</script>
</head>
<body>
<div class="w3-center" style="margin-top: 50px;">
<form action="list.bo" method="post" name="sf">
	<input type="hidden" name="pageNum" value="1">�Խñ� �˻�:
	<select name="column">
		<option value="">�����ϼ���</option>
		<option value="title">����</option>
		<option value="content">����</option>
		<option value="name">�ۼ���</option>
	</select>
	<script type="text/javascript">
	document.sf.column.value="${param.column}";
	</script>
	<input type="text" name="find" size="50" value="${find}">
	<input type="submit" value="�˻�">
</form>
</div>
<div style="margin: 50px; padding: 25px;" align="center">
<form action="searchList.bo" method="post" name="f">
<table border="1" style="border-collapse: collapse;" class="w3-table-all w3-hoverable">
	<caption>model2 �Խ��� ���</caption>
	<c:if test="${boardcount==0 }">
	<tr><td colspan="5" align="center">��ϵ� �Խñ��� �����ϴ�.</td></tr>
	</c:if>
	<c:if test="${boardcount!=0 }">
	<tr><td colspan="5" align="right">�۰���:${boardcount}</td></tr>
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
	<td align="left">
<%-- empty : b.file1==null || b.file1=='' --%>
	<c:if test="${!empty b.file1}">
	<a href="file/${b.file1}" style="text-decoration:none;"><img  src="img/fileicon.png"></a>
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
</c:forEach>

	<%-- ������ �κ� ��� --%>
	<tr align="center">
	<td colspan="5">
	<%-- pageNum �Ķ���� ���� �κ� --%>
	<c:if test="${pageNum<=1 }">[����]</c:if>
	<c:if test="${pageNum >1 }"><a href="javascript:listcall(${pageNum-1})">[����]</a></c:if>
	<c:forEach var="a" begin="${startpage}" end="${endpage}" >
		<c:if test="${a==pageNum}">[${a}]</c:if>
		<c:if test="${a!=pageNum }"><a href="javascript:listcall(${a})">[${a}]</a></c:if>
	</c:forEach>
	<c:if test="${pageNum >= maxpage }">[����]&nbsp;</c:if>
	<c:if test="${pageNum < maxpage }"><a href="javascript:listcall(${pageNum+1})">[����]</a></c:if>
	</td>
	</tr>
	</c:if>
	<tr><td colspan="3" align="center">
	<input type="text" name="searchword"></td>
	<td align="center"><input type="radio" name="sel" value="1">����<input type="radio" name="sel" value="2">�ۼ���</td>
	<td align="center"><input type="submit" value="�˻�"></td></tr>
	<tr><td colspan="5" align="right"><a href="writeForm.bo">�۾���</a></td></tr>
</table>
</form>
</div>
</body>
</html>