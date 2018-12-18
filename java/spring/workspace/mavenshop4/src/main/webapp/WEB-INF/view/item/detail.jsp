<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
 <%-- /WEB-INF/view/item/detail.jsp --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ �� ����</title>
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
<h2>��ǰ �� ����</h2>
<table>
	<tr>
		<td><img src="../picture/${item.pictureUrl}" width="200" height="250"></td>
		<td align="center">
			<table>
				<tr><td width="80">��ǰ��</td><td>${item.name}</td></tr>
				<tr><td width="80">����</td><td>${item.price}</td></tr>
				<tr><td width="80">��ǰ����</td><td>${item.description}</td></tr>
				<tr><td colspan="2" align="center">
						<%-- ���� URL : /mavenshop3/item/detail.shop
							 ../cart/cartAdd.shop : ��Ű�� ��ü�� �ٲ��� �Ѵ�.
						 --%> 
						<form action="../cart/cartAdd.shop">
						<input type="hidden" name="id" value="${item.id}">
						<table>
							<tr>
								<td>
									<select name="quantity">
									<c:forEach begin="1" end="10" var="i"><option>${i}</option></c:forEach>
									</select>
								</td>
								<td>
									<input type="submit" value="��ٱ���">
									<input type="button" value="��ǰ���" onclick="location.href='list.shop'">
								</td>
							</tr>
						</table>
					</form>
			</table>
		</td>
	</tr>
</table>
</body>
</html>