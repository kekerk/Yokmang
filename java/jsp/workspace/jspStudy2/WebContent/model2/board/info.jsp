<%@page import="model.BoardDao"%>
<%@page import="model.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	/WebContent/model1/board/info.jsp
	1. num 파라미터를 이용하여 db에서 해당 게시물 정보 조회.
		Board BoardDao.selectOne(num)
	2. readcnt 값을 +1로 증가시키기.
	BoardDao.readcntadd(num)
	3. Board의 정보를 화면에 출력하기.
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>model2 이용한 게시물 info</title>
</head>
<body>
<table border="1" style="border-collapse : collapse;" class="w3-table-all">
	<caption>모델2 게시물 상세 보기</caption>
	<tr><td>글쓴이</td><td>${board.name }</td></tr>
	<tr><td>제목</td><td>${board.title }</td></tr>
	<tr><td>내용</td><td><table width="490" height="250"><tr><td>${board.content}</td></tr></table></td>
	</tr>
	<tr><td>첨부파일</td>
	<td>
	<c:if test="${!empty board.file1}">
	<a href="file/${board.file1}">${board.file1}</a>
	</c:if>
	<c:if test="${empty board.file1 }">
	[파일 없음]
	</c:if>
	</td>
	</tr>
	<tr><td colspan="2" align="center">
	<a href="replyForm.bo?num=${board.num }">[답변]</a>  <%-- 원글에 대한 num --%>
	<a href="updateForm.bo?num=${board.num}">[수정]</a> 
	<a href="deleteform.bo?num=${board.num }">[삭제]</a> 
	<a href="list.bo">[목록]</a>
	</td>
	</tr> 
</table>
</body>
</html>