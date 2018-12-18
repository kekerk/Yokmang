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
		msg = "비밀번호가 다릅니다.";
		url = "repassform.jsp?id="+mem.getId();
	}else {
		mem.setPass(ps2);
		int result = dao.repass(mem);
		if(result>0){
			msg = mem.getId()+"님의 비밀번호가 변경되었습니다.";
			url = "main.jsp";
		}else{
			msg="비밀번호 변경 실패";
			url="repassform.jsp?id=" + mem.getId();
		}
	}
	
%>

<head>
<script>
alert("<%=msg%>");
location.href="<%=url %>";
</script>
