<%@page import="model.BoardDao"%>
<%@page import="model.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<%-- webcontent/model1/board/reply.jsp : 답변글 등록
			1. 파라미터들을 보드 객체에 저장
			2. Board 객체를 db에 insert
			3. 등록 성공 : list.jsp로 페이지 이동
			4. 등록 실패 : replyForm.jsp로 이동
			
 --%>
 	<jsp:useBean id="boardr" class="model.Board"/>
 	<jsp:setProperty property="*" name="boardr"/>
<!DOCTYPE html>
<html>
<%
		String msg = null;
		String url = null;
		if(new BoardDao().reply(boardr)){  
			msg="답변 성공";
			url = "list.jsp";
// 			response.sendRedirect("list.jsp"); -> alert 창을 띄우지 않는다.
		}else {
			msg="답변 실패";
			url="replyForm.jsp?num="+boardr.getNum();
		}
	
		
%>
<script>
alert("<%=msg%>");
location.href="<%=url%>";
</script>