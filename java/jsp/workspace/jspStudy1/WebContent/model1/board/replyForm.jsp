<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- /WebContent/model1/board/replyForm.jsp
				1. ������ �亯�� ��� ȭ��.
					������ ���� : num, ref, reflevel, refstep
										num : �Ķ���� ����
				2. �亯�� : ȭ�鿡 �Է¹ޱ�.
     --%>
<!DOCTYPE html>
<html>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	Board board = new BoardDao().selectOne(num);
%>
<head>
<meta charset="EUC-KR">
<title>�� 1 �Խ��� ��� ����</title>

</head>
<body>
<form action="reply.jsp" method="post" name="f" >
	<input type="hidden" name="num" value="<%=board.getNum() %>">
	<input type="hidden" name="ref" value="<%=board.getRef() %>">
	<input type="hidden" name="reflevel" value="<%=board.getReflevel() %>">
	<input type="hidden" name="refstep" value="<%=board.getRefstep() %>">
	<table border="1" style="border-collapse: collapse;">
		<caption>��1 �Խñ� ��� ����</caption>
		<tr><td>�۾���</td><td><input type="text" name="name"></td></tr>
		<tr><td>��й�ȣ</td><td><input type="password" name="pass"></td></tr>
		<tr><td>����</td><td><input type="text" name="title" value="RE:<%=board.getTitle()%>"></td></tr>
		<tr><td>����</td><td><textarea rows="15" cols="80" name="content"></textarea></td></tr>
		<tr><td colspan="2" align="center">
		<a href="javascript:document.f.submit()">[�亯 ���]</a>
		<a href="javascript:document.f.reset()">[�ٽ� �ۼ�]</a>
		<a href="javascript:history.go(-1)">[�ڷ� ����]</a>
		</td></tr>
	</table>
</form>
</body>
</html>