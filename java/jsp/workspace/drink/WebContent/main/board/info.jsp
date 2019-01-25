<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<html>
<%--
   - BoardAllAction.info �޼��� ����
   1. num �Ķ���͸� �̿��Ͽ� db���� �ش� �Խù� ������ ��ȸ
      Board BoardDao.selectOne(num)
   2. readcnt ���� +1�� �����ϱ�.
      Board BoardDao.readcntadd(num)
      - info.jsp�� ��� : jstl�� el�� ����
   3. Board�� ������ ȭ�鿡 ����ϱ�
 --%>
<head>
<style>
  caption{
    font-weight: bold;
    font-size: 20pt;
  }
</style>
<meta charset="EUC-KR">
<title>�Խù� �� ����</title>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link href="/drink/Simple-jQuery-Star-Rating-System-For-Bootstrap-3/css/star-rating.css" media="all" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/drink/Simple-jQuery-Star-Rating-System-For-Bootstrap-3/js/star-rating.js" type="text/javascript"></script>

</head>

<body>
<input type="hidden" name= "code" value="${param.code}">
<input type="hidden" name="num" value="${param.num}">
<table border = "1" style ="border-collapse: collapse;" class="w3-table-all">
 <caption>ABOUT</caption>
 <tr><td rowspan="5" style="width:350px; height:550px;"><img src="img/${b.file1}" style="width:350px;height:550px;"></td></tr>
  <tr><td>�۾��� : ${b.name}</td></tr>
  <tr><td>���� : ${b.title}</td></tr>
  <tr><td>����</td></tr>
  <tr><td rowspan="7">${b.content}</td></tr>
  <tr><td colspan="2">
  <c:if test="${sessionScope.login =='admin' }">
    <a href="updateForm.bo?num=${b.num}">[����]</a>
    <a href="delete.bo?num=${b.num}&code=${b.code}">[����]</a>
    </c:if>
    <a href="list.bo?code=${b.code}">[���]</a></td></tr></table>
<form action="reply.bo" name="rp" method="post">
<input type="hidden" name="num" value="${b.num}">
<table border="1" style="border-collpase:collapse;" class="w3-table-all">
  <caption>���</caption>
 <tr>
 <th>����</th><th>���̵�</th><th>����</th></tr>
 <tr>
 <td align="center" style="width:10%;"><input type="text" class="rating rating-loading" name="rating" value="${review.rating}" data-size="s"></td>
  <td align="center" style="width:10%;"><input type="text" name="rname" value="${sessionScope.login}" readonly="readonly"></td>
   <td>
   <textarea rows="5" cols="100" name="rcontent"></textarea>
   <c:if test="${sessionScope.login != null}">
   <button type="submit" class="btn btn-primary">���</button>
   </c:if>
   </td></tr>
</table>
</form>
<form action="rdelete.bo" method="post">
  <c:forEach var="rlist" items="${rlist}">
<input type="hidden" name="rnum" value="${rlist.rnum}">
<table border = "1" style="border-collapse: collapse;" class="w3-table-all">
 <tr>
  <td align="center" style="width:1.5%;"><input type="text" class="rating rating-loading" value="${rlist.rating}" data-size="s" readonly="readonly"></td>
  <td align="center" style="width:6.8%;"><font size="3pt">${rlist.rname}</font></td>
   <td align="center" style="width:25%;"><font size="3pt">${rlist.rcontent}</font></td>
   <td style="width:5%;">
   <c:if test="${sessionScope.login != null}">
   <input type="submit" class="btn btn-primary" value="����">
   </c:if>
   </td>
   </tr>
</table>
</c:forEach>
</form>
</body>
</html>