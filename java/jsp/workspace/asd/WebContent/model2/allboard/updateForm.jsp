
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
<title>�Խñ� ����</title>
<style type="text/css">
caption {
	font :bold;
	font-size: x-large;
}
</style>
</head>
<body>

<div style="margin: 50px; padding: 25px;" align="center">
<form action = "update.all?boardtype=${allboard.boardtype}" name="f" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value="${allboard.no}">
	<input type="hidden" name="file2" value="${allboard.file1}">
	<c:if test="${param.boardtype==3}">
	<input type="hidden" name="dormi" value="${param.dormi}">
	</c:if>
	<table border="1" style="border-collapse : collapse;"  class="w3-table-all w3-centered">
	<c:if test="${param.boardtype ==1 }">
	<caption>����� �� �ı� �Խù� ����</caption>
	</c:if>
	<c:if test="${param.boardtype ==2 }">
	<caption>������ �Խù� ����</caption>
	</c:if>
	<c:if test="${param.boardtype ==3 }">
	<c:if test="${sessionScope.dormi =='Gryffindor' }">
	<caption>�׸��ɵ��� �Խù� ����</caption>
	</c:if>
	<c:if test="${sessionScope.dormi =='Slytherin' }">
	<caption>�������� �Խù� ����</caption>
	</c:if>
	<c:if test="${sessionScope.dormi =='Hufflepuff' }">
	<caption> ����Ǫ�� �Խù� ����</caption>
	</c:if>
	<c:if test="${sessionScope.dormi =='Ravenclaw' }">
	<caption> ����Ŭ�� �Խù� ����</caption>
	</c:if>
	</c:if>
	<c:if test="${param.boardtype ==3 }">
	<caption> ���� �Խù� ����</caption>
	</c:if>
	<tr>
		<td colspan="2">�ۼ��� : <input type="text" name="nickname" value="${allboard.nickname}" readonly></td>
		<td colspan="2">÷������ : <div id ="file_desc">${allboard.file1}<c:if test="${param.boardtype == 3 or param.boardtype == 4}"><a href="javascript:file_delete()">[÷�����ϻ���]</a></c:if></div>
	</tr>
	<tr>
		<td colspan="2">���� : <input type="text" name="title" value="${allboard.title}" ></td>
		<td colspan="2">��й�ȣ : <input type="password" name="password" value="${allboard.password}"></td>
	</tr>
	<tr>
		<td colspan="4"><textarea rows="15" cols="80" name="content">${allboard.content}</textarea></td>
	</tr>
	<tr>
		<td colspan="2">÷������ <input type="file" name="file1"></td>
		<td><a href="javascript:document.f.submit()" style="text-decoration:none;">[�Խù�����]</a></td>
		<c:if test="${param.boardtype==3}">
		<td><a href="list.all?boardtype=${param.boardtype}&dormi=${param.dormi}" style="text-decoration:none;">[���]</a></td>
	    </c:if>
		<c:if test="${param.boardtype!=3}">
		<td><a href="list.all?boardtype=${param.boardtype}" style="text-decoration:none;">[���]</a></td>
	    </c:if>
	</tr>
</table>
</form>
</div>
</body>
</html>