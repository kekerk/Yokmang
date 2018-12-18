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
	alert("로그인하세요");
	opener.location.href="loginform.jsp";
	self.close(); //현재창 닫기
</script>		
<%	} else {  
	MemberDao dao = new MemberDao();
	Member mem = dao.selectOne(login);
	if(pass.equals(mem.getPass())){
		int result = dao.updatepass(login,chgpass);
		if(result>0){  // 결과 성공
			msg = login + "님 비밀번호 수정완료";
		}else { // 결과 실패
			msg = login + "님 비밀번호 수정 오류 발생";
		}
	}else {
		msg = login + "님 기존 비밀번호 오류입니다.";
	}
}%>
<script type="text/javascript">
alert("<%=msg%>");
self.close();
</script>

