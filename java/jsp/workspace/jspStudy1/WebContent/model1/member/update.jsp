<%@page import="model.MemberDao"%>
<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<%-- WebContent/model1/member/update.jsp
	1.모든 파라미터를 Member 객체 저장. : usebean액션 사용
	2. 파라미터를 저장한 Member 객체를 db에서 수정하기.
	
 --%>
 <%-- Member mem = new Member() --%>
 	<jsp:useBean id="updatemem" class="model.Member"/> <%-- 실행하면 값없는 객체만 생성 --%>
 	<jsp:setProperty property="*" name="updatemem"/>  
 <%-- 프로퍼티 == 파라미터 인 값을 mem 객체 입력 
 		  mem.setId(request.getParameter("id"))
 		  mem.setName(request.getParameter("name"))
		  .
		  .
 --%>
 	
<html>
<%
	MemberDao dao = new MemberDao();
	Member mem1 = dao.selectOne(updatemem.getId());
	String msg =null;
	String url=null;
	if(!updatemem.getPass().equals(mem1.getPass())){

	msg = "비밀번호가 틀립니다.";
	url = "updateform.jsp?id="+updatemem.getId();

		} else {
	int result = dao.update(updatemem);
	// 비밀번호가 틀리면 "비밀번호가 틀립니다."  메세지 출력. updateform.jsp

	if(result>0){  //수정 성공
		msg = updatemem.getId()+"님의 회원 정보가 수정되었습니다.";
		url = "main.jsp";
	}else {
		msg ="회원 정보 수정 실패";
		url = "updateform.jsp?id="+updatemem.getId();
 	}
	}
%>
<script>
alert("<%=msg%>");
location.href="<%=url %>";
</script>
