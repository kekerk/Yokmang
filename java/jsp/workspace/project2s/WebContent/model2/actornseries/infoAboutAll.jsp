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
<title>About Harry Potter</title>
<style>
.main {
	width: 100%;
	margin-top: 15px;
}

.test {
	width: 50%;
}

.head {
	margin-top: 20px;
	text-align: center;
}

.img {
	width: 100%;
}

.content h4 {
	text-align: center;
}

.content h5 {
	text-align: center;
}

.magic h5 {
	text-align: center;
	margin-top:15%;
}
</style>
</head>
<body>
	<div class="main">
		<hr style="border: 2px solid silver">
		<h3 class="head">촬영 장소</h3>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="${path}/model2/actornseries/img/place/kingscorss_station.png"
						class="img">
				</div>
				<div class="content">
					<h5>9와 3/4 승강장을 촬영한 킹스 크로스 역</h5>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="${path}/model2/actornseries/img/place/Australia_House.png"
						class="img">
					<div class="content">
						<h6>
							마법 세계의 유일한 은행인 그린고트 은행 내부 촬영장인<br>영국 내 오스트레일리아 대사관
						</h6>
					</div>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="${path}/model2/actornseries/img/place/Bodleian_Library_Oxford.jpg"
						class="img">
					<div class="content">
						<h5>호그와트 도서관으로 나온 옥스퍼드대 보들레이언 도서관</h5>
					</div>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="${path}/model2/actornseries/img/place/The_Christ_Church_Colledge_Oxford.jpg"
						class="img">
					<div class="content">
						<h5>호그와트 대연회장으로 나온 옥스퍼드대 교회</h5>
					</div>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img src="${path}/model2/actornseries/img/place/Alnwick_Castle.jpg"
						class="img">
					<div class="content">
						<h5>호그와트 성으로 나왔던 안위크 캐슬</h5>
					</div>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="${path}/model2/actornseries/img/place/Glenfinnan_Viaduct.jpg"
						class="img">
					<div class="content">
						<h5>호그와트를 갈 때마다 거쳐가는 글렌피넌 고가교</h5>
					</div>
				</div>
			</div>
		</div>
		<hr style="border: 2px solid silver">
		<h3 class="head">유용할(?) 수도 있는 마법 주문 소개</h3>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120810_163/eog990428_1344577592320CROnr_GIF/%BE%CB%B7%CE%C8%A3%B8%F0%B6%F3.GIF?type=w2"
						class="img">
				</div>
			</div>
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>알로호모라(Alohomora)</strong><br> 잠겨있는 자물쇠나 문 등을 열어주는 주문
					</h5>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>브래키움 엠멘도(Brakium Ememdo)</strong><br>
						부러진 뼈를 붙여주는 주문</h5>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120806_52/eog990428_1344233819874BQrQm_GIF/anigif.gif?type=w2"
						class="img">
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120810_59/eog990428_1344577279979A3355_GIF/%BE%C6%B9%D9%B4%D9%C4%C9%B4%D9%BA%EA%B6%F3.GIF?type=w2"
						class="img">
				</div>
			</div>
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>아바다 케다브라(Avada Kedabra)</strong><br> 용서받지 못할 3개의 주문 중 하나로 살인 주문<br>
						해리 포터만이 이 주문의 유일한 생존자
					</h5>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>익스펙토 패트로눔(Expecto Patronum)</strong><br> 디멘터를 쫓을 주 있는 패트로누스 소환 주문
					</h5>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120806_87/eog990428_1344234963334cU8w5_GIF/anigif.gif?type=w2"
						class="img">
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120810_134/eog990428_1344578470227WD0vn_GIF/%C6%C4%B8%A3%C6%BC%BD%BA_%C5%DB%C6%F7%B7%AF%BD%BA.GIF?type=w2"
						class="img">
				</div>
			</div>
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>파르티스 템포러스(Partis Temporus)</strong><br> 아주 위험하고 강력한 화염을 만드는 주문
					</h5>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>오큘러스 레파로(Oculus Reparo)</strong><br> 안경을 깨끗하게 닦거나 고치는 주문
					</h5>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120810_128/eog990428_1344577960193Ax3eL_GIF/%BF%C0%C4%F0%B7%E7%BD%BA_%B7%B9%C6%C4%B7%CE.GIF?type=w2"
						class="img">
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120806_139/eog990428_1344234565623yfvJs_GIF/anigif.gif?type=w2"
						class="img">
				</div>
			</div>
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>리디큘러스(Riddikulus)</strong><br> 보가트를 우스꽝스러운 모습으로 만들어<br> 퇴치하는 보가트
						퇴치 마법
					</h5>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>윙가디움 레비오사(Wingardium Leviosa)</strong><br> 사람이나 사물을 띄우는 공중부양 마법
					</h5>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120806_85/eog990428_1344231323590Wm7jr_GIF/%C0%AE%B0%A1%B8%A3%B5%F0%BF%F2%B7%B9%BA%F1%BF%C0%BF%EC%BB%E7.gif?type=w2"
						class="img">
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120810_97/eog990428_1344578982484chees_GIF/%C8%A3%B1%D7%BF%CD%C6%AE%B8%B6%B9%FD%C1%F6%B5%B5.GIF?type=w2"
						class="img">
				</div>
			</div>
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>나는 천하의 멍텅구리임을 엄숙히 선언합니다</strong><br><strong>(I Solemly Swear That I'm Up To
						No Good)</strong><br> 호그와트 비밀지도를 사용하기 위한 시동주문
					</h5>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>슬러귤러스 이럭토(Slugulus Eructo)</strong><br> 입에서 달팽이가 나오게 하는 주문
					</h5>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120806_209/eog990428_1344233204629MMPe3_GIF/anigif.gif?type=w2"
						class="img">
				</div>
			</div>
		</div>
	</div>
</body>
</html>