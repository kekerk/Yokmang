<%@page import="model.MemberDao"%>
<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<%-- WebContent/model1/member/update.jsp
	1.��� �Ķ���͸� Member ��ü ����. : usebean�׼� ���
	2. �Ķ���͸� ������ Member ��ü�� db���� �����ϱ�.
	
 --%>
 <%-- Member mem = new Member() --%>
 	<jsp:useBean id="updatemem" class="model.Member"/> <%-- �����ϸ� ������ ��ü�� ���� --%>
 	<jsp:setProperty property="*" name="updatemem"/>  
 <%-- ������Ƽ == �Ķ���� �� ���� mem ��ü �Է� 
 		  mem.setId(request.getParameter("id"))
 		  mem.setName(request.getParameter("name"))
		  .
		  .
 --%>
 	
<html>
<%
	MemberDao dao = new MemberDao();
	Member mem1 = dao.selectOne(updatemem.getId());
	String msg =null;
	String url=null;
	if(!updatemem.getPass().equals(mem1.getPass())){

	msg = "��й�ȣ�� Ʋ���ϴ�.";
	url = "updateform.jsp?id="+updatemem.getId();

		} else {
	int result = dao.update(updatemem);
	// ��й�ȣ�� Ʋ���� "��й�ȣ�� Ʋ���ϴ�."  �޼��� ���. updateform.jsp

	if(result>0){  //���� ����
		msg = updatemem.getId()+"���� ȸ�� ������ �����Ǿ����ϴ�.";
		url = "main.jsp";
	}else {
		msg ="ȸ�� ���� ���� ����";
		url = "updateform.jsp?id="+updatemem.getId();
 	}
	}
%>
<script>
alert("<%=msg%>");
location.href="<%=url %>";
</script>
