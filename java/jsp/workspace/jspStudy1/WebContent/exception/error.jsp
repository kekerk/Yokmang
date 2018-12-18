<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- 에러 페이지 : exception 객체가 전달됨.--%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>오류 발생 페이지</title>
</head>
<body>
<h1> 파라미터 name을 입력해주세요</h1>
<h1> 계속 오류가 발생하면 전산부로 연락 바랍니다.</h1>
<h1> 전산부 : 1234 김삿갓</h1>
<h1> exception 객체는 error 페이지에서만 제공됩니다.</h1>
<%=exception.getMessage() %> <!-- null 상태 -->

</body>
</html>