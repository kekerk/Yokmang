<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>장바구니 목록</title>
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
<h2>장바구니 목록</h2>
<table>
	<tr><td colspan="5"><font color="green">장바구니 상품 목록</font></td></tr>
	<tr><td>상품명</td><td>가격</td><td>수량</td><td>합계</td><td>비고</td></tr>
	<c:set var="tot" value="${0}"/>
	<c:forEach items="${cart.itemSetList}" var="itemSet" varStatus="stat">
		<tr><td>${itemSet.item.name}</td><td>${itemSet.item.price}</td><td>${itemSet.quantity}</td><td>${itemSet.item.price * itemSet.quantity}</td>
		<td><a href="cancel.shop?index=${stat.index}">취소</a></td></tr>
		<c:set var="tot" value="${tot+(itemSet.item.price*itemSet.quantity)}"/>
	</c:forEach>
	<tr><td colspan="5"><font color="green">총구입 금액 : ${tot}원</font></td></tr>
</table>
<br>${message}<br><a href="../item/list.shop">상품목록</a>&nbsp;&nbsp;<a href="checkout.shop">주문하기</a>
</body>
</html>