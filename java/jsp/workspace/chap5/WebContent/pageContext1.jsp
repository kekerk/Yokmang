<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>pageContext 객체 예제</title>
</head>
<body>
<h1>pageContext 객체 : 현재 페이지의 자원을 관리하는 객체</h1>
<p>&lt;%=pageContext.getRequest() == request %&gt; 는 <%= pageContext.getRequest() == request %><br>
<p>&lt;%=pageContext.getResponse() == response %&gt; 는 <%= pageContext.getResponse() == response %><br>
<h2> 이 페이지는 pageContext1.jsp에서 작성된 내용입니다.<br>
이 페이지의 내용은 화면에 출력되지 않습니다. 하지만 실행 후 url은 pageContext1.jsp로 남아있습니다.</h2>
<%pageContext.forward("pageContext2.jsp"); %> <!--  pageContext.forward("pageContext2.jsp") : url은 실행된 jsp로 잡아놓은채로 다른 jsp 파일을 브라우저에 출력시킨다. -->
</body>
</html>