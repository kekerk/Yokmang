<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<%--
			1. �Ķ���͸� Member ��ü�� ����
			2. member db table�� insert(�߰�)
			3. ���� : loginForm.jsp ������ �̵�
			4. ���� : joinForm.jsp ������ �̵�
 --%>
 <%-- 1. �Ķ���͸� Member ��ü�� ���� --%>
 <jsp:useBean id="mem" class="model.Member" />
 <jsp:setProperty property="*" name="mem"/>
 <%-- 2. member db table�� insert(�߰�)--%>
 <%
 		MemberDao dao = new MemberDao();
 		int result = dao.insert(mem);
 		String msg= null;
 		String url = null;
    	/* 3. ���� : loginForm.jsp ������ �̵�*/
    	if(result > 0){ //1
    		msg = mem.getId() + "�� ȸ�� ������ �Ϸ�Ǿ����ϴ�.";
    		url = "loginform.jsp";
    	} else {
    		/* 4. ���� : joinForm.jsp ������ �̵�*/
    		msg = " ȸ�� ���� ����";
 			url = "joinform.jsp";
    	}
 %>
 <script>
 	alert("<%=msg%>");
 	location.href="<%=url%>";
 </script>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ Ȯ��</title>
</head>
<body>

</body>
</html>