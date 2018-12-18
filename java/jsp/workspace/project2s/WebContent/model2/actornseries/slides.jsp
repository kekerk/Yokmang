<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>Slide show</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta content="text/html; charset=iso-8859-2" http-equiv="Content-Type">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.mySlides {display:none;}
</style>
</head>

<body>

<h2 class="w3-center">Still Cut</h2>

<div class="w3-content w3-section" style="max-width:700px; border:1px solid silver; padding : 2%;">
  <img class="mySlides w3-animate-fading" src="${path}/model2/actornseries/img/slides/1_${param.img}" style="width:100%">
  <img class="mySlides w3-animate-fading" src="${path}/model2/actornseries/img/slides/2_${param.img}" style="width:100%">
  <img class="mySlides w3-animate-fading" src="${path}/model2/actornseries/img/slides/3_${param.img}" style="width:100%">
</div>

<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 10000);
}
</script>
</body>
</html>