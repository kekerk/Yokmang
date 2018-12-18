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
 <caption>���</caption>
 <c:if test="${boardcount==0}">
 <tr><td colspan="5">��ϵ� �Խñ��� �����ϴ�.</td></tr>
 </c:if>
 <c:if test="${boardcount!=0}">
 <tr><td colspan="5" align="right">�� ���� : ${boardcount}</td></tr>
 <tr align="center" valign="middle">
   <th width="8%">��ȣ</th>
   <th width="8%">����</th>
   <th width="50%">����</th>
   <th width="14%">�ۼ���</th>
   <th width="17%">��¥</th>
   <th width="11%">��ȸ��</th></tr>
   
   <c:forEach var="b" items="${list}">
   <tr align="center" valign="middle">
     
    <td>${boardnum}</td>
    <c:set var="boardnum" value="${boardnum-1}"/>
    <td align="left">
<%-- b.file1 == null || b.file1 == ''  => (empty�� �� ���� ��밡��) ÷������ ���� ���� --%>
    <c:if test="${!empty b.file1}">
    <a href="file/${b.file1}" style="text-decoration: none;">@</a></c:if>
    <c:if test="${empty b.file1}"></c:if>
    <%-- ��� ���� ���� --%>
    <c:if test="${b.reflevel>0}">
     <c:forEach var="i" begin="1" end="${b.reflevel}">&nbsp;&nbsp;&nbsp;</c:forEach>
    ��</c:if>
    <%-- info.bo : num �Ķ���Ϳ� �ش��ϴ� �Խù��� db���� ��ȸ�ϱ�
         info.jsp�� �ش��ϴ� �Խù��� --%>
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
    <%--������ �κ� ����ϱ�--%>
 <tr align = "center"><td colspan="5"><font size="3pt">
<c:if test="${pageNum <=1}">[����]</c:if>
<c:if test="${pageNum > 1}">
 <a href="javascript:listcall(${pageNum	 - 1})">[����]</a>
 </c:if>
 
 <c:forEach var="a" begin="${startpage}" end ="${endpage}">
  <c:if test="${a==pageNum}">[${a}]</c:if>
  <c:if test="${a!=pageNum }">
   <a href="javascript:listcall(${a})">[${a}]</a></c:if>
 </c:forEach> 
 
 <c:if test="${pageNum>=maxpage}">[����]</c:if>
 <c:if test="${pageNum < maxpage}">
 <a href="javascript:listcall(${pageNum + 1})">[����]</a>
 </c:if>
 </font></td></tr></c:if>
 <tr>
 <td colspan ="6" valign="middle" align="right" ><font size="3pt"><a href = "writeForm.bo#d">[�۾���]</a>
</font></td></tr>
</table>
<div class="w3-center">
  <form action="list.bo" method="post" name="sf">
  <input type="hidden" name="pageNum" value="1">
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
</body></html>