<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<title>Insert title here</title>
</head>
<body>
<div style="border: 2px solid silver; margin-top: 220px; padding: 25px;" align="center">
<img class="mySlides w3-animate-fading" src="img/taeri4.jpg" width="100%">
<img class="mySlides w3-animate-fading" src="img/taeri2.jpg" width="100%">
<img class="mySlides w3-animate-fading" src="img/taeri3.jpg" width="100%">
</div>
<script>
var slideIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
      x[i].style.display = "none"; 
    }
    slideIndex++;
    if (slideIndex > x.length) {slideIndex = 1} 
    x[slideIndex-1].style.display = "block"; 
    setTimeout(carousel, 4000); 
}
</script>
</body>
</html>