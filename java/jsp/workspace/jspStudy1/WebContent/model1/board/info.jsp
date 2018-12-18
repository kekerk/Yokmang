<%@page import="model.BoardDao"%>
<%@page import="model.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
	/WebContent/model1/board/info.jsp
	1. num 파라미터를 이용하여 db에서 해당 게시물 정보 조회.
		Board BoardDao.selectOne(num)
	2. readcnt 값을 +1로 증가시키기.
	BoardDao.readcntadd(num)
	3. Board의 정보를 화면에 출력하기.
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
<title>model1 이용한 게시물 info</title>
</head>

<body>
<table border="1" style="border-collapse : collapse;">
	<caption>모델1 게시물 상세 보기</caption>
	<tr><td>글쓴이</td><td><%=board.getName() %></td></tr>
	<tr><td>제목</td><td><%=board.getTitle() %></td></tr>
	<tr><td>내용</td><td><table width="490" height="250"><tr><td><%=board.getContent() %></td></tr></table></td>
	</tr>
	<tr><td>첨부파일</td>
	<td>
	<% if(board.getFile1()!=null && !board.getFile1().equals("")) {%>
	<a href="file/<%=board.getFile1() %>"><%=board.getFile1() %></a>
	<%} else { %>
	[파일 없음]
	<%} %>
	</td>
	</tr>
	<tr><td colspan="2" align="center">
	<a href="replyForm.jsp?num=<%=board.getNum() %>">[답변]</a>  <%-- 원글에 대한 num --%>
	<a href="UForm.jsp?num=<%=board.getNum() %>">[수정]</a> 
	<a href="deleteform.jsp?num=<%=board.getNum() %>">[삭제]</a> 
	<a href="list.jsp">[목록]</a>
	</td>
	</tr> 
</table>
</body>
</html>