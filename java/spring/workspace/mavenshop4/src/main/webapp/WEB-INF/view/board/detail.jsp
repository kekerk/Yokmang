<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խù� �󼼺���</title>
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
	<table border="1" style="border-collapse: collapse; width:100%;">
		<tr>
			<td align="center" width="20%">�۾���</td>
			<td width="80%">${board.name}</td>
		</tr>		
		<tr>
			<td align="center" width="20%">����</td>
			<td width="80%">${board.subject}</td>
		</tr>		
		<tr>
			<td align="center" width="20%">����</td>
			<td width="80%" align="center"><table width="100%" height="250"><tr><td>${board.content}</td></tr></table>
			</td>
		</tr>	
		<tr>
			<td align="center" width="20%">÷������</td>
			<td width="80%">
				<c:if test="${!empty board.fileurl}">
				<a href="../file/${board.fileurl}">${board.fileurl}</a>
				</c:if>
				<c:if test="${empty board.fileurl }">
				[���� ����]
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="reply.shop?num=${board.num}">[�亯]</a>
				<a href="update.shop?num=${board.num}">[����]</a>
				<a href="delete.shop?num=${board.num}">[����]</a>
				<a href="list.shop">[�Խù����]</a>
			</td>
		</tr>
	</table>

</body>
</html>