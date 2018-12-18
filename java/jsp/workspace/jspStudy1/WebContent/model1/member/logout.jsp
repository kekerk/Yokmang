<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--  WebContent/model1/member/logout.jsp 
		 1. session에 등록된 로그인 정보를 제거.
		 2. loginform.jsp로 페이지 이동.
	--%>
<%
	    // session.invalidate(); ->session 객체를 새로 주입함. 기존의 세션 정보는 날아간다.
		String msg=null;
		String url=null;
		session.removeAttribute("login"); //세션에 있는 login에 대한 Attribute를 제거한다.
		if(session.getAttribute("login")==null){
			msg="로그아웃되었습니다.";
			url="loginform.jsp";
		}
%>
<script>
alert("<%=msg%>");
location.href="<%=url%>";
</script>
