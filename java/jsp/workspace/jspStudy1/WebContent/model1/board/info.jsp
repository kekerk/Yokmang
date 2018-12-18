<%@page import="model.BoardDao"%>
<%@page import="model.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
	/WebContent/model1/board/info.jsp
	1. num �Ķ���͸� �̿��Ͽ� db���� �ش� �Խù� ���� ��ȸ.
		Board BoardDao.selectOne(num)
	2. readcnt ���� +1�� ������Ű��.
	BoardDao.readcntadd(num)
	3. Board�� ������ ȭ�鿡 ����ϱ�.
 --%>
<!DOCTYPE html>
<html>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	BoardDao dao = new BoardDao();
	Board board = dao.selectOne(num);
	int result = dao.readcntadd(num);
%>
<head>
<meta charset="EUC-KR">
<title>model1 �̿��� �Խù� info</title>
</head>

<body>
<table border="1" style="border-collapse : collapse;">
	<caption>��1 �Խù� �� ����</caption>
	<tr><td>�۾���</td><td><%=board.getName() %></td></tr>
	<tr><td>����</td><td><%=board.getTitle() %></td></tr>
	<tr><td>����</td><td><table width="490" height="250"><tr><td><%=board.getContent() %></td></tr></table></td>
	</tr>
	<tr><td>÷������</td>
	<td>
	<% if(board.getFile1()!=null && !board.getFile1().equals("")) {%>
	<a href="file/<%=board.getFile1() %>"><%=board.getFile1() %></a>
	<%} else { %>
	[���� ����]
	<%} %>
	</td>
	</tr>
	<tr><td colspan="2" align="center">
	<a href="replyForm.jsp?num=<%=board.getNum() %>">[�亯]</a>  <%-- ���ۿ� ���� num --%>
	<a href="UForm.jsp?num=<%=board.getNum() %>">[����]</a> 
	<a href="deleteform.jsp?num=<%=board.getNum() %>">[����]</a> 
	<a href="list.jsp">[���]</a>
	</td>
	</tr> 
</table>
</body>
</html>