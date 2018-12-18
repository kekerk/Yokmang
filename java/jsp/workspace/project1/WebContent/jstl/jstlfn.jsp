<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL 함수 예제</title>
</head>
<body>
<c:set var="str1" value="Functions <태그>를 사용합니다.                  " />
<c:set var="str2" value="사용" />
<c:set var="tokens" value="1,2,3,4,5,6,7,8,9,10" />
length(str1)=${fn:length(str1)}<br> <%-- EL 형태 --%>
toUpperCase(str1)=${fn:toUpperCase(str1)}<br>
toLowerCase(str1)=${fn:toLowerCase(str1)}<br>
substring(str1,3,6)=${fn:substring(str1,3,6) }<br>
substringAfter(str1,str2)=${fn:substringAfter(str1,str2) }<br> <%-- '사용' 뒤쪽  --%>
substringBefore(str1,str2)=${fn:substringBefore(str1,str2) }<br><%-- '사용' 앞쪽  --%>
trim(str1)=${fn:trim(str1)}<br>
replace(str1,src,des)=${fn:replace(str1," ","-") }<br>
indexOf(str1,str2)=${fn:indexOf(str1,str2) }<br>
startsWith(str1,str2)=${fn:startsWith(str1,"Fun")}<br>
endsWith(str1,"합니다.")=${fn:endsWith(str1,"합니다.                  ") }<br>
contains(str1,str2)=${fn:contains(str1,str2) }<br>
containsIgnoreCase(str1,str2)=${fn:containsIgnoreCase(str1,str2) }<br><%--containsIgnoreCase(str1,str2) :대소문자 구별하지 않고 str2가 str1에 포함되어 있는지  --%>
<hr>
<c:set var="arr" value="${fn:split(tokens,',')}" />
<c:forEach var="i" items="${arr }">
	${i}-
</c:forEach>
<br>
join(arr,'-')=${fn:join(arr,'-')}<br><%-- 배열을 하나로 묶는다.--%>
</body>
</html>