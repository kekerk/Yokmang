<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@ taglib prefix="test" uri="/ELFunctions" %>  
  <%-- uri="/ELFunctions" : WEB_INF의 하위 파일 중 <uri> 태그가 /ELFunctions 인 파일을 로드함.
     -->   /WEB_INF/tlds/elfunction.tld 파일을 의미 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EL에서 자바 함수 사용하기 : taglib Directive 사용하기</title>
</head>
<body>
<form method="post">
	x : <input type="text" name="x" value="${param.x }"><br> <%-- param.x , param.y의 값이 없으면 null이 아니라 공백으로 들어간다 --%>
	y : <input type="text" name="y" value="${param.y }"><br>
	<input type="submit" value="더하기">
</form><p>
<%--
	 test:  -> /WEB-INF/tlds/elfunction.tld 파일 결정
	add   -> el.Compute 클래스의 add  메서드를 의미 
				   elfunction.tld의 	<name>add</name> 과 동일
 --%>
합계 : ${test:add(param.x,param.y) }<br> 
<%--
	 test(접두사):add(함수)( param.x,param.y )
	접두사 test는 <%@taglib prefix="test" .... %>에서 지정되었기에 test로 접두사를 써야한다.
--%>
</body>
</html>