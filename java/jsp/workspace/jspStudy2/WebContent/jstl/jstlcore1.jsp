<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL core 태그 예제</title>
</head>
<body>

<h3>&lt;c:set .. /%gt; : page 영역에 속성으로 등록. 다른 영역에 등록시 scope 속성을 추가함 : scope="request"</h3>
<c:set var="test" value="${'Hello JSTL'}" scope="request"/>

<h3>&lt;c:out .. /%gt; : 등록된 속성 값 조회. el표현과 비슷함</h3>
<c:out value="${test}" />

<h3>&lt;c:remove .. /%gt; : 등록된 속성 값 삭제</h3>
<c:remove var="test"/>
test속성값 : ${test}

<h3>if 조건 태그 </h3>
<c:if test="${5 < 10}">
	<h4>5는 10보다 작다.</h4>
</c:if>
<c:if test="${5 > 10}"> <%-- 출력 안됨 --%>
	<h4>5는 10보다 크다.</h4>
</c:if>

<h3>choose 조건 태그 </h3>
<c:choose>
	<c:when test="${5+10 == 40 }"> <%-- 출력 안됨 --%>
		<h4>5와 10의 합은 40이다.</h4>
	</c:when>
		<c:when test="${5+10 == 15 }">
		<h4>5와 10의 합은 15이다.</h4>
	</c:when>
	<c:otherwise>
	<h4>5와 10의 합은 모른다.</h4>
	</c:otherwise>
</c:choose>
</body>
</html>