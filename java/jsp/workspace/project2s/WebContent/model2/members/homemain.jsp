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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<title>Main</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	function seriesinfo(no) {
	location.href = "${path}/model2/actornseries/infoseries.ans?seriesno="+no;
	}
</script>
<style>
.video iframe {
	padding: 20px;
	width: 100%;
	height: 500px;
}

.inmain {
	height: 500px;
	margin: 20px;
}
</style>
</head>
<body>
	<c:if test="${empty sessionScope.login}">
		<div class="video">
			<iframe width="560" height="315" src="https://www.youtube.com/embed/MMnSN1m98mE" frameborder="0" allow="autoplay; encrypted-media"></iframe>
		</div>
	</c:if>
	<c:if test="${!empty sessionScope.login}">
		<div class="inmain" style="width:100%;">
			<div>
			</div>
			<div style="margin:5%;">
				<h2 class="w3-center">Rank</h2>
				<c:forEach var="listseries" items="${serieslist}">
						<div class="w3-third w3-center" style="border:1px solid silver; padding:10px;" >
							<a href="javascript:seriesinfo(${listseries.seriesno})"><img src="${path}/model2/actornseries/img/series/${listseries.posimage}" style="width: 150px; height: 200px;"></a>
							<p style="font-family:"><strong>${rank-8}</strong>[게시물 수 :<fmt:formatNumber value="${listseries.seriescnt}" pattern="0" />]</p>
							<c:set var="rank" value="${rank+1}"/>
						</div>
					
				</c:forEach>
			</div>
		</div>
	</c:if>
	<div class="w3-row" style="marign-top:5%;">
		<div class="w3-half">
			<a href="http://hpwishlist.warnerbros.com/"><img src="homepage/homepage1.jpg" style="margin-bottom: 10px; padding-right: 10px;" width="100%"></a>
		</div>
		<div class="w3-half">
			<a href="http://www.harrypotterclub.co.kr/"><img src="homepage/homepage2.jpg" width="100%" style="margin-top: 10px;"></a>
			<a href="http://www.mrharrypotter.com/"><img src="homepage/homepage3.jpg" width="100%" style="margin-top: 10px; margin-bottom: 10px;"></a>
		</div>
	</div>
</body>
</html>