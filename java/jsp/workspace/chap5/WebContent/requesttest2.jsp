<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!--  num,kbn 파라미터가 전송됨. -->
<html>
<head>
<meta charset="EUC-KR">
<title>요청된 계산 결과</title>
</head>
<body>

<hr>
<%
	request.setCharacterEncoding("EUC-KR");
	String num = request.getParameter("num");
	int a = Integer.parseInt(num);
	String kbn = request.getParameter("kbn");
	String str = (kbn.equals("1")? "합계" :
						 kbn.equals("2")? "짝수합계":"홀수합계");
	int sum=0;
	for(int i=1;i<=a;i++){
		switch(kbn) {
		case "1" : sum+=i; break;
		case "2" : if(i%2==0) sum += i; break;		
		case "3" : if(i%2==1) sum +=i;  break;
		}
	}
%>
계산된 결과 값 : <%=sum %>

<hr>
</body>
</html>