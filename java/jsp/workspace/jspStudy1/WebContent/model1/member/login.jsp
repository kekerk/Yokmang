<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%-- /WebContent/model1/member/login.jsp (화면이 따로 없음)
		1. id,pass 파라미터 전달.
		2. DBMS에서 id에 해당하는 데이터를 읽어서 Member 객체로 전달.
			null 인 경우 : 해당 아이디 없음. -> 비밀번호 오류(alert)
																 loginform.jsp 페이지 이동
			null 이 아닌 경우 :  아이디가 존재함. -> 비밀번호 비교 실행.
																		비밀번호가 맞으면 : session에 등록.
																									  main.jsp 페이지 이동.
																		비밀번호가 틀리면 : 비밀번호 오류(alert)
																									  loginform.jsp 페이지 이동.
																									  
--%>
<%
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		MemberDao dao = new MemberDao();
		Member mem = dao.selectOne(id);  // db의 정보를 mem에 저장.
		String msg = "아이디를 확인하세요";
		String url = "loginform.jsp";
		if(mem != null){ //아이디가 존재하는 경우
			// pass :  입력받은 비밀번호. 파라미터 값.
			// mem.getPass() : DB에 저장된 id에 대한 비밀번호
			if(pass.equals(mem.getPass())){  //로그인 성공
				session.setAttribute("login", id); //login 정보를 session에 저장. (세션에 흔적 남기기)
				msg = id+"님이 로그인 하셨습니다.";
				url = "main.jsp";
			} else {
				msg = "비밀번호가 틀립니다.";
 			}
		}
%>
<script>
alert("<%=msg%> ");
location.href="<%=url %>";
</script>