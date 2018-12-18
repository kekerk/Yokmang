<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <c:set var="path" value="${pageContext.request.contextPath}"/>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<title><decorator:title/></title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<decorator:head/>
<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
body{
	background-color: white;
}
#sideimg{
margin-top : 200px;
}
#main{
	padding-top: 100px;
}
#smallinfo h4{
	text-align: center;
}
</style>
<body class="w3-content" style="max-width:1400px">

<%--sidebar/menu --%>
<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;width:250px" id="mySidebar">
  <div class="w3-container w3-display-container w3-padding-16">
    <i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
    <h3 class="w3-wide"><b>Hogwarts</b></h3>
  </div>
	<c:if test="${!empty sessionScope.login}">
  	<div id="smallinfo" style="border:1px solid gray;">
  	<h4>Welcome!</h4>
  	<h4><strong>${sessionScope.login}</strong></h4>
  	<h4>${sessionScope.dormi} <c:if test ="${sessionScope.login!='admin' }">${sessionScope.grade}ÇÐ³â</c:if></h4>	
  	</div>
  	</c:if>
  <div class="w3-padding-64 w3-large w3-text-grey" style="font-weight:bold">
  <c:if test="${empty sessionScope.login}">
    <a href="${path}/model2/members/joinform.me" class="w3-bar-item w3-button">Join for login</a>
    <a href="${path}/model2/members/loginform.me" class="w3-bar-item w3-button">Login</a>
  </c:if>
  <c:if test="${!empty sessionScope.login}">
     <a href="${path}/model2/members/info.me?id=${sessionScope.login}" class="w3-bar-item w3-button">My page</a>
     <a href="${path}/model2/members/logout.me" class="w3-bar-item w3-button">Logout</a>
 	<c:if test="${sessionScope.login=='admin'}">
     <a href="${path}/model2/members/list.me" class="w3-bar-item w3-button">Member list</a>
	</c:if>
     <a href="${path}/model2/members/main.me" class="w3-bar-item w3-button">Main</a>
     <a onclick="myAccFunc1()" href="javascript:void(0)" class="w3-button w3-block w3-white w3-left-align" id="myBtn">Info<i class="fa fa-caret-down"></i></a>
     <div id="demoAcc1" class="w3-bar-block w3-hide w3-padding-large w3-medium">
     <a href="${path}/model2/actornseries/infoauthor.ans" class="w3-bar-item w3-button">Author</a>
     <a href="${path}/model2/actornseries/listact.ans" class="w3-bar-item w3-button">Actor</a>
     <a href="${path}/model2/actornseries/listseries.ans" class="w3-bar-item w3-button">series brief</a>
     <a href="${path}/model2/actornseries/infoAboutAll.ans" class="w3-bar-item w3-button">E.T.C</a>
     </div>
     <a onclick="myAccFunc2()" href="javascript:void(0)" class="w3-button w3-block w3-white w3-left-align" id="myBtn">Dormitory board<i class="fa fa-caret-down"></i></a>
    <div id="demoAcc2" class="w3-bar-block w3-hide w3-padding-large w3-medium">
      <a href="${path}/model2/allboard/list.all?boardtype=3&dormi=Gryffindor" class="w3-bar-item w3-button">Gryffindor</a>
      <a href="${path}/model2/allboard/list.all?boardtype=3&dormi=Slytherin" class="w3-bar-item w3-button">Slytherin</a>
      <a href="${path}/model2/allboard/list.all?boardtype=3&dormi=Hufflepuff" class="w3-bar-item w3-button">Hufflepuff</a>
      <a href="${path}/model2/allboard/list.all?boardtype=3&dormi=Ravenclaw" class="w3-bar-item w3-button">Ravenclaw</a>
    </div>
    <a href="${path}/model2/allboard/list.all?boardtype=1" class="w3-bar-item w3-button">Best scene & Review board</a>
    <a href="${path}/model2/allboard/list.all?boardtype=2" class="w3-bar-item w3-button">Gallary board</a>
    <a href="${path}/model2/allboard/list.all?boardtype=4" class="w3-bar-item w3-button">Free board</a>

    </c:if>
  </div>
   <c:if test="${empty sessionScope.login}">
  <div id="sideimg">
   <img src="${path}/model2/mainimg/side1.gif" style="width:100%">
  </div>
  </c:if>
</nav>

<!-- Top menu on small screens -->
<header class="w3-bar w3-top w3-hide-large w3-blue-grey w3-xlarge">
  <div class="w3-bar-item w3-padding-24 w3-wide">Hogwarts</div>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding-24 w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:250px">

  <!-- Push down content on small screens -->
  <div class="w3-hide-large" style="margin-top:83px"></div>
  

  <!-- Image header -->
  <div class="w3-display-container w3-container" id="main">
  <c:if test="${!empty sessionScope.login}">
    <img src="${path}/model2/mainimg/main3.gif" style="width:100%">
   </c:if>
   <c:if test="${empty sessionScope.login}">
    <img src="${path}/model2/mainimg/main5.jpg" style="width:100%">
   </c:if>
  </div>


	<div class="w3-display-container w3-container"><decorator:body/></div>
  <div class="w3-black w3-center w3-padding-24" style="margin-top: 15px;">Producted by L.C.H</div>
</div>

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

</body>
</html>