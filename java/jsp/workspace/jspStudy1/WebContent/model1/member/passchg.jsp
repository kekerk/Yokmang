<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<%
	String msg = null;
	String login = (String) session.getAttribute("login");
	String pass = request.getParameter("pass");
	String chgpass = request.getParameter("chgpass");
	if(login==null){ %>
<script type="text/javascript">
	alert("�α����ϼ���");
	opener.location.href="loginform.jsp";
	self.close(); //����â �ݱ�
</script>		
<%	} else {  
	MemberDao dao = new MemberDao();
	Member mem = dao.selectOne(login);
	if(pass.equals(mem.getPass())){
		int result = dao.updatepass(login,chgpass);
		if(result>0){  // ��� ����
			msg = login + "�� ��й�ȣ �����Ϸ�";
		}else { // ��� ����
			msg = login + "�� ��й�ȣ ���� ���� �߻�";
		}
	}else {
		msg = login + "�� ���� ��й�ȣ �����Դϴ�.";
	}
}%>
<script type="text/javascript">
alert("<%=msg%>");
self.close();
</script>

