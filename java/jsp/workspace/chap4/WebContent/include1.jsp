<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- /WebContent/include1.jsp
    		  include Directive ����.
    		  include �����ڴ� �ٸ� �������� ���� �� ���̾��� ����� ���� �������Դϴ�.
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>include Directive ����</title>
</head>
<body>
<% String msg = "include1.jsp �������� msg ���� �Դϴ�."; %> 
<h1>include1.jsp �������Դϴ�.</h1>
<%@ include file = "include2.jsp" %> <!--  �� �κп� include2.jsp�� ��ũ��Ʈ�� HTML�� ���. -->
<h2>include1.jsp �������� include2.jsp �������� �����մϴ�.</h2>
<h2>include1.jsp �������� include2.jsp �������� �ϳ��� �������� ��ȯ�˴ϴ�.<br> <!-- �Ϳ� -->
������ �ϳ��̹Ƿ� ������ ������ �� �ֽ��ϴ�.<br>���߿� include �׼��±׿� ���Ͽ� ���ô�.</h2>
</body>
</html>
<%--
	 JSP  �ּ�
	 <%--    -- %>
	 java �ּ�
	 <% //        %>
	 <%  /*   */ %>
	 html �ּ�
	 <!--           -->
	 JSP Directive(������)
	  1. page : <%@ page �Ӽ���..... %>
	  	         	 - �ش� �������� Ư¡ ���� ���.
	  2. include : <%@ include file="���Ե� ������" %>
	  				 - ���� �������� ���Ե� �������� include
	  				 - ���� �������� ���Ե� �������� �ϳ��� �������� ������.	
	  3. taglib : <%@ taglib prefix=" " uri= " " %>
	  				 - Ŀ�����±�(����� ���� �±�) ���� ����.
	  				 	JSTL, EL �κп��� ����.
--%>

