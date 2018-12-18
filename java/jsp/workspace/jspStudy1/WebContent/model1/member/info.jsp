<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="model.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- 
			/WebContent/model1/member/info.jsp
			회원 정보 보기 화면
			1. id 파라미터 가져오기
			2. 로그아웃 상태인 경우 : alert("로그인하세요"); , loginform.jsp 페이지로 이동.
			3.	로그인 상태인 경우 
				- id파라미터와 login값을 비교해서 다르면 alert("자기정보만 조회가 가능"); , main.jsp 페이지로 이동.
				- id파라미터와 login값을 비교해서 같으면 DB에서 해당 member 정보를 가져오기.
		    4. member 정보를 화면에 출력하기.
 --%>
 <html>
<head>
<meta charset="EUC-KR">
<title>my page</title>
</head>
<style>
	table {
		margin: 0 auto;
		width : 800px;
		border: 2px solid green;
		text-align: center;
	}
	caption {
	font-weight: bold;
	font-size: x-large;
	}
</style>
<body>
<%
		// 로그인 정보
		String login =(String) session.getAttribute("login");
		// 파라미터 정보
		String id = request.getParameter("id");  
		if(login == null){ %>
		<script>
		alert( "로그인하세요")
		location.href="loginform.jsp";
		</script>
	<%	
		}else {
			if(!login.equals(id) && !login.equals("admin")){ 
			%> <%-- 파라미터 값을 넣어준 이유 : 관리자 확인 위해 --%>
 		<script>
		alert("자기 정보만 조회가 가능합니다");
		location.href="main.jsp";	
		</script>			
	<%
		
			}else {   
				MemberDao dao = new MemberDao(); 
				Member mem = dao.selectOne(id);  %>

<form>
	<table border="1" style="border-collapse: collapse;">
		<caption>my page</caption>
		<tr>
		<td rowspan="6"><img src="img/<%=mem.getPicture() %>" width="100" height="120"></td>
		<td>아이디</td>
		<td><%=mem.getId() %></td></tr>
		<tr>
		<td>비밀번호</td>
		<td><%=mem.getPass() %></td>
		</tr>
		<tr>
		<td>이름</td>
		<td><%=mem.getName() %></td>
		</tr>
		<tr>
		<td>성별</td>
		<td>
			<%= mem.getGender()==1? "남":"여" %> 
		</td>
		</tr>
		<tr>
		<td>전화번호</td>
		<td><%= mem.getTel() %></td>
		</tr>
		<tr>
		<td>이메일</td>
		<td><%= mem.getEmail() %></td>
		</tr>
		<tr><td colspan="3">
			<a href="updateform.jsp?id=<%=mem.getId()%>">[수정]</a>
			<a href="repassform.jsp?id=<%=mem.getId()%>">[비밀번호 변경]</a>
			<% if(!id.equals("admin")) {%>
			<a href="deleteform.jsp?id=<%=mem.getId() %>">[탈퇴]</a>
			<% } %>
		</td>
		</tr>
	</table>
</form>
<%	
			
		}
  }
%>
</body>
</html>

