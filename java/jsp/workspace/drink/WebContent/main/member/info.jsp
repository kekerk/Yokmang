<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ����</title>
</head>
<body>
 <input type ="hidden" name="picture" value="">
 <table style="border-collapse:collapse;" class="w3-table-all w3-large">
 <caption>���� ������</caption>
  <tr>
  <td colspan="6" rowspan="7"><img src="img/${mem.picture}" style="width:300px; height:300px;" id="pic">
  <br></td>
   <td>���̵� :</td><td> ${mem.id}</td></tr>
   <tr><td>�̸� :</td><td> ${mem.name}</td></tr>
   <tr><td>�ַ� :</td><td> ${mem.max}</td></tr>
   <tr><td>��ȭ��ȣ :</td><td> ${mem.tel}</td></tr>
   <tr><td>������� : </td><td> ${mem.birthday}</td></tr>
   <tr><td>�ּ� : </td><td> ${mem.addr}</td></tr>
   <tr><td colspan="6" align="center"><a href ="main.jsp">[����������]</a> 
   <a href ="updateForm.me?id=${mem.id}">[����]</a>
<c:if test="${mem.id != 'admin'}">
   <a href ="deleteForm.me?id=${mem.id}">[Ż��]</a>
</c:if>
</td></tr></table></body></html>