<%@page import="model.BoardDao"%>
<%@page import="model.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<%-- webcontent/model1/board/reply.jsp : �亯�� ���
			1. �Ķ���͵��� ���� ��ü�� ����
			2. Board ��ü�� db�� insert
			3. ��� ���� : list.jsp�� ������ �̵�
			4. ��� ���� : replyForm.jsp�� �̵�
			
 --%>
 	<jsp:useBean id="boardr" class="model.Board"/>
 	<jsp:setProperty property="*" name="boardr"/>
<!DOCTYPE html>
<html>
<%
		String msg = null;
		String url = null;
		if(new BoardDao().reply(boardr)){  
			msg="�亯 ����";
			url = "list.jsp";
// 			response.sendRedirect("list.jsp"); -> alert â�� ����� �ʴ´�.
		}else {
			msg="�亯 ����";
			url="replyForm.jsp?num="+boardr.getNum();
		}
	
		
%>
<script>
alert("<%=msg%>");
location.href="<%=url%>";
</script>