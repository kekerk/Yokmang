<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- WebContent/model1/member/main.jsp
		 1. 로그인 이후의 페이지.
		 	 로그인 상태만 화면에 출력.
		 	 로그아웃 상태면 loginform.jsp로 페이지 이동. (로그아웃 submit)
		 2. 관리자로 로그인 하는 경우 회원 목록 보기(list.jsp) 링크 추가하기.
 --%>
	<html>
	<head><title>회원 관리 프로그램</title>
	<style type="text/css">
	body {font-family: "Raleway", Arial, sans-serif }
	</style>
	</head>
	<body>
	<div style="margin: 50px; padding: 25px; border:1px solid silver; " align="center">
	<h3>${sessionScope.login} 회원님 반갑습니다.</h3>
	<%-- logout.me : session 종료. loginform.jsp 페이지로 이동. --%>
	<h3><a href="logout.me">logout</a></h3> <%-- 세션에 있는 내용 전부 지워버리기. --%>
	<h3><a href="info.me?id=${sessionScope.login}">my page</a></h3>  
	<c:if test="${sessionScope.login=='admin' }">
	<h3><a href="list.me">회원 목록 보기</a></h3>   
	</c:if>
	</div>
	<%-- ?id=<%=login%> : get 방식 --%>
	</body>
</html>	
