<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:choose>
<c:when test="${param.name=='guest' && param.pass == 'jquery' }">
	<h3>반갑습니다 고객님</h3>
</c:when>
<c:otherwise>
	<h3>아이디 또는 비밀번호를 확인하세요</h3>
</c:otherwise>
</c:choose>

<%
	String msg= null;
	if(request.getParameter("name").equals("guest") && request.getParameter("pass").equals("jquery")){
		msg = "반갑습니다 고객님";
	}else{
		msg = "아이디 또는 비밀번호를 확인하세요";
	}
%>
<%=msg%>