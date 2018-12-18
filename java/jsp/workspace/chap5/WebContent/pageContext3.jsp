<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- /WebContent/pageContext3.jsp --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>pageContext 객체 : include 예제</title>
</head>
<body>
<h3>pageContext3.jsp 페이지 입니다.</h3><br>
<% 
String msg="pageContext3.jsp의 msg 변수"; 
/*변수는 같은 서블릿이 아니기 때문에 공유할 수 없다.
하지만 같은 request영역이므로 request.setAttribute("msg",msg);[pageContext3.jsp]와 request.getAttribute("msg");[pageContext4.jsp]를 이용하여 변수를 넘겨준다.   */
request.setAttribute("msg",msg);
pageContext.setAttribute("msg",msg);
request.setAttribute("today",new Date());

pageContext.include("pageContext4.jsp");  %>
<h3>pageContext3.jsp 페이지 입니다.</h3> 
<!-- pageContext3.jsp와 pageContext4.jsp는 같은 서블릿이 아니라서 변수를 공유할 수 없다.  -->
</body>
</html>