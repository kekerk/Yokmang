<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@page import="model.MemberDao"%>
 <%@page import="model.Member"%>
<!DOCTYPE html>
<%--
	1.�α����� �ȵ� ��� :
		�α����� �ʿ��մϴ�. �޼��� ���. loginform.jsp �������� �̵�
	2. �α����� �� ���
		- �Ϲݻ������ ���� id�� �α��� ������ ��ġ�ؾ��ϰ�, �����ڴ� ��������� ����.
		- �Ϲ� ����� 
			1. ��й�ȣ ����. Ʋ���� ��й�ȣ ���� �޼��� ���. deleteform.jsp�� �̵�.
			2. ��й�ȣ �´� ��� : db���� id�� ���� ����.
					- �α׾ƿ� �ϱ�.
					- Ż�� �Ϸ� �޼��� ���. loginform.jsp�� �̵�.
			3. ������
					- db���� �ش� id�� ���� ����.
					  Ż��޼��� ���. list.jsp�� ������ �̵�.
 --%>
<html>
<%	
	String login = (String) session.getAttribute("login"); //���� �α����� �ƴ��� �ȵƴ��� �˾ƺ��� ���� ����.
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String msg =null;
	String url=null;
	if(login == null){  // �α����� �ȵ� ���
		msg = "�α����ϼ���";
		url="loginform.jsp";
		} else if(!login.equals(id) && !login.equals("admin")){
			msg = "���θ� Ż�� �����մϴ�.";
			url="deleteform.jsp?id"+id;
		}else {
			MemberDao dao = new MemberDao();
		 	Member mem = dao.selectOne(id);
			if(login.equals("admin")){
				int result = dao.delete(mem);
				if(result>0){  //���� ����
					msg = mem.getId()+"���� ���� Ż�� �Ϸ�Ǿ����ϴ�.";
					url = "list.jsp";
				}else {
					msg ="ȸ�� ���� ���� ����";
					url = "list.jsp";
			 	}
			}else{
			 	if(!mem.getPass().equals(pass)){
			 		msg ="��й�ȣ ����";
					url = "deleteform.jsp?id="+mem.getId();
			 	}else {
			 		int result = dao.delete(mem);
					if(result>0){  //���� ����
						session.invalidate();
						msg = mem.getId()+"���� Ż�� �Ϸ�Ǿ����ϴ�.";
						url = "loginform.jsp";
					}else {
						msg ="ȸ�� ���� ���� ����";
						url = "deleteform.jsp?id="+mem.getId();
				 	}
			 	}
			}
}
 %>
<script>
alert("<%=msg%>");
location.href="<%=url%>";
</script>
