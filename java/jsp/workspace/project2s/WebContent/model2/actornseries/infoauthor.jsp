<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Author Profile</title>
<style type="text/css">
#authorinfo {
	margin-top: 3%;
	padding: 2%;
}

#authorimg {
	width: 70%;
	margin-top : 50px;
}
</style>
</head>
<body>
	<div id="authorinfo" class="w3-row">
		<div class="w3-third w3-center">
			<img src="${path}/model2/actornseries/img/rowling.PNG" id="authorimg">
		</div>
		<div class="w3-twothird">
			<div>
				<h4>
					<strong>조앤 K. 롤링</strong>(Joan K. Rowling)
				</h4>
				<p>출생 : 1965년 7월 31일, 영국</p>
				<hr style="border:2px solid silver;">
				<div>
					<h5><strong>학력 사항</strong></h5>
					<p>하버드 대학교 명예박사</p>
					<p>엑시터 대학교 명예박사</p>
					<p>엑시터대학교 불문학, 고전학 학사</p>
					<h5><strong>수상 내역</strong></h5>
					<p>런던시 자유상(2012)</p>
					<p>안데르센 문학상(2010)</p>
					<p>레종도뇌르 슈발리에 훈장(2009)</p>
					<p>올해의 작가상(2000)</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>