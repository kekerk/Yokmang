<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<%--
	/WebContent/importtest.jsp
	page Directive(������) ����
	page Directive�� ���� jsp �������� Ư¡�� �Ӽ��� �̿��Ͽ� ������.
  
      	 language="java" : �⺻�� java. ����� ��� java ����. �������ص� ��.
	     contentType : �ۼ��� �������� ������ ������ ���ڵ� ��� ����.
	     			������ ���� : MIMEŸ�� ������.  (text/html). image/gif ...
		  pageEncoding : ���ڵ� ����.    
		  import : ���Ǵ� Ŭ������ ��Ű�� ����. ������ ��� ������ �Ӽ���.
 --%>
<html>
<head>
<meta charset="EUC-KR">
<title>page Directive ����</title>
</head>
<body>
<%
	Date today = new Date(); 
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>

	���� ��¥ : <%=sf.format(today) %>
</body>
</html>