<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<hr>
오늘 날짜 : <%=request.getAttribute("today") %><br> <!-- pageContext3.jsp의 request.setAttribute("today",new Date());의 값을 받아올 수 있다. -->
name : <%=request.getParameter("name") %><br>
msg값 : <%=request.getAttribute("msg") %><br>
msg값 : <%=pageContext.getAttribute("msg") %> <!--  같은 페이지에서 이루어지는 것이 아니라서 null값으로 나온다. -->
<hr>
