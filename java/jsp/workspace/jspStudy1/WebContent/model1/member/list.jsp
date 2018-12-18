<%@page import="model.Member"%>
<%@page import="java.util.List"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 
<!DOCTYPE html>
<%-- /WebContent/model1/list.jsp 
		 	1. 로그아웃 상태
		 		로그인하세요 메세지 출력. loginform.jsp로 이동
		 	2. admin이 아닌 경우
		 		관리자만 조회 가능합니다. 메세지 출력. main.jsp로 이동
		 	3. admin인 경우
		 		MemberDao 클래스에 list 메서드 추가하기.
		 		List<Member> list() 기능 : 현재 가지고 있는 모든 멤버의 목록을 리턴.
		 	4. db에서 조회한 list를 화면에 출력.	
--%>

 <html>
    <%
		// 로그인 정보. request.parameter는 필요 없다.
		String login =(String) session.getAttribute("login");
		if(login == null){ %>
		<script>
		alert( "로그인하세요")
		location.href="loginform.jsp";
		</script>
	<%	
		}else {
			if(!login.equals("admin")){ %> 
 		<script>
		alert("관리자만 조회가 가능합니다")
		location.href="main.jsp";
		</script>		
	<%	
			}else {   
				MemberDao dao = new MemberDao();
				List<Member> list = dao.list(); %> <%-- 회원정보 전체 리턴 --%>
<head>
<meta charset="EUC-KR">
<title>회원목록보기</title>
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
<table border="1" style="border-collapse: collapse;">
	<caption>모델1 회원 목록 조회</caption>
	<tr><th>사진</th><th>아이디</th><th>이름</th><th>성별</th><th>전화</th><th>이메일</th><th>&nbsp;</th></tr>
<% for(Member m : list){ %> <%-- 순서대로 저장된 record를 출력 --%>
<tr>
	<td><img src="img/sm_<%=m.getPicture() %>" width="50" height="50"></td> <%-- 작은 이미지 파일을 저장 : 썸네일 이미지 --%>
	<td><a href="info.jsp?id=<%=m.getId() %> "><%=m.getId() %></a></td>	
	<td><%=m.getName() %></td>	
	<td><%=m.getGender()==1? "남자":"여자" %></td>	
	<td><%=m.getTel() %></td>	
	<td><%=m.getEmail() %></td>	
	<td><a href="updateform.jsp?id=<%=m.getId() %>">[수정]</a>	
			 <a href="delete.jsp?id=<%=m.getId() %>">[강제탈퇴]</a></td>
</tr>
<%} %>
</table>
</body>
</html>
<%	
		}
  }
%>