<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%-- /WebContent/model1/member/login.jsp (ȭ���� ���� ����)
		1. id,pass �Ķ���� ����.
		2. DBMS���� id�� �ش��ϴ� �����͸� �о Member ��ü�� ����.
			null �� ��� : �ش� ���̵� ����. -> ��й�ȣ ����(alert)
																 loginform.jsp ������ �̵�
			null �� �ƴ� ��� :  ���̵� ������. -> ��й�ȣ �� ����.
																		��й�ȣ�� ������ : session�� ���.
																									  main.jsp ������ �̵�.
																		��й�ȣ�� Ʋ���� : ��й�ȣ ����(alert)
																									  loginform.jsp ������ �̵�.
																									  
--%>
<%
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		MemberDao dao = new MemberDao();
		Member mem = dao.selectOne(id);  // db�� ������ mem�� ����.
		String msg = "���̵� Ȯ���ϼ���";
		String url = "loginform.jsp";
		if(mem != null){ //���̵� �����ϴ� ���
			// pass :  �Է¹��� ��й�ȣ. �Ķ���� ��.
			// mem.getPass() : DB�� ����� id�� ���� ��й�ȣ
			if(pass.equals(mem.getPass())){  //�α��� ����
				session.setAttribute("login", id); //login ������ session�� ����. (���ǿ� ���� �����)
				msg = id+"���� �α��� �ϼ̽��ϴ�.";
				url = "main.jsp";
			} else {
				msg = "��й�ȣ�� Ʋ���ϴ�.";
 			}
		}
%>
<script>
alert("<%=msg%> ");
location.href="<%=url %>";
</script>