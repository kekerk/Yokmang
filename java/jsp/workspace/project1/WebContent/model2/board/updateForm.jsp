<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function file_delete(){
	document.f.file2.value="";
	file_desc.innerHTML = "";
	
}
</script>
<meta charset="EUC-KR">
<title>model2 �Խñ� ����</title>
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
<form action = "update.bo" name="f" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${board.num}">
	<input type="hidden" name="file2" value="${board.file1}">
	<table border="1" style="border-collapse : collapse;"  class="w3-table-all">
	<caption>model2 �Խ��� ���� ȭ��</caption>
	<tr>
		<td align="center">�ۼ���</td>
		<td><input type="text" name="name" value="${board.name }" readonly></td>
	</tr>
	<tr>
		<td align="center">��й�ȣ</td>
		<td><input type="password" name="pass" ></td>
	</tr>
	<tr>
		<td align="center">����</td>
		<td><input type="text" name="title" value="${board.title}" ></td>
	</tr>		
	<tr>
		<td align="center">����</td>
		<td><textarea rows="15" cols="80" name="content">${board.content}</textarea></td>
	</tr>
	<tr>
		<td align="center">÷������</td>
	<td>
		<c:if test="${!empty board.file1}">
		
		<div id ="file_desc">${board.file1}<a href="javascript:file_delete()">[÷�����ϻ���]</a></div>
		
		</c:if>
	<input type="file" name="file1"></td>
	</tr>
	<tr>
		<td colspan="3" align="center"><a href="javascript:document.f.submit()">[�Խù�����]</a>
		</td>
	</tr>	
</table>
</form>
</div>
</body>
</html>