<%@page import="model.Member"%>
<%@page import="java.util.List"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 
<!DOCTYPE html>
<%-- /WebContent/model1/list.jsp 
		 	1. �α׾ƿ� ����
		 		�α����ϼ��� �޼��� ���. loginform.jsp�� �̵�
		 	2. admin�� �ƴ� ���
		 		�����ڸ� ��ȸ �����մϴ�. �޼��� ���. main.jsp�� �̵�
		 	3. admin�� ���
		 		MemberDao Ŭ������ list �޼��� �߰��ϱ�.
		 		List<Member> list() ��� : ���� ������ �ִ� ��� ����� ����� ����.
		 	4. db���� ��ȸ�� list�� ȭ�鿡 ���.	
--%>

 <html>
    <%
		// �α��� ����. request.parameter�� �ʿ� ����.
		String login =(String) session.getAttribute("login");
		if(login == null){ %>
		<script>
		alert( "�α����ϼ���")
		location.href="loginform.jsp";
		</script>
	<%	
		}else {
			if(!login.equals("admin")){ %> 
 		<script>
		alert("�����ڸ� ��ȸ�� �����մϴ�")
		location.href="main.jsp";
		</script>		
	<%	
			}else {   
				MemberDao dao = new MemberDao();
				List<Member> list = dao.list(); %> <%-- ȸ������ ��ü ���� --%>
<head>
<meta charset="EUC-KR">
<title>ȸ����Ϻ���</title>
</head>
<style>
	table {
		margin: 0 auto;
		width : 800px;
		border: 2px solid green;
		text-align: center;
	}
	caption {
	font-weight: bold;
	font-size: x-large;
	}
</style>
<body>
<table border="1" style="border-collapse: collapse;">
	<caption>��1 ȸ�� ��� ��ȸ</caption>
	<tr><th>����</th><th>���̵�</th><th>�̸�</th><th>����</th><th>��ȭ</th><th>�̸���</th><th>&nbsp;</th></tr>
<% for(Member m : list){ %> <%-- ������� ����� record�� ��� --%>
<tr>
	<td><img src="img/sm_<%=m.getPicture() %>" width="50" height="50"></td> <%-- ���� �̹��� ������ ���� : ����� �̹��� --%>
	<td><a href="info.jsp?id=<%=m.getId() %> "><%=m.getId() %></a></td>	
	<td><%=m.getName() %></td>	
	<td><%=m.getGender()==1? "����":"����" %></td>	
	<td><%=m.getTel() %></td>	
	<td><%=m.getEmail() %></td>	
	<td><a href="updateform.jsp?id=<%=m.getId() %>">[����]</a>	
			 <a href="delete.jsp?id=<%=m.getId() %>">[����Ż��]</a></td>
</tr>
<%} %>
</table>
</body>
</html>
<%	
		}
  }
%>