<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="path" value="${pageContext.request.contextPath}"/>
 <!DOCTYPE html>
<html>
<title><decorator:head /></title>
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
  bottom: 540px;
  height: inherit;
}
#under{
	margin-top: 180px;
	text-align: right;
	font-style: italic;
}
</style>
<decorator:head/>
<body>
<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
     <a href="${path}/model2/member/homemain.jsp" class="w3-bar-item w3-button w3-theme-l1">Home</a>
    <button  id="openNav" class="w3-bar-item w3-button w3-theme-l1" onclick="w3_open()">&#9776;</button>
    <c:if test="${empty sessionScope.login }">
    <a href="${path}/model2/member/loginform.me" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Login</a>
   	</c:if>
   	<c:if test="${!empty sessionScope.login }">
   	    <a href="${path}/model2/member/logout.me" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Logout</a>
   	    <a  class="w3-bar-item w3-button w3-hide-small w3-hover-white">${sessionScope.login } Welcome!</a>
    </c:if>
</div>
</div>

<!-- Sidebar -->
<nav class="w3-sidebar w3-bar-block w3-large w3-theme-l5 w3-animate-left" id="mySidebar" style="display: none;">
  <!-- <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-large" title="Close Menu"> -->
  <button class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-large w3-collapse"  onclick="w3_close()"> <i class="fa fa-remove"></i></button>
  <!-- </a> -->
  <h4 class="w3-bar-item"><b>index</b></h4>
 <c:if test="${!empty sessionScope.login }">
  <a class="w3-bar-item w3-button w3-hover-black" href="${path}/model2/member/info.me?id=${sessionScope.login}">my page</a>
  </c:if>
  <a class="w3-bar-item w3-button w3-hover-black" href="${path}/model2/member/main.me">customer list</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="${path}/model2/board/list.bo">board</a>
  <div class="w3-container" id="under">
  		<p>made by L.C.H</p>
  </div>
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<!-- <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
 -->
<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main" style="margin-left:0px" id="main">

  <div class="w3-row w3-padding-64" style="margin-left: 400px;">
    <div class="w3-twothird w3-container">
      <decorator:body/>
    </div>
  </div>

<!--   <div class="w3-row">
    <div class="w3-twothird w3-container">
      <h1 class="w3-text-teal">Heading</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum
        dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>

  </div> -->

<!--   <div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container">
      <h1 class="w3-text-teal">Heading</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum
        dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>

  </div>

  Pagination
  <div class="w3-center w3-padding-32">
    <div class="w3-bar">
      <a class="w3-button w3-black" href="#">1</a>
      <a class="w3-button w3-hover-black" href="#">2</a>
      <a class="w3-button w3-hover-black" href="#">3</a>
      <a class="w3-button w3-hover-black" href="#">4</a>
      <a class="w3-button w3-hover-black" href="#">5</a>
    </div>
  </div> -->

 

<!--     <div class="w3-container w3-theme-l1">
      <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    </div> -->


<!-- END MAIN -->
</div>

<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
/* function w3_open() {
    if (mySidebar.style.display === 'block') {
        mySidebar.style.display = 'none';
        document.getElementById("main").style.marginLeft = "15%";
        mySidebar.style.width="15%";
        overlayBg.style.display = "none";
    } else {
        mySidebar.style.display = 'block';
        overlayBg.style.display = "block";
    }
}

// Close the sidebar with the close button
function w3_close() {
	document.getElementById("main").style.marginLeft = "0%";
    mySidebar.style.display = "none";
    overlayBg.style.display = "none";
} */


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