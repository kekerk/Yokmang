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
<title>모델2 게시물 목록 보기</title>
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
	<caption>model2 조건 게시물 검색</caption>
	<c:if test="${searchboardcount==0 }">
	<tr><td colspan="5" align="center">등록된 게시글이 없습니다.</td></tr>
	</c:if>
	<c:if test="${searchboardcount>0 }">
	<tr><td colspan="5" align="right">글개수:${searchboardcount} </td></tr>
	<tr align="center" valign="middle">
	<th width="8%">번호</th>
	<th width="50%">제목</th>
	<th width="14%">작성자</th>
	<th width="17%">날짜</th>
	<th width="11%">조회수</th>
	</tr>
		<c:forEach var="b" items="${list}">
	<tr align="center" valign="middle">
	<td>${boardnum}</td><%-- 게시 번호 --%>
	<c:set var="boardnum" value="${boardnum-1 }"/>
	<%-- 첨부파일이 있는 경우 @ 붙여서 출력 --%>
	<%-- 답글인 경우  안으로 들여쓰기 --%>
	<td align="left">
	<c:if test="${!empty b.file1}">
	<a href="file/${b.file1}" style="text-decoration:none;">@</a>
	</c:if>
	<c:if test="${empty b.file1}"> &nbsp;&nbsp;&nbsp;</c:if>
	<c:if test="${b.reflevel >0 }">
	<c:forEach var="i" begin="1" end="${ b.reflevel}">&nbsp;&nbsp;&nbsp;</c:forEach>└
	</c:if>
	<a href="info.bo?num=${b.num}">${b.title}</a></td>
	<td>${b.name}</td>
	<%-- --------------------------------시간 출력------------------------------------------ --%>
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
	</c:forEach>	<%-- 페이지 부분 출력 --%>
	<tr align="center">
	<td colspan="5">
	<%-- pageNum 파라미터 전달 부분 --%>
	<c:if test="${pageNum<=1 }">[이전]</c:if>
	<c:if test="${pageNum >1 }"><a href="searchList.bo?pageNum=${pageNum-1}&sel=${sel}&searchword=${searchword}">[이전]</a></c:if>
	<c:forEach var="a" begin="${startpage}" end="${endpage}" >
		<c:if test="${a==pageNum}">[${a}]</c:if>
		<c:if test="${a!=pageNum }"><a href="searchList.bo?pageNum=${a}&sel=${sel}&searchword=${searchword}">[${a}]</a></c:if>
	</c:forEach>
	<c:if test="${pageNum >= maxpage }">[다음]&nbsp;</c:if>
	<c:if test="${pageNum < maxpage }"><a href="searchList.bo?pageNum=${pageNum+1}&sel=${sel}&searchword=${searchword}">[다음]</a></c:if>
	</td>
	</tr>
	</c:if>
	<tr><td colspan="5" align="right"><a href= "writeForm.bo">글쓰기</a></td></tr>
	<tr><td colspan="5" align="right"><a href="javascript:location.href='list.bo'">[전체 게시물 목록]</a></td></tr>
</table>
</form>
</div>
</body>
</html>