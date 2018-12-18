<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 정보</title>
</head>
<body>
 <input type ="hidden" name="picture" value="">
 <table style="border-collapse:collapse;" class="w3-table-all w3-large">
 <caption>마이 페이지</caption>
  <tr>
  <td colspan="6" rowspan="7"><img src="img/${mem.picture}" style="width:300px; height:300px;" id="pic">
  <br></td>
   <td>아이디 :</td><td> ${mem.id}</td></tr>
   <tr><td>이름 :</td><td> ${mem.name}</td></tr>
   <tr><td>주량 :</td><td> ${mem.max}</td></tr>
   <tr><td>전화번호 :</td><td> ${mem.tel}</td></tr>
   <tr><td>생년월일 : </td><td> ${mem.birthday}</td></tr>
   <tr><td>주소 : </td><td> ${mem.addr}</td></tr>
   <tr><td colspan="6" align="center"><a href ="main.jsp">[메인페이지]</a> 
   <a href ="updateForm.me?id=${mem.id}">[수정]</a>
<c:if test="${mem.id != 'admin'}">
   <a href ="deleteForm.me?id=${mem.id}">[탈퇴]</a>
</c:if>
</td></tr></table></body></html>