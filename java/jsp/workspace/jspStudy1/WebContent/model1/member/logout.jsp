<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--  WebContent/model1/member/logout.jsp 
		 1. session�� ��ϵ� �α��� ������ ����.
		 2. loginform.jsp�� ������ �̵�.
	--%>
<%
	    // session.invalidate(); ->session ��ü�� ���� ������. ������ ���� ������ ���ư���.
		String msg=null;
		String url=null;
		session.removeAttribute("login"); //���ǿ� �ִ� login�� ���� Attribute�� �����Ѵ�.
		if(session.getAttribute("login")==null){
			msg="�α׾ƿ��Ǿ����ϴ�.";
			url="loginform.jsp";
		}
%>
<script>
alert("<%=msg%>");
location.href="<%=url%>";
</script>
