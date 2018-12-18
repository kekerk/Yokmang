<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="logintime" class="java.util.Date"/>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<title><decorator:title /></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lobster">
<style>
body {font-family: "Raleway", Arial, sans-serif }
.w3-row img {margin-bottom: 0px}
#title{font-size: x-large; font-style: italic;}
#to{font-family: "Lobster", serif;}
#idtext{font-size: x-large;}
.MyprofileTitle{font-size: x-large; font-style: italic;}
</style>
<decorator:head/>
<body>

<!-- !PAGE CONTENT! -->
<div class="w3-content w3-animate-opacity" style="max-width:1300px;">

  <!-- Header -->
  <header class="w3-container w3-large w3-padding-24">
  <c:if test="${empty sessionScope.login}">
  <a href="${path}/model2/member/loginform.me" class="w3-left w3-button w3-white">Login</a>
  <a href="#join" class="w3-right w3-button w3-white ">Join</a>
  </c:if>
  <c:if test="${!empty sessionScope.login}">
    <a href="${path}/model2/member/info.me?id=${sessionScope.login}" class="w3-left w3-button w3-white">My page</a>
    <a href="${path}/model2/member/logout.me" class="w3-left w3-button w3-white">Logout</a>
    <a href="#main" class="w3-right w3-button w3-white">main</a>
    <a href="${path}/model2/board/list.bo" class="w3-right w3-button w3-white">board</a>
    <c:if test="${sessionScope.login=='admin' }">
    <a href="${path}/model2/member/list.me" class="w3-right w3-button w3-white">customer list</a>
    </c:if>
  </c:if>
  </header>
  <!-- ���̵� �� ���� �ð� ǥ�� -->
   <div class="w3-container w3-large w3-padding-24" align="center">
    <c:if test="${!empty sessionScope.login}">
    <a class="w3-center w3-white" id="idtext">${sessionScope.login } Welcome!</a><br>	
    <a class="w3-center w3-white"> Refresh Time : <fmt:formatDate value="${logintime}" pattern="yyyy-MM-dd HH:mm:ss a"/></a>
  </c:if>
  </div>
  <!-- Photo Grid -->
  <div class="w3-row">
    <div class="w3-half">
      <img src="img/pic5.jpg"  class="w3-hover-opacity" style="width:100%">
      <img src="img/pic6.jpg"  class="w3-hover-opacity" style="width:100%">
      <img src="img/pic7.jpg"  class="w3-hover-grayscale" style="width:100%">
    </div>

    <div class="w3-half">
      <img src="img/pic1.jpg"  class="w3-hover-opacity" style="width:100%">
      <img src="img/pic8.jpg"  class="w3-hover-opacity" style="width:100%"> 
    </div>
  </div>
</div>
  <!-- main -->
<div class="w3-content w3-animate-opacity" style="max-width:1300px" id="main">
  <div class="w3-row">
   <decorator:body/>
  </div>
<!-- End Page Content -->
</div>
<!-- Footer / join Section -->
<footer class="w3-light-grey w3-padding-64 w3-center w3-animate-opacity" id="join">
  <h2 id="to">To. You</h2>
  <img src="img/pic4.jpg" class="w3-image w3-padding-32" width="300" height="300">
  <form style="margin:auto;width:60%" action="${path}/model2/member/join.me" method="post">
 	<p id="title">û��</p>
    <p>�װ� ���Ƽ��� ���߽��ϴ�. ���� ��ſ����. �׷��� ������ �� ����ſ���. ������ ����� �� �̰ܳ��ſ���. ���ϵ� ���� ��� ���� �����Ŵϱ��.</p>
 	<c:if test="${empty sessionScope.login}">
    <p class="w3-large w3-text-pink">���� ȸ������</p>
     <div class="w3-section">
      <label><b>Id</b></label>
      <input class="w3-input w3-border" type="text" required name="id">
    </div>
    <div class="w3-section">
      <label><b>Password</b></label>
      <input class="w3-input w3-border" type="password" required name="pass">
    </div>
    <div class="w3-section">
      <label><b>Name</b></label>
      <input class="w3-input w3-border" type="text" required name="name">
    </div>
    <div class="w3-section">
      <label><b>Gender</b></label>
      <input type="radio" required name="gender" value="1" checked>�� <input type="radio" required name="gender" value="2">��
    </div>
    <div class="w3-section">
      <label><b>Telephone</b></label>
      <input class="w3-input w3-border" type="text" required name="tel">
    </div>
    <div class="w3-section">
      <label><b>E-mail</b></label>
      <input class="w3-input w3-border" type="text" required name="email">
    </div>
    <div class="w3-section">
      <label><b>������ ȸ�� ���� �� �α����ϼż� ���� �����մϴ�.</b></label>
    </div>
    <button type="submit" class="w3-button w3-block w3-dark-grey">join</button>
    </c:if>
    <c:if test="${!empty sessionScope.login}">
    <p class="w3-large w3-text-pink"></p>
     <div class="w3-section">
      <label class="MyprofileTitle"><b>my profile</b></label>
      <p>�̸�:��âȯ<br>����:28��<br>����:���ϵ� ����<br>���:��å,�������<br></p>
      <label class="MyprofileTitle"><b>���ְ� ���� ��</b></label>
     <p>${sessionScope.login }�� ����  �Ϸ絵 �ʹ� �����߾��. ����� �� ���� ����̿���. ���� �� �� �����Ŷ� �Ͼ�� ��. ��� �翡�� ���� ���ݾƿ�</p>
    </div>
    
    </c:if>
  </form>
  <br>
  <p>����� ��õ�� ���������2�� 115, 509ȣ, 811ȣ (���굿, �븢��ũ��Ÿ�� 3��) Goodee Academy</p>
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" class="w3-hover-text-green">w3.css</a></p>
</footer>
 
</body>
</html>
