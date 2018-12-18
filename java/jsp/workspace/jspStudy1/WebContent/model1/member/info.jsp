<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="model.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- 
			/WebContent/model1/member/info.jsp
			ȸ�� ���� ���� ȭ��
			1. id �Ķ���� ��������
			2. �α׾ƿ� ������ ��� : alert("�α����ϼ���"); , loginform.jsp �������� �̵�.
			3.	�α��� ������ ��� 
				- id�Ķ���Ϳ� login���� ���ؼ� �ٸ��� alert("�ڱ������� ��ȸ�� ����"); , main.jsp �������� �̵�.
				- id�Ķ���Ϳ� login���� ���ؼ� ������ DB���� �ش� member ������ ��������.
		    4. member ������ ȭ�鿡 ����ϱ�.
 --%>
 <html>
<head>
<meta charset="EUC-KR">
<title>my page</title>
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
<%
		// �α��� ����
		String login =(String) session.getAttribute("login");
		// �Ķ���� ����
		String id = request.getParameter("id");  
		if(login == null){ %>
		<script>
		alert( "�α����ϼ���")
		location.href="loginform.jsp";
		</script>
	<%	
		}else {
			if(!login.equals(id) && !login.equals("admin")){ 
			%> <%-- �Ķ���� ���� �־��� ���� : ������ Ȯ�� ���� --%>
 		<script>
		alert("�ڱ� ������ ��ȸ�� �����մϴ�");
		location.href="main.jsp";	
		</script>			
	<%
		
			}else {   
				MemberDao dao = new MemberDao(); 
				Member mem = dao.selectOne(id);  %>

<form>
	<table border="1" style="border-collapse: collapse;">
		<caption>my page</caption>
		<tr>
		<td rowspan="6"><img src="img/<%=mem.getPicture() %>" width="100" height="120"></td>
		<td>���̵�</td>
		<td><%=mem.getId() %></td></tr>
		<tr>
		<td>��й�ȣ</td>
		<td><%=mem.getPass() %></td>
		</tr>
		<tr>
		<td>�̸�</td>
		<td><%=mem.getName() %></td>
		</tr>
		<tr>
		<td>����</td>
		<td>
			<%= mem.getGender()==1? "��":"��" %> 
		</td>
		</tr>
		<tr>
		<td>��ȭ��ȣ</td>
		<td><%= mem.getTel() %></td>
		</tr>
		<tr>
		<td>�̸���</td>
		<td><%= mem.getEmail() %></td>
		</tr>
		<tr><td colspan="3">
			<a href="updateform.jsp?id=<%=mem.getId()%>">[����]</a>
			<a href="repassform.jsp?id=<%=mem.getId()%>">[��й�ȣ ����]</a>
			<% if(!id.equals("admin")) {%>
			<a href="deleteform.jsp?id=<%=mem.getId() %>">[Ż��]</a>
			<% } %>
		</td>
		</tr>
	</table>
</form>
<%	
			
		}
  }
%>
</body>
</html>

