<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>out ���� ��ü ����</title>
</head>
<body>
<h3>out ��ü�� response ��ü�� ��¹��ۿ� ������ �����ϴ� ��½�Ʈ�� ��ü��.</h3>
<h3>out ��ü�� �ڷ����� JspWriter(������ ��� ��Ʈ��) �̴�.</h3>
<h3> ��������� ������ ��µ��� �ʽ��ϴ�.</h3>
<% out.clearBuffer(); %> <%--      --%>
��� ������ ũ�� : <%= out.getBufferSize() %><br><%-- 8k : 8000�� ����. --%>
��� ������ ���� ũ�� : <%=out.getRemaining() %><br>
<hr>
<h1>1���� 10������ �� ���ϱ�:ǥ����</h1>
<%
	int sum=0;
	for(int i=1;i<=10;i++){
		sum+=i;
%>
	1���� <%=i %> ������ �߰��� : <%=sum %><br>
<%
	}
%>
<hr>
<h1>1���� 10������ �� ���ϱ�:out ��ü ����ϱ�</h1>
<%
	sum=0;
	for(int i=1;i<=10;i++){
		sum+=i;
		out.println("1����"+i+"������ �߰��� : "+ sum+"<br>"); //out.println ���
	}
%>
</body>
</html>