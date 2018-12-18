<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품 삭제 전 확인</title>
<style type="text/css">
table {
	width: 90%;
	border-collapse: collapse;
}

th, td {
	border: 3px solid #bcbcbc;
	text-align: center;
	padding: 8px;
}

th {
	background-color: #4CAF50;
	color: white;
	text-align: center;
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
	<h2>상품 삭제 전 확인하기</h2>
	<table>
		<tr>
			<td><img src="../picture/${item.pictureUrl}" width="200"
				height="250"></td>
			<td align="center">
				<table>
					<tr>
						<td width="80">상품명</td>
						<td>${item.name}</td>
					</tr>
					<tr>
						<td width="80">가격</td>
						<td>${item.price}</td>
					</tr>
					<tr>
						<td width="80">상품내용</td>
						<td>${item.description}</td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="삭제"
							onclick="location.href='delete.shop?id=${item.id}'">&nbsp;
							<input type="button" value="상품목록"
							onclick="location.href='list.shop'">&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>