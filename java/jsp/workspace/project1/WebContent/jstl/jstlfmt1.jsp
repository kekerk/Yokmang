<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="EUC-KR">
<title>format tag example</title>
</head>
<body>
<h3>숫자 관련 형식 지정하기</h3>
<%-- type="currency" 해당 지역의 화폐단위를 표시  --%>
<fmt:formatNumber value="500000" type="currency"/><br>
<fmt:setLocale value="en_US"/> <%-- 지역 변경하기 --%>
<fmt:formatNumber value="500000" type="currency"/><br>
<fmt:setLocale value="ko_KR"/>
<fmt:formatNumber value="0.15" type="percent" /><br>
<fmt:formatNumber value="1234567890.5555" pattern="###,###.00" /><br><%-- 가장 많이 쓰는 방법 --%>
<h3>날짜 관련 형식 지정하기</h3>
<jsp:useBean id="today" class="java.util.Date"/> <%-- class="java.util.Date" : 현재 날짜 및 시각을 가져올 수 있다.--%>
년월일 : <fmt:formatDate value="${today}" type="date"/><br>
시분초 : <fmt:formatDate value="${today}" type="time"/><br>
년월일 시분초 : <fmt:formatDate value="${today}" type="both"/><br>
형식 지정 : <fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss a"/><br>
<br>
년월일 시분초 : <fmt:formatDate value="${today}" type="both" timeStyle="short" dateStyle="short"/><br>
년월일 시분초 : <fmt:formatDate value="${today}" type="both" timeStyle="long" dateStyle="long"/><br>
년월일 시분초 : <fmt:formatDate value="${today}" type="both" timeStyle="full" dateStyle="full"/><br>
<br>
<h3>포맷된 숫자를 일반 숫자로 바꾸기</h3>
<fmt:parseNumber value="20,000" var="num1" pattern="##,###" /> 
<fmt:parseNumber value="10,000" var="num2" pattern="##,###" />

합 : ${num1+num2}<br>
합 : <fmt:formatNumber value="${num1+num2 }" pattern="###,###" />

<h3>포맷된 날짜를 일반 날짜로 바꾸기</h3>
<fmt:parseDate value="2018-10-04 10:30:30" pattern="yyyy-MM-dd HH:mm:ss" var="day" />
${day}<br>
<%-- day날짜 요일 출력하기 --%>
<fmt:parseDate value="${day }" pattern="yyyy년 MM월 dd일 E요일" /><br>
<fmt:parseDate value="${day }" type="date" dateStyle="full" />
</body>
</html>