<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session을 이용한 상품 선택하기</title>
</head>
<body>
<h2>상품 선택</h2>
<form name="f" method="post" action="sessionadd.jsp">
	<select name="product">
		<option>사과</option>
		<option>귤</option>
		<option>자몽</option>
		<option>레몬</option>
		<option>딸기</option>
		<option>배</option>
	</select>
	<input type="submit" value="장바구니 추가">
<a href="sessiontot.jsp">계산하기</a>
</form>
</body>
</html>