<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta charset="EUC-KR">
<title>추천</title>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link href="/drink/Simple-jQuery-Star-Rating-System-For-Bootstrap-3/css/star-rating.css" media="all" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/drink/Simple-jQuery-Star-Rating-System-For-Bootstrap-3/js/star-rating.js" type="text/javascript"></script>
</head>
<body>
<table border="1" style="border-collapse:collapse;" class="w3-table-all">
  <tr>
  <th>랭킹</th><th>별점</th>
  <th>사진</th><th>내용</th></tr>
  <c:forEach var="list" items="${list}" varStatus="a">
  <c:set var="content" value="${list.content}"/>
  <tr>
   <td style="width:60px; font-weight:bold;"><p>${1+a.index}</p></td>
   <td style="width:15px;"><br><input type="text" class="rating rating-loading" value="${list.avg}" data-size="s" readonly="readonly"></td>
   <td style="width:100px; height:100px;"><a href="info.bo?num=${list.num}"><img src="img/${list.file1}" style="width:100px; height:100px;"></a></td>
   <td colspan="6" style="font-size:12pt;"><p>${fn:substring(content,0,9)}...</p></td>
   </tr>
   </c:forEach>
</table>
</body>
</html>