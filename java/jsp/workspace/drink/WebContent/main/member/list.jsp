<%@page import="java.util.List"%>
<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
  caption{
     font-size:20pt;
     font-weight:bold;
  }
</style>
<meta charset="EUC-KR">
<title>회원 목록 보기</title>
</head>
<body>
<table  class="w3-table-all w3-large">
 <caption>술고래들</caption>
  <tr><th>사진</th><th>아이디</th><th>이름</th><th>주량</th><th>전화번호</th><th>주소</th><th>생일</th>
  <th>&nbsp;</th><th>&nbsp;</th></tr>
  <c:forEach var="list" items="${list}">
  <tr>
   <td><img src="img/sm_${list.picture}" style="width:50px; height:50px;"></td>
   <td><a href ="info.me?id=${list.id}">${list.id}</a></td>
   <td>${list.name}</td><td>${list.max}</td><td>${list.tel}</td>
   <td>${list.addr}</td><td>${list.birthday}</td>
   <td><a href="updateForm.me?id=${list.id}">[수정]</a>
   <td><a href="deleteForm.me?id=${list.id}">[강제 탈퇴]</a></td>
   </tr>
   </c:forEach>
</table>
</body>
</html>