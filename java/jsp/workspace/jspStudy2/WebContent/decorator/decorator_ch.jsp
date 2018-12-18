<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<title><decorator:title /></title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif;}
.w3-sidebar {
	z-index: 3;
	width: 250px;
	top: 43px;
	bottom:0;
	height:inherit;
}
</style>
<decorator:head/>

<body>

<!-- Navbar -->
<div class="w3-top">
<div class="w3-sidebar w3-bar-block w3-animate-left" id="mySidebar" style="display:none;">
<button class="w3-bar-item w3-button w3-black w3-large"
  onclick="w3_close()">Close &times;</button>
  <h4 class="w3-bar-item"><b>Menu</b></h4>
  	    <a href="${path}/model2/member/main.me" class="w3-bar-item w3-button w3-hover-black">회원관리</a>
    	<a href="${path}/model2/board/list.bo" class="w3-bar-item w3-button w3-hover-black">게시판</a>
</div>
  <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
	<button id="openNav" class="w3-button w3-black w3-xlarge w3-bar-item w3-hide-small" onclick="w3_open()">&#9776;</button>
    <a href="${path}/" class="w3-bar-item w3-button w3-black">home</a>
    <c:if test="${empty sessionScope.login }">
		<a href="${path}/model2/member/loginform.me" class="w3-bar-item w3-button w3-hide-small w3-hover-white">로그인</a>
	</c:if>
	<c:if test="${!empty sessionScope.login }">
		${sessionScope.login }님
		<a href="${path}/model2/member/logout.me" class="w3-bar-item w3-button w3-hide-small w3-hover-white">로그아웃</a>
	</c:if>
  </div>
</div>

<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div id="main" class="w3-main" style="margin:200px">

  <div >
 	<decorator:body />
  </div>

  <footer id="myFooter">
  	<div class="footer" style="background-color: skyblue; width= 500px; height=500px;">
      <h4>구디 아카데미 Since 2016</h4>
    </div>
    <!-- <div class="w3-container w3-theme-l2 w3-padding-32">
      <h4>구디 아카데미 Since 2016</h4>
    </div> -->
  </footer>

<!-- END MAIN -->
</div>

<script>
function w3_open() {
	  document.getElementById("main").style.marginLeft = "15%";
	  document.getElementById("mySidebar").style.width = "15%";
	  document.getElementById("mySidebar").style.display = "block";
	  document.getElementById("openNav").style.display = 'none';
	}
	function w3_close() {
	  document.getElementById("main").style.marginLeft = "0%";
	  document.getElementById("mySidebar").style.display = "none";
	  document.getElementById("openNav").style.display = "inline-block";
	}

</script>

</body>
</html>
