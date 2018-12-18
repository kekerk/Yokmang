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
 	1.pageNum 파라미터 존재. pageNum 파라미터가 없으면 1로 설정.        pageNum-> 페이지 분류
 	2.페이지 별로 10건씩 출력하는 알고리즘.
 		-> db에서 해당 페이지의 출력되는 게시물을 조회. 순서 지정.
 	3.게시물을 화면에 출력.
  --%>
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
	<input type="hidden" name="pageNum" value="1">게시글 검색:
	<select name="column">
		<option value="">선택하세요</option>
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="name">작성자</option>
	</select>
	<script type="text/javascript">
	document.sf.column.value="${param.column}";
	</script>
	<input type="text" name="find" size="50" value="${find}">
	<input type="submit" value="검색">
</form>
</div>
<div style="margin: 50px; padding: 25px;" align="center">
<form action="searchList.bo" method="post" name="f">
<table border="1" style="border-collapse: collapse;" class="w3-table-all w3-hoverable">
	<caption>model2 게시판 등록</caption>
	<c:if test="${boardcount==0 }">
	<tr><td colspan="5" align="center">등록된 게시글이 없습니다.</td></tr>
	</c:if>
	<c:if test="${boardcount!=0 }">
	<tr><td colspan="5" align="right">글개수:${boardcount}</td></tr>
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
	<td align="left">
<%-- empty : b.file1==null || b.file1=='' --%>
	<c:if test="${!empty b.file1}">
	<a href="file/${b.file1}" style="text-decoration:none;"><img  src="img/fileicon.png"></a>
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
</c:forEach>

	<%-- 페이지 부분 출력 --%>
	<tr align="center">
	<td colspan="5">
	<%-- pageNum 파라미터 전달 부분 --%>
	<c:if test="${pageNum<=1 }">[이전]</c:if>
	<c:if test="${pageNum >1 }"><a href="javascript:listcall(${pageNum-1})">[이전]</a></c:if>
	<c:forEach var="a" begin="${startpage}" end="${endpage}" >
		<c:if test="${a==pageNum}">[${a}]</c:if>
		<c:if test="${a!=pageNum }"><a href="javascript:listcall(${a})">[${a}]</a></c:if>
	</c:forEach>
	<c:if test="${pageNum >= maxpage }">[다음]&nbsp;</c:if>
	<c:if test="${pageNum < maxpage }"><a href="javascript:listcall(${pageNum+1})">[다음]</a></c:if>
	</td>
	</tr>
	</c:if>
	<tr><td colspan="3" align="center">
	<input type="text" name="searchword"></td>
	<td align="center"><input type="radio" name="sel" value="1">제목<input type="radio" name="sel" value="2">작성자</td>
	<td align="center"><input type="submit" value="검색"></td></tr>
	<tr><td colspan="5" align="right"><a href="writeForm.bo">글쓰기</a></td></tr>
</table>
</form>
</div>
</body>
</html>