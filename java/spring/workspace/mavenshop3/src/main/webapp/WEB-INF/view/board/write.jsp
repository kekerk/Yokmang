<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 글쓰기</title>
<style type="text/css">
table {
	width: 90%;
	border-collapse: collapse;
}

th, td {
	border: 3px solid #bcbcbc;

	padding: 8px;
}

th {
	background-color: #4CAF50;
	color: white;

}

td {
	background-color: #f2f2f2;
}

td.title {
	background-color: #e2e2e2;
	color: blue;
}
</style>
</head>
<body>
<form:form modelAttribute="board" action="write.shop" enctype="multipart/form-data" name="f">
	<table border="1" style="border-collapse: collapse; width:100%;">
		<tr>
			<td align="center">글쓴이</td>
			<td><form:input path="name"/><font color="red"><form:errors path="name"/></font></td>
		</tr>
		<tr>
			<td align="center">비밀번호</td>
			<td><form:password path="pass"/><font color="red"><form:errors path="pass"/></font></td>
		</tr>			
		<tr>
			<td align="center">제목</td>
			<td><form:input path="subject"/><font color="red"><form:errors path="subject"/></font></td>
		</tr>		
		<tr>
			<td align="center">내용</td>
			<td><form:textarea path="content" rows="15" cols="80"/><font color="red"><form:errors path="content"/></font></td>
		</tr>	
		<tr>
			<td align="center">첨부파일</td>
			<td><input type="file" name="file1"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="javascript:document.f.submit()">[게시물 등록]</a>
				<a href="list.shop">[게시물목록]</a>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>