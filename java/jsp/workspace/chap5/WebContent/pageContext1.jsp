<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>pageContext ��ü ����</title>
</head>
<body>
<h1>pageContext ��ü : ���� �������� �ڿ��� �����ϴ� ��ü</h1>
<p>&lt;%=pageContext.getRequest() == request %&gt; �� <%= pageContext.getRequest() == request %><br>
<p>&lt;%=pageContext.getResponse() == response %&gt; �� <%= pageContext.getResponse() == response %><br>
<h2> �� �������� pageContext1.jsp���� �ۼ��� �����Դϴ�.<br>
�� �������� ������ ȭ�鿡 ��µ��� �ʽ��ϴ�. ������ ���� �� url�� pageContext1.jsp�� �����ֽ��ϴ�.</h2>
<%pageContext.forward("pageContext2.jsp"); %> <!--  pageContext.forward("pageContext2.jsp") : url�� ����� jsp�� ��Ƴ���ä�� �ٸ� jsp ������ �������� ��½�Ų��. -->
</body>
</html>