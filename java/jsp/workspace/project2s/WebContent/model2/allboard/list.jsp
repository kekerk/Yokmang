<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <% request.setCharacterEncoding("euc-kr"); %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Board</title>
<style type="text/css">
caption {
	font :bold;
	font-size: x-large;
}
</style>
<script type="text/javascript">
function lists(page){
	document.sf.pageNum.value=page;
	document.sf.submit();
}
</script>
</head>
<body>
<c:if test="${boardtype== 1}">
<div style=" margin:30px;padding: 25px;" class="w3-center">
 <table style="border-collapse: collapse;" class="w3-table-all w3-centered">
	<c:if test="${boardcount==0 }">
	<tr><td colspan="5"><h2>게시물이 없습니다.</h2></td></tr>
	</c:if>
	<c:if test="${boardcount!=0 }">
	<h2>명장면 및 후기 게시판</h2>
	<c:forEach var="b" items="${list}">	
	<div class=" w3-third" style="border:1px solid silver; padding-top:10px;">
	<div><a href="info.all?no=${b.no}&boardtype=${b.boardtype}" style="text-decoration:none;"><img src="file/sm_${b.file1}" style="width:300px; height:200px;"></a></div>
	<div><p><a href="info.all?no=${b.no}&boardtype=${b.boardtype}" style="text-decoration:none;">${boardnum} : [${b.seriesname}]${b.title}</a></p></div>
	<c:set var="boardnum" value="${boardnum-1 }"/>
	<div><p>작성 날짜 :<jsp:useBean id="today" class="java.util.Date" />
	<fmt:formatDate value="${today}" pattern="yyyyMMdd" var="Today1" />
	<fmt:formatDate value="${b.regdate}" pattern="yyyyMMdd" var="regday1" />
	<c:choose>
	<c:when test="${regday1 != Today1}">
	<fmt:formatDate value="${b.regdate}" pattern="yy/MM/dd hh:mm:ss" />
	</c:when>
	<c:otherwise>
	<fmt:formatDate value="${b.regdate}" pattern="hh:mm:ss" />
	</c:otherwise>
	</c:choose> 
	</p></div>
	<div><p>작성자 : ${b.nickname}</p></div>
	<div><p>조회수 : ${b.readcnt}</p></div>
	</div>
	</c:forEach>
	<%-- 페이지 부분 출력 --%>
	<tr align="center">
	<td colspan="5">
	<%-- pageNum 파라미터 전달 부분 --%>
	<c:if test="${pageNum<=1 }"><p class="w3-button w3-black" style="text-decoration: none;">Previous</p></c:if>
	<c:if test="${pageNum >1 }"><a href="javascript:lists(${pageNum-1})" class="w3-button w3-black" style="text-decoration: none;">Previous</a></c:if>
	<c:forEach var="a" begin="${startpage}" end="${endpage}" >
		<c:if test="${a==pageNum}"><p class="w3-button w3-black" style="text-decoration: none;">${a}</p></c:if>
		<c:if test="${a!=pageNum }"><a href="javascript:lists(${a})" class="w3-button w3-black" style="text-decoration: none;">${a}</a></c:if>
	</c:forEach>
	<c:if test="${pageNum >= maxpage }"><p class="w3-button w3-black" style="text-decoration: none;">Next</p></c:if>
	<c:if test="${pageNum < maxpage }"><a href="javascript:lists(${pageNum+1})" class="w3-button w3-black" style="text-decoration: none;">Next</a></c:if>
	</td>
	</tr>
	</c:if>
	<tr><td colspan="5" align="right"><a href="writeForm.all?boardtype=${boardtype}" class="w3-button w3-black" style="text-decoration: none;">Write</a></td></tr>
</table>

<form action="list.all" method="post" name="sf" style="margin-top:20px;">
  <input type="hidden" name="pageNum" value="1">
  <input type="hidden" name="boardtype" value="${boardtype}">
  <select name="column">
    <option value="">선택하세요</option>
    <option value="nickname">작성자</option>
    <option value="title">제목</option>
   </select>
   <script type="text/javascript">
     document.sf.column.value="${param.column}";
   </script>
   <input type="text" name="find" size="50" value="${find}">
   <input type="submit" value="search" class="w3-button w3-black" style="text-decoration: none;">
 </form>
</div>
</c:if>
<%------------------------------------------------갤러리 게시판--------------------------------------------------- --%>
<c:if test="${boardtype == 2}">
<div style=" margin:30px;padding: 25px;" class="w3-center">
 <table style="border-collapse: collapse;" class="w3-table-all w3-centered">
	<c:if test="${boardcount==0 }">	
	<tr><td colspan="5"><h2>게시물이 없습니다.</h2></td></tr>	
	</c:if>
	<c:if test="${boardcount!=0 }">
	<h2>갤러리 게시판</h2>
	<c:forEach var="b" items="${list}">	
	<div class=" w3-third" style="border:1px solid silver; padding-top:10px;">
	<div><a href="info.all?no=${b.no}&boardtype=${b.boardtype}" style="text-decoration:none;"><img src="file/sm_${b.file1}" style="width:300px; height:200px;"></a></div>
	<div><p><a href="info.all?no=${b.no}&boardtype=${b.boardtype}" style="text-decoration:none;">${boardnum} : ${b.title}</a></p></div>
	<c:set var="boardnum" value="${boardnum-1 }"/>
	<div><p>작성 날짜 :<jsp:useBean id="today2" class="java.util.Date" />
	<fmt:formatDate value="${today2}" pattern="yyyyMMdd" var="Today2" />
	<fmt:formatDate value="${b.regdate}" pattern="yyyyMMdd" var="regday2" />
	<c:choose>
	<c:when test="${regday2 != Today2}">
	<fmt:formatDate value="${b.regdate}" pattern="yy/MM/dd hh:mm:ss" />
	</c:when>
	<c:otherwise>
	<fmt:formatDate value="${b.regdate}" pattern="hh:mm:ss" />
	</c:otherwise>
	</c:choose> 
	</p></div>
	<div><p>작성자 : ${b.nickname}</p></div>
	<div><p>조회수 : ${b.readcnt}</p></div>
	
	</div>
	</c:forEach>
	<%-- 페이지 부분 출력 --%>
	<tr align="center">
	<td colspan="5">
	<%-- pageNum 파라미터 전달 부분 --%>
	<c:if test="${pageNum<=1 }"><p  class="w3-button w3-black" style="text-decoration: none;">Previous</p></c:if>
	<c:if test="${pageNum >1 }"><a href="javascript:lists(${pageNum-1})"  class="w3-button w3-black" style="text-decoration: none;">Previous</a></c:if>
	<c:forEach var="a" begin="${startpage}" end="${endpage}" >
		<c:if test="${a==pageNum}"><p  class="w3-button w3-black" style="text-decoration: none;">${a}</p></c:if>
		<c:if test="${a!=pageNum }"><a href="javascript:lists(${a})"  class="w3-button w3-black" style="text-decoration: none;">${a}</a></c:if>
	</c:forEach>
	<c:if test="${pageNum >= maxpage }"><p  class="w3-button w3-black" style="text-decoration: none;">Next</p></c:if>
	<c:if test="${pageNum < maxpage }"><a href="javascript:lists(${pageNum+1})"  class="w3-button w3-black" style="text-decoration: none;">Next</a></c:if>
	</td>
	</tr>
	</c:if>
	<tr><td colspan="5" align="right"><a href="writeForm.all?boardtype=${boardtype}"  class="w3-button w3-black" style="text-decoration: none;">Write</a></td></tr>
</table>
<form action="list.all" method="post" name="sf">
  <input type="hidden" name="pageNum" value="1">
  <input type="hidden" name="boardtype" value="${boardtype}" >
  <select name="column">
    <option value="">선택하세요</option>
    <option value="nickname">작성자</option>
    <option value="title">제목</option>
   </select>
   <script type="text/javascript">
     document.sf.column.value="${param.column}";
   </script>
   <input type="text" name="find" size="50" value="${find}" >
   <input type="submit" value="search" class="w3-button w3-black" style="text-decoration: none;">
 </form>
</div>
</c:if>
<%----------------------------------------------기숙사별 게시판-------------------------------------------------- --%>
<c:if test="${boardtype == 3}"><%--기숙사별 게시판--%>
<div style="margin: 50px; padding: 25px;">

<table style="border-collapse: collapse;" class="w3-table w3-bordered">
 	<c:if test="${dormi =='Gryffindor' }">
	<caption>그리핀도르 게시판</caption>
	</c:if>
	<c:if test="${dormi =='Slytherin' }">
	<caption>슬리데린 게시판</caption>
	</c:if>
	<c:if test="${dormi =='Hufflepuff' }">
	<caption>후플푸프 게시판</caption>
	</c:if>
	<c:if test="${dormi =='Ravenclaw' }">
	<caption>래번클로 게시판</caption>
	</c:if>
	<c:if test="${boardcount==0 }">
	<tr><td colspan="5" class="w3-centered"><h2>등록된 게시글이 없습니다.</h2></td></tr>
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
	<a href="file/${b.file1}" style="text-decoration:none;"><img src="file.jpg"></a>
	</c:if>
	<c:if test="${empty b.file1}"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
	<a href="info.all?no=${b.no}&boardtype=${b.boardtype}&dormi=${b.dormi}">${b.title}</a></td>
	<td>${b.nickname}</td>
	<%-- --------------------------------시간 출력------------------------------------------ --%>
	<jsp:useBean id="today3" class="java.util.Date" />
	<fmt:formatDate value="${today3}" pattern="yyyyMMdd" var="Today3" />
	<fmt:formatDate value="${b.regdate}" pattern="yyyyMMdd" var="regday3" />
	<c:choose>
	<c:when test="${regday3 != Today3}">
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
	<td class="w3-centered" colspan="5">
	<%-- pageNum 파라미터 전달 부분 --%>
	<c:if test="${pageNum<=1 }"><p  class="w3-button w3-black" style="text-decoration: none;">Previous</p></c:if>
	<c:if test="${pageNum >1 }"><a href="javascript:lists(${pageNum-1})"  class="w3-button w3-black" style="text-decoration: none;">Previous</a></c:if>
	<c:forEach var="a" begin="${startpage}" end="${endpage}" >
		<c:if test="${a==pageNum}"><p  class="w3-button w3-black" style="text-decoration: none;">${a}</p></c:if>
		<c:if test="${a!=pageNum }"><a href="javascript:lists(${a})"  class="w3-button w3-black" style="text-decoration: none;">${a}</a></c:if>
	</c:forEach>
	<c:if test="${pageNum >= maxpage }"><p  class="w3-button w3-black" style="text-decoration: none;">Next</p></c:if>
	<c:if test="${pageNum < maxpage }"><a href="javascript:lists(${pageNum+1})"  class="w3-button w3-black" style="text-decoration: none;">Next</a></c:if>
	</td>
	</tr>
	</c:if>
	<tr><td colspan="5" align="right"><a href="writeForm.all?boardtype=${boardtype}"  class="w3-button w3-black" style="text-decoration: none;">Write</a></td></tr>
</table>

<form action="list.all" method="post" name="sf" class="w3-center">
  <input type="hidden" name="pageNum" value="1">
  <input type="hidden" name="boardtype" value="${boardtype}">
  <input type="hidden" name="dormi" value="${sessionScope.dormi}">
  <select name="column">
    <option value="">선택하세요</option>
    <option value="nickname">작성자</option>
    <option value="title">제목</option>
   </select>
   <script type="text/javascript">
     document.sf.column.value="${param.column}";
   </script>
   <input type="text" name="find" size="50" value="${find}">
    <input type="submit" value="search" class="w3-button w3-black" style="text-decoration: none;">
 </form>
</div>
</c:if>
<%-----------------------------------------------자유게시판------------------------------------------ --%>
<c:if test="${boardtype == 4}"><%-- 자유게시판 --%>
<div style="margin: 50px; padding: 25px;">


<table style="border-collapse: collapse;" class="w3-table w3-bordered">
	<caption>자유 게시판</caption>
	<c:if test="${boardcount==0 }">
	<tr><td colspan="5" class="w3-centered"><h2>등록된 게시글이 없습니다.</h2></td></tr>
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
	<a href="file/${b.file1}" style="text-decoration:none;"><img src="file.jpg"></a>
	</c:if>
	<c:if test="${empty b.file1}"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
	<c:if test="${b.id=='admin'}"><font style="color: red">[공지사항]</font></c:if>
	<a href="info.all?no=${b.no}&boardtype=${b.boardtype}" style="text-decoration:none;">${b.title}</a></td>
	<td>${b.nickname}</td>
	<%-- --------------------------------시간 출력------------------------------------------ --%>
	<jsp:useBean id="today4" class="java.util.Date" />
	<fmt:formatDate value="${today4}" pattern="yyyyMMdd" var="Today4" />
	<fmt:formatDate value="${b.regdate}" pattern="yyyyMMdd" var="regday4" />
	<c:choose>
	<c:when test="${regday4 != Today4}">
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
<tr align="center" class="w3-center">
	<td colspan="5" >
	<%-- pageNum 파라미터 전달 부분 --%>
<c:if test="${pageNum<=1 }"><p  class="w3-button w3-black" style="text-decoration: none;">Previous</p></c:if>
	<c:if test="${pageNum >1 }"><a href="javascript:lists(${pageNum-1})"  class="w3-button w3-black" style="text-decoration: none;">Previous</a></c:if>
	<c:forEach var="a" begin="${startpage}" end="${endpage}" >
		<c:if test="${a==pageNum}"><p  class="w3-button w3-black" style="text-decoration: none;">${a}</p></c:if>
		<c:if test="${a!=pageNum }"><a href="javascript:lists(${a})"  class="w3-button w3-black" style="text-decoration: none;">${a}</a></c:if>
	</c:forEach>
	<c:if test="${pageNum >= maxpage }"><p  class="w3-button w3-black" style="text-decoration: none;">Next</p></c:if>
	<c:if test="${pageNum < maxpage }"><a href="javascript:lists(${pageNum+1})"  class="w3-button w3-black" style="text-decoration: none;">Next</a></c:if>
	</td>
	</tr>
	</c:if>
	<tr><td colspan="5"><a href="writeForm.all?boardtype=${boardtype}"  class="w3-button w3-black" style="text-decoration: none;">Write</a></td></tr>

</table>

<form action="list.all" method="post" name="sf" class="w3-center">
  <input type="hidden" name="pageNum" value="1">
  <input type="hidden" name="boardtype" value="${boardtype}">
  <select name="column">
    <option value="">선택하세요</option>
    <option value="nickname">작성자</option>
    <option value="title">제목</option>
   </select>
   <script type="text/javascript">
     document.sf.column.value="${param.column}";
   </script>
   <input type="text" name="find" size="50" value="${find}">
   <input type="submit" value="search" class="w3-button w3-black" style="text-decoration: none;">
 </form>
</div>
</c:if>
</body>
</html>