<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:choose>
<c:when test="${param.name=='guest' && param.pass == 'jquery' }">
	<h3>�ݰ����ϴ� ����</h3>
</c:when>
<c:otherwise>
	<h3>���̵� �Ǵ� ��й�ȣ�� Ȯ���ϼ���</h3>
</c:otherwise>
</c:choose>

<%
	String msg= null;
	if(request.getParameter("name").equals("guest") && request.getParameter("pass").equals("jquery")){
		msg = "�ݰ����ϴ� ����";
	}else{
		msg = "���̵� �Ǵ� ��й�ȣ�� Ȯ���ϼ���";
	}
%>
<%=msg%>