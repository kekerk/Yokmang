<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>out 내장 객체 예제</title>
</head>
<body>
<h3>out 객체는 response 객체의 출력버퍼에 내용을 전달하는 출력스트림 객체임.</h3>
<h3>out 객체의 자료형은 JspWriter(문자형 출력 스트림) 이다.</h3>
<h3> 여기까지의 내용은 출력되지 않습니다.</h3>
<% out.clearBuffer(); %> <%--      --%>
출력 버퍼의 크기 : <%= out.getBufferSize() %><br><%-- 8k : 8000자 정도. --%>
출력 버퍼의 남은 크기 : <%=out.getRemaining() %><br>
<hr>
<h1>1부터 10까지의 합 구하기:표현식</h1>
<%
	int sum=0;
	for(int i=1;i<=10;i++){
		sum+=i;
%>
	1부터 <%=i %> 까지의 중갑합 : <%=sum %><br>
<%
	}
%>
<hr>
<h1>1부터 10까지의 합 구하기:out 객체 사용하기</h1>
<%
	sum=0;
	for(int i=1;i<=10;i++){
		sum+=i;
		out.println("1부터"+i+"까지의 중간합 : "+ sum+"<br>"); //out.println 사용
	}
%>
</body>
</html>