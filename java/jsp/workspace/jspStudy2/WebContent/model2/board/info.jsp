<%@page import="model.BoardDao"%>
<%@page import="model.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	/WebContent/model1/board/info.jsp
	1. num �Ķ���͸� �̿��Ͽ� db���� �ش� �Խù� ���� ��ȸ.
		Board BoardDao.selectOne(num)
	2. readcnt ���� +1�� ������Ű��.
	BoardDao.readcntadd(num)
	3. Board�� ������ ȭ�鿡 ����ϱ�.
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>model2 �̿��� �Խù� info</title>
</head>
<body>
<table border="1" style="border-collapse : collapse;" class="w3-table-all">
	<caption>��2 �Խù� �� ����</caption>
	<tr><td>�۾���</td><td>${board.name }</td></tr>
	<tr><td>����</td><td>${board.title }</td></tr>
	<tr><td>����</td><td><table width="490" height="250"><tr><td>${board.content}</td></tr></table></td>
	</tr>
	<tr><td>÷������</td>
	<td>
	<c:if test="${!empty board.file1}">
	<a href="file/${board.file1}">${board.file1}</a>
	</c:if>
	<c:if test="${empty board.file1 }">
	[���� ����]
	</c:if>
	</td>
	</tr>
	<tr><td colspan="2" align="center">
	<a href="replyForm.bo?num=${board.num }">[�亯]</a>  <%-- ���ۿ� ���� num --%>
	<a href="updateForm.bo?num=${board.num}">[����]</a> 
	<a href="deleteform.bo?num=${board.num }">[����]</a> 
	<a href="list.bo">[���]</a>
	</td>
	</tr> 
</table>
</body>
</html>