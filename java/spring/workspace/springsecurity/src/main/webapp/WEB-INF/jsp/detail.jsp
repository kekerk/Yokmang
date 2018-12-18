<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품 상세 내용</title>
</head>
<body>
<h2>상품 상세 내용</h2>
${item.id}
${item.name}
${item.pictureUrl}
${item.description}
${item.price}
</body>
</html>