<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>scriptlet ����</title>
</head>
<body>
<h1>  ��ũ��Ʈ�� : ������ _jspService() �޼��� ������ �����  </h1>
<% // ��ũ��Ʈ�� : ������ _jspService() �޼��� ������ �����
     String msg = "��ũ��Ʈ ����";
	 int sum = 0;
	 for (int i=1;i<=10;i++){
		 sum += i;
	 }
%>
<%=msg %><br> <%-- JSP�� ���̴� �κ��� <%      %> ó���� �Ѵ�. --%>
1���� 10������ �� : <%=sum /* 10������ �� */ %>

<h1> ǥ���� : ���� ������ ���.</h1>
out.println(sum); ���·� ������ ǥ�õ�. => ; �̳� // ó�� �ȵ�.<br>
���� ����ؾ� ��.<br>
<%=10+5 %><br>
<%=Math.random() %><br>
<%=1/*=System.out.println()*/ %> : ���� �����Ƿ� ���� �߻�. <br>

<h1>���� : ����� �����.</h1>
jsp ���� : jsp ������ �����<br>
<%= msg %><br>
<%= this.msg %><br> <%-- ???? --%>
<%= this.getMsg() %><br>
<%!
	String msg = "�������� ��µ�";
	String getMsg() {
		return msg;
	}
%>
</body>
</html>