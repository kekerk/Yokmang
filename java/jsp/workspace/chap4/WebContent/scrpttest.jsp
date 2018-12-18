<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>script 예제</title>
</head>
<body>
	<h1>스크립트 종류 : 3가지</h1>
	<ol>
		<li> 스크립트릿(scriptlet): <mark>&lt;%      %&gt;</mark>
			    자바 소스의 영역. </li>
	     <li> 표현식 : <mark>&lt;%=값  %&gt;</mark>
	     		 브라우저에 내용 출력. ; 사용 안됨. 한 줄 주석 사용안됨</li>
         <li> 선언문  : <mark>&lt;%!  %&gt;</mark>
         		  서블릿의 멤버로 변환되는 영역. 거의 사용안함. 
	</ol>
</body>
</html>