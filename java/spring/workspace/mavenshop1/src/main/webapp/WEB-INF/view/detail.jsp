<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>상품 상세 보기</title>
</head>
<body>
	<h2>상품 상세 보기</h2>
	<table>
		<tr>
			<td><img src="img/${item.pictureUrl}"></td>
			<td><table>
				<tr>
					<td>상품명</td>
					<td>${item.name}</td>
				</tr>	
				<tr>
					<td>가격</td>
					<td>${item.price}</td>
				</tr>	
				<tr>
					<td>상품설명</td>
					<td>${item.description}</td>
				</tr>
				<tr>
					<td colspan="2"><a href="index.shop">상품목록</a></td>
				</tr>
			</table></td>
		</tr>
	</table>
</body>
</html>