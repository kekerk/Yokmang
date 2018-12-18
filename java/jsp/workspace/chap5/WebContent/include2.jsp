<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<hr>
<h4>response parameter value</h4>
Name : <%=request.getParameter("name") %><br>
Id : <%=request.getParameter("id") %><br>
Tel : <%=request.getParameter("tel") %><br>
Test : <%=request.getParameter("test") %>
<hr>