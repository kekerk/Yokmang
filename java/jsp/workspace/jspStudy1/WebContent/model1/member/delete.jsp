<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@page import="model.MemberDao"%>
 <%@page import="model.Member"%>
<!DOCTYPE html>
<%--
	1.로그인이 안된 경우 :
		로그인이 필요합니다. 메세지 출력. loginform.jsp 페이지로 이동
	2. 로그인이 된 경우
		- 일반사용자인 경우는 id와 로그인 정보가 일치해야하고, 관리자는 상관없음을 인증.
		- 일반 사용자 
			1. 비밀번호 검증. 틀리면 비밀번호 오류 메세지 출력. deleteform.jsp로 이동.
			2. 비밀번호 맞는 경우 : db에서 id의 정보 삭제.
					- 로그아웃 하기.
					- 탈퇴 완료 메세지 출력. loginform.jsp로 이동.
			3. 관리자
					- db에서 해당 id의 정보 삭제.
					  탈퇴메세지 출력. list.jsp로 페이지 이동.
 --%>
<html>
<%	
	String login = (String) session.getAttribute("login"); //현재 로그인이 됐는지 안됐는지 알아보기 위한 상태.
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String msg =null;
	String url=null;
	if(login == null){  // 로그인이 안된 경우
		msg = "로그인하세요";
		url="loginform.jsp";
		} else if(!login.equals(id) && !login.equals("admin")){
			msg = "본인만 탈퇴가 가능합니다.";
			url="deleteform.jsp?id"+id;
		}else {
			MemberDao dao = new MemberDao();
		 	Member mem = dao.selectOne(id);
			if(login.equals("admin")){
				int result = dao.delete(mem);
				if(result>0){  //삭제 성공
					msg = mem.getId()+"님의 강제 탈퇴가 완료되었습니다.";
					url = "list.jsp";
				}else {
					msg ="회원 정보 삭제 실패";
					url = "list.jsp";
			 	}
			}else{
			 	if(!mem.getPass().equals(pass)){
			 		msg ="비밀번호 오류";
					url = "deleteform.jsp?id="+mem.getId();
			 	}else {
			 		int result = dao.delete(mem);
					if(result>0){  //삭제 성공
						session.invalidate();
						msg = mem.getId()+"님의 탈퇴가 완료되었습니다.";
						url = "loginform.jsp";
					}else {
						msg ="회원 정보 삭제 실패";
						url = "deleteform.jsp?id="+mem.getId();
				 	}
			 	}
			}
}
 %>
<script>
alert("<%=msg%>");
location.href="<%=url%>";
</script>
