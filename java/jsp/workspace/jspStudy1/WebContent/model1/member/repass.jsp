<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<% 
	request.setCharacterEncoding("euc-kr");
	String id = request.getParameter("id");
	String ps1 = request.getParameter("pass1");
	String ps2 = request.getParameter("pass2");
	MemberDao dao = new MemberDao();
	Member mem = dao.selectOne(id);
	String msg = null;
	String url = null;
	if(!mem.getPass().equals(ps1)){  
		msg = "��й�ȣ�� �ٸ��ϴ�.";
		url = "repassform.jsp?id="+mem.getId();
	}else {
		mem.setPass(ps2);
		int result = dao.repass(mem);
		if(result>0){
			msg = mem.getId()+"���� ��й�ȣ�� ����Ǿ����ϴ�.";
			url = "main.jsp";
		}else{
			msg="��й�ȣ ���� ����";
			url="repassform.jsp?id=" + mem.getId();
		}
	}
	
%>

<head>
<script>
alert("<%=msg%>");
location.href="<%=url %>";
</script>
