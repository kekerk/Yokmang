<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>scriptlet 예제</title>
</head>
<body>
<h1>  스크립트릿 : 서블릿의 _jspService() 메서드 영역에 저장됨  </h1>
<% // 스크립트릿 : 서블릿의 _jspService() 메서드 영역에 저장됨
     String msg = "스크립트 예제";
	 int sum = 0;
	 for (int i=1;i<=10;i++){
		 sum += i;
	 }
%>
<%=msg %><br> <%-- JSP가 쓰이는 부분은 <%      %> 처리를 한다. --%>
1부터 10까지의 합 : <%=sum /* 10까지의 합 */ %>

<h1> 표현식 : 값은 브라우저 출력.</h1>
out.println(sum); 형태로 서블릿에 표시됨. => ; 이나 // 처리 안됨.<br>
값을 출력해야 함.<br>
<%=10+5 %><br>
<%=Math.random() %><br>
<%=1/*=System.out.println()*/ %> : 값이 없으므로 오류 발생. <br>

<h1>선언문 : 멤버로 저장됨.</h1>
jsp 선언문 : jsp 서블릿의 멤버임<br>
<%= msg %><br>
<%= this.msg %><br> <%-- ???? --%>
<%= this.getMsg() %><br>
<%!
	String msg = "선언문으로 출력됨";
	String getMsg() {
		return msg;
	}
%>
</body>
</html>