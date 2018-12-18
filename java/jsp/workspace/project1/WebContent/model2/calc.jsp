<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>model2 연습(계산)</title>
</head>
<body>
<form action="calc.me" method="post">
 <input type="text" name="num1" value="${param.num1}"> 
 <select name="op">
 	<option>+</option>
 	<option>-</option>
 	<option>*</option>
 	<option>/</option>
 </select>
 <input type="text" name="num2" value="${param.num2}"> 
 <input type="submit"  value="="> 
  <input type="text" name="result" value=" <fmt:formatNumber value='${result }' pattern='###,###.00' />"> 
</form>
</body>
</html>