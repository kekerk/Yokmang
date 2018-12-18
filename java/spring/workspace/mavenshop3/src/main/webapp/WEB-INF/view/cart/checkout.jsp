<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>주문 전 상품 목록 보기</title>
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
	<h2>배송지 정보</h2>
	<table>
		<tr>
			<td width="30%" class="title">구매자 ID</td>
			<td width="70%">${sessionScope.loginUser.userId}</td>
		</tr>
		<tr>
			<td width="30%" class="title">이름</td>
			<td width="70%">${sessionScope.loginUser.userName}</td>
		</tr>
		<tr>
			<td width="30%" class="title">우편번호</td>
			<td width="70%">${sessionScope.loginUser.postcode}</td>
		</tr>
		<tr>
			<td width="30%" class="title">주소</td>
			<td width="70%">${sessionScope.loginUser.address}</td>
		</tr>
		<tr>
			<td width="30%" class="title">전화번호</td>
			<td width="90%">${sessionScope.loginUser.phoneNo}</td>
		</tr>
		<tr>
			<td width="30%" class="title">이메일</td>
			<td width="90%">${sessionScope.loginUser.email}</td>
		</tr>
	</table>
	<br>
	<br>
	<h2>구매할 상품 목록</h2>
	<table>
		<tr>
			<td>상품명</td>
			<td>상품가격</td>
			<td>수량</td>
			<td>총액</td>
		</tr>
		<c:forEach items="${sessionScope.CART.itemSetList}" var="itemSet">
			<tr>
				<td>${itemSet.item.name}</td>
				<td>${itemSet.item.price}원</td>
				<td>${itemSet.quantity}</td>
				<td>${itemSet.item.price * itemSet.quantity}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" style="text-align: right;">총금액 : 
			<%-- ${CART.totalAmount} : Cart 객체의 getTotalAmount() 메서드 호출됨 --%>
			<fmt:formatNumber value="${CART.totalAmount}" pattern="#,###"/>원
			</td>
		</tr>
		<tr>
			<td colspan="4" >
				<a href="end.shop">주문확정</a>&nbsp;
				<a href="../item/list.shop">상품목록</a>
			</td>
		</tr>
	</table>
</body>
</html>