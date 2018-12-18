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
<title>Actor brief</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
#info {
	border: 1px solid silver;
	margin: 3%;
	padding: 2%;
	width:80%;
	margin-left : 10%;
}

#actorimg {
	width: 70%;
	vertical-align: middle;
	margin-left : 30px;
}
.text{
margin-top : 20px;
}
</style>
<script type="text/javascript">
function slide(){
	var img = "${actor.actorimg}"
	var op = "width=1000px; height=700px;";
	window.open("slides.jsp?img="+img,"",op);
}
</script>
</head>
<body>
	<div style="margin-top:5%;">
		<form method="post" name="f">
			<table border="1" style="border-collapse: collapse;"
				class="w3-table-all w3-centered">
				<tr>
					<c:forEach var="b" items="${list}">
						<c:if test="${b.no == 1 or b.no ==2 or b.no ==3 or b.no ==5 or b.no ==6 or b.no ==7 or b.no ==9 or b.no ==13 or b.no ==27 or b.no ==48 }">
						<td><a href="${path}/model2/actornseries/infoact.ans?no=${b.no}" style="text-decoration: none;"><strong>${b.actorname}</strong></a></td>
					</c:if>
					<c:if test="${b.no != 1 and b.no != 2 and b.no != 3 and b.no !=5 and b.no !=6 and b.no !=7 and b.no !=9 and b.no !=13 and b.no !=27 and b.no !=48 }">
						<td><a href="${path}/model2/actornseries/infoact.ans?no=${b.no}" style="text-decoration: none;">${b.actorname}</a></td>
					</c:if>
					</c:forEach>
				</tr>

				<tr>
					<td colspan="5"><c:if test="${pageNum<=1 }"><p class="w3-button w3-black">Previous</p></c:if> <c:if
							test="${pageNum >1 }">
							<p class="w3-button w3-black"><a href="listact.ans?pageNum=${pageNum-1}" style="text-decoration: none;">Previous</a></p>
						</c:if> <c:forEach var="a" begin="${startpage}" end="${endpage}">
							<c:if test="${a==pageNum}"><p class="w3-button w3-white">${a}</p></c:if>
							<c:if test="${a!=pageNum }">
								<p class="w3-button w3-black"><a href="listact.ans?pageNum=${a}" style="text-decoration: none;">${a}</a></p>
							</c:if>
						</c:forEach> <c:if test="${pageNum >= maxpage}"><p class="w3-button w3-black">Next</p></c:if> <c:if
							test="${pageNum < maxpage }">
							<p class="w3-button w3-black"><a href="listact.ans?pageNum=${pageNum+1}" style="text-decoration: none;">Next</a></p>
						</c:if></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="info" class="w3-row" >
		<c:if test="${actor != null }">
			<div class="w3-third w3-center">
				<c:if test="${actor.actorimg == 'Scamander.jpg' or actor.actorimg == 'harry.jpg' or actor.actorimg == 'Hermione.jpg' or actor.actorimg == 'ron.jpg'or actor.actorimg == 'Dumbledore2.jpg'or actor.actorimg == 'Snape.jpg'or actor.actorimg == 'DracoMalfoy.jpg'or actor.actorimg == 'Hagrid.jpg'or actor.actorimg == 'Black.jpg'or actor.actorimg == 'Voldemort.jpg'}">
				<a href="javascript:slide()"><img src="${path}/model2/actornseries/img/actor/${actor.actorimg}"	id="actorimg"></a>
				</c:if>
				<c:if test="${actor.actorimg != 'Scamander.jpg' and actor.actorimg != 'harry.jpg' and actor.actorimg != 'Hermione.jpg' and actor.actorimg != 'ron.jpg'and actor.actorimg != 'Dumbledore2.jpg' and actor.actorimg != 'Snape.jpg' and actor.actorimg != 'DracoMalfoy.jpg' and actor.actorimg != 'Hagrid.jpg' and actor.actorimg != 'Black.jpg' and actor.actorimg != 'Voldemort.jpg'}">
				<img src="${path}/model2/actornseries/img/actor/${actor.actorimg}"	id="actorimg">
				</c:if>
			</div>
			<div class="w3-twothird text w3-center">
				<h4>
					실제 이름 : <strong>${actor.actorname}</strong>
				</h4>
				<p>극 중 이름 : ${actor.seriesname}</p>
				<p>출생연월 : <fmt:formatDate value="${actor.birthdate}" pattern="yy년 MM월 dd일" /></p>
				<p>출생지 : ${actor.birthplace}</p>
				<p>출연 시리즈 : ${actor.actseries}</p>
				<c:if test="${actor.actorimg == 'Scamander.jpg' or actor.actorimg == 'harry.jpg' or actor.actorimg == 'Hermione.jpg' or actor.actorimg == 'ron.jpg'or actor.actorimg == 'Dumbledore2.jpg'or actor.actorimg == 'Snape.jpg'or actor.actorimg == 'DracoMalfoy.jpg'or actor.actorimg == 'Hagrid.jpg'or actor.actorimg == 'Black.jpg'or actor.actorimg == 'Voldemort.jpg'}">
				<p><strong>이미지를 클릭하시면 스틸 컷 3장을 보실 수 있습니다.</strong></p>
				</c:if>
			</div>
		</c:if>
		<c:if test="${actor == null }">
		<div class="w3-center">
			<h3>등장인물을 클릭해주세요</h3>
		</div>
		</c:if>
	</div>
</body>
</html>