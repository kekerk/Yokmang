<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- /WebContent/model1/member/updateform.jsp
			 1. id �Ķ���͸� �����´�.
		  	2. �α׾ƿ� ������ ��� : alert("�α����ϼ���"); , loginform.jsp �������� �̵�.
			3.	�α��� ������ ��� 
				- id�Ķ���Ϳ� login���� ���ؼ� �ٸ��� alert("�ڱ������� ��ȸ�� ����"); , main.jsp �������� �̵�.
				- id�Ķ���Ϳ� login���� ���ؼ� ������ DB���� �ش� member ������ ��������.
		    4. member ������ ȭ�鿡 ����ϱ�.
 --%>
<html>
<%
		String login = (String) session.getAttribute("login");
		String id  = request.getParameter("id");
		if(login==null){%>
		<script>
		alert("�α����ϼ���");
		location.href="loginform.jsp";
		</script> 
		<%} else {
			if(!login.equals(id) && !login.equals("admin")){ %>
		<script>
		alert("������ ������ ������ �����մϴ�.");
		location.href="main.jsp";
		</script> 
		<%	} else {
			MemberDao dao = new MemberDao();
			Member mem = dao.selectOne(id);  %>
<head>
<meta charset="EUC-KR">
<title>model1 ȸ�� ���� ����</title>
</head><style>
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
<script >
function win_open() {
	var op = "width=500, height=150, left=50, top=150";
	open("memberimgForm.jsp","",op);
	
}
function passchg_winopen() {
	var op = "width=500, height=300, left=50, top=150";
	open("passchgform.jsp","",op);
	
}
</script>
<body>
<form action = "update.jsp" name="f" method="post">
	<input type="hidden" name="picture" value="<%=mem.getPicture()%>">
	<table border="1" style="border-collapse : collapse;">
	<caption>��1���� ������ ȸ�� ���� ȭ��</caption>
	<tr>
		<td rowspan="4" align="center" valign="bottom">
		<img src=" img/<%=mem.getPicture()%>" width="100" height="120" id="pic"><br>
		<font size="1"><a href="javascript:win_open()">��������</a></font></td>
		<td>���̵�</td>
		<td><input type="text" name="id" value="<%=mem.getId()%>" readonly></td>
	</tr>
	<tr>
		<td>��й�ȣ</td>
		<td><input type="password" name="pass" value="<%=mem.getPass()%>" ></td>
	</tr>
	<tr>
		<td>�̸�</td>
		<td><input type="text" name="name" value="<%=mem.getName()%>" ></td>
	</tr>		
	<tr>
		<td>����</td>
		<td><input type="radio" name="gender" value="1"  id="g1">����
				<input type="radio" name="gender" value="2" id="g2">����</td>
	</tr>
	<script>
	gender = <%=mem.getGender()%>;
	if(gender ==1)
			g1.setAttribute("checked","checked");
	else
		    g2.setAttribute("checked","checked");
	</script>
	<tr>
		<td>��ȭ��ȣ</td>
		<td colspan="2"><input type="text" name="tel" value="<%=mem.getTel()%>" ></td>
	</tr>
	<tr>
		<td>�̸���</td>
		<td colspan="2"><input type="text" name="email" value="<%=mem.getEmail()%>" ></td>
	</tr>
	<tr>
		<td colspan="3" align="center"><input type="submit"  value="ȸ�� ����" >
		<input type="button" value="��й�ȣ����" onclick="passchg_winopen()">
		</td>
	</tr>	
</table>
</form>
</body>
</html>
<%	}	} %>