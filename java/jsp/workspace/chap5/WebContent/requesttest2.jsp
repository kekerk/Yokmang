<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!--  num,kbn �Ķ���Ͱ� ���۵�. -->
<html>
<head>
<meta charset="EUC-KR">
<title>��û�� ��� ���</title>
</head>
<body>

<hr>
<%
	request.setCharacterEncoding("EUC-KR");
	String num = request.getParameter("num");
	int a = Integer.parseInt(num);
	String kbn = request.getParameter("kbn");
	String str = (kbn.equals("1")? "�հ�" :
						 kbn.equals("2")? "¦���հ�":"Ȧ���հ�");
	int sum=0;
	for(int i=1;i<=a;i++){
		switch(kbn) {
		case "1" : sum+=i; break;
		case "2" : if(i%2==0) sum += i; break;		
		case "3" : if(i%2==1) sum +=i;  break;
		}
	}
%>
���� ��� �� : <%=sum %>

<hr>
</body>
</html>