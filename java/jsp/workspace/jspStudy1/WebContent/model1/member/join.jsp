<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<%--
			1. 파라미터를 Member 객체에 저장
			2. member db table에 insert(추가)
			3. 성공 : loginForm.jsp 페이지 이동
			4. 실패 : joinForm.jsp 페이지 이동
 --%>
 <%-- 1. 파라미터를 Member 객체에 저장 --%>
 <jsp:useBean id="mem" class="model.Member" />
 <jsp:setProperty property="*" name="mem"/>
 <%-- 2. member db table에 insert(추가)--%>
 <%
 		MemberDao dao = new MemberDao();
 		int result = dao.insert(mem);
 		String msg= null;
 		String url = null;
    	/* 3. 성공 : loginForm.jsp 페이지 이동*/
    	if(result > 0){ //1
    		msg = mem.getId() + "님 회원 가입이 완료되었습니다.";
    		url = "loginform.jsp";
    	} else {
    		/* 4. 실패 : joinForm.jsp 페이지 이동*/
    		msg = " 회원 가입 실패";
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
<title>회원가입 확인</title>
</head>
<body>

</body>
</html>