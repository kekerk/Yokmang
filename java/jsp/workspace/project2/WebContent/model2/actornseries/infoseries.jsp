<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("euc-kr");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<title>Series brief</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
#info {
	border: 1px solid silver;
	margin: 3%;
	padding: 2%;
	width: 95%;

}

#posimg {
	width: 70%;
	vertical-align: middle;
	margin-top: 63px;
	margin-left: 30px;
}

.text {
	margin-top: 20px;
}
</style>
</head>
<body>
	<div style="margin-top: 5%;">
		<form method="post" name="f">
			<table border="1" style="border-collapse: collapse;"
				class="w3-table-all w3-hoverable w3-centered">
				<tr align="center" valign="middle">
					<c:forEach var="b" items="${list}">
						<td align="center"><a
							href="${path}/model2/actornseries/infoseries.ans?seriesno=${b.seriesno}" style="text-decoration: none;">
								${b.posname}</a></td>
					</c:forEach>
				</tr>

				<tr>
					<td colspan="5"><c:if test="${pageNum<=1 }"><p class="w3-button w3-black">Previous</p></c:if> <c:if
							test="${pageNum >1 }">
							<a href="listseries.ans?pageNum=${pageNum-1}" class="w3-button w3-black" style="text-decoration: none;">Previous</a>
						</c:if> <c:forEach var="a" begin="${startpage}" end="${endpage}">
							<c:if test="${a==pageNum}"><p class="w3-button w3-black">${a}</p></c:if>
							<c:if test="${a!=pageNum }">
								<a href="listseries.ans?pageNum=${a}" class="w3-button w3-black" style="text-decoration: none;">${a}</a>
							</c:if>
						</c:forEach> <c:if test="${pageNum >= maxpage}"><p class="w3-button w3-black">Next</p></c:if> <c:if
							test="${pageNum < maxpage }">
							<a href="listseries.ans?pageNum=${pageNum+1}" class="w3-button w3-black" style="text-decoration: none;">Next</a>
						</c:if></td>
				</tr>
			</table>
		</form>
	</div>
	<form method="post" name="avg">
		<div id="info" class="w3-row">
			<c:if test="${series != null }">
				<div class="w3-third w3-center">
					<img
						src="${path}/model2/actornseries/img/series/${series.posimage}"
						id="posimg">
					<div>감독 : ${series.moviedirector}</div>
					<div>개요 : ${series.outline}</div>
					<div>
						<p>
							네티즌 평점 :
							<fmt:formatNumber value="${series.onlinescore}" pattern="0.00" />
						</p>
					</div>
<!-- 					<div>
						평점 : <input type="text" name="avgscore" readonly>
					</div> -->
				</div>
				<div class="w3-twothird text w3-center">
					<h4>
						<strong>${series.posname}</strong>
					</h4>
					<hr style="border: 2px solid silver;">
					<h5>줄거리</h5>
					<div>
						<textarea cols="68" rows="15" readonly>${series.poscontent}</textarea>
					</div>
					<div class="w3-row">
						<!-- <div class="w3-half">
							<input type="text" name="posscore" value="평점등록">
							<button onclick="javascript:avg(this)">등록</button>
						</div> -->
						<div class="w3-center " style="height:30px;">
							<a href="${path}/model2/allboard/writeForm.all?boardtype=1&seriesno=${series.seriesno}" class="w3-button w3-black" style="text-decoration: none;">명장면 및 후기 게시물 등록</a>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${series == null }">
				<div class="w3-center">
					<h3>시리즈를 선택해주세요</h3>
				</div>
			</c:if>
		</div>
	</form>
</body>
</html>