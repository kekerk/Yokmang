<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	// Accordion 
	function myAccFunc1() {
		var x = document.getElementById("demoAcc1");
		if (x.className.indexOf("w3-show") == -1) {
			x.className += " w3-show";
		} else {
			x.className = x.className.replace(" w3-show", "");
		}
	}
	function myAccFunc2() {
		var x = document.getElementById("demoAcc2");
		if (x.className.indexOf("w3-show") == -1) {
			x.className += " w3-show";
		} else {
			x.className = x.className.replace(" w3-show", "");
		}
	}
	function myAccFunc3() {
		var x = document.getElementById("demoAcc3");
		if (x.className.indexOf("w3-show") == -1) {
			x.className += " w3-show";
		} else {
			x.className = x.className.replace(" w3-show", "");
		}
	}


	// Script to open and close sidebar
	function w3_open() {
		document.getElementById("mySidebar").style.display = "block";
		document.getElementById("myOverlay").style.display = "block";
	}

	function w3_close() {
		document.getElementById("mySidebar").style.display = "none";
		document.getElementById("myOverlay").style.display = "none";
	}
</script>
<title><decorator:title/></title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.w3-sidebar a {
	font-family: "Roboto", sans-serif
}

body, h1, h2, h3, h4, h5, h6, .w3-wide {
	font-family: "Montserrat", sans-serif;
}

img { 
   max-width:100%;
   height:400px;
}
</style>
<decorator:head/>
</head>
<body class="w3-content" style="max-width: 1500px">
	<!-- 메뉴 -->
	<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top"
		style="z-index: 3; width: 150px" id="mySidebar">
		<div class="w3-container w3-display-container w3-padding-16">
		
			<i onclick="w3_close()"
				class="fa fa-remove w3-hide-large w3-button w3-display-topright">안냥</i>
			<h3 class="w3-wide">
				<a href="${path}/"><img src="${path}/w3images/ASD.PNG" style="width:100px; height:100px;"></a>
			</h3>
		</div>
		<div class="w3-padding-64 w3-large w3-text-grey"
			style="font-weight: bold">
			<a onclick="myAccFunc1()" href="javascript:void(0)"
				class="w3-button w3-block w3-white w3-left-align" >
				소주<i class="fa fa-caret-down"></i>
			</a>
			<div id="demoAcc1"
				class="w3-bar-block w3-hide w3-padding-large w3-medium">
				<a href="${path}/main/board/list.bo?code=1" class="w3-bar-item w3-button">보급형</a> 
				<a href="${path}/main/board/list.bo?code=2" class="w3-bar-item w3-button">증류소주</a> 
				<a href="${path}/main/board/list.bo?code=3"class="w3-bar-item w3-button">탁주</a>
			</div>
			<a onclick="myAccFunc2()" href="javascript:void(0)"
				class="w3-button w3-block w3-white w3-left-align" >
				양주<i class="fa fa-caret-down"></i>
			</a>
			<div id="demoAcc2"
				class="w3-bar-block w3-hide w3-padding-large w3-medium">
				<a href="${path}/main/board/list.bo?code=4" class="w3-bar-item w3-button">브랜디</a> 
				<a href="${path}/main/board/list.bo?code=5" class="w3-bar-item w3-button">위스키</a> 
				<a href="${path}/main/board/list.bo?code=6"class="w3-bar-item w3-button">보드카</a> 
			    <a href="${path}/main/board/list.bo?code=7"class="w3-bar-item w3-button">테킬라</a>
			</div>
			<a onclick="myAccFunc3()" href="javascript:void(0)"
				class="w3-button w3-block w3-white w3-left-align">
				맥주<i class="fa fa-caret-down"></i>
			</a>
			<div id="demoAcc3"
				class="w3-bar-block w3-hide w3-padding-large w3-medium">
				<a href="${path}/main/board/list.bo?code=8" class="w3-bar-item w3-button">에일</a> 
			    <a href="${path}/main/board/list.bo?code=9" class="w3-bar-item w3-button">라거</a>
			</div>
			<a href="${path}/main/board/recommend.bo" class="w3-bar-item w3-button w3-text-black">Recommend</a>
		</div>
	</nav>
	<!-- Top menu on small screens -->
	<header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">
		<div class="w3-bar-item w3-padding-24 w3-wide">마또마</div>
		<a href="javascript:void(0)"
			class="w3-bar-item w3-button w3-padding-24 w3-right"
			onclick="w3_open()"><i class="fa fa-bars"></i></a>
	</header>

	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large" onclick="w3_close()"
		style="cursor: pointer" title="close side menu" id="myOverlay"></div>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 250px">
		<!-- Push down content on small screens -->
		<div class="w3-hide-large" style="margin-top: 83px"></div>
		<!-- Top header -->
		<header class="w3-container w3-xlarge">
			<p class="w3-left">MTM</p>
			<p class="w3-right">
			<c:if test="${empty sessionScope.login}">
				<a href="${path}/main/member/loginForm.me">로그인</a>
		    </c:if>
		     <c:if test="${!empty sessionScope.login}">
		     <a href="${path}/main/member/logout.me">로그아웃</a>
		     </c:if>
		    <a href="#" class="fa fa-search"></a>
			</p>
		</header>
	</div>

	<!-- 메인 사진 -->
	<div class="w3-row-padding" style="margin-left:20%;">
		<img src="${path}/w3images/onepage_restaurant.jpg"
			style="width: 100%; height: 100%;">
			<decorator:body/>
		<div class="w3-col l3 s6">
			<div class="w3-container"></div>
		</div>


		<!-- Footer -->
		<footer class="w3-padding-64 w3-light-grey w3-small w3-center"
			id="footer">
			<div class="w3-row-padding">
				<h2 class="aright">Contact</h2>
				<h3 class=" aright1">
					<i class="fa fa-fw fa-map-marker"></i>마또마
				</h3>
				<h3 class=" aright1">
					<i class="fa fa-fw fa-phone"></i>010-6526-5158
				</h3>
				<h3 class=" aright1">
					<i class="fa fa-fw fa-envelope"></i>bleaknight2@gmail.com
				</h3>
			</div>
		</footer>

		<div class="w3-black w3-center w3-padding-24">
			Powered by <a href="https://www.w3schools.com/w3css/default.asp"
				title="W3.CSS" target="_blank" class="w3-hover-opacity">w3.css</a>
		</div>

		<!-- End page content -->
	</div>
</body>
</html>
