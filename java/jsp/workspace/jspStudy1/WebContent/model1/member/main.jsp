<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%-- WebContent/model1/member/main.jsp
		 1. 로그인 이후의 페이지.
		 	 로그인 상태만 화면에 출력.
		 	 로그아웃 상태면 loginform.jsp로 페이지 이동. (로그아웃 submit)
		 2. 관리자로 로그인 하는 경우 회원 목록 보기(list.jsp) 링크 추가하기.
 --%>
<%
	String login = (String)session.getAttribute("login");//로그인이 되어있지 않으면 절대로 main.jsp로 갈 수 없다.
	if(login==null){ //logout 상태
		response.sendRedirect("loginform.jsp");  // 로그인 화면으로 다시 보낸다.
	} else {
			
%>		
<html>
	<head><title>회원 관리 프로그램</title>
	</head>
	<style>
	body {
		background-image : url('taeri2.jpg');	
		background-position : center center;
		background-repeat : no-repeat;
	}
	</style>
	<body>
	<h3><%=login %> 회원님 반갑습니다.</h3>
	<h3><a href="logout.jsp">logout</a></h3> <%-- 세션에 있는 내용 전부 지워버리기. --%>
	<h3><a href="info.jsp?id=<%=login%>">my page</a></h3>  
	<% if(login.equals("admin")){ %>
	<h3><a href="list.jsp">회원 목록 보기</a></h3>   
	<%} %>
	<%-- ?id=<%=login%> : get 방식 --%>
	</body>
</html>	
<%}%>