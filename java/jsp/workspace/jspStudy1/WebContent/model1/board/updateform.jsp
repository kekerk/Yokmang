<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	BoardDao dao = new BoardDao();
	Board board = dao.selectOne(num);
%>
</head>

<body>
<form action = "update.jsp?num=<%=board.getNum() %>" name="f" method="post" enctype="multipart/form-data">
	<table border="1" style="border-collapse : collapse;">
	<caption>모델1으로 구현한 게시판 수정 화면</caption>
	<tr>
		<td align="center">작성자</td>
		<td><input type="text" name="name" value="<%=board.getName()%>" readonly></td>
	</tr>
	<tr>
		<td align="center">비밀번호</td>
		<td><input type="password" name="pass" value="<%=board.getPass()%>" ></td>
	</tr>
	<tr>
		<td align="center">제목</td>
		<td><input type="text" name="title" value="<%=board.getTitle()%>" ></td>
	</tr>		
	<tr>
		<td align="center">내용</td>
		<td><textarea rows="15" cols="80" name="content"><%=board.getContent() %></textarea></td>
	</tr>
	<tr>
		<td align="center">첨부파일</td>
	<td>
	<input type="file" name="file1" value="<%=board.getFile1()%>">
	</td>
	</tr>
	<tr>
		<td colspan="3" align="center"><a href="javascript:document.f.submit()">[회원수정]</a>
		</td>
	</tr>	
</table>
</form>
</body>
</html>