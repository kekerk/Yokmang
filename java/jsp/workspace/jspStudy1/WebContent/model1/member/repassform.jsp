<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html><%-- info.jsp�� ��й�ȣ���� �ֱ�. --%>
<style>
	table {
		margin: 0 auto;
		width : 400px;
		border: 2px solid green;
		text-align: center;
	}
	caption {
	font-weight: bold;
	font-size: x-large;
	}
</style>
<%
	request.setCharacterEncoding("euc-kr");
	String id = request.getParameter("id");
	String login = (String) session.getAttribute("login");
	String msg=null;
	String url=null;
	if(login == null){
		msg="�α��� �ϼ���";
		url ="loginform.jsp";
	}else if(!login.equals(id) && !login.equals("admin")){
		msg="�ڱ� ��й�ȣ�� ������ �����մϴ�";
		url="main.jsp";
	}
%>
<head>
<meta charset="EUC-KR">
<title>��й�ȣ �缳��</title>
</head>
<body>
	<form action="repass.jsp" name="f" method="post">
	<input type="hidden" name="id" value="<%=request.getParameter("id") %>">
	<table border="1" style="border-collapse : collapse;">
		<caption>��й�ȣ ����</caption>
		<tr>
			<td>���� ��й�ȣ</td>
			<td><input type="password" name="pass1"></td>
		</tr>
		<tr>
			<td>������ ��й�ȣ</td>
			<td><input type="password" name="pass2"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="��й�ȣ ����">
			</td>
		</tr>	
	</table>
	</form>

</body>
</html>