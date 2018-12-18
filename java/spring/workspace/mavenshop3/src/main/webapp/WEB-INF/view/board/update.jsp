<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խù� ����</title>
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
<script type="text/javascript">
function file_delete(){
	document.f.file2.value="";
	file_desc.style.display = "none";
}
</script>
</head>
<body>
<form:form modelAttribute="board" action="update.shop" enctype="multipart/form-data" name="f">
	<input type="hidden" name="num" value="${board.num}">
	<input type="hidden" name="file2" value="${board.fileurl}">
	<table border="1" style="border-collapse: collapse; width:100%;">
		<tr>
			<td colspan="2" align="center">Spring �Խ��� ����</td>
		</tr>
		<tr>
			<td>�۾���</td><td><form:input path="name"/>
			<font color="red"><form:errors path="name"/></font></td>
		</tr>
		<tr>
			<td>��й�ȣ</td><td>
			<form:password path="pass"/>
			<font color="red"><form:errors path="pass"/></font>
			<spring:hasBindErrors name="board">
			<font color="red">
				<c:forEach items="${errors.globalErrors}" var="error">
					<spring:message code ="${error.code}" />
				</c:forEach>
			</font>
			</spring:hasBindErrors>	
			</td>
		</tr>
		<tr>
			<td>����</td><td><form:input path="subject"/>
			<font color="red"><form:errors path="subject"/></font></td>
		</tr>
		<tr>
			<td>����</td><td><form:textarea cols="80" rows="15" path="content"/>
			<font color="red"><form:errors path="content"/></font></td>
		</tr>
		<tr>
			<td>÷������</td>
			<td>
				<c:if test="${!empty board.fileurl}">
				<div id="file_desc">
					<a href="../file/${board.fileurl}">${board.fileurl}</a>
					<a href="javascript:file_delete()">[÷�����ϻ���]</a>
				</div>
				</c:if>
				<input type="file" name="file1">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="javascript:document.f.submit()">[�Խù� ����]</a>
				<a href="list.shop">[�Խù� ���]</a>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>