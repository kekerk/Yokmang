<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%request.setCharacterEncoding("euc-kr"); %>
<html>
<head>
<meta charset="EUC-KR">
<title>LIST</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script>
  function listcall(page){
	  document.sf.pageNum.value=page;
	  document.sf.submit();
  }
</script>
<style>
  caption{
    font-weight: bold;
    font-size: 24pt;
  }
  table{
      width : 100%;
      height : inherit;
      position : relative;
  }
</style>
</head>
<body>
<table border="1" style="border-collapse: collapse;" class="w3-table-black w3-large">
 <caption>목록</caption>
 <c:if test="${boardcount==0}">
 <tr><td colspan="5">등록된 게시글이 없습니다.</td></tr>
 </c:if>
 <c:if test="${boardcount!=0}">
 <tr><td colspan="5" align="right">글 개수 : ${boardcount}</td></tr>
 <tr align="center" valign="middle">
   <th width="8%">번호</th>
   <th width="8%">사진</th>
   <th width="50%">제목</th>
   <th width="14%">작성자</th>
   <th width="17%">날짜</th>
   <th width="11%">조회수</th></tr>
   
   <c:forEach var="b" items="${list}">
   <tr align="center" valign="middle">
     
    <td>${boardnum}</td>
    <c:set var="boardnum" value="${boardnum-1}"/>
    <td align="left">
<%-- b.file1 == null || b.file1 == ''  => (empty로 한 번에 사용가능) 첨부파일 여부 검증 --%>
    <c:if test="${!empty b.file1}">
    <a href="file/${b.file1}" style="text-decoration: none;">@</a></c:if>
    <c:if test="${empty b.file1}"></c:if>
    <%-- 답글 여부 검증 --%>
    <c:if test="${b.reflevel>0}">
     <c:forEach var="i" begin="1" end="${b.reflevel}">&nbsp;&nbsp;&nbsp;</c:forEach>
    └</c:if>
    <%-- info.bo : num 파라미터에 해당하는 게시물을 db에서 조회하기
         info.jsp에 해당하는 게시물을 --%>
    <a href="info.bo?num=${b.num}">${b.title}</a></td>
    <td>${b.name}</td>
    <td>
    <jsp:useBean id="today" class="java.util.Date"/>
    <fmt:formatDate value="${today}" pattern="yy/MM/dd" var="todays"/>
    <fmt:formatDate value="${b.regdate}" pattern="yy/MM/dd" var="date"/>
    <c:choose>
    <c:when test="${date==todays}">
     <fmt:formatDate value="${b.regdate}" pattern="HH:mm:ss"/>
     </c:when>
     <c:when test="${date!=todays}">
     <fmt:formatDate value="${b.regdate}" type="both"/>
     </c:when>
     </c:choose>
    </td>
    <td>${b.readcnt}</td>
    </tr> </c:forEach>
    <%--페이지 부분 출력하기--%>
 <tr align = "center"><td colspan="5"><font size="3pt">
<c:if test="${pageNum <=1}">[이전]</c:if>
<c:if test="${pageNum > 1}">
 <a href="javascript:listcall(${pageNum	 - 1})">[이전]</a>
 </c:if>
 
 <c:forEach var="a" begin="${startpage}" end ="${endpage}">
  <c:if test="${a==pageNum}">[${a}]</c:if>
  <c:if test="${a!=pageNum }">
   <a href="javascript:listcall(${a})">[${a}]</a></c:if>
 </c:forEach> 
 
 <c:if test="${pageNum>=maxpage}">[다음]</c:if>
 <c:if test="${pageNum < maxpage}">
 <a href="javascript:listcall(${pageNum + 1})">[다음]</a>
 </c:if>
 </font></td></tr></c:if>
 <tr>
 <td colspan ="6" valign="middle" align="right" ><font size="3pt"><a href = "writeForm.bo#d">[글쓰기]</a>
</font></td></tr>
</table>
<div class="w3-center">
  <form action="list.bo" method="post" name="sf">
  <input type="hidden" name="pageNum" value="1">
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
</body></html>