<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%-- WebContent/model1/member/main.jsp
		 1. �α��� ������ ������.
		 	 �α��� ���¸� ȭ�鿡 ���.
		 	 �α׾ƿ� ���¸� loginform.jsp�� ������ �̵�. (�α׾ƿ� submit)
		 2. �����ڷ� �α��� �ϴ� ��� ȸ�� ��� ����(list.jsp) ��ũ �߰��ϱ�.
 --%>
<%
	String login = (String)session.getAttribute("login");//�α����� �Ǿ����� ������ ����� main.jsp�� �� �� ����.
	if(login==null){ //logout ����
		response.sendRedirect("loginform.jsp");  // �α��� ȭ������ �ٽ� ������.
	} else {
			
%>		
<html>
	<head><title>ȸ�� ���� ���α׷�</title>
	</head>
	<style>
	body {
		background-image : url('taeri2.jpg');	
		background-position : center center;
		background-repeat : no-repeat;
	}
	</style>
	<body>
	<h3><%=login %> ȸ���� �ݰ����ϴ�.</h3>
	<h3><a href="logout.jsp">logout</a></h3> <%-- ���ǿ� �ִ� ���� ���� ����������. --%>
	<h3><a href="info.jsp?id=<%=login%>">my page</a></h3>  
	<% if(login.equals("admin")){ %>
	<h3><a href="list.jsp">ȸ�� ��� ����</a></h3>   
	<%} %>
	<%-- ?id=<%=login%> : get ��� --%>
	</body>
</html>	
<%}%>