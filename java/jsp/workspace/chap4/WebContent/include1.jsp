<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- /WebContent/include1.jsp
    		  include Directive 예제.
    		  include 지시자는 다른 페이지를 포함 할 수이쓴ㄴ 기능을 가진 지시자입니다.
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>include Directive 예제</title>
</head>
<body>
<% String msg = "include1.jsp 페이지의 msg 변수 입니다."; %> 
<h1>include1.jsp 페이지입니다.</h1>
<%@ include file = "include2.jsp" %> <!--  이 부분에 include2.jsp의 스크립트를 HTML에 출력. -->
<h2>include1.jsp 페이지가 include2.jsp 페이지를 포함합니다.</h2>
<h2>include1.jsp 페이지와 include2.jsp 페이지는 하나의 서블릿으로 변환됩니다.<br> <!-- 와우 -->
서블릿이 하나이므로 변수를 공유할 수 있습니다.<br>나중에 include 액션태그와 비교하여 봅시다.</h2>
</body>
</html>
<%--
	 JSP  주석
	 <%--    -- %>
	 java 주석
	 <% //        %>
	 <%  /*   */ %>
	 html 주석
	 <!--           -->
	 JSP Directive(지시자)
	  1. page : <%@ page 속성들..... %>
	  	         	 - 해당 페이지의 특징 설정 기능.
	  2. include : <%@ include file="포함될 페이지" %>
	  				 - 현재 페이지에 포함될 페이지를 include
	  				 - 현재 페이지와 포함될 페이지는 하나의 서블릿으로 생성됨.	
	  3. taglib : <%@ taglib prefix=" " uri= " " %>
	  				 - 커스텀태그(사용자 정의 태그) 사용시 설정.
	  				 	JSTL, EL 부분에서 설명.
--%>

